package hw_03;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyComputer extends JFrame {
	
	private JTextField numField = new JTextField();
	char num[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'C', '0', '.'};
	String cal[] = {"Shift", "¡Ò / ¡Ô", "¡Ñ / ^", "+", "-", "ENTER"};
	String cal2[] = {"sin / arcsin", "tan / arctan", "cos / arccos",
			"Log¢°¢¯", "¢J¡÷¢K", "¢K¡÷¢J", "Ln / e", "(1/x)", "£k"};
	JButton button1[] = new JButton[12];
	JButton button2[] = new JButton[6];
	JButton button3[] = new JButton[9];
	
	public MyComputer() {
		JPanel field = new JPanel(new GridLayout(1,1));
		numField.setText("0.0");
		numField.setHorizontalAlignment(SwingConstants.RIGHT);
		field.add(numField);
		
		JPanel p1 = new JPanel(new GridLayout(7, 3));
		for(int i = 0; i <= 8; i++){
			button3[i] = new JButton(cal2[i] + "");
			p1.add(button3[i]);
		}
		
		for(int i = 0; i <= 11; i++){
			button1[i] = new JButton(num[i] + "");
			p1.add(button1[i]);
		}
		
		JPanel p2 = new JPanel(new GridLayout(6,1));
		for(int i = 0; i <= 5; i++){
			button2[i] = new JButton(cal[i] + "");
			p2.add(button2[i]);
		}
		
		getContentPane().add(field, BorderLayout.NORTH);
		getContentPane().add(p2, BorderLayout.EAST);
		getContentPane().add(p1, BorderLayout.CENTER);
		
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MyComputer frame = new MyComputer();
		
		frame.setTitle("Computer");
		frame.setSize(300, 230);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
}
