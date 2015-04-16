/**
 * 
 */
package concesionarioCoches.concesionario;

import java.util.ArrayList;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las
 * siguientes opciones:
 * <ol>
 * <li>Alta de un coche (se pedir� matricula, color y modelo).</li>
 * <li>Baja de un coche (por matr�cula).</li>
 * <li>Mostrar un coche (por matr�cula).</li>
 * <li>Mostrar concesionario (todos los coches del concesionario).</li>
 * <li>Contar el n�mero de coches en el concesionario.</li>
 * <li>Mostrar coches de un color.</li>
 * </ol>
 * L�gicamente, no podr� a�adirse un coche inv�lido o ya contenido (no pueden
 * existir dos coches con la misma matr�cula en el concesionario). Por cada
 * coche que se d� de alta, han de conocerse todas sus caracter�sticas. Ninguna
 * de las caracter�sticas del coche puede ser por defecto.
 * 
 * @author Elisa Navarro Zuara
 * @version 1.0
 */
public class Concesionario {
	
	/**
	 * Colecci�n de coches. No puede tener null.
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	
	/**
	 * Nombre del concesionario
	 */
	private final String nombre = "IES Gran Capit�n";

	/**
	 * A�ade un coche al almacen
	 * 
	 * @param matricula
	 *            Representa la matr�cula del coche a a�adir
	 * @param color
	 *            Representa el color del coche a a�adir
	 * @param modelo
	 *            Representa el modelo del coche a a�adir
	 * @return true si el coche se a�ade, false en otro caso (el coche es null o
	 *         el coche ya est� contenido en el almacen)
	 */
	public boolean annadir(String matricula, Color color, Modelo modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}

	/**
	 * Elimina un coche del almacen
	 * 
	 * @param matricula
	 *            Representa la matr�cula del coche a eliminar
	 * @return true si el coche se elimina, false en otro caso (el coche no est�
	 *         en el almacen)
	 */
	public boolean eliminar(String matricula) {
		return almacen.remove(Coche.instanciarCoche(matricula));
	}

	/**
	 * Devuelve el n�mero de coches del almacen
	 * 
	 * @return N�mero de coches del almacen
	 */
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el coche indicado por la matr�cula
	 * 
	 * @param matricula
	 *            Representa la matr�cula a buscar
	 * @return Coche contenido en el almacen. null si no existe
	 */
	public Coche get(String matricula) {
		Coche coche = Coche.instanciarCoche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		return null;
	}
	
	public Coche get(int index) {
		if(almacen.isEmpty())
			return null;
		if(index < 0 | index > almacen.size()-1)
			return null;
		return almacen.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	/**
	 * Genera una lista de coches de un determinado color
	 * 
	 * @param color
	 *            Representa el color a buscar
	 * @return Lista de coches de un determinado color
	 */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}