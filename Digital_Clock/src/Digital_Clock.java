
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

import Label.*;

public class Digital_Clock {
	public static void main(String[] args) {
		DigitalLabel date = new DigitalLabel("date");
		DigitalLabel time = new DigitalLabel("time");
		DigitalLabel day = new DigitalLabel("day");
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame f = new JFrame("Digital Clock");
		f.setSize(300,150);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(3,1));
		
		f.add(date);
		f.add(time);
		f.add(day);
		
		f.getContentPane().setBackground(Color.black);
		
		f.setVisible(true);
	}
}
