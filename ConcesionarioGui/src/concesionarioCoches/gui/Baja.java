package concesionarioCoches.gui;

import javax.swing.JOptionPane;

import concesionarioCoches.concesionario.Coche;
import concesionarioCoches.concesionario.Concesionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Baja extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Baja dialog = new Baja();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Baja(Concesionario concesionario) {
		super();
		setTitle("Baja");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		annadir.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche coche = concesionario.get(textField.getText());
				if (coche != null) {
					mostrarCoche(coche);
					int n = JOptionPane.showOptionDialog(contentPanel,
							"¿Está seguro de que desea eliminarlo?", "Confirmar",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, null, null);
					
					switch (n) {
					case JOptionPane.YES_OPTION:
						concesionario.eliminar(textField.getText());
						break;
					}
				} else {
					JOptionPane.showMessageDialog(contentPanel,
							"No se ha podido eliminar.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	private void mostrarCoche(Coche coche) {
		switch (coche.getColor()) {
		case PLATA:
			radioButtonPlata.setSelected(true);
			break;
		case ROJO:
			radioButtonRojo.setSelected(true);
			break;
		case AZUL:
			radioButtonAzul.setSelected(true);
		}
		comboBoxMarca.addItem(coche.getModelo().getMarca());
		comboBoxMarca.setSelectedItem(coche.getModelo().getMarca());
		comboBoxModelo.addItem(coche.getModelo());
		comboBoxModelo.setSelectedItem(coche.getModelo());
	}

}