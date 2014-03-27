package hw_03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyComputer extends JFrame {
	
	private JPanel contentPane;
	char num[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'C', '0', '.'};
	JButton button[] = new JButton[12];
	/**
	 * Create the frame.
	 */
	public MyComputer() {
		JPanel p1 = new JPanel(new GridLayout(4, 3));
		for(int i = 0; i <= 11; i++){
			button[i] = new JButton(num[i] + "");
			p1.add(button[i]);
		}
		
		add(p1, BorderLayout.SOUTH);
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
