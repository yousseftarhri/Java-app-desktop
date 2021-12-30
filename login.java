package gestion_de_stock;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Base obj = new Base();
		setBounds(100, 100, 871, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(339, 106, 104, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = new String(passwordField.getPassword());
                Object[] x = obj.getData_2();
                if(textField.getText().equals("admin") && password.equals("admin")) {
					JOptionPane.showMessageDialog(null, "Good");
					//Fournisseur obj2= new Fournisseur();

                }
                else {
					JOptionPane.showMessageDialog(null, "Incorrect name or pass");
					//System.out.println(txtn.getText()+" "+txtn.getText());

                }
			}
		});
		btnConnect.setBounds(339, 309, 100, 24);
		contentPane.add(btnConnect);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(235, 108, 56, 14);
		contentPane.add(lblNom);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(235, 212, 88, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(339, 210, 104, 18);
		contentPane.add(passwordField);
	}
}
