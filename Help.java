import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Help extends JFrame {

	private JPanel contentPane;

	void contactus() {
		ContactUs contactus = new ContactUs();
		contactus.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	void aboutus() {
		AboutUs aboutus = new AboutUs();
		aboutus.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	void password() {
		ChangePassword changepassword = new ChangePassword();
		changepassword.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	void username() {
		ChangeUsername changeusername = new ChangeUsername();
		changeusername.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	void main() {
		MainScreen mainscreen = new MainScreen();
		mainscreen.setVisible(true);
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
					Help frame = new Help();
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
	public Help() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 400, 450, 300);
		//setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChangeUsename = new JButton("Change User Name");
		btnChangeUsename.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			username();
			}
		});
		btnChangeUsename.setBounds(25, 126, 182, 30);
		contentPane.add(btnChangeUsename);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			password();
			}
		});
		btnChangePassword.setBounds(217, 126, 168, 30);
		contentPane.add(btnChangePassword);
		
		JButton btnAboutUs = new JButton("About Us");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			aboutus();
			}
		});
		btnAboutUs.setBounds(217, 189, 168, 30);
		contentPane.add(btnAboutUs);
		
		JButton btnContactUs = new JButton("Contact Us");
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			contactus();
			}
		});
		btnContactUs.setBounds(25, 189, 182, 30);
		contentPane.add(btnContactUs);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			main();
			}
		});
		btnNewButton.setBounds(0, 0, 71, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblHelp = new JLabel("Help Us");
		lblHelp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblHelp.setBounds(165, 40, 96, 23);
		contentPane.add(lblHelp);
	}

}
