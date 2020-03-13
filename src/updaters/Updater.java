package updaters;

import java.util.List;
import java.util.ListIterator;

public class Updater extends Thread {
	
	List<Updatable> updatables;
	
	public Updater(List<Updatable> updatables) {
		this.updatables = updatables;
	}
	
	public void run() {
		ListIterator<Updatable> updateIT;
		
		while(!this.isInterrupted()) {
			updateIT = updatables.listIterator();
			
			while(updateIT.hasNext()) {
				updateIT.next().updateStuff();
			}
		}
	}
}
