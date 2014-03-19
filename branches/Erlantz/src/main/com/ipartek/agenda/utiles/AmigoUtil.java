package com.ipartek.agenda.utiles;

public class AmigoUtil {

	/**
	 * Se hace un trim antes de validar (quitar blancos delante y detr�s del
	 * nombre) Se contemplan tildes y � Se hace un toLowerCase() del nombre
	 * Validar las siguientes condiciones del nombre y apellido del amigo
	 * <ol>
	 * <li>Que no sea null.</li>
	 * <li>La longitud minima de 2</li>
	 * <li>La longitud minima de 2 y sin espacio</li>
	 * <li>No contenga n�meros.</li>
	 * <li>No empezar por espacio en blanco</li>
	 * <li>No empezar por caracter especial</li>
	 * <li>Permitir solo caracteres <b>'</b> <b>-</b></li>
	 * </ol>
	 * 
	 * @param nombre del amigo a chequear
	 * @return <b>True</b> si cumple las condiciones <b>False</b> en caso de no
	 *         cumplirlas
	 */
	public static boolean checkNombre(final String nombre) {
		boolean resul = false;
		String nombreC = nombre;
		if (nombreC != null) {
			nombreC = nombreC.toLowerCase().trim();
			resul = nombreC.matches("[a-z-'������]{2,}");
		}
		return resul;
	}

	/**
	 * Metodo para validar los numeros de telefono. Deben empezar por
	 * <ul>
	 * <li>Contenga numero del 0-9</li>
	 * <li>Tenga un tama�o de 9 d�gitos</li>
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
	 * Metodo para validar el Codigo Postal
	 * <ul>
	 * <li>Deben estar comprendidos entre 0 -9</li>
	 * <li>Debe tener una longitud de 5</li>
	 * </ul>
	 * 
	 * @param cp
	 * @return
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
