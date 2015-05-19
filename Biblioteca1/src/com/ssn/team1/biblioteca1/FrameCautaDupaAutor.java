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

public class FrameCautaDupaAutor extends JFrame {

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
					FrameCautaDupaAutor frame = new FrameCautaDupaAutor();
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
	public FrameCautaDupaAutor() {
		setTitle("Cauta dupa autor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIntroducetiAutorul = new JLabel("Introduceti autorul :");
		lblIntroducetiAutorul.setBounds(65, 96, 121, 14);
		contentPane.add(lblIntroducetiAutorul);
		
		textField = new JTextField();
		textField.setBounds(196, 93, 121, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCauta = new JButton("Cauta !");
		btnCauta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			    boolean inputValid;
			 
				  String autor = textField.getText();
			      inputValid = !Validator.stringulEsteGol(autor);
			      if (!inputValid) {
			        System.out.println(" ! camp GOL");
			      }
			      else{
			    	  MeniuFunctii.cautareAutor(autor, inputValid);
			      }
			}
		});
		btnCauta.setBounds(150, 177, 89, 23);
		contentPane.add(btnCauta);
	}

}
