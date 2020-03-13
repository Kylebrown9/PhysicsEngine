package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ToggleButton extends JButton implements ActionListener {

	private static final long serialVersionUID = 1L;
	boolean state = false;
	
	String s1;
	String s2;
	
	Runnable state1;
	Runnable state2;
	
	public static ToggleButton create(String s1, String s2, Runnable state1, Runnable state2) {
		ToggleButton tB = new ToggleButton(s1,s2,state2,state2);
		tB.addActionListener(tB);
		return tB;
	}
	
	public static ToggleButton createPlayPause(Runnable state1, Runnable state2) {
		ToggleButton tB = new ToggleButton(labels.play,labels.pause,state2,state2);
		tB.addActionListener(tB);
		return tB;
	}
	
	private ToggleButton(String s1, String s2, Runnable state1, Runnable state2) {
		super(s1);
		
		this.state1 = state1;
		this.state2 = state2;
		
		this.s1 = s1;
		this.s2 = s2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(state) {
			this.setText(s1);
			state1.run();
		} else {
			this.setText(s2);
			state2.run();
		}
		
		state = !state;
	}
	
	public class labels {
		public static final String play = "\u25B6";
		public static final String pause = "||"; 
	}
}
