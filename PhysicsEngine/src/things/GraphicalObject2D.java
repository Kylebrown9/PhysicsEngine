package things;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicalObject2D {
	
	int x, y;
	int r, d;
	Color c;
	
	public GraphicalObject2D(int x, int y, int size, Color c) {
		this.x = x;
		this.y = y;
		this.r = size;
		this.d = r*2;

		this.c = c;
	}
	
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void drawObject(Graphics g) {
		g.drawOval(x-r, y-r, d, d);
		System.out.println(x+y);
	}
	
	public void drawObject(Graphics g, int refX, int refY) {
		g.drawOval(x+refX-r, y+refY-r, d, d);
	}
	
	public double[] getPos() {
		double[] pos = {x,y};
		return pos;
	}
	
	public int getSize() {
		return r;
	}
	
	public Color getColor() {
		return c;
	}
}
