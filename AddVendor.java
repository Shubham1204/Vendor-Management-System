import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.*;
import java.io.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddVendor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVendor frame = new AddVendor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * void BAck button
	 */
	
	void back() {
		MainScreen mainscreen = new MainScreen();
		mainscreen.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	
	

	/**
	 * Void Submit Button
	 */
	
	void submit() {
		
	/**
	 * class vendor
	 */

//	class Vendor implements Serializable {
//
//		private static final long serialVersionUID = 1L;
//		private String name;
//		private String company;
//		private String address;
//		private String software;
//
//		Vendor(){ };
//		
//		Vendor(String name, String company, String address, String software){
//			this.name = name;
//			this.company = company;
//			this.address = address;
//			this.software = software;
//		}
//		@Override
//		public String toString() {
//			return "Name: " + name + "\nCompany: " + company + "\n Address: " + address + "\nSoftware: " + software; 
//		}
//	}

	Vendor v;
		
	v = new Vendor(textField.getText() , textField_1.getText() , textField_2.getText() , textField_3.getText());
	
	/**
	 * file vendor
	 */

	try {
		FileOutputStream f = new FileOutputStream("F:\\sam.dat");
		ObjectOutputStream o = new ObjectOutputStream(f);
		
		//write objects to file
		o.writeObject(v);
		
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
	 * Create the frame.
	 */
	public AddVendor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddVendor = new JLabel("Add Vendor");
		lblAddVendor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAddVendor.setBounds(170, 33, 92, 19);
		contentPane.add(lblAddVendor);
		
		JLabel lblName = new JLabel("Vendor Name");
		lblName.setBounds(23, 83, 80, 14);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(131, 80, 221, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCompany = new JLabel("Company Name");
		lblCompany.setBounds(23, 120, 80, 14);
		contentPane.add(lblCompany);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 117, 221, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(23, 166, 46, 14);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setBounds(131, 163, 221, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSoftwarerequired = new JLabel("Software Name");
		lblSoftwarerequired.setBounds(23, 201, 92, 14);
		contentPane.add(lblSoftwarerequired);
		
		textField_3 = new JTextField();
		textField_3.setBounds(131, 198, 221, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			submit();
			}
		});
		btnSubmit.setBounds(173, 238, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
		});
		btnBack.setBounds(310, 238, 89, 23);
		contentPane.add(btnBack);
	}
}
