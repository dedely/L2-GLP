package process.executor;

import data.Coordinates;
import data.faction.Faction;
import data.unit.Unit;
import process.SelectableRepository;
import process.factory.UnitFactory;
import process.managers.UnitManager;

public class CreateUnitExecutor implements Executor {

	private String unitToCreate;
	private Faction faction;
	private int totalTime;
	private int timeLeft;
	private Coordinates position;
	private boolean complete = false;

	public CreateUnitExecutor(String unitToCreate, int totalTime, Coordinates position, Faction faction) {
		this.unitToCreate = unitToCreate;
		this.totalTime = totalTime;
		timeLeft = totalTime;
		this.position = position;
	}

	@Override
	public boolean execute() {
		/*if(timeLeft == 0) {
			Unit unit = UnitFactory.createUnit(unitToCreate, position, faction);
			UnitManager manager = new UnitManager(unit);
			SelectableRepository r = SelectableRepository.getInstance();
			r.register(manager);
		}*/
		return complete;
	}

	public int getProgress() {
		int progress;
		if(timeLeft > 0) {
			progress = 1 - (timeLeft/totalTime);
		}else {
			progress = 1;
		}
		return progress;
	}

}