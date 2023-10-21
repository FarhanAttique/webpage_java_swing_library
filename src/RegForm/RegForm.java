package RegForm;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class RegForm extends JFrame {

	private JPanel contentPane;
	private JTextField FirstNameFeild;
	private JTextField EmailField;
	private JPasswordField PasswordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegForm frame = new RegForm();
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
	public RegForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Registration Form ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(77, 41, 118, 14);
		panel_1.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_1_2 = new JLabel("Email Address");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(60, 82, 135, 14);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(71, 132, 124, 14);
		panel_1.add(lblNewLabel_1_3);
	
		
		FirstNameFeild = new JTextField();
		FirstNameFeild.setBounds(205, 39, 157, 20);
		panel_1.add(FirstNameFeild);
		FirstNameFeild.setColumns(10);
		
		
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(205, 80, 157, 20);
		panel_1.add(EmailField);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(205, 130, 154, 20);
		panel_1.add(PasswordField);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					String url = "jdbc:mysql://localhost:3306/regform";
					String name = "root";
					String password = "";
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url,name,password);
					Statement s = con.createStatement();

				
						 
				//	 JOptionPane.showInputDialog(this, "Table Created SuccessFully ");
					
					String fname = FirstNameFeild.getText().toString();
				
					String em    = EmailField.getText().toString();
					String pass = PasswordField.getText().toString();
					
                   s.executeUpdate("INSERT INTO form(name,  Email, password,) "
                   		         + "VALUES ('"+fname+"','"+em+"','"+pass+"');");
					
					JOptionPane.showInputDialog(this, "Data Inserted Sueccfully");
					
				}catch(Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(148, 218, 103, 34);
		panel_1.add(btnNewButton);
	}
}
