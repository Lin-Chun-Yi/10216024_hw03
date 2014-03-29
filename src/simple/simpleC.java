package simple;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class simpleC extends JFrame{
	private String buttonNumber[] = {"7", "8", "9",
					                 "4", "5", "6",
					                 "1", "2", "3",
					                 "c", "0", "."};
	
	private String buttonName1[] = {"÷ / √", "× / ^", "+", "-", "="};
	
	private String buttonName2[] = {"sin", "tan", "cos",
									"Log１０", "℃→℉", "℉→℃",
									"Ln / e", "(1/x)", "π"};
	
	JButton buttonSign[] = new JButton[9];
	JButton buttonCenter[] = new JButton[12];
	JButton buttonWest[] = new JButton[7];
	JTextField numberField = new JTextField();
	JButton backspace = new JButton("backspace");
	JButton buttonN = new JButton("n!");
	JButton buttonShift = new JButton("Shift");
	
	double number;
	String numberstring = "";
	boolean doc = false;
	String operator;
	
	public simpleC(){
		JPanel p1 = new JPanel(new GridLayout(7, 3));
		JPanel p2 = new JPanel(new GridLayout(7, 1));
		
		for(int i = 0; i <= 8; i++){
			buttonSign[i] = new JButton(buttonName2[i]);
			p1.add(buttonSign[i]);
			buttonSign[i].addActionListener(new buttonAction());
		}
		
		for(int i = 0; i <= 11; i++){
			buttonCenter[i] = new JButton(buttonNumber[i]);
			p1.add(buttonCenter[i]);
			buttonCenter[i].addActionListener(new buttonAction());
		}
		
		p2.add(buttonShift);
		p2.add(buttonN);
		
		for(int i = 0; i <= 4; i++){
			buttonWest[i] = new JButton(buttonName1[i]);
			p2.add(buttonWest[i]);
			buttonWest[i].addActionListener(new buttonAction());
		}
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.WEST);
		add(numberField, BorderLayout.NORTH);
		add(backspace, BorderLayout.EAST);
		numberField.setText("0.0");
		numberField.setHorizontalAlignment(SwingConstants.RIGHT);
		
		backspace.addActionListener(new buttonAction());
		buttonN.addActionListener(new buttonAction());
	}
	
	private class buttonAction implements ActionListener{
		
		
		public void actionPerformed(ActionEvent event){
			if(((AbstractButton) event.getSource()).getText() == "."){
				if(doc == false){
					if (Double.parseDouble(numberField.getText()) == 0){
						numberstring = "0";
					}
					
					numberstring += ".";
					numberField.setText(numberstring);
					doc = true;
				}
				
			}else if(((AbstractButton) event.getSource()).getText() == "0" ||
					 ((AbstractButton) event.getSource()).getText() == "1" ||
					 ((AbstractButton) event.getSource()).getText() == "2" ||
				  	 ((AbstractButton) event.getSource()).getText() == "3" ||
				  	 ((AbstractButton) event.getSource()).getText() == "4" ||
				 	 ((AbstractButton) event.getSource()).getText() == "5" ||
					 ((AbstractButton) event.getSource()).getText() == "6" ||
					 ((AbstractButton) event.getSource()).getText() == "7" ||
					 ((AbstractButton) event.getSource()).getText() == "8" ||
					 ((AbstractButton) event.getSource()).getText() == "9"){
				numberstring += ((AbstractButton) event.getSource()).getText();
				numberField.setText(numberstring);
				
				if (numberField.getText() == "0")
					numberField.setText("0");
				
			}else if(((AbstractButton) event.getSource()).getText() == "="){
				numberField.setText(baseOperation(number,
	                    Double.parseDouble(numberField.getText()), 
	                    operator) + "");
				
			}else if(((AbstractButton) event.getSource()).getText() == "sin" ||
				 	 ((AbstractButton) event.getSource()).getText() == "cos" ||
				 	 ((AbstractButton) event.getSource()).getText() == "tan" ||
				 	 ((AbstractButton) event.getSource()).getText() == "Log１０" ||
				  	 ((AbstractButton) event.getSource()).getText() == "℃→℉" ||
				   	 ((AbstractButton) event.getSource()).getText() == "℉→℃" ||
				   	 ((AbstractButton) event.getSource()).getText() == "Ln / e" ||
				   	 ((AbstractButton) event.getSource()).getText() == "(1/x)" ||
				   	 ((AbstractButton) event.getSource()).getText() == "π" ){
				number = Double.parseDouble(numberField.getText());
				operator = (String) ((AbstractButton) event.getSource()).getText();
				numberstring = advancedOperation(number, operator) + "";
				numberField.setText(numberstring);
				
			}else if(((AbstractButton) event.getSource()).getText() == "c"){
				numberstring = "";
				numberField.setText("0");
				
			}else if(((AbstractButton) event.getSource()).getText() == "n!"){
				number = Double.parseDouble(numberField.getText());
				numberstring = factorial(number) + "";
				numberField.setText(numberstring);
				
			}else if(((AbstractButton) event.getSource()).getText() == "backspace"){
				//無法執行
				
			}else if(((AbstractButton) event.getSource()).getText() == "Shift"){
				//無法執行
				
			}else{
				number = Double.parseDouble(numberField.getText());
				
				doc = false;
				numberstring = "";
				
				numberField.setText(numberstring);
			
				operator = (String) ((AbstractButton) event.getSource()).getText();
			}
		}
	}
	
	public double baseOperation(double number1, double number2, String operator){
		if(operator == "+"){
			return number1 + number2;
		}else if(operator == "-"){
			return number1 - number2;
		}else if(operator == "÷ / √"){
			return number1 / number2;
		}else if(operator == "× / ^"){
			return number1 * number2;
		}else{
			return number2;
		}
	}
	
	public double advancedOperation(double number, String operator){
		if(operator == "sin"){
			return Math.sin(number);
		}else if(operator == "tan"){
			return Math.tan(number);
		}else if(operator == "cos"){
			return Math.cos(number);
		}else if(operator == "Log１０"){
			return Math.log10(number);
		}else if(operator == "℃→℉"){
			return number * 1.8 + 32;
		}else if(operator == "℉→℃"){
			return (number - 32) * 5 / 9;
		}else if(operator == "Ln / e"){
			return Math.log(number);
		}else if(operator == "(1/x)"){
			return 1 / number;
		}else{
			return number;
		}
	}
	
	public double factorial(double number){
		int num = (int)number;
		int sum = 1;
		
		for(int i = 1; i <= num; i++){
			sum *= i;
		}
		
		return sum;
	}
	
	public static void main(String[] args){
		simpleC frame = new simpleC();
		frame.setTitle("computer");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
