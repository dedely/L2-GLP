package process.builder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import data.Constants;
import data.faction.Faction;
import data.tree.BinaryTree;
import data.tree.Research;
import data.tree.Upgrade;
import tests.input.InputParameter;

public class ResearchTreeBuilder {
	public String faction;
	public static final String SEPARATOR = ";";
	
	public ResearchTreeBuilder(String faction) {
		this.faction = faction;
	}

	  public static BinaryTree BuildTree (Faction faction) throws IOException {
		BinaryTree binaryTree = new BinaryTree();

			try { 
					if (faction.getName().equals(Constants.UNION)) {
						BufferedReader upgradesFile = new BufferedReader(new FileReader(InputParameter.UPGRADES_UNION));
						String line = "";
						int index = 0;
						while ((line = upgradesFile.readLine()) != null) {
							Research research = new Research(null, -1, null, -1);
							String researchItem[] = line.split(" ");
							String tmp[] = researchItem[0].split(SEPARATOR);
							String upgrade[] = null;
							research.setName(researchItem[1]);
							research.setCost(toInt(researchItem[2]));
							research.setTimeLeft(toInt(researchItem[3]));
							research.setUnlocked(toBool(researchItem[4]));
							binaryTree.putResearch(index, research);
							for (String s : tmp) {
								Upgrade firstUpgrade = new Upgrade(null, -1);
								upgrade = s.split("=");
								firstUpgrade.setName(upgrade[0]);
								firstUpgrade.setValue(toInt(upgrade[1]));
								research.addUpgrade(firstUpgrade);
							}
							binaryTree.putResearch(index, research);
							index++;
							
						}
						upgradesFile.close();
					}
						else if (faction.getName().equals(Constants.REPUBLIC)) {
							BufferedReader upgradesFile = new BufferedReader(new FileReader(InputParameter.UPGRADES_REPUBLIC));
							String line = "";
							int index = 0;
							while ((line = upgradesFile.readLine()) != null) {
								Research research = new Research(null, -1, null, -1);
								String researchItem[] = line.split(" ");
								String tmp[] = researchItem[0].split(SEPARATOR);
								String upgrade[] = null;
								research.setName(researchItem[1]);
								research.setCost(toInt(researchItem[2]));
								research.setTimeLeft(toInt(researchItem[3]));
								research.setUnlocked(toBool(researchItem[4]));
								binaryTree.putResearch(index, research);
								for (String s : tmp) {
									Upgrade firstUpgrade = new Upgrade(null, -1);
									upgrade = s.split("=");
									firstUpgrade.setName(upgrade[0]);
									firstUpgrade.setValue(toInt(upgrade[1]));
									research.addUpgrade(firstUpgrade);
								}
								binaryTree.putResearch(index, research);
								index++;
								
							}
							upgradesFile.close();
						}
							else if (faction.getName().equals(Constants.FEDERATION)) {
								BufferedReader upgradesFile = new BufferedReader(new FileReader(InputParameter.UPGRADES_FEDERATION));
								String line = "";
								int index = 0;
								while ((line = upgradesFile.readLine()) != null) {
									Research research = new Research(null, -1, null, -1);
									String researchItem[] = line.split(" ");
									String tmp[] = researchItem[0].split(SEPARATOR);
									String upgrade[] = null;
									research.setName(researchItem[1]);
									research.setCost(toInt(researchItem[2]));
									research.setTimeLeft(toInt(researchItem[3]));
									research.setUnlocked(toBool(researchItem[4]));
									binaryTree.putResearch(index, research);
									for (String s : tmp) {
										Upgrade firstUpgrade = new Upgrade(null, -1);
										upgrade = s.split("=");
										firstUpgrade.setName(upgrade[0]);
										firstUpgrade.setValue(toInt(upgrade[1]));
										research.addUpgrade(firstUpgrade);
									}
									binaryTree.putResearch(index, research);
									index++;
									
								}
								upgradesFile.close();
							} 
			}
			catch (FileNotFoundException e){
				System.err.println(e);
			}
			finally {}
		 return binaryTree;
	  }

		private static int toInt(String string) {
		    return Integer.parseInt(string);
		} 
		
		private static boolean toBool(String string) {
		    return Boolean.parseBoolean(string);
		}
			  
	  public static void addToResearch (Research research, Upgrade upgrade) {
		  research.getUpgrades().add(upgrade);
	  }
}
