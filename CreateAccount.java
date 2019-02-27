import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class CreateAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblEmailId;
	private JTextField textField_2;
	private JPasswordField passwordField;

	
	/**
	 * Back to login	
	 */
	void login() {
		
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
			this.dispose();
	}
	
	
	void create_account() {
		
		User u;
		
		u = new User(textField.getText() , textField_1.getText() , textField_2.getText() , passwordField.getText());
		
		/**
		 * file User
		 */

		try {
			FileOutputStream f = new FileOutputStream("F:\\user.dat");
			ObjectOutputStream o = new ObjectOutputStream(f);
			//write objects to file
			o.writeObject(u);
			
			o.close();
			f.close();
			
		}
		catch(FileNotFoundException e){
			System.out.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Intilizing stream");
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount frame = new CreateAccount();
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
	public CreateAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setBounds(168, 11, 107, 26);
		contentPane.add(lblCreateAccount);
		
		JLabel lblName = new JLabel("User Name: ");
		lblName.setBounds(30, 69, 63, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setToolTipText("First Name");
		textField.setBounds(106, 66, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Last Name");
		textField_1.setBounds(203, 66, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(30, 138, 56, 14);
		contentPane.add(lblPassword);
		
		lblEmailId = new JLabel("Email ID: ");
		lblEmailId.setBounds(30, 108, 46, 14);
		contentPane.add(lblEmailId);
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			create_account();
			}
		});
		btnNewButton.setBounds(132, 203, 124, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAlreadyHaveAn = new JButton("Already Have An Account, Click Here!!");
		btnAlreadyHaveAn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			login();
			}
		});
		btnAlreadyHaveAn.setBounds(79, 237, 253, 23);
		contentPane.add(btnAlreadyHaveAn);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Email Id");
		textField_2.setBounds(106, 105, 183, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Password");
		passwordField.setBounds(106, 135, 183, 20);
		contentPane.add(passwordField);
	}
}
