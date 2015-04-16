package concesionarioCoches.gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			About dialog = new About();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("Sobre concesionario");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText("Concesionario IES Gran Capit\u00E1n\r\n\r\nVersion: (1.1.0)\r\nBuild id: 0123456789\r\n(c) Copyright 2015.  All rights reserved.\r\n\r\nRealizado por:\r\n\tJuan Antonio Romero Molero\r\n\tElisa Navarro Zuara");
		textArea.setBounds(0, 0, 382, 153);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 382, 156);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(233, 173, 91, 23);
		
		getContentPane().setLayout(null);
		getContentPane().add(scrollPane);
		getContentPane().add(btnOk);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
}