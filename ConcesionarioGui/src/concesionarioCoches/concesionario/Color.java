/**
 * 
 */
package concesionarioCoches.concesionario;

/**
 * Se limitar�n los colores a tres: plata, rojo y azul. Para solicitar el color
 * al dar de alta al coche podr� implementarse un m�todo pedirColor que mediante
 * la gesti�n de un men�, devolver� el color indicado.
 * 
 * @author Elisa Navarro Zuara
 * @version 1.0
 */
public enum Color {
	
	/**
	 * Representa el color plata
	 */
	PLATA, 
	
	/**
	 * Representa el color rojo
	 */
	ROJO, 
	
	/**
	 * Representa el color azul
	 */
	AZUL;

	/**
	 * Array de colores
	 */
	private static final Color[] VALUES = Color.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del men�
	 * 
	 * @return Array de cadenas con las opciones del men�
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de colores
	 * 
	 * @return Array de colores
	 */
	public static Color[] getValues() {
		return VALUES;
	}

}