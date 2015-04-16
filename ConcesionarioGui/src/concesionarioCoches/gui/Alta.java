package concesionarioCoches.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import concesionarioCoches.concesionario.Color;
import concesionarioCoches.concesionario.Concesionario;
import concesionarioCoches.concesionario.Marca;
import concesionarioCoches.concesionario.Modelo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alta extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Alta dialog = new Alta();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Alta(Concesionario concesionario) {
		super();
		setTitle("Alta");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		eliminar.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionario.annadir(textField.getText(), getColor(),
						(Modelo) comboBoxModelo.getSelectedItem()))
					JOptionPane.showMessageDialog(contentPanel,
							"Coche añadido con éxito.");
				else
					JOptionPane.showMessageDialog(contentPanel,
							"El coche no se ha podido añadir.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
	}
	
	private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
		Marca marca = (Marca) comboBoxMarca.getSelectedItem();
		ArrayList<Modelo> modelos = new ArrayList<Modelo>();
		for (Modelo m : Modelo.values()) {
			if (m.getMarca() == marca)
				modelos.add(m);
		}
		return modelos.toArray();
	}
	
	private Color getColor() {
		if (radioButtonPlata.isSelected())
			return Color.PLATA;
		else if (radioButtonRojo.isSelected())
			return Color.ROJO;
		else if (radioButtonAzul.isSelected())
			return Color.AZUL;
		else
			return null;
	}

}