package cli.tests;

import cli.data.Coordinates;
import cli.data.Description;
import cli.data.faction.Faction;
import cli.data.tree.ResearchTree;
import cli.data.unit.ArtilleryLikeInfantry;

public class TestUnits {

	public static void main(String[] args) {
		Description goodGuysDescription = new Description("The ones fighting for the good things");
		Description mortarTeam1Description = new Description("mortar team of the *insert faction name here*");

		Faction goodGuys = new Faction("goodGuys", goodGuysDescription);
		Coordinates mortarTeam1Pos = new Coordinates(0, 0);
		ArtilleryLikeInfantry mortarTeam1 = new ArtilleryLikeInfantry(100, goodGuys, "mortar", mortarTeam1Pos,
				mortarTeam1Description, 10, 50, 2, 40, false, 2, 10);
		System.out.println(mortarTeam1.toString());
		
		Description badGuysDescription = new Description("The ones fighting for the good things");
		Description mortarTeam2Description = new Description("mortar team of the *insert faction name here*");

		Faction badGuys = new Faction("badGuys", badGuysDescription);
		Coordinates mortarTeam2Pos = new Coordinates(0, 0);
		ArtilleryLikeInfantry mortarTeam2 = new ArtilleryLikeInfantry(100, badGuys, "mortar", mortarTeam2Pos,
				mortarTeam2Description, 10, 50, 2, 40, false, 2, 10);
		System.out.println(mortarTeam2.toString());

	}

}
