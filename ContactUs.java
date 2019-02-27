import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ContactUs extends JFrame {

	private JPanel contentPane;

	void back() {
		Help help = new Help();
		help.setVisible(true);
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
					ContactUs frame = new ContactUs();
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
	public ContactUs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setBounds(90, 116, 98, 39);
		contentPane.add(lblContactNumber);
		
		JLabel lblContactEmail = new JLabel("Contact Email");
		lblContactEmail.setBounds(266, 112, 121, 54);
		contentPane.add(lblContactEmail);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				back();
			}
		});
		btnBack.setBounds(0, 0, 73, 23);
		contentPane.add(btnBack);
		
		JLabel lblContactUs = new JLabel("     Contact Us");
		lblContactUs.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblContactUs.setBounds(114, 35, 184, 38);
		contentPane.add(lblContactUs);
		
		JLabel label = new JLabel("+91 9876543210");
		label.setBounds(90, 148, 98, 22);
		contentPane.add(label);
		
		JLabel lblAbcgmailcom = new JLabel("abc@gmail.com");
		lblAbcgmailcom.setBounds(266, 156, 98, 14);
		contentPane.add(lblAbcgmailcom);
	}
}
