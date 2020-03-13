package updaters;

import java.util.ArrayList;
import java.util.List;

public class PausableUpdater {
	Runnable update;
	Updater updater;
	List<Updatable> updatables = new ArrayList<Updatable>();
	
	public PausableUpdater(Updatable u) {
		updatables.add(u);
		
		updater = new Updater(updatables);
	}
	
	public PausableUpdater(Updatable u1, Updatable u2) {
		updatables.add(u1);
		updatables.add(u2);
		
		updater = new Updater(updatables);
	}
	
	/**
	 * constructs and starts a new Updater updating updatables
	 */
	public void play() {
		updater = new Updater(updatables);
		updater.start();
	}
	
	/**
	 * interrupts the current Updater
	 */
	public void pause() {
		updater.interrupt();
	}
}
