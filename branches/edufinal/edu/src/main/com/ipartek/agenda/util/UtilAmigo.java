package com.ipartek.agenda.util;
/**
 * Clase que contiene los testeos propios de la clase Amigo
 * @author Eduardo Monterrubio
 *
 */
public class UtilAmigo {
	static boolean result;
	static String pattern,CPl,movill;
	/**
	 * Metodo que comprueba que el nombre tenga al menos dos caracteres
	 * @param nombre
	 * @return boolean si correcto, false en caso contrario
	 */
	public static boolean checkNombre(String nombre){
		result = false;
		if (nombre != null) {
			nombre = nombre.trim();

			// TODO comprobar mas de un espacio en blanco
			pattern = "[A-Za-z]{2,}";

			result = nombre.matches(pattern);

		}
		return result;
	}

	public static boolean checkApellido(String apellido){
		result=false;
		result=checkNombre(apellido);
		return result;

	}

	public static boolean checkCalle(String calle){
		result=false;
		result=checkNombre(calle);
		return result;
	}
	/**
	 * Metodo que comprueba que el cp sean cinco caracteres
	 * @param cp
	 * @return boolean si correcto, false en caso contrario
	 */
	public static boolean checkCP(int cp){
		result=false;
		CPl= Integer.toString(cp);
		pattern="[0-9]{5}";
		if (CPl.matches(pattern)){
			result=true;
		}
		return result;
	}

	public static boolean checkLocalidad(String localidad){
		result=false;
		result=checkNombre(localidad);
		return result;
	}

	public static boolean checkProvincia(String provincia){
		result=false;
		result=checkNombre(provincia);
		return result;
	}
	/**
	 * Metodo que comprueba que el movil tenga nueve digitos
	 * @param movil
	 * @return boolean si correcto, false en caso contrario
	 */
	public static boolean checkMovil(int movil){
		result=false;
		movill= Integer.toString(movil);
		pattern="[0-9]{9}";
		if (movill.matches(pattern)){
			result=true;
		}
		return result;
	}

	public static boolean checkFijo(int fijo){
		result=false;
		result=checkMovil(fijo);
		return result;
	}





}
