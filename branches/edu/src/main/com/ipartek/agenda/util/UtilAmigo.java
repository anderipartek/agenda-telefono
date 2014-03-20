package com.ipartek.agenda.util;
/**
 * Clase que contiene los testeos propios de la clase Amigo
 * @author Eduardo Monterrubio
 *
 */
public class UtilAmigo {
	
	/**
	 * Metodo que comprueba que el nombre tenga al menos dos caracteres
	 * @param nombre
	 * @return boolean si correcto, false en caso contrario
	 */
	public static boolean checkNombre(String nombre){
		boolean result = false;
		if (nombre != null) {
			nombre = nombre.trim();

			// TODO comprobar mas de un espacio en blanco
			String pattern = "[A-Za-z]{2,}";

			result = nombre.matches(pattern);

		}
		return result;
	}
	
	public static boolean checkApellido(String apellido){
		boolean result=false;
		result=checkNombre(apellido);
		return result;

	}
	
	public static boolean checkCalle(String calle){
		boolean result=false;
		result=checkNombre(calle);
		return result;
	}
	/**
	 * Metodo que comprueba que el cp sean cinco caracteres
	 * @param cp
	 * @return boolean si correcto, false en caso contrario
	 */
	public static boolean checkCP(int cp){
		boolean result=false;
		String CPl= Integer.toString(cp);
		String pattern="[0-9]{5}";
		if (CPl.matches(pattern)){
			result=true;
		}
		return result;
	}
	
	public static boolean checkLocalidad(String localidad){
		boolean result=false;
		result=checkNombre(localidad);
		return result;
	}
	
	public static boolean checkProvincia(String provincia){
		boolean result=false;
		result=checkNombre(provincia);
		return result;
	}
	/**
	 * Metodo que comprueba que el movil tenga nueve digitos
	 * @param movil
	 * @return boolean si correcto, false en caso contrario
	 */
	public static boolean checkMovil(int movil){
		boolean result=false;
		String movill= Integer.toString(movil);
		String pattern="[0-9]{9}";
		if (movill.matches(pattern)){
			result=true;
		}
		return result;
	}
	
	public static boolean checkFijo(int fijo){
		boolean result=false;
		result=checkMovil(fijo);
		return result;
	}
	
	
	
	

}
