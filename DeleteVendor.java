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

public class DeleteVendor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	String name;
	String company;
	String address;
	String software;
	private JLabel labeladdress;
	private Object v;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteVendor frame = new DeleteVendor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void back() {
		MainScreen mainscreen = new MainScreen();
		mainscreen.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	
	void deletevendor() {

		try {
			
			FileInputStream fi = new FileInputStream("F:\\sam.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			FileOutputStream f = new FileOutputStream("F:\\sam.dat");
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			//Read Object from file
			Vendor v1 = (Vendor)oi.readObject();
			
			
			name = v1.Name();
			company = v1.company();
			
			if(company==textField_1.getText() && name==textField.getText() ) {
					Vendor v = null;
			}
					
			//write objects to file
			o.writeObject(v);
			
		oi.close();
		fi.close();
					
		o.close();
		f.close();
		
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
	public DeleteVendor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteVendor = new JLabel("Delete Vendor");
		lblDeleteVendor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblDeleteVendor.setBounds(133, 29, 174, 25);
		contentPane.add(lblDeleteVendor);
		
		JLabel lblVendorName = new JLabel("Vendor Name");
		lblVendorName.setBounds(30, 92, 101, 14);
		contentPane.add(lblVendorName);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(30, 134, 101, 14);
		contentPane.add(lblCompanyName);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnDeleteVendor = new JButton("Delete Vendor");
		btnDeleteVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			deletevendor();
			}
		});
		btnDeleteVendor.setBounds(153, 183, 89, 23);
		contentPane.add(btnDeleteVendor);
		
		textField = new JTextField();
		textField.setBounds(153, 89, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 131, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
