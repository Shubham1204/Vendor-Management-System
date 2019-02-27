import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SearchVendor extends JFrame {

	private JPanel contentPane;

	String name;
	String company;
	String address;
	String software;
	private JLabel labeladdress;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchVendor frame = new SearchVendor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Back Button
	 */
	void back() {

		MainScreen mainscreen = new MainScreen();
		mainscreen.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	/**
	 * Search vendor
	 */
	
	void searchvendor() {

	try {
		
		FileInputStream fi = new FileInputStream("F:\\sam.dat");
		ObjectInputStream oi = new ObjectInputStream(fi);
		
		//Read Object from file
		Vendor v1 = (Vendor)oi.readObject();
		
		name = v1.Name();
		company = v1.company();
		address = v1.Address();
		software = v1.Software();
				
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
	public SearchVendor() {
		searchvendor();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(10, 75, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblComapny = new JLabel("Comapny: ");
		lblComapny.setBounds(10, 115, 64, 14);
		contentPane.add(lblComapny);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(10, 159, 100, 14);
		contentPane.add(lblAddress);
		
		JLabel lblSoftwareRequired = new JLabel("Software Required: ");
		lblSoftwareRequired.setBounds(10, 194, 118, 14);
		contentPane.add(lblSoftwareRequired);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			back();
			}
		});
		btnBack.setBounds(0, 0, 64, 23);
		contentPane.add(btnBack);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			searchvendor();
			}
		});
		btnSearch.setBounds(172, 219, 89, 23);
		contentPane.add(btnSearch);
		
		JLabel labelname = new JLabel(name);
		labelname.setBounds(154, 75, 107, 14);
		contentPane.add(labelname);
		
		JLabel lblSearchVendor = new JLabel("  Search Vendor");
		lblSearchVendor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblSearchVendor.setBounds(115, 21, 198, 43);
		contentPane.add(lblSearchVendor);
		
		JLabel labelcomapny = new JLabel(company);
		labelcomapny.setBounds(154, 115, 107, 14);
		contentPane.add(labelcomapny);
		
		labeladdress = new JLabel(address);
		labeladdress.setBounds(154, 159, 107, 14);
		contentPane.add(labeladdress);
		
		JLabel labelsoftware = new JLabel(software);
		labelsoftware.setBounds(154, 194, 107, 14);
		contentPane.add(labelsoftware);
	}
}
