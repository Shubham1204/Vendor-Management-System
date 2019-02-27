import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;

public class ChangeUsername extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeUsername frame = new ChangeUsername();
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
	
	void submit() {
		
		/**
		 * file User
		 */
		
	

		try {
			
			
			FileInputStream fi = new FileInputStream("F:\\user.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			FileOutputStream f = new FileOutputStream("F:\\user.dat");
			ObjectOutputStream o = new ObjectOutputStream(f);
			//write objects to file
			
			User u1 = (User)oi.readObject();
			if(textField.getText()==u1.First_Name()) {
			User u = new User(textField_1.getText());
			
			o.writeObject(u);
			}
			//Read Object from file
//			User u1 = (User)oi.readObject();
//			
//			
//			String first_name = u1.First_Name();
//			String last_name = u1.Last_name();
//			String email = u1.Email();
//			String password = u1.Password();
//			
//			if(textField.getText()==first_name) {
//				User u = new User(textField_1.getText());
//				o.writeObject(u);
//			}
		
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
	public ChangeUsername() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangeUserName = new JLabel("Change User Name");
		lblChangeUserName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblChangeUserName.setBounds(111, 23, 244, 32);
		contentPane.add(lblChangeUserName);
		
		JLabel lblOldUserName = new JLabel("Old User Name");
		lblOldUserName.setBounds(27, 97, 89, 14);
		contentPane.add(lblOldUserName);
		
		JLabel lblNewUserName = new JLabel("New User Name");
		lblNewUserName.setBounds(27, 132, 104, 14);
		contentPane.add(lblNewUserName);
		
		textField = new JTextField();
		textField.setBounds(159, 94, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 129, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				submit();
			}
		});
		btnSubmit.setBounds(159, 200, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
		});
		btnBack.setBounds(0, 0, 73, 23);
		contentPane.add(btnBack);
	}
}
