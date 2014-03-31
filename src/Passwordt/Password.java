package Passwordt;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Password extends JFrame{
	static Password passwordFrame = new Password();
	
	public Password(){
		JLabel jlbPassword = new JLabel("Enter the password:");
		JPasswordField jpfPassword = new JPasswordField("");
	
		add(jlbPassword, BorderLayout.WEST);
		add(jpfPassword, BorderLayout.CENTER);
		
		jpfPassword.setEchoChar('*');
		jpfPassword.addActionListener(new actionPassword());
	}
	
	private class actionPassword implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JPasswordField input = (JPasswordField) e.getSource();
			char[] password = input.getPassword();
			
			try {
				if(isPasswordCorrect(password)){
					JOptionPane.showMessageDialog(passwordFrame, "Correct password.");
				}else{
					JOptionPane.showMessageDialog(passwordFrame, 
							"Sorry. Try again.", "Error password.", 
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (HeadlessException | FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private static boolean isPasswordCorrect(char[] inputPassword) throws FileNotFoundException{
		File file = new File("Password.txt");
		Scanner input = new Scanner(file);
		char[] truePassword = input.next().toCharArray();
		input.close();
		if(truePassword.length != inputPassword.length)
			return false;
		for (int i = 0; i < inputPassword.length; i++)
			if (inputPassword[i] != truePassword[i])
				return false;

		
		return true;
	}
	
	public static void main(String[] args){
		passwordFrame.setTitle("Login");
		passwordFrame.setSize(300, 60);
		passwordFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		passwordFrame.setLocationRelativeTo(null);
		passwordFrame.setVisible(true);
	}
}
