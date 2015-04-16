package concesionarioCoches.gui;

import javax.swing.JOptionPane;

import concesionarioCoches.concesionario.Coche;
import concesionarioCoches.concesionario.Concesionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarPorMatricula extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			MostrarPorMatricula dialog = new MostrarPorMatricula();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public MostrarPorMatricula(Concesionario concesionario) {
		super();
		setTitle("Mostrar por matricula");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		annadir.setVisible(false);
		eliminar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);
		
		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coche coche = concesionario.get(textField.getText());
				if (coche != null) {
					mostrarCoche(coche);
				} else {
					JOptionPane.showMessageDialog(contentPanel,
							"No existe ningún coche con esa matricula.", "Error",
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