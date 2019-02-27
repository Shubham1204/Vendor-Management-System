import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class SplashScreen extends JWindow{

	private JPanel contentPane;

	private int counter;
	private Timer timer;
	private boolean isVisible ;  //false
	private void plusProgress(){
		timer = new Timer(20,e->{
		if(counter>=100){
			timer.stop();
			Login login = new Login();
			login.setVisible(true);
			SplashScreen.this.setVisible(false);
			SplashScreen.this.dispose();
		}
		imglbl.setVisible(isVisible);
		isVisible = true;
			if(counter<=100){
		counter++;
		progressBar.setValue(counter);
		}
		});
		timer.start();
		
	}
	
	JLabel imglbl = new JLabel("");
	
	JProgressBar progressBar = new JProgressBar();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
					frame.plusProgress();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		Icon icon =new ImageIcon(SplashScreen.class.getResource("splas.jpg"));
		contentPane.setLayout(null);
		imglbl.setIcon(icon);
		imglbl.setBounds(110, 35, 233, 215);
		contentPane.add(imglbl);
		
		JLabel lblVendorManagementSystem = new JLabel("VENDOR MANAGEMENT SYSTEM");
		lblVendorManagementSystem.setFont(new Font("Wide Latin", Font.BOLD | Font.ITALIC, 13));
		lblVendorManagementSystem.setBounds(0, 11, 450, 31);
		contentPane.add(lblVendorManagementSystem);
		
		
		progressBar.setBounds(0, 272, 440, 14);
		contentPane.add(progressBar);
	}
}
