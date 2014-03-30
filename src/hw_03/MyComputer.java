/**
package hw_03;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MyComputer extends JFrame {
	
	private static JTextField numField = new JTextField();
	char num[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	String sign1[] = {"¡Ò / ¡Ô", "¡Ñ / ^", "+", "-", "ENTER"};
	String sign2[] = {"sin / arcsin", "tan / arctan", "cos / arccos",
			"Log¢°¢¯", "¢J¡÷¢K", "¢K¡÷¢J", "Ln / e", "(1/x)", "£k"};
	
	
	
	JButton buttonNum[] = new JButton[10];
	JButton buttonWest[] = new JButton[5];
	JButton buttonCenter[] = new JButton[9];
	
	JButton backspace = new JButton("backspace");
	JButton buttonN = new JButton("n!");
	JButton buttonC = new JButton("C");
	JButton buttonDoc = new JButton(".");
	JButton buttonShift = new JButton("Shift");
	
	boolean doc = false;
	static long sum1 = 0;
	long sum2 = 0;
	long temp;
	
	public MyComputer() {
		JPanel field = new JPanel(new GridLayout(1, 1, 10, 5));
		numField.setText("0");
		numField.setHorizontalAlignment(SwingConstants.RIGHT);
		field.add(numField);
		
		JPanel back = new JPanel(new GridLayout(1, 1));
		back.add(backspace);
		
		JPanel p1 = new JPanel(new GridLayout(7, 3));
		for(int i = 0; i <= 8; i++){
			buttonCenter[i] = new JButton(sign2[i] + "");
			p1.add(buttonCenter[i]);
			buttonCenter[i].addActionListener(new buttonSign());
		}
		
		for(int i = 7; i <= 9; i++){
			buttonNum[i] = new JButton(num[i] + "");
			p1.add(buttonNum[i]);
			buttonNum[i].addActionListener(new buttonNumber());
		}
		for(int i = 4; i <= 6; i++){
			buttonNum[i] = new JButton(num[i] + "");
			p1.add(buttonNum[i]);
			buttonNum[i].addActionListener(new buttonNumber());
		}
		for(int i = 1; i <= 3; i++){
			buttonNum[i] = new JButton(num[i] + "");
			p1.add(buttonNum[i]);
			buttonNum[i].addActionListener(new buttonNumber());
		}
		p1.add(buttonC);
		buttonNum[0] = new JButton(num[0] + "");
		p1.add(buttonNum[0]);
		p1.add(buttonDoc);
		
		buttonNum[0].addActionListener(new buttonNumber());
		buttonC.addActionListener(new buttonNumber());
		buttonDoc.addActionListener(new buttonNumber());
		
		JPanel p2 = new JPanel(new GridLayout(7, 1));
		p2.add(buttonShift);
		p2.add(buttonN);
		for(int i = 0; i <= 4; i++){
			buttonWest[i] = new JButton(sign1[i] + "");
			p2.add(buttonWest[i]);
			buttonWest[i].addActionListener(new buttonSign());
		}
		
		getContentPane().add(field, BorderLayout.NORTH);
		getContentPane().add(p2, BorderLayout.LINE_START);
		getContentPane().add(p1, BorderLayout.CENTER);
		getContentPane().add(back, BorderLayout.EAST);
	}
	
	public class buttonNumber implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if (doc == false){
				if(e.getSource() == buttonNum[1]){
					temp = sum1 * 10;
					temp += 1;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[2]){
					temp = sum1 * 10;
					temp += 2;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[3]){
					temp = sum1 * 10;
					temp += 3;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[4]){
					temp = sum1 * 10;
					temp += 4;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[5]){
					temp = sum1 * 10;
					temp += 5;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[6]){
					temp = sum1 * 10;
					temp += 6;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[7]){
					temp = sum1 * 10;
					temp += 7;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[8]){
					temp = sum1 * 10;
					temp += 8;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[9]){
					temp = sum1 * 10;
					temp += 9;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonNum[0]){
					temp = sum1 * 10;
					temp += 0;
					sum1 = temp;
					numField.setText(String.format("%d%n", sum1));
				}else if(e.getSource() == buttonDoc){
					doc = true;
					numField.setText(String.format("%d%n.", sum1));
				}
			}else{
				if(e.getSource() == buttonNum[1]){
					temp = sum2 * 10;
					temp += 1;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[2]){
					temp = sum2 * 10;
					temp += 2;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[3]){
					temp = sum2 * 10;
					temp += 3;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[4]){
					temp = sum2 * 10;
					temp += 4;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[5]){
					temp = sum2 * 10;
					temp += 5;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[6]){
					temp = sum2 * 10;
					temp += 6;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[7]){
					temp = sum2 * 10;
					temp += 7;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[8]){
					temp = sum2 * 10;
					temp += 8;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[9]){
					temp = sum2 * 10;
					temp += 9;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}else if(e.getSource() == buttonNum[0]){
					temp = sum2 * 10;
					temp += 0;
					sum2 = temp;
					numField.setText(String.format("%d%n.%d%n", sum1, sum2));
				}
			}
			
			if(e.getSource() == buttonC){
				doc = false;
				sum1 = 0;
				sum2 = 0;
				numField.setText(String.format("%d%n", sum1));
			}
		}
	}
	
	public class buttonSign implements ActionListener{
		char baseSign;
		long number;
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == buttonWest[0]){
				baseSign = '¡Ò';
				numField.setText(String.format("%c", baseSign));
			}else if(e.getSource() == buttonWest[5]){
				number = Long.parseLong(numField.getText());
				baseOperation(baseSign, number);
			}
		}
	}
	
	public static void baseOperation(char base, long number){
		if (base == '/'){
			sum1 /= number;
			numField.setText(String.format("%d%n", sum1));
		}
	}
	
	/**
	 * Launch the application.
	 */
/**
	public static void main(String[] args) {
		MyComputer frame = new MyComputer();
		
		frame.setTitle("Computer");
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	
}
*/