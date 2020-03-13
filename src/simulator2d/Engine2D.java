package simulator2d;

import java.util.List;
import java.util.ListIterator;

import things.Thing;
import updaters.Updatable;

public class Engine2D implements Updatable{
	
	List<Thing> universe;
	
	/**
	 * generates an engine with the designated list of things
	 * 
	 * @param universe
	 */
	public Engine2D(List<Thing> universe) {
		this.universe = universe;
	}
	
	/**
	 * updates each thing with the list of all things
	 */
	public void updateStuff() {
		ListIterator<Thing> universeIT = universe.listIterator();
		Thing temp;
		
		while(universeIT.hasNext()) {
			temp = universeIT.next();
			temp.update(universe);
		}
	}
}
