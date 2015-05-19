package com.lazarescu.licenta.biblioteca;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameInformatiiMembru extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameInformatiiMembru frame = new FrameInformatiiMembru();
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
	public FrameInformatiiMembru() {
		setTitle("Informatii membru");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIntroducetiNumeleDe = new JLabel(
				"Introduceti numele de utilizator :");
		lblIntroducetiNumeleDe.setBounds(10, 98, 171, 14);
		contentPane.add(lblIntroducetiNumeleDe);

		textField = new JTextField();
		textField.setBounds(184, 95, 216, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnAfisare = new JButton("Afisare");
		btnAfisare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				MeniuFunctii.informatiiMembru(username);

			}
		});
		btnAfisare.setBounds(171, 189, 89, 23);
		contentPane.add(btnAfisare);
	}

}
