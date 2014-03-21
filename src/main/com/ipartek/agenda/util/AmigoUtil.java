package com.ipartek.agenda.util;

import java.util.regex.Pattern;

/**
 * Clase de utilidades para Amigo.
 * Se comprueban las siguinetes caracteristicas de un amigo:
 * <ol>
 * 	<li>Nombre</li>
 * 	<li>Apellido</li>
 * 	<li>Calle</li>
 * 	<li>Población</li>
 * 	<li>Provincia</li>
 * 	<li>Código Postal</li>
 * 	<li>Teléfono fijo</li>
 * 	<li>Teléfono móvil</li>
 * </ol>
 * 
 * @author Patricia Navascués Vega
 * @version 1.0
 * @see com.ipartek.agenda.bean.Amigo
 */
public class AmigoUtil {

	private static final int LONGITUD_CP = 5;
	private static final char DIGITO_9 = '9';
	private static final char DIGITO_8 = '8';
	private static final char DIGITO_7 = '7';
	private static final char DIGITO_6 = '6';

	/***
	 * Valida el nombre del amigo sea correcto. Se hace un Trim antes de
	 * validar. Se contemplan tildes y ñs. Se hace un lower case del nombre
	 * Valida las siguientes condiciones del nombre del alumno:
	 * <ol>
	 * <li>No null.</li>
	 * <li>longitud minima de 2.</li>
	 * <li>longitud minima de 2 y sin espacio.</li>
	 * <li>No contenga numéros</li>
	 * <li>No empezar espacio en blanco</li>
	 * <li>No empezar caracter especial</li>
	 * <li>Permitir sólo carácteres <b>'</b> <b>-</b></li>
	 * </ol>
	 * 
	 * @param nombre
	 *            Nombre del alumno a comprobar.
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	// Método para comprobar que el nombre del alumno es al menos un caracter.

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
	 * Valida el apellido del amigo sea correcto.
	 * 
	 * @param apellido
	 *            apellido del amigo.
	 * @return<b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *                    contrario.
	 * @see com.ipartek.agenda.util.AmigoUtil.checkNombre.
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	static public boolean checkApellido(String apellido) {
		return checkNombre(apellido);
	}

	/**
	 * Valida el código postal del amigo.
	 * <ol>
	 * <li>Longitud de 5 dígitos</li>
	 * 
	 * </ol>
	 * 
	 * @param cp
	 *            código postal del amigo
	 * 
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	public static boolean checkCodigoPostal(int cp) {
		boolean resultado = false;

		if (String.valueOf(cp).length() == LONGITUD_CP) {
			resultado = true;
		}

		return resultado;

	}

	/**
	 * Valida el calle del amigo sea correcto.
	 * 
	 * @param calle
	 *            calle del amigo.
	 * @see com.ipartek.agenda.util.AmigoUtil.checkNombre.
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	public static boolean checkCalle(String calle) {
		return checkNombre(calle);
	}

	/**
	 * Valida el localidad del amigo sea correcto.
	 * 
	 * @param localidad
	 *            localidad del amigo.
	 * @see com.ipartek.agenda.util.AmigoUtil.checkNombre.
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	public static boolean checkLocalidad(String localidad) {
		return checkNombre(localidad);
	}

	/**
	 * Valida el provincia del amigo sea correcto.
	 * 
	 * @param provincia
	 *            provincia del amigo.
	 * @see com.ipartek.agenda.util.AmigoUtil.checkNombre.
	 * 
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *                    contrario.
	 */
	public static boolean checkProvincia(String provincia) {
		return checkNombre(provincia);
	}

	/**
	 * Valida el teléfono fijo del alumno sea correcto. Valida las siguientes
	 * condiciones del teléfono fijo del alumno:
	 * <ol>
	 * <li>No 000000000</li>
	 * <li>longitud de 9 dígitos.</li>
	 * <li>Caracteres numéricos.</li>
	 * <li>Comienzo por 9 o por 8.</li>
	 * </ol>
	 * 
	 * @param telefono
	 *            Número de teléfono del alumno.
	 * @return <b>true</b> si cumple todas las condiciones, <b>false</b> en caso
	 *         contrario.
	 */
	public static boolean checkTelefonosFijos(int telefono) {
		boolean resultado = false;
		if (isTelephoneCorrect(telefono)) {
			char primerNumero = String.valueOf(Math.abs((long) telefono)).charAt(0);
			if (primerNumero == DIGITO_9 || primerNumero == DIGITO_8) {
				resultado = true;
			}

		}

		return resultado;
	}

	/**
	 * Valida el teléfono móvil del amigo sea correcto. Valida las siguientes
	 * condiciones del teléfono móvil del amigo:
	 * <ol>
	 * <li>No 000000000</li>
	 * <li>longitud de 9 dígitos.</li>
	 * <li>Caracteres numéricos.</li>
	 * <li>Comienzo por 6 o por 7.</li>
	 * </ol>
	 * 
	 * @param movil
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *                    contrario.
	 */
	public static boolean checkTelefonosMoviles(int movil) {
		boolean resultado = false;
		if (isTelephoneCorrect(movil)) {
			char primerNumero = String.valueOf(Math.abs((long) movil)).charAt(0);
			if (primerNumero == DIGITO_6 || primerNumero == DIGITO_7) {
				resultado = true;
			}
		}
		return resultado;
	}

	/**
	 * Método para comprobar que los telefonos cumplen las caracteristicas
	 * comunes a fijos y moviles.
	 * <ol>
	 * <li>longitud de 9 dígitos.</li>
	 * <li>Caracteres numéricos.</li>
	 * </ol>
	 * 
	 * @param telefono
	 * @return <b>true</b> si cumple las condiciones, <b>false</b> en caso
	 *                    contrario.
	 */
	private static boolean isTelephoneCorrect(int telefono) {
		boolean resultado = false;
		String tel = String.valueOf(telefono);
		if (tel != null && !tel.isEmpty()) {
			if (tel.length() == 9) {
				if (isOnlyNumeric(tel)) {
					resultado = true;
				}
			}
		}
		return resultado;
	}

	/**
	 * Comprueba que sólo posee caracteres numéricos.
	 * 
	 * @param telefono
	 *            número de teléfono del amigo.
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
	 * Poner la letra nicial en mayúsculas.
	 * 
	 * @param cadena
	 *            cadena de texto.
	 * @return cadena con char inicial en Mayúscula.
	 */
	static public String toCapitalCase(String cadena) {
		char caracter = Character.toUpperCase(cadena.charAt(0));
		String subcadena = cadena.substring(1, cadena.length());

		return caracter + subcadena.toLowerCase();
	}
}
