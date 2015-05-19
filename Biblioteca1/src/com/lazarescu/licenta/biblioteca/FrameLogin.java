package com.lazarescu.licenta.biblioteca;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrameLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField userTextField;
	private JButton btnLogin;
	private String password;
	private String username;
	private static FrameLogin frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new FrameLogin();
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
	public FrameLogin() {

		setTitle("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBiblioteca = new JLabel(
				"Bine ati venit ! \r\n\r\nBiblioteca V1.0\r\n");
		lblBiblioteca.setLabelFor(contentPane);
		lblBiblioteca.setToolTipText("");
		lblBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiblioteca.setBounds(66, 11, 286, 118);
		contentPane.add(lblBiblioteca);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(323, 206, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				password = passwordField.getText();
				username = userTextField.getText().trim();
				// frame.dispose();
				boolean inputValid = !Validator.stringulEsteGol(username)
						&& !Validator.stringulEsteGol(password);
				if (!inputValid) {
					InterfataUtilizator.showMessage(" ! camp GOL");
					// login(username,password);
				} else {
					MeniuFunctii.login(username, password);
				}

			}
		});

		passwordField = new JPasswordField();
		passwordField.setBounds(102, 207, 86, 20);
		contentPane.add(passwordField);

		userTextField = new JTextField();
		userTextField.setBounds(102, 176, 86, 20);
		contentPane.add(userTextField);
		userTextField.setColumns(10);

		JLabel lblUser = new JLabel("User :");
		lblUser.setBounds(10, 179, 46, 14);
		contentPane.add(lblUser);

		JLabel lblParola = new JLabel("Parola :");
		lblParola.setBounds(10, 210, 46, 14);
		contentPane.add(lblParola);
	}

}
