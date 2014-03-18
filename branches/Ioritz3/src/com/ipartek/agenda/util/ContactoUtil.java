package com.ipartek.agenda.util;

import java.util.regex.Pattern;

/**
 * Clase de utilidades para Contacto
 * @author Ioritz Bereikua Etxebarria
 *
 */

public class ContactoUtil {
	/**
	 * Valida el nombre del contacto sea correcto. Se hace un Trim antes de
	 * validar Se contemplan tildes y ñ Se hace un lowerCase del nombre Valida
	 * las siguientes condiciones del nombre del alumno:
	 * <ol>
	 * <li>No null.</li>
	 * <li>longitud minima de 2</li>
	 * <li>longitud minima de 2 y sin espacio</li>
	 * <li>No contenga nuemeros</li>
	 * <li>No empezar espacio en blanco</li>
	 * <li>No empezar caracter especial</li>
	 * <li>Permitir solo caracteres <b>'</b> <b>-</b></li>
	 * </ol>
	 * 
	 **/
	
	
	
	/**
	 * 
	 * @param nombre del contacto a comprobar
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	
	
	// Método para comprobar que el nombre del alumno es al menos un caracter
	static public boolean checkNombre(String nombre) {
		boolean result = false;
		if (nombre != null) {
			nombre = nombre.toLowerCase().trim();

			String pattern = "[a-z\\s-'áéíóúñ]{2,}";

			result = nombre.matches(pattern);

		}
		return result;
	}
	

	/**
	 * Valida el apellido del contacto sea correcto.
	 * 
	 * @param apellido
	 *            apellido del contacto.
	 * @return<b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *                    contrario.
	 * 
	 */
	static public boolean checkApellido(String apellido) {
		return checkNombre(apellido);
	}
	
	/**
	 * Poner la letra nicial en mayúsculas.
	 * 
	 * @param nombre
	 *            cadena de texto.
	 * @return cadena con char inicial en Mayúscula.
	 */
	static public String toCapitalCase(String cadena) {
		char _char = Character.toUpperCase(cadena.charAt(0));
		String subcadena = cadena.substring(1, cadena.length());

		return _char + subcadena.toLowerCase();
	}
	
	static public boolean checkCalle(String calle){
		boolean result = false;
		if (calle != null) {
			calle = calle.toLowerCase().trim();

			String pattern = "[a-z\\s-'áéíóúñ]{15,}";

			result = calle.matches(pattern);

		}
		return result;
	}
	

	/**
	 * Valida el teléfono fijo del contacto sea correcto. Valida las siguientes
	 * condiciones del teléfono fijo del contacto:
	 * <ol>
	 * <li>No null.</li>
	 * <li>No vacío.</li>
	 * <li>longitud de 9 dígitos.</li>
	 * <li>Caracteres numéricos.</li>
	 * <li>Comienzo por 9 o por 8.</li>
	 * </ol>
	 * 
	 * @param telefono
	 *            Número de teléfono del contacto.
	 * @return <b>true</b> si cumple todas las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	static public boolean checkTelefonosFijos(String telefono) {
		boolean resultado = false;
		if (isTelephoneCorrect(telefono)) {
			char primerNumero = telefono.charAt(0);
			if (primerNumero == '9' || primerNumero == '8') {
				resultado = true;
			}

		}

		return resultado;
	}

	/**
	 * Valida el teléfono móvil del contacto sea correcto. Valida las siguientes
	 * condiciones del teléfono móvil del contacto:
	 * <ol>
	 * <li>No null.</li>
	 * <li>No vacío.</li>
	 * <li>longitud de 9 dígitos.</li>
	 * <li>Caracteres numéricos.</li>
	 * <li>Comienzo por 6 o por 7.</li>
	 * </ol>
	 * 
	 * @param movil
	 * @return
	 */
	static public boolean checkTelefonosMoviles(String movil) {
		boolean resultado = false;
		if (isTelephoneCorrect(movil)) {
			if (movil.charAt(0) == '6' || movil.charAt(0) == '7') {
				resultado = true;
			}
		}
		return resultado;
	}
	
	/**
	 * Comprueba que sólo posee caracteres numéricos
	 * 
	 * @param telefono
	 *            número de teléfono del contacto.
	 * @return <b>true</b> si sólo contiene caracteres numéricos, <b>false</b>
	 *         en caso contrario.
	 */
	private static boolean isOnlyNumeric(String telefono) {
		boolean resultado = false;
		// String pattern = "[a-zA-Z]+";
		String pattern = "[0-9]{9}+";
		if (Pattern.matches(pattern, telefono)) {
			resultado = true;
		}
		return resultado;
	}

	/**
	 * Comprueba características comunes de teléfonos fijos y móviles.
	 * 
	 * @param telefono
	 *            teléfono del contacto.
	 * @return <b>true</b> si cumple con las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	private static boolean isTelephoneCorrect(String telefono) {
		boolean resultado = false;
		if (telefono != null && !telefono.isEmpty()) {
			if (telefono.length() == 9) {
				if (isOnlyNumeric(telefono)) {
					resultado = true;
				}
			}
		}
		return resultado;
	}
	
	
	
	/**
	 * Valida si la localidad del contacto es valido
	 * @param localidad localidad donde vive el contacto de la agenda
	 * @return <b>true</b> si cumple con las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	
	private static boolean checkLocalidad(String localidad){
		boolean resultado = false;
		if (localidad != null) {
			localidad = localidad.toLowerCase().trim();

			String pattern = "[a-z\\s-'áéíóúñ]{1,}";

			resultado = localidad.matches(pattern);

		}
		return resultado;
	}
	
	/**
	 * Valida si la provincia del contacto sea valido
	 * @param provincia la provincia donde vive el contacto de la agenda
	 * @return <b>true</b> si cumple con las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	
	private static boolean checkProvincia(String provincia){
		boolean resultado = false;
		if (provincia != null) {
			provincia = provincia.toLowerCase().trim();

			String pattern = "[a-z\\s-'áéíóúñ]{2,}";

			resultado = provincia.matches(pattern);

		}
		return resultado;
	}
	
	/**
	 * Comprueba si el codigo postal solo posee caracteres numericos
	 * @param cp Codigo postal de la provincia donde vive el contacto
	 * @return <b>true</b> si cumple con las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	
	private static boolean checkCodigoPostal(String cp){
		boolean resultado = false;
		// String pattern = "[a-zA-Z]+";
		String pattern = "^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$";
		if (Pattern.matches(pattern, cp)) {
			resultado = true;
		}
		return resultado;
	}
	
	/**
	 * Comprueba que solo tenga caracteres numericos
	 * @param cp Codigo postal del contacto
	 * @return <b>true</b> si cumple con las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	
	private static boolean isCpOnlyNumeric(String cp) {
		boolean resultado = false;
		// String pattern = "[a-zA-Z]+";
		String pattern = "[0-9]{5}+";
		if (Pattern.matches(pattern, cp)) {
			resultado = true;
		}
		return resultado;
	}
	
	/**
	 * Comprueba características comunes del codigo postal.
	 * @param cp codido postal del contacto
	 * @return <b>true</b> si cumple con las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	
	private static boolean isCpCorrect(String cp) {
		boolean resultado = false;
		if (cp != null && !cp.isEmpty()) {
			if (cp.length() == 5) {
				if (isOnlyNumeric(cp)) {
					resultado = true;
				}
			}
		}
		return resultado;
	}
	
	




	

	
	

}
