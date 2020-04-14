package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import data.Constants;
import process.factory.UnitFactory;
import process.file.FileExtractor;

public class TestFileExtractor {
	public static void main(String[] args) {
		FileExtractor Fe=new FileExtractor();
		HashMap<String,String> infos = new HashMap<String, String>();
		try {
			infos=Fe.readFile("C:\\Users\\awen9\\Documents\\test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("the file specified wasn't found");
		} catch (IOException e) {
			System.out.println("error while reading file");
		}
		System.out.println(infos.toString());
		
		UnitFactory UnitF = new UnitFactory();
		UnitF.createUnit(Constants.WRATH, null, null);
	}
	
	
}
