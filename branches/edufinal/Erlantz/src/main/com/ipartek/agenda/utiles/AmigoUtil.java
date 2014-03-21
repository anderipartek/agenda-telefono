package com.ipartek.agenda.utiles;

/**
 * Clase para realizar validaciones tales como nombre, apellido, cp y telefonos.
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public final class AmigoUtil {
	/**
	 * Constructor final sin uso.
	 */
	private AmigoUtil() {
	}

	/**
	 * Se hace un trim antes de validar (quitar blancos delante y detrás del
	 * nombre) Se contemplan tildes y ñ Se hace un toLowerCase() del nombre
	 * Validar las siguientes condiciones del nombre y apellido del amigo
	 * <ol>
	 * <li>Que no sea null.</li>
	 * <li>La longitud minima de 2</li>
	 * <li>La longitud minima de 2 y sin espacio</li>
	 * <li>No contenga números.</li>
	 * <li>No empezar por espacio en blanco</li>
	 * <li>No empezar por caracter especial</li>
	 * <li>Permitir solo caracteres <b>'</b> <b>-</b></li>
	 * </ol>
	 * 
	 * @param nombre del amigo a chequear
	 * @return <b>TRUE</b> si cumple las condiciones <b>FALSE</b> en caso de no
	 *         cumplirlas
	 */
	public static boolean checkNombre(final String nombre) {
		boolean resul = false;
		String nombreC = nombre;
		if (nombreC != null) {
			nombreC = nombreC.toLowerCase().trim();
			resul = nombreC.matches("[a-z-'áéíóúñ]{2,}");
		}
		return resul;
	}

	/**
	 * Metodo para validar los numeros de telefono. Deben empezar por
	 * <ul>
	 * <li>Contenga numero del 0-9</li>
	 * <li>Tenga un tamaño de 9 dígitos</li>
	 * </ul>
	 * 
	 * @param telefono del amigo
	 * @return <b>TRUE</b> si es correcto y cumple los parametros / <b>FALSE</b>
	 *         si no se cumplen los parametros
	 */
	public static boolean checkNumeros(final String telefono) {
		boolean result = false;
		if (telefono.matches("[0-9]{9}")) {
			result = true;
		}
		return result;
	}

	/**
	 * Metodo para validar el Codigo Postal.
	 * <ul>
	 * <li>Deben estar comprendidos entre 0 -9</li>
	 * <li>Debe tener una longitud de 5</li>
	 * </ul>
	 * 
	 * @param cp codigo postal
	 * @return <b>TRUE</b> si es correcto el CP / <b>FALSE</b> si no es correcto
	 *         el CP
	 */
	public static boolean checkCP(final int cp) {
		boolean result = false;
		String codigo = String.valueOf(cp);
		if (codigo.matches("[0-9]{5}")) {
			result = true;
		}
		return result;
	}
}
