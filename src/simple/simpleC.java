package simple;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class SimpleC extends JFrame{
	/**button name*/
	private String buttonNumber[] = {"7", "8", "9",
					                 "4", "5", "6",
					                 "1", "2", "3",
					                 "c", "0", "."};
	
	private String buttonName1[] = {"¡Ò / ¡Ô", "¡Ñ / ^", "+", "-", "="};
	
	private String buttonName2[] = {"sin / arcsin", "tan / arctan", "cos / arccos",
									"Log¢°¢¯", "¢J¡÷¢K", "¢K¡÷¢J",
									"Ln / e", "(1/x)", "£k"};
	
	/**button create*/
	JButton buttonSign[] = new JButton[9];
	JButton buttonCenter[] = new JButton[12];
	JButton buttonWest[] = new JButton[7];
	JTextField numberField = new JTextField();
	JButton backspace = new JButton("backspace");
	JButton buttonN = new JButton("n!");
	JButton buttonShift = new JButton("Shift");
	
	
	
	/**control variable, else variable*/
	double number; // remember the number to calculate 
	String numberstring = ""; //recode number in text field
	boolean doc = false; //control decimal
	String operator; //recode sign
	boolean shiftControl = false; //shift control
	int docControl = 0; //calculate decimal
	double numberCalaulate;
	boolean numC;
	
	/**set button, JFrame, Panel*/
	public SimpleC(){
		JPanel p1 = new JPanel(new GridLayout(7, 3));
		JPanel p2 = new JPanel(new GridLayout(7, 1));
		
		for(int i = 0; i <= 8; i++){//the sign for center above
			buttonSign[i] = new JButton(buttonName2[i]);
			p1.add(buttonSign[i]);
			buttonSign[i].addActionListener(new buttonAction());
		}
		
		for(int i = 0; i <= 11; i++){//the number and c, doc
			buttonCenter[i] = new JButton(buttonNumber[i]);
			p1.add(buttonCenter[i]);
			buttonCenter[i].addActionListener(new buttonAction());
		}
		
		p2.add(buttonShift);//shift button
		p2.add(buttonN);//n! button
		
		for(int i = 0; i <= 4; i++){//button west for base sign
			buttonWest[i] = new JButton(buttonName1[i]);
			p2.add(buttonWest[i]);
			buttonWest[i].addActionListener(new buttonAction());
		}
		
		/**add the panel to JFrame by BorderLayut*/
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.WEST);
		add(numberField, BorderLayout.NORTH);
		add(backspace, BorderLayout.EAST);
		numberField.setText("0.0"); //text field
		numberField.setHorizontalAlignment(SwingConstants.RIGHT); //the input location
		
		/**add to action listener*/
		backspace.addActionListener(new buttonAction());
		buttonN.addActionListener(new buttonAction());
		buttonShift.addActionListener(new buttonAction());
		buttonShift.setBackground(Color.cyan);
		
		numberField.setEditable(false);
		
		
		
	}
	
	/**action listener*/
	private class buttonAction implements ActionListener{
		/**action performed*/
		public void actionPerformed(ActionEvent event){
			if(((AbstractButton) event.getSource()).getText() == "."){ //the doc control
				if(doc == false){
					if (Double.parseDouble(numberField.getText()) == 0){ //Foolproof
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
					 ((AbstractButton) event.getSource()).getText() == "9"){ //the number input
				numberstring += ((AbstractButton) event.getSource()).getText();
				numberField.setText(numberstring);
				
				if(((AbstractButton) event.getSource()).getText() != "0")
					numC = true;
				
				if (numC == false){ //Foolproof
					number = 0;
					numberstring = "";
					numberField.setText("0");
					numC = true;
				}
				
				if(doc == true) //doc control
					docControl++;
				
			}else if(((AbstractButton) event.getSource()).getText() == "="){ //base operation
				numberCalaulate = Double.parseDouble(numberField.getText());
				numberstring = baseOperation(number, numberCalaulate, operator, shiftControl) + "";
				numberField.setText(numberstring);
				
			}else if(((AbstractButton) event.getSource()).getText() == "sin / arcsin" ||
				 	 ((AbstractButton) event.getSource()).getText() == "cos / arctan" ||
				 	 ((AbstractButton) event.getSource()).getText() == "cos / arccos" ||
				 	 ((AbstractButton) event.getSource()).getText() == "Log¢°¢¯" ||
				  	 ((AbstractButton) event.getSource()).getText() == "¢J¡÷¢K" ||
				   	 ((AbstractButton) event.getSource()).getText() == "¢K¡÷¢J" ||
				   	 ((AbstractButton) event.getSource()).getText() == "Ln / e" ||
				   	 ((AbstractButton) event.getSource()).getText() == "(1/x)" ||
				   	 ((AbstractButton) event.getSource()).getText() == "£k" ){ //advanced operation
				number = Double.parseDouble(numberField.getText());
				operator = (String) ((AbstractButton) event.getSource()).getText();
				numberstring = advancedOperation(number, operator, shiftControl) + "";
				numberField.setText(numberstring);
				
			}else if(((AbstractButton) event.getSource()).getText() == "c"){ //to reset zero
				numberstring = "";
				numberField.setText("0");
				numberCalaulate = 0;
				number = 0;
				numC = false;
				
			}else if(((AbstractButton) event.getSource()).getText() == "n!"){ //to calculate factorial
				number = Double.parseDouble(numberField.getText());
				numberstring = factorial(number) + "";
				numberField.setText(numberstring);
				
			}else if(((AbstractButton) event.getSource()).getText() == "backspace"){ //to delete final number
				char numChar[] = numberstring.toCharArray();
				numberstring = "";
				doc = false;
				for (int i = 0; i < numChar.length - 1; i++){
					numberstring += numChar[i];
				}
				numberField.setText(numberstring);
				if(docControl > 0){
					docControl--;
					doc = true;
				}
				
			}else if(((AbstractButton) event.getSource()).getText() == "Shift"){ //shift button
				//cyan is false, red is true
				if(shiftControl == true){
					shiftControl = false;
					buttonShift.setBackground(Color.cyan); 
				}else{
					shiftControl = true;
					buttonShift.setBackground(Color.red);
				}
				
			}else{//to set the sign prepared to calculate by based operation
				number = Double.parseDouble(numberField.getText());
				doc = false;
				numberstring = "";
				
				numberField.setText(numberstring);
				
				operator = (String)((AbstractButton) event.getSource()).getText();
			}
		}
	}
	
	/**based operation*/
	public double baseOperation(double number1, double number2, String operator, boolean shiftControl){
		if(shiftControl == false){
			if(operator == "+"){
				return number1 + number2;
			}else if(operator == "-"){
				return number1 - number2;
			}else if(operator == "¡Ò / ¡Ô"){
				return number1 / number2;
			}else if(operator == "¡Ñ / ^"){
				return number1 * number2;
			}else{
				return number2;
			}
		}else{
			if(operator == "+"){
				return number1 + number2;
			}else if(operator == "-"){
				return number1 - number2;
			}else if(operator == "¡Ò / ¡Ô"){
				return Math.pow(number1, 1 / number2);
			}else if(operator == "¡Ñ / ^"){
				return Math.pow(number1, number2);
			}else{
				return number2;
			}
		}
	}
	
	/**advanced operation*/
	public double advancedOperation(double number, String operator, boolean shiftControl){
		if (shiftControl == false){ //when shift is not
			if(operator == "sin / arcsin"){
				return Math.sin(number);
			}else if(operator == "tan / arctan"){
				return Math.tan(number);
			}else if(operator == "cos / arccos"){
				return Math.cos(number);
			}else if(operator == "Log¢°¢¯"){
				return Math.log10(number);
			}else if(operator == "¢J¡÷¢K"){
				return number * 1.8 + 32;
			}else if(operator == "¢K¡÷¢J"){
				return (number - 32) * 5 / 9;
			}else if(operator == "Ln / e"){
				return Math.log(number);
			}else if(operator == "(1/x)"){
				return 1 / number;
			}else if(operator == "£k"){
				return number * Math.PI;
			}else{
				return number;
			}
		}else{ //when shift is true
			if(operator == "sin / arcsin"){
				return Math.asin(number);
			}else if(operator == "tan / arctan"){
				return Math.atan(number);
			}else if(operator == "cos / arccos"){
				return Math.acos(number);
			}else if(operator == "Log¢°¢¯"){
				return Math.log10(number);
			}else if(operator == "¢J¡÷¢K"){
				return number * 1.8 + 32;
			}else if(operator == "¢K¡÷¢J"){
				return (number - 32) * 5 / 9;
			}else if(operator == "Ln / e"){
				return Math.exp(number);
			}else if(operator == "(1/x)"){
				return 1 / number;
			}else if(operator == "£k"){
				return number * Math.PI;
			}else{
				return number;
			}
		}
	}
	
	/**return the n!*/
	public double factorial(double number){
		int num = (int)number;
		int sum = 1;
		
		for(int i = 1; i <= num; i++){
			sum *= i;
		}
		
		return sum;
	}
	
	private static boolean isPasswordCorrect(char[] inputPassword) {
		char[] actualPassword = { '0', '0', '0', '0' };
		if (inputPassword.length != actualPassword.length)
			return false; // Return false if lengths are unequal
		for (int i = 0; i < inputPassword.length; i++)
			if (inputPassword[i] != actualPassword[i])
				return false;
		return true;
	}
	
	/**main method*/
	public static void main(String[] args){
		/**create the frame*/
		final SimpleC computerFrame = new SimpleC();
		computerFrame.setTitle("­pºâ¾÷");
		computerFrame.setSize(500, 350);
		computerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		computerFrame.setLocationRelativeTo(null);
		
		final JFrame passwordFrame = new JFrame("JPassword Usage Demo");
		JLabel jlbPassword = new JLabel("Enter the password: ");
		JPasswordField jpwName = new JPasswordField(10);
		jpwName.setEchoChar('*');
		jpwName.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JPasswordField input = (JPasswordField) e.getSource();
				char[] password = input.getPassword();
				if (isPasswordCorrect(password)) {
					JOptionPane.showMessageDialog(passwordFrame,
							"Correct  password.");
					passwordFrame.setVisible(false);
					computerFrame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(passwordFrame,
							"Sorry. Try again.", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JPanel jplContentPane = new JPanel(new BorderLayout());
		jplContentPane.setBorder(BorderFactory.createEmptyBorder(20, 20,
				20, 20));
		jplContentPane.add(jlbPassword, BorderLayout.WEST);
		jplContentPane.add(jpwName, BorderLayout.CENTER);
		passwordFrame.setContentPane(jplContentPane);
		passwordFrame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		passwordFrame.pack();
		passwordFrame.setVisible(false);
		passwordFrame.setLocationRelativeTo(null);
		
		final JFrame chooseFrame = new JFrame("register / login");
		JButton buttonLogin = new JButton("Login");
		JButton buttonRegister = new JButton("Register");
		JPanel jplSetWordFrame = new JPanel(new GridLayout(2, 1));
		jplSetWordFrame.add(buttonLogin);
		jplSetWordFrame.add(buttonRegister);
		chooseFrame.setContentPane(jplSetWordFrame);
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					passwordFrame.setVisible(true);
			}
		});
		buttonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					final File file = new File("password.txt");
					final JFrame setPass = new JFrame("Register");
					JLabel jlbSetPass = new JLabel("Enter the password: ");
					JPasswordField jpwSetPass = new JPasswordField(10);
					jpwSetPass.setEchoChar('*');
					jpwSetPass.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							JPasswordField input = (JPasswordField) e.getSource();
							char[] password = input.getPassword();
							try {
								PrintWriter output = new PrintWriter(file);
								output
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(passwordFrame,
									"Success.");
							chooseFrame.setVisible(true);
							setPass.setVisible(false);
						}
					});
			}
		});
		
		chooseFrame.setSize(200,100);
		chooseFrame.setLocationRelativeTo(null);
		chooseFrame.setVisible(true);
		
	}
}
