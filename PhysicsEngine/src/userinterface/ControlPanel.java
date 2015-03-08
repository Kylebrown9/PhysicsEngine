package userinterface;

import java.awt.GridLayout;

import javax.swing.JPanel;

import simulator2d.Renderer2D;
import simulator2d.Simulator2D;

public class ControlPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Simulator2D simulator;
	Renderer2D r;
	ToggleButton playButton;
	
	public ControlPanel(Renderer2D renderer) {
		r = renderer;
		
		simulator = new Simulator2D(r);
		
		this.initToggleButton();
		
		this.setLayout(new GridLayout(1,5));
		this.add(playButton);
	}

	private void initToggleButton() {
		Runnable play = new Runnable() {
			public void run() {
				simulator.play();
			}
		};
		
		Runnable pause = new Runnable() {
			public void run() {
				simulator.pause();
			}
		};
		
		playButton = ToggleButton.createPlayPause(play, pause);
	}
}
