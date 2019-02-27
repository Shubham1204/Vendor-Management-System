import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AboutUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutUs frame = new AboutUs();
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
	
	/**
	 * Create the frame.
	 */
	public AboutUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblAboutUs.setBounds(155, 35, 153, 25);
		contentPane.add(lblAboutUs);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblAVendorManagement = new JLabel("A Vendor Management system is a system that allows");
		lblAVendorManagement.setBounds(78, 94, 296, 14);
		contentPane.add(lblAVendorManagement);
		
		JLabel lblYouToAdd = new JLabel("you to add a vendor, search a vendor, modify a");
		lblYouToAdd.setBounds(78, 121, 258, 14);
		contentPane.add(lblYouToAdd);
		
		JLabel lblVendorDeleteA = new JLabel("vendor and delete a vendor.");
		lblVendorDeleteA.setBounds(78, 146, 258, 14);
		contentPane.add(lblVendorDeleteA);
		
		JLabel lblVersion = new JLabel("Version 0.0.1");
		lblVersion.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVersion.setBounds(78, 184, 89, 14);
		contentPane.add(lblVersion);
	}
}
