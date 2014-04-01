package simple;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class Password extends JFrame{
	
	public Password(){
		/**create password frame*/
	}
	
	public void createFrame(){

		JPanel p = new JPanel(new BorderLayout());
		JLabel jlbPassword = new JLabel("Enter the password:");
		JPasswordField jpfPassword = new JPasswordField("");
		p.setBorder(BorderFactory.createEmptyBorder(20, 20,
				20, 20));
		p.add(jlbPassword, BorderLayout.WEST);
		p.add(jpfPassword, BorderLayout.CENTER);
		
		add(p, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
		jpfPassword.setEchoChar('*');
		jpfPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JPasswordField input = (JPasswordField) e.getSource();
				char[] password = input.getPassword();
				
				try {
					if(isPasswordCorrect(password)){
						JOptionPane.showMessageDialog(input, "Correct password.");
						SimpleC computerFrame = new SimpleC();
						computerFrame.setVisible(true);
						computerFrame.setTitle("­pºâ¾÷");
						computerFrame.setSize(500, 350);
						computerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						computerFrame.setLocationRelativeTo(null);
						
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(input, 
								"Sorry. Try again.", "Error password.", 
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException | FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
	
}
