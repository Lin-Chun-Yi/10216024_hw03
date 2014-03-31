package ppassword;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class password extends JFrame{
	public password(){
		JPanel p = new JPanel(new GridLayout(1,2));
		JLabel jlbPassword = new JLabel("Enter the password:");
		JPasswordField jpfPassword = new JPasswordField("");
		
		p.add(jlbPassword);
		p.add(jpfPassword);
		
		add(jlbPassword, BorderLayout.WEST);
		add(jpfPassword, BorderLayout.CENTER);
		
		jpfPassword.setEchoChar('*');
		jpfPassword.addActionListener(new actionPassword());
	}
	
	private class actionPassword implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
	
	private static boolean isPasswordCorrect(char[] inputPassword){
		
		
		return true;
	}
	
	public static void main(String[] args){
		password passwordFrame = new password();
		passwordFrame.setTitle("Login");
		passwordFrame.setSize(300, 60);
		passwordFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		passwordFrame.setLocationRelativeTo(null);
		passwordFrame.setVisible(true);
	}
}
