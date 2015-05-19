package com.ssn.team1.biblioteca1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameCautareDupaTitlu extends JFrame {

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
					FrameCautareDupaTitlu frame = new FrameCautareDupaTitlu();
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
	public FrameCautareDupaTitlu() {
		setTitle("Cautare dupa titlu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroducetiTitlul = new JLabel("Introduceti titlul :");
		lblIntroducetiTitlul.setBounds(67, 101, 105, 14);
		contentPane.add(lblIntroducetiTitlul);
		
		textField = new JTextField();
		textField.setBounds(226, 98, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCauta = new JButton("Cauta !");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean inputValid;
			    String titlu = textField.getText();
		
			      inputValid = !Validator.stringulEsteGol(titlu);
			      if (!inputValid) {
			        InterfataUtilizator.showMessage(" ! camp GOL");
			      }else{
				MeniuFunctii.cautareTitlu(titlu);
			      }
			}
		});
		btnCauta.setBounds(140, 166, 89, 23);
		contentPane.add(btnCauta);
	}

}
