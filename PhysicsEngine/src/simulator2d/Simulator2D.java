package simulator2d;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import things.ExampleThings;
import things.GraphicalObject2D;
import things.Thing;
import updaters.PausableUpdater;
import updaters.Updatable;

public class Simulator2D {
	/**
	 * 
	 */
	PausableUpdater pU;
	Engine2D e;
	
	Renderer2D r;
	List<Thing> things;
	
	/**
	 * Creates a simulator that outputs to the named renderer
	 * The things contained in the created simulator are the two default things
	 * inside of ExampleThings
	 * 
	 * @param r the renderer that this simulator outputs to
	 */
	public Simulator2D(Renderer2D r) {
		this.r = r;
		
		//*****************************************************
		things = new ArrayList<Thing>();
		things.add(ExampleThings.getSouthThing());
		things.add(ExampleThings.getNorthThing());	
		
		this.r.set(getGraphicObjects2D());
		
		//*****************************************************	
		e = new Engine2D(things);
		pU = new PausableUpdater((Updatable)this.r,(Updatable)e);
	}
	
	/**
	 * Creates a simulator that outputs to the named renderer
	 * The things contained in the created simulator are the things
	 * specified in the parameter
	 * 
	 * @param r the renderer that this simulator outputs to
	 * @param things designated things to simulate
	 */
	public Simulator2D(Renderer2D r, List<Thing> things) {
		this.r = r;
		
		//*****************************************************
		this.things = things;	
		
		this.r.set(getGraphicObjects2D());
		
		//*****************************************************
		e = new Engine2D(this.things);
		pU = new PausableUpdater((Updatable)this.r,(Updatable)e);
	}
	
	/**
	 * Plays the PausableUpdater contained in this Simulator
	 */
	public void play() {
		pU.play();
	} 
	
	/**
	 * Pauses the PausableUpdater contained in this Simulator
	 */
	public void pause() {
		pU.pause();
	}
	 
	/**
	 * 
	 * @return A list of the graphical object of each Thing in this Simulator
	 */
	public List<GraphicalObject2D> getGraphicObjects2D() {
		List<GraphicalObject2D> output = new ArrayList<GraphicalObject2D>();
		
		ListIterator<Thing> universeIT = things.listIterator();
		while(universeIT.hasNext()) {
			output.add(universeIT.next().getGraphicalObject2D());
		}
		
		return output;
	}
}
