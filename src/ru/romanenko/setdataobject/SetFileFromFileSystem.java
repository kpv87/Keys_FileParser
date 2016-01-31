package ru.romanenko.setdataobject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import ru.romanenko.dataobject.File;

public class SetFileFromFileSystem {

	public File getFile(String filePath) throws IOException {
		File in_file = new File();
		int arrayIndex = 0;
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		try {
			// StringBuilder sb = new StringBuilder();
			String line;
			line = br.readLine();

			while (line != null) {
				in_file.addLine(arrayIndex, line);
				/*
				 * sb.append(line); sb.append(System.lineSeparator());
				 */
				line = br.readLine();
				arrayIndex++;
			}
			// String everything = sb.toString();

			// in_file.setFile(sb.toString());
			return in_file;
		} finally {
			br.close();
		}

	}

	public void insert(String filename, long offset, byte[] content)
			throws IOException {
		RandomAccessFile r = new RandomAccessFile(new java.io.File(filename),"rw");
		RandomAccessFile rtemp = new RandomAccessFile(new java.io.File(filename+ "~"), "rw");
		long fileSize = r.length();
		FileChannel sourceChannel = r.getChannel();
		FileChannel targetChannel = rtemp.getChannel();
		sourceChannel.transferTo(offset, (fileSize - offset), targetChannel);
		sourceChannel.truncate(offset);
		r.seek(offset);
		r.write(content);
		long newOffset = r.getFilePointer();
		targetChannel.position(0L);
		sourceChannel.transferFrom(targetChannel, newOffset,
				(fileSize - offset));
		sourceChannel.close();
		targetChannel.close();
	}

	public void writeOutFile(String inFilePath, String outFilePath) {
		try {
			java.io.File outFile = new java.io.File(outFilePath);

			if (!outFile.exists()) {
				outFile.createNewFile();
			}

			ArrayList<String> listF = getFile(inFilePath).getStringFile();
			int index = 5;
			String firstPartString;
			String secondPartString;
			String outString;
			Set<String> result = new TreeSet<String>();
			while (listF.size() >= index) {
				firstPartString = listF.get(index - 1).substring(0, 12);
				secondPartString = listF.get(index - 1).substring(20, 32);
				result.add(firstPartString);
				result.add(secondPartString);
				/*
				outString = secondPartString + "\r\n" + firstPartString
						+ "\r\n";

				insert(outFilePath, 0, outString.getBytes());
				// System.out.println(secondPartString);
				// System.out.println(firstPartString);
				index = index + 5;*/
			}
			for (String str : result) {
				insert(outFilePath, 0, str.getBytes());
			}

		} catch (IOException e) {

		}

	}
}
