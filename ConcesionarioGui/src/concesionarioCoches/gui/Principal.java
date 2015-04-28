package concesionarioCoches.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import concesionarioCoches.concesionario.Concesionario;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	private JFrame frame;
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnCoche;
	private JMenu mnBuscar;
	private JMenu mnAyuda;
	private Concesionario concesionario = new Concesionario();
	private Alta alta;
	private Baja baja;
	private Mostrar mostrar;
	private ElegirColor elegirColor;
	private MostrarPorMatricula mostrarPorMatricula;
	private About about;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Concesionario IES Gran Capitán");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevoConcesionario = new JMenuItem("Nuevo concesionario");
		mntmNuevoConcesionario.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_N, InputEvent.ALT_MASK | InputEvent.SHIFT_MASK));
		mnArchivo.add(mntmNuevoConcesionario);
		
		JMenuItem mntmAbrirConcesionario = new JMenuItem("Abrir concesionario...");
		mnArchivo.add(mntmAbrirConcesionario);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mnArchivo.add(mntmGuardarComo);
		
		mnArchivo.addSeparator();
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnArchivo.add(mntmSalir);
		
		mnCoche = new JMenu("Coche");
		mnCoche.setMnemonic('C');
		menuBar.add(mnCoche);
		
		JMenuItem mntmAlta = new JMenuItem("Alta");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alta();
			}
		});
		mntmAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnCoche.add(mntmAlta);
		
		JMenuItem mntmBaja = new JMenuItem("Baja");
		mntmBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				baja();
			}
		});
		mntmBaja.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnCoche.add(mntmBaja);
		
		JMenuItem mntmMostrarConcesionario = new JMenuItem("Mostrar concesionario");
		mntmMostrarConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
			}
		});
		mnCoche.add(mntmMostrarConcesionario);
		
		mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('B');
		menuBar.add(mnBuscar);
		
		JMenuItem mntmCochePorMatricula = new JMenuItem("Por matr\u00EDcula...");
		mntmCochePorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorMatricula();
			}
		});
		mnBuscar.add(mntmCochePorMatricula);
		
		JMenuItem mntmCochePorColor = new JMenuItem("Por color...");
		mntmCochePorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorColor();
			}
		});
		mnBuscar.add(mntmCochePorColor);
		
		mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mnAyuda.add(mntmAyuda);
		
		JMenuItem mntmSobreConcesionario = new JMenuItem("Sobre concesionario");
		mntmSobreConcesionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				about = new About();
				about.setVisible(true);
			}
		});
		mnAyuda.add(mntmSobreConcesionario);
		
		frame.getContentPane().setLayout(null);
	}

	private void alta() {
		alta = new Alta(concesionario);
		alta.setVisible(true);
	}
	
	private void baja() {
		baja = new Baja(concesionario);
		baja.setVisible(true);
	}
	
	private void mostrar() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrar = new Mostrar(concesionario);
		mostrar.setVisible(true);
	}

	private void mostrarPorColor() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		elegirColor = new ElegirColor(concesionario);
		elegirColor.setVisible(true);
	}
	
	private void mostrarPorMatricula() {
		if (concesionario.size() == 0) {
			JOptionPane.showMessageDialog(frame.getContentPane(),
					"No hay coches en el concesionario.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		mostrarPorMatricula = new MostrarPorMatricula(concesionario);
		mostrarPorMatricula.setVisible(true);
	}
	
}
