package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import data.Constants;
import data.Coordinates;
import data.unit.AttackHelicopter;
import data.unit.Worker;
import process.factory.UnitFactory;
import process.file.FileExtractor;

public class TestFileExtractor {
	public static void main(String[] args) {
		FileExtractor Fe=new FileExtractor();
		HashMap<String,String> infos = new HashMap<String, String>();
		try {
			infos=Fe.readFile("src/tests/input/wrath.txt");
		} catch (FileNotFoundException e) {
			System.out.println("the file specified wasn't found");
		} catch (IOException e) {
			System.out.println("error while reading file");
		}
		System.out.println(infos.toString());
		
		UnitFactory unitF = UnitFactory.getInstance();
		AttackHelicopter testAttk =(AttackHelicopter) unitF.createUnit(Constants.WRATH, new Coordinates(15, 15, 0), Constants.PLAYER);
		System.out.println(testAttk.toString());
		Worker testWorker = (Worker) unitF.createUnit(Constants.TAPIR, new Coordinates(15, 15, 0), Constants.PLAYER);
		System.out.println("\n\n\n"+testWorker.toString());
	}
	
	
}
