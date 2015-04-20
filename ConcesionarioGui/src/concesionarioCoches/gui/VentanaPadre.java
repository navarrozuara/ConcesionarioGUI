package concesionarioCoches.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.concesionario.Marca;
import concesionarioCoches.concesionario.Modelo;

public class VentanaPadre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JLabel lblMatricula;
	protected JLabel lblColor;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JRadioButton radioButtonPlata;
	protected JRadioButton radioButtonRojo;
	protected JRadioButton radioButtonAzul;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComboBox<Marca> comboBoxMarca;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JButton annadir;
	protected JButton eliminar;
	protected JButton buttonAnterior;
	protected JButton buttonSiguiente;
	protected JButton buscar;
	protected JButton salir;

	public VentanaPadre() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(26, 11, 76, 30);
		
		textField = new JTextField();
		textField.setBounds(106, 16, 177, 20);
		textField.setColumns(10);
		
		lblColor = new JLabel("Color");
		lblColor.setBounds(26, 58, 49, 14);
		
		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setBounds(106, 54, 65, 23);
		buttonGroup.add(radioButtonPlata);
		
		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setBounds(173, 54, 65, 23);
		buttonGroup.add(radioButtonRojo);
		
		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setBounds(238, 54, 65, 23);
		buttonGroup.add(radioButtonAzul);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(26, 99, 49, 14);
		
		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setBounds(106, 95, 65, 22);
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(106, 138, 92, 22);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 142, 49, 14);
		
		annadir = new JButton("A\u00F1adir");
		annadir.setBounds(205, 164, 86, 23);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(205, 164, 86, 23);
		
		buttonAnterior = new JButton("<");
		buttonAnterior.setBounds(205, 164, 43, 23);
		
		buttonSiguiente = new JButton(">");
		buttonSiguiente.setBounds(248, 164, 43, 23);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(205, 164, 86, 23);
		
		salir = new JButton("Salir");
		salir.setBounds(300, 164, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(lblMarca);
		getContentPane().add(lblModelo);
		getContentPane().add(lblColor);
		getContentPane().add(lblMatricula);
		getContentPane().add(radioButtonPlata);
		getContentPane().add(radioButtonRojo);
		getContentPane().add(radioButtonAzul);
		getContentPane().add(annadir);
		getContentPane().add(eliminar);
		getContentPane().add(buttonAnterior);
		getContentPane().add(buttonSiguiente);
		getContentPane().add(buscar);
		getContentPane().add(salir);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		getContentPane().add(textField);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}