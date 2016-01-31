package ru.romanenko.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import ru.romanenko.dataobject.File;
import ru.romanenko.setdataobject.SetFileFromFileSystem;

public class KeysFileParser {
	public String str;
	KeysFileParser(){

	}
	public static void main(String[] args) throws IOException {
		SetFileFromFileSystem sf = new SetFileFromFileSystem();

		//sf.getFile("d://eclipse.ini").getStringFile();
		//System.out.println();
		sf.writeOutFile(args[0],args[1]);
		//sf.writeOutFile("d://example.txt","d://out_example.txt");
		
		/*File in_file = sf.getFile("d://out_example.txt");
		ArrayList<String> string_file = in_file.getStringFile();
		
		Iterator itr = string_file.iterator();
	      while(itr.hasNext()) {
	         
	         System.out.println(itr.next());
	      }*/
		
		//System.out.println();
		//parceFileFirstMethod(in_file);
		
	}
}
