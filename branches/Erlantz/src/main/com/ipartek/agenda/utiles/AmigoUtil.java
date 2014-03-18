package com.ipartek.agenda.utiles;

public class AmigoUtil {

	/**
	 * Se hace un trim antes de validar (quitar blancos delante y detrás del nombre) Se contemplan tildes y ñ Se hace un toLowerCase() del nombre
	 * Validar las siguientes condiciones del nombre y apellido del alumno
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
	 * @param nombre del alumno a chequear
	 * @return <b>True</b> si cumple las condiciones <b>False</b> en caso de no cumplirlas
	 */
	public static boolean checkNombre(String nombre) {

		boolean resul = false;
		if (nombre != null) {
			nombre = nombre.toLowerCase().trim();
			resul = nombre.matches("[a-z\\s-'áéíóúñ]{2,}");
		}
		return resul;
	}

	/**
	 * Metodo que pone la letra capital en mayuscula
	 * 
	 * @param cadena de texto
	 * @return cadena de texto con la letra inicial en Mayuscula
	 */
	public static String toCapitalCase(String cadena) {
		char _char = Character.toUpperCase(cadena.charAt(0));
		String subCadena = cadena.substring(1, cadena.length());
		return _char + subCadena.toLowerCase();
	}

	public static boolean checkNumeros(String telefono) {
		boolean result = false;
		if (telefono.startsWith("9") || telefono.startsWith("6")
				|| telefono.startsWith("3") || telefono.isEmpty()) {
			if (telefono.length() == 9 || telefono.isEmpty()) {
				result = true;
			}
		}
		return result;
	}
}
