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
	 * validar Se contemplan tildes y � Se hace un lowerCase del nombre Valida
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
	
	
	// M�todo para comprobar que el nombre del alumno es al menos un caracter
	static public boolean checkNombre(String nombre) {
		boolean result = false;
		if (nombre != null) {
			nombre = nombre.toLowerCase().trim();

			String pattern = "[a-z\\s-'������]{2,}";

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
	 * Poner la letra nicial en may�sculas.
	 * 
	 * @param nombre
	 *            cadena de texto.
	 * @return cadena con char inicial en May�scula.
	 */
	static public String toCapitalCase(String cadena) {
		char _char = Character.toUpperCase(cadena.charAt(0));
		String subcadena = cadena.substring(1, cadena.length());

		return _char + subcadena.toLowerCase();
	}
	

	/**
	 * Valida el tel�fono fijo del contacto sea correcto. Valida las siguientes
	 * condiciones del tel�fono fijo del contacto:
	 * <ol>
	 * <li>No null.</li>
	 * <li>No vac�o.</li>
	 * <li>longitud de 9 d�gitos.</li>
	 * <li>Caracteres num�ricos.</li>
	 * <li>Comienzo por 9 o por 8.</li>
	 * </ol>
	 * 
	 * @param telefono
	 *            N�mero de tel�fono del contacto.
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
	 * Valida el tel�fono m�vil del contacto sea correcto. Valida las siguientes
	 * condiciones del tel�fono m�vil del contacto:
	 * <ol>
	 * <li>No null.</li>
	 * <li>No vac�o.</li>
	 * <li>longitud de 9 d�gitos.</li>
	 * <li>Caracteres num�ricos.</li>
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
	 * Comprueba que s�lo posee caracteres num�ricos
	 * 
	 * @param telefono
	 *            n�mero de tel�fono del contacto.
	 * @return <b>true</b> si s�lo contiene caracteres num�ricos, <b>false</b>
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
	 * Comprueba caracter�sticas comunes de tel�fonos fijos y m�viles.
	 * 
	 * @param telefono
	 *            tel�fono del contacto.
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



	

	
	

}
