import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.DropMode;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	
	String firstname;
		
	void help() {
		Help help = new Help();
		help.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	void addvendor() {
		AddVendor addvendor = new AddVendor();
		addvendor.setVisible(true);
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
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	void searchvendor() {

		SearchVendor searchvendor = new SearchVendor();
		searchvendor.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}	
		
	void delete() {

			DeleteVendor deletevendor = new DeleteVendor();
			deletevendor.setVisible(true);
			this.setVisible(false);
			this.dispose();
	}

	void modify() {

		ModifyVendor modifyvendor = new ModifyVendor();
		modifyvendor.setVisible(true);
		this.setVisible(false);
		this.dispose();
}
	
	void logout() {
		Login login = new Login();
		login.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	void username() {
	try {
		
		FileInputStream fi = new FileInputStream("F:\\user.dat");
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		//Read Object from file
		User u1 = (User)oi.readObject();
		
		firstname=u1.First_Name();			
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

	
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		username();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddVendor = new JButton("Add Vendor");
		btnAddVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			addvendor();
			}
		});
		btnAddVendor.setBounds(10, 90, 89, 23);
		contentPane.add(btnAddVendor);
		
		JButton btnSearchVendor = new JButton("Search Vendor");
		btnSearchVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchvendor();
			}
		});
		btnSearchVendor.setBounds(109, 90, 89, 23);
		contentPane.add(btnSearchVendor);
		
		JButton btnDeleteVendor = new JButton("Delete Vendor");
		btnDeleteVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			delete();
			}
		});
		btnDeleteVendor.setBounds(208, 90, 89, 23);
		contentPane.add(btnDeleteVendor);
		
		JButton btnModifyVendorDetails = new JButton("Modify Vendor Details");
		btnModifyVendorDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			modify();
			}
		});
		btnModifyVendorDetails.setBounds(307, 90, 89, 23);
		contentPane.add(btnModifyVendorDetails);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				help();
			}
		});
		btnHelp.setBounds(158, 188, 89, 23);
		contentPane.add(btnHelp);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			logout();
			}
		});
		btnLogOut.setBounds(345, 0, 89, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblWelcome = new JLabel("WELCOME ");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblWelcome.setBounds(10, 23, 116, 38);
		contentPane.add(lblWelcome);
		
		
		JLabel lblUser = new JLabel(firstname);
		lblUser.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblUser.setBounds(136, 28, 121, 30);
		contentPane.add(lblUser);
	}
}
