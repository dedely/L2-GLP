package process.builder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import data.Constants;
import data.faction.Faction;
import data.tree.Research;
import data.tree.Upgrade;

public class ResearchTreeBuilder {

	public String faction;
	public static final String SEPARATOR = ";";
	
	public ResearchTreeBuilder(String faction) {
		this.faction = faction;
	}

	
	  public void BuildTree (Faction faction, String fileName, String fileResearch) throws IOException {
		  Map<Integer, Research> treeMap = faction.getResearchTree().getResearches();
		  for (Map.Entry<Integer, Research> entry : treeMap.entrySet()) {
			String line, fields[];
			
			try { 
					if (faction.getName().equals(Constants.UNION)) {
						BufferedReader upgradesFileUnion = new BufferedReader(new FileReader(fileName));
						while ((line = upgradesFileUnion.readLine()) != null) {
							fields = line.split(SEPARATOR);
							for (String s : fields) {
								String name = " ";
								int value = -1;
								String elements[];
								elements = s.split(",");
								name = elements[0];
								value = Integer.parseInt(elements[1]);
								addToResearch(entry.getValue(), new Upgrade(name, value));
							}
							upgradesFileUnion.close();
						}
					}
						else if (faction.getName().equals(Constants.REPUBLIC)) {
							BufferedReader upgradesFileRepublic = new BufferedReader(new FileReader(fileName));
							while ((line = upgradesFileRepublic.readLine()) != null) {
								fields = line.split(SEPARATOR);
								for (String s : fields) {
									String name = " ";
									int value = -1;
									String elements[];
									elements = s.split(",");
									name = elements[0];
									value = Integer.parseInt(elements[1]);
									addToResearch(entry.getValue(), new Upgrade(name, value));
								}
								upgradesFileRepublic.close();
							}
						}
							else if (faction.getName().equals(Constants.FEDERATION)) {
								BufferedReader upgradesFileFederation = new BufferedReader(new FileReader(fileName));
								while ((line = upgradesFileFederation.readLine()) != null) {
									fields = line.split(SEPARATOR);
									for (String s : fields) {
										String name = " ";
										int value = -1;
										String elements[];
										elements = s.split(",");
										name = elements[0];
										value = Integer.parseInt(elements[1]);
										addToResearch(entry.getValue(), new Upgrade(name, value));
									}
									upgradesFileFederation.close();
							}
						
			}
			}catch (FileNotFoundException e) {
				System.err.println(e.getMessage());
			}catch (IOException e) {
				System.err.println(e.getMessage());
			}
			/*try {
				
				BufferedReader researchFileUnion = new BufferedReader(new FileReader (fileResearch));
				while ((line = researchFileUnion.readLine()) != null) {
					fields = line.split(SEPARATOR);
					for (String s : fields) {
						String name = " ";
						int cost = -1;
						boolean unlocked = false;
						String elements[];
						elements = s.split(",");
						name = elements[0];
						cost = Integer.parseInt(elements[1]);
						unlocked = Boolean.parseBoolean(elements[2]);
						
					}
				}
				researchFileUnion.close();
			}catch (IOException e) {
				System.err.println(e.getMessage());
			}
		
		  }*/
	  }
	  }
	  
	  public void addToResearch (Research research, Upgrade upgrade) {
		  research.getUpgrades().add(upgrade);
	  }
}
