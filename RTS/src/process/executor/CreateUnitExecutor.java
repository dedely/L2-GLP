package process.executor;

import java.util.NoSuchElementException;

import data.Constants;
import data.Coordinates;
import data.Cost;
import data.Resource;
import data.building.UnitBuilding;
import data.order.MoveToPosition;
import data.unit.Unit;
import process.Faction;
import process.factory.TestFactory;
import process.managers.SelectableManager;
import process.repository.SelectableRepository;
import process.visitor.selectable.ManagerVisitor;

/**
 * @author Adel
 *
 */
public class CreateUnitExecutor implements Executor {

	private Faction testFaction;
	private UnitBuilding unitBuilding;
	private String unitToCreate;
	private Coordinates position;

	private Cost cost;
	private int timeLeft;
	private int totalTime;
	private boolean complete = false;

	/**
	 * The constructor prepares what's needed to create a new unit.
	 * 
	 * @param testFaction
	 * @param unitBuilding
	 * @param unitToCreate
	 */
	public CreateUnitExecutor(Faction testFaction, UnitBuilding unitBuilding, String unitToCreate) {
		this.testFaction = testFaction;
		this.unitBuilding = unitBuilding;
		this.unitToCreate = unitToCreate;
		position = unitBuilding.getPosition();
		try {
			cost = testFaction.getCost(unitToCreate);
			totalTime = cost.getTime();
			timeLeft = totalTime;
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public boolean execute() {
		if (timeLeft == totalTime) {
			try {
				Resource mats = testFaction.getResource(Constants.MATS);
				int currentCount = mats.getResourceCount();
				int price = cost.getCost();
				int newCount = currentCount - price;
				if (newCount >= 0) {
					testFaction.updateResource(Constants.MATS, newCount);
					timeLeft--;
				} else {
					complete = true;
				}
			} catch (NoSuchElementException e) {
				complete = true;
				System.err.println(e.getMessage());
			}
		} else if (timeLeft == 0) {
			try {
				SelectableRepository r = SelectableRepository.getInstance();
				Unit unit = TestFactory.createUnit(unitToCreate, testFaction.getPlayer(), position);
				Integer id = r.nextIdentity();
				unit.setId(id);
				ManagerVisitor visitor = new ManagerVisitor(testFaction);
				SelectableManager unitManager = unit.accept(visitor);
				testFaction.addNew(unitManager);
				r.addNew(unit);
				System.out.println(unitBuilding.getRallyPoint());
				unitManager.giveOrder(new MoveToPosition(unitBuilding.getRallyPoint(), Constants.GO_AT_ALL_COST));
			} catch (IllegalArgumentException e) {
				System.err.println(e.getMessage());
			}
			complete = true;
		} else {
			timeLeft--;
		}
		return complete;
	}

	public int getProgress() {
		int progress;
		if (timeLeft > 0) {
			progress = (int) (100 - ((timeLeft * 100.0f) / totalTime));
		} else {
			progress = 100;
		}
		return progress;
	}

}