package simple;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Register extends JFrame{

	
	public Register(){
		
		
		/**create register frame*/
		
	}
	
	public void createFrame(){

		
		JLabel jlbRegister = new JLabel("Enter new password:");
		JPasswordField jpfRegister = new JPasswordField("");
	
		add(jlbRegister, BorderLayout.WEST);
		add(jpfRegister, BorderLayout.CENTER);
		
		jpfRegister.setEchoChar('*');
		jpfRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JPasswordField input = (JPasswordField) e.getSource();
				
				try {
					process(input.getPassword());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(input, "Success.");
				ChooseFrame chooseFrame = new ChooseFrame();
				chooseFrame.createFrame();
				chooseFrame.setSize(300, 200);
				chooseFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				chooseFrame.setLocationRelativeTo(null);
				chooseFrame.setVisible(true);
				setVisible(false);
			}
		});
	}

	public static void process(char[] newPassword) throws FileNotFoundException{
		File targetFile = new File("Password.txt");
		PrintWriter output = new PrintWriter(targetFile);
		
		output.print(newPassword);
	    output.close();
	}
}
