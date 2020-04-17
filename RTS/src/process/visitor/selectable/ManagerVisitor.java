package process.visitor.selectable;
import data.Selectable;
import data.building.DefenseBuilding;
import data.building.ResearchBuilding;
import data.building.ResourceBuilding;
import data.building.UnitBuilding;
import data.unit.AttackHelicopter;
import data.unit.GroundUnit;
import data.unit.GroundUnitWithMountedWeapon;
import data.unit.TransportHelicopter;
import data.unit.TroopTransport;
import data.unit.Worker;
import process.Faction;
import process.managers.AttackHeliManager;
import process.managers.DefenseBuildingManager;
import process.managers.ResourceBuildingManager;
import process.managers.SelectableManager;
import process.managers.UnitBuildingManager;
import process.managers.UnitManager;
import process.managers.WorkerManager;

/**
 * This visitor returns the appropriate manager for a given {@link Selectable}
 * 
 * @author Adel
 *
 */
public class ManagerVisitor implements SelectableVisitor<SelectableManager> {

	private Faction player;

	public ManagerVisitor(Faction player) {
		this.player = player;
	}

	@Override
	public SelectableManager visit(DefenseBuilding selectable) {
		return new DefenseBuildingManager(selectable);
	}

	@Override
	public SelectableManager visit(ResearchBuilding selectable) {
		return null;
	}

	@Override
	public SelectableManager visit(ResourceBuilding selectable) {
		return new ResourceBuildingManager(player, selectable);
	}

	@Override
	public SelectableManager visit(UnitBuilding selectable) {
		return new UnitBuildingManager(selectable, player);
	}

	@Override
	public SelectableManager visit(AttackHelicopter selectable) {
		return new AttackHeliManager(selectable);
	}

	@Override
	public SelectableManager visit(GroundUnit selectable) {
		return new UnitManager(selectable);
	}

	@Override
	public SelectableManager visit(GroundUnitWithMountedWeapon selectable) {
		return new UnitManager(selectable);
	}

	/**
	 * Not supported yet...
	 */
	@Override
	public SelectableManager visit(TransportHelicopter selectable) {
		return null;
	}

	/**
	 * Not supported yet...
	 */
	@Override
	public SelectableManager visit(TroopTransport selectable) {
		return null;
	}

	@Override
	public SelectableManager visit(Worker selectable) {
		return new WorkerManager(player, selectable);
	}

}