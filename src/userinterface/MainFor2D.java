package userinterface;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

import simulator2d.Renderer2D;

public class MainFor2D extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Renderer2D r;
	ControlPanel c;
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MainFor2D r = new MainFor2D();
	}
	
	public MainFor2D() {
		Container contentPane = this.getContentPane();
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		r = Renderer2D.create();
		contentPane.add(r);
		
		c = new ControlPanel(r);
		contentPane.add(c);
		
		layout.putConstraint(SpringLayout.NORTH, r, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, r, 0, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, r, 0, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, r, 0, SpringLayout.NORTH, c);
		
		layout.putConstraint(SpringLayout.NORTH, c, -150, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, c, 0, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, c, 0, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, c, 0, SpringLayout.SOUTH, contentPane);
		
		this.setVisible(true);
		this.pack();
	}
}
