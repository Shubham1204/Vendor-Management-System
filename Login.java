import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	void checkLogin() {
		String emailid = textField.getText();
		String pass = passwordField.getText();
//		if(userid.equals(pass)) {
//			MainScreen mainscreen = new MainScreen();
//			mainscreen.setVisible(true);
//			this.setVisible(false);
//			this.dispose();
//		}
			try {
				
				FileInputStream fi = new FileInputStream("F:\\user.dat");
				ObjectInputStream oi = new ObjectInputStream(fi);
				
				//Read Object from file
				User u1 = (User)oi.readObject();
				if(emailid.equals(u1.Email()) && pass.equals(u1.Password())) {
					
				MainScreen mainscreen = new MainScreen();
				mainscreen.setVisible(true);
				this.setVisible(false);
				this.dispose();
				}
							
				//System.out.println(u1.toString());
						
				//System.out.println(v1.Name());
						
				oi.close();
				fi.close();
			
			}
			catch(FileNotFoundException e){
				System.out.println("File Not Found");
			} catch (IOException e) {
				System.out.println("Error Intilizing stream");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Class not Found");
				e.printStackTrace();
			}
			
			
	}
	
	
	
	void createaccount(){
		CreateAccount createaccount = new CreateAccount();
		createaccount.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginScreen = new JLabel("Login Screen");
		lblLoginScreen.setBounds(168, 49, 75, 19);
		contentPane.add(lblLoginScreen);
		
		JLabel lblNewLabel = new JLabel("Email Id:");
		lblNewLabel.setBounds(41, 96, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(41, 121, 58, 19);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkLogin();
			}
		});
		btnLogin.setBounds(154, 175, 89, 23);
		contentPane.add(btnLogin);
		
		textField = new JTextField();
		textField.setBounds(157, 93, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 120, 86, 20);
		contentPane.add(passwordField);
		
		JButton btnCreateANew = new JButton("Create A New Account");
		btnCreateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createaccount();
			}
		});
		btnCreateANew.setBounds(126, 227, 212, 23);
		contentPane.add(btnCreateANew);
		
//		if(invalid==true) {
//		JLabel lblInvalidUsernameOr = new JLabel("Invalid Username Or Password");
//		lblInvalidUsernameOr.setForeground(Color.RED);
//		lblInvalidUsernameOr.setBounds(126, 150, 158, 14);
//		contentPane.add(lblInvalidUsernameOr);
//		}

	}
}
