package tests;

import data.Constants;
import data.Coordinates;
import data.building.ResourceBuilding;
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
		ResourceBuilding ub = (ResourceBuilding) bf.createBuilding(Constants.UNION_MINE, new Coordinates(0, 0), Constants.PLAYER);
		System.out.println(ub.toString());
	}
}