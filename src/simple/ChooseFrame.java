package simple;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChooseFrame extends JFrame{
	
	public ChooseFrame(){
		
	}
	
	public void createFrame(){

		JButton buttonLogin = new JButton("Login");
		JButton buttonRegister = new JButton("Register");
		
		JPanel jpChoose = new JPanel(new GridLayout(2, 1));
		
		jpChoose.setBorder(BorderFactory.createEmptyBorder(20, 20,
				20, 20));
		jpChoose.add(buttonLogin, BorderLayout.WEST);
		jpChoose.add(buttonRegister, BorderLayout.CENTER);
		
		add(jpChoose, BorderLayout.CENTER);
		
		buttonLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Password passwordFrame = new Password();
				passwordFrame.setVisible(true);
				passwordFrame.createFrame();
				passwordFrame.setTitle("Login");
				passwordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				passwordFrame.setSize(300, 100);
				passwordFrame.setLocationRelativeTo(null);
				
				setVisible(false);
			}
		});
		buttonRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Register registerFrame = new Register();
				registerFrame.setVisible(true);
				registerFrame.createFrame();
				registerFrame.setTitle("Login");
				registerFrame.setSize(300, 60);
				registerFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				registerFrame.setLocationRelativeTo(null);
				
				setVisible(false);
			}
		});
	}
}
