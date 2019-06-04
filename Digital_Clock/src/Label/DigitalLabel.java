package Label;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class DigitalLabel extends JLabel implements ActionListener {
	String type;
	SimpleDateFormat sdf;

	public DigitalLabel(String type) {
		this.type = type;
		setForeground(Color.green);

		switch (type) {
		case "date":
			sdf = new SimpleDateFormat("  MMMM / dd / yyyy");
			setFont(new Font("sans-serif", Font.PLAIN, 12));
			setHorizontalAlignment(SwingConstants.LEFT);
			break;
		case "time":
			sdf = new SimpleDateFormat("hh:mm:ss a");
			setFont(new Font("sans-serif", Font.PLAIN, 40));
			setHorizontalAlignment(SwingConstants.CENTER);
			break;
		case "day":
			sdf = new SimpleDateFormat("EEEE  ");
			setFont(new Font("sans-serif", Font.PLAIN, 16));
			setHorizontalAlignment(SwingConstants.RIGHT);
			break;
		default:
			sdf = new SimpleDateFormat();
			break;
		}
		Timer t = new Timer(1000, this);
		t.start();
	}

	public void actionPerformed(ActionEvent e) {
		Date d = new Date();
		setText(sdf.format(d));
	}
}