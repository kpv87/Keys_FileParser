package ru.romanenko.dataobject;

import java.util.ArrayList;

//import java.io.File;

public class File{
	String lineFile;
	ArrayList<String> stringFile;
	
	public File() {
		this.stringFile = new ArrayList<String>();
	}

	public File(String filePath) {
		// TODO Auto-generated constructor stub
	}

	public String getLineFile() {
		return lineFile;
	}

	public void setLineFile(String lineFile) {
		this.lineFile = lineFile;
	}

	public ArrayList<String> getStringFile() {
		return stringFile;
	}

	public void setStringFile(ArrayList<String> stringFile) {
		this.stringFile = stringFile;
	}
	
	public void addLine(int index, String line) {
		stringFile.add(index,line);
	}
	
}
