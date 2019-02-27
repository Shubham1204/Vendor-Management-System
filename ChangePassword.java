import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void back() {
		Help help = new Help();
		help.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	//User u;
	
	void submit() {
	
		String email_user = textField.getText();
		String old_password = passwordField.getText();
		String new_password = passwordField_1.getText();
		/**
		 * file User
		 */
		
	

		try {
			
			
			FileInputStream fi = new FileInputStream("F:\\user.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			FileOutputStream f = new FileOutputStream("F:\\user.dat");
			ObjectOutputStream o = new ObjectOutputStream(f);
			//write objects to file
			
			//Read Object from file
			User u1 = (User)oi.readObject();
			
			
			String first_name = u1.First_Name();
			String last_name = u1.Last_name();
			String email = u1.Email();
			String password = u1.Password();
			
			if(email_user==email && password==old_password) {
			User u = new User(first_name,last_name,email,new_password);
			o.writeObject(u);
			}
		
			o.close();
			oi.close();
			f.close();
			fi.close();
					
		}catch(FileNotFoundException e){
			System.out.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Intilizing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Class Not Found");
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * Create the frame.
	 */
	public ChangePassword() {
		
//		User u=null;
//		String userg = u.First_Name().toString();
//		System.out.println(userg);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblChangePassword.setBounds(118, 31, 207, 31);
		contentPane.add(lblChangePassword);
		
		JLabel lblUserName = new JLabel("Email Id");
		lblUserName.setBounds(23, 91, 63, 14);
		contentPane.add(lblUserName);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setBounds(23, 128, 89, 14);
		contentPane.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(23, 168, 89, 14);
		contentPane.add(lblNewPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			submit();
			}
		});
		btnSubmit.setBounds(157, 213, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
		});
		btnBack.setBounds(0, 0, 68, 23);
		contentPane.add(btnBack);
		
		textField = new JTextField();
		textField.setBounds(139, 88, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 125, 86, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(139, 165, 89, 20);
		contentPane.add(passwordField_1);
	}
}
