/**
 * 
 */
package concesionarioCoches.concesionario;

/**
 * Se limitar�n los modelos de coches a siete: C�rdoba (marca Seat), Toledo
 * (marca Seat), Ibiza (marca Seat), Serie 1 (marca BMW), Serie 2 (marca BMW),
 * Serie 3 (marca BMW) y Serie 5 (marca BMW). Para solicitar el modelo al dar de
 * alta al coche podr� implementarse un m�todo pedirModelo que mediante la
 * gesti�n de un men�, devolver� el modelo indicado.
 * 
 * @author Elisa Navarro Zuara
 * @version 1.0
 */
public enum Modelo {

	/**
	 * Representa el modelo Serie1
	 */
	SERIE1(Marca.BMW),

	/**
	 * Representa el modelo Serie2
	 */
	SERIE2(Marca.BMW),

	/**
	 * Representa el modelo Serie3
	 */
	SERIE3(Marca.BMW),

	/**
	 * Representa el modelo Serie5
	 */
	SERIE5(Marca.BMW),

	/**
	 * Representa el modelo Cordoba
	 */
	CORDOBA(Marca.SEAT),

	/**
	 * Representa el modelo Ibiza
	 */
	IBIZA(Marca.SEAT),

	/**
	 * Representa el modelo Toledo
	 */
	TOLEDO(Marca.SEAT);
	
	/**
	 * Marca del modelo
	 */
	private Marca marca;

	/**
	 * Construye un nuevo modelo de marca especificada
	 * 
	 * @param marca
	 *            Representa la marca del nuevo modelo
	 */
	private Modelo(Marca marca) {
		this.marca = marca;
	}

	/**
	 * Devuelve la marca del modelo
	 * 
	 * @return Marca del modelo
	 */
	public Marca getMarca() {
		return marca;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name();

	}

	// Para el men�-------------------------------------------------
	
	/**
	 * Array de modelos
	 */
	private static final Modelo[] VALUES = Modelo.values();

	/**
	 * Genera un array de cadenas con las distintas opciones del men�
	 * 
	 * @return Array de cadenas con las opciones del men�
	 */
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}

	/**
	 * Devuelve el array de modelos
	 * 
	 * @return Array de modelos
	 */
	public static Modelo[] getValues() {
		return VALUES;
	}
	// -------------------------------------------------

}