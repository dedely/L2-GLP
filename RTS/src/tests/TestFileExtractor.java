package tests;

import data.Constants;
import data.Coordinates;
import data.building.UnitBuilding;
import data.unit.AttackHelicopter;
import data.unit.Worker;
import process.builder.FileExtractor;
import process.factory.BuildingFactory;
import process.factory.UnitFactory;

public class TestFileExtractor {
	public static void main(String[] args) {
		FileExtractor Fe = new FileExtractor();
		BuildingFactory bf = BuildingFactory.getInstance();
		UnitBuilding ub = (UnitBuilding) bf.createBuilding(Constants.UNION_FACTORY, new Coordinates(0, 0), Constants.PLAYER);
		System.out.println(ub.toString());
	}
}