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

public class ModifyVendor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	String name;
	String company;
	String address;
	String software;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyVendor frame = new ModifyVendor();
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
	
	
	void modifyvendor() {

		try {
			
			FileOutputStream f = new FileOutputStream("F:\\sam.dat");
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			//FileInputStream fi = new FileInputStream("F:\\sam.dat");
			//ObjectInputStream oi = new ObjectInputStream(fi);
			
//			v1 = (Vendor)oi.readObject();
//			
			Vendor v = new Vendor(textField.getText() , textField_1.getText() , textField_2.getText() , textField_3.getText());
			
//			
//			name = textField.getText();
//			company = textField_1.getText();
//			address = textField_2.getText();
//			software = textField_3.getText();
//			
//			//v.Name() = name;
//			v = new Vendor(name,company,address,software);
			
			o.writeObject(v);
		//	V = (Vendor)o.writeObject();
			
			//Read Object from file
			
			
			//v1 = Vendor(textField.getText() , textField_1.getText() , textField_2.getText() , textField_3.getText());
			//int n1;
			//n1= v1.Name().hashCode(); 
			//v1.Name()= add(textField.getText());
			//name = name.replace(v1.Name(), textField.getText());
			
			//System.out.println(name);
			//v1 = new Vendor(name);
			
//			company = v1.company();
//			address = v1.Address();
//			software = v1.Software();
			
			//v1.Name().replace(name, textField.getText());
			
			//write objects to file
			//o.writeObject(v);
			
			o.close();
			f.close();
			
		//	oi.close();
		//	fi.close();
			
		
		}
		catch(FileNotFoundException e){
			System.out.println("File Not Found");
		} catch (IOException e) {
			System.out.println("Error Intilizing stream");
			e.printStackTrace();
		}
//			catch (ClassNotFoundException e) {
//			System.out.println("Class not Found");
//			e.printStackTrace();
//		}		
		}
	

//	private Vendor Vendor(String name, String company, String address, String software) {
//		// TODO Auto-generated method stub
//		this.name = name;
//		this.company = company;
//		this.address = address;
//		this.software = software;
//		return null;
//	}

	/**
	 * Create the frame.
	 */
	public ModifyVendor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModifyVendor = new JLabel("Modify Vendor");
		lblModifyVendor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblModifyVendor.setBounds(116, 30, 177, 25);
		contentPane.add(lblModifyVendor);
		
		JLabel lblVendorName = new JLabel("Vendor Name");
		lblVendorName.setBounds(36, 86, 89, 14);
		contentPane.add(lblVendorName);
		
		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(36, 121, 89, 14);
		contentPane.add(lblCompanyName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(36, 157, 46, 14);
		contentPane.add(lblAddress);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			back();
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblSoftwareRequired = new JLabel("Software Name");
		lblSoftwareRequired.setBounds(36, 192, 100, 14);
		contentPane.add(lblSoftwareRequired);
		
		JButton btnModifyVendor = new JButton("Modify Vendor");
		btnModifyVendor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			modifyvendor();
			}
		});
		btnModifyVendor.setBounds(167, 227, 126, 23);
		contentPane.add(btnModifyVendor);
		
		textField = new JTextField();
		textField.setBounds(187, 83, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 118, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 154, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 189, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}

}
