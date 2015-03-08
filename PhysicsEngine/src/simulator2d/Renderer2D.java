package simulator2d;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JPanel;

import things.GraphicalObject2D;
import updaters.Updatable;

public class Renderer2D extends JPanel implements Updatable, ComponentListener {
	
	private static final long serialVersionUID = 1L;
	
	private int refX = 0;
	private int refY = 0;
	
	private List<GraphicalObject2D> universeGraphics;
	
	private Renderer2D() {
		setReferenceVariables();
		repaint();
	}
	
	/**
	 * Constructs a renderer, then adds a component listener to it
	 * 
	 * @return the newly constructed renderer
	 */
	public static Renderer2D create() {
		Renderer2D r = new Renderer2D();
		r.addComponentListener(r);
		return r;
	}
	
	public void set(List<GraphicalObject2D> universeGraphics) {
		this.universeGraphics = universeGraphics;
	}
	
	/**
	 * draws all of the GraphicalObject2Ds that it has
	 */
	public void paintComponent(Graphics g) {
		ListIterator<GraphicalObject2D> uGraphicsIT = universeGraphics.listIterator();
		
		while(uGraphicsIT.hasNext()) {
			uGraphicsIT.next().drawObject(g, refX, refY);
		}
	}
	
	/**
	 * repaints
	 */
	public void updateStuff() {
		repaint();
	}

	public void setReferenceVariables() {
		Dimension dim = getSize();
		refX = (int) dim.getWidth()/2;
		refY = (int) dim.getHeight()/2;
	}
	
	/**
	 * calls setReferenceVariables()
	 */
	@Override
	public void componentResized(ComponentEvent arg0) {
		setReferenceVariables();
	}
	
	@Override
	public void componentHidden(ComponentEvent arg0) {}
	@Override
	public void componentMoved(ComponentEvent arg0) {}
	@Override
	public void componentShown(ComponentEvent arg0) {}
}
