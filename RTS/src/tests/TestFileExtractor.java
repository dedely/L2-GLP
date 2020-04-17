package tests;

import data.Constants;
import data.Coordinates;
import data.unit.AttackHelicopter;
import data.unit.Worker;
import process.builder.FileExtractor;
import process.factory.UnitFactory;

public class TestFileExtractor {
	public static void main(String[] args) {
		FileExtractor Fe = new FileExtractor();
		UnitFactory unitF = UnitFactory.getInstance();
		AttackHelicopter testAttk = (AttackHelicopter) unitF.createUnit(Constants.WRATH, new Coordinates(15, 15, 0),
				Constants.PLAYER);
		System.out.println(testAttk.toString());
		Worker testWorker = (Worker) unitF.createUnit(Constants.TAPIR, new Coordinates(15, 15, 0), Constants.PLAYER);
		System.out.println("\n\n\n" + testWorker.toString());
	}
}