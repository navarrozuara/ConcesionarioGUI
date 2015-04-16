package concesionarioCoches.gui;

import concesionarioCoches.concesionario.Coche;
import concesionarioCoches.concesionario.Concesionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mostrar extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Concesionario concesionario;
	private int indiceCoche = -1;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			Mostrar dialog = new Mostrar();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Mostrar(Concesionario concesionario) {
		super();
		setTitle("Mostrar concesionario");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		this.concesionario = concesionario;
		
		annadir.setVisible(false);
		eliminar.setVisible(false);
		buscar.setVisible(false);
		
		textField.setEnabled(false);
		
		radioButtonPlata.setEnabled(false);
		radioButtonRojo.setEnabled(false);
		radioButtonAzul.setEnabled(false);

		comboBoxMarca.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		
		buttonAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});
		
		buttonSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});
		actualizar();
	}
	
	void actualizar() {
		if (concesionario.size() == 0) {
			return;
		}
		indiceCoche = 0;
		mostrarCoche(concesionario.get(indiceCoche));
		comprobarBotones();		
	}
	
	private void mostrarSiguiente() {
		mostrarCoche(concesionario.get(++indiceCoche));
		comprobarBotones();
	}

	private void mostrarAnterior() {
		mostrarCoche(concesionario.get(--indiceCoche));
		comprobarBotones();
	}
	
	private void mostrarCoche(Coche coche) {
		textField.setText(coche.getMatricula());
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
	
	private void comprobarBotones() {
		if (concesionario.get(indiceCoche + 1) == null)
			buttonSiguiente.setEnabled(false);
		else
			buttonSiguiente.setEnabled(true);

		if (concesionario.get(indiceCoche - 1) == null)
			buttonAnterior.setEnabled(false);
		else
			buttonAnterior.setEnabled(true);
	}
	
}