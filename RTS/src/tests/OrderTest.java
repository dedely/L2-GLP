package tests;

import java.util.ArrayList;
import java.util.Iterator;

import data.Constants;
import data.Coordinates;
import data.faction.Faction;
import data.order.MoveToPosition;
import data.unit.Unit;
import gui.elements.SimuPara;
import process.Game;
import process.OrderTreatment;
import process.SelectableRepository;
import process.factory.UnitFactory;

public class OrderTest {
	public static void main(String args[]) {
		Game game =new Game(Constants.DEFAULT_CONFIG);
		addTestUnits(game);
		SelectableRepository r = SelectableRepository.getInstance();
		r.select(new Coordinates(SimuPara.DEFAULT_CAMERA.getPositionX(), SimuPara.DEFAULT_CAMERA.getPositionY(), 0));
		OrderTreatment.giveOrderReplace(r.getSelected().get(0),new MoveToPosition(new Coordinates(10, 10), Constants.GO_AT_ALL_COST));
		System.out.println(r.getSelected().get(0).getPosition().toString());
		for(int i=0 ; i<55 ; i++) {
		System.out.println("execution");
		OrderTreatment.executeNextOrder((Unit)r.getSelected().get(0));
		System.out.println(r.getSelected().get(0).getPosition().toString());
		}
	}

	private static void addTestUnits(Game game) {
		ArrayList<Faction> factions = game.getState().getFactions();
		Iterator<Faction> factionIterator = factions.iterator();
		SelectableRepository.getInstance().register(UnitFactory.createUnit(Constants.TEST_GROUND,
				new Coordinates(SimuPara.DEFAULT_CAMERA.getPositionX(), SimuPara.DEFAULT_CAMERA.getPositionY(), 0),
				factionIterator.next()));
		SelectableRepository.getInstance().register(UnitFactory.createUnit(Constants.TEST_GROUND,
				new Coordinates(SimuPara.SCALE, SimuPara.SCALE, 0), factionIterator.next()));
	}

}
