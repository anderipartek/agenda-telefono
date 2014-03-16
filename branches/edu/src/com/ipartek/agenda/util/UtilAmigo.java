package com.ipartek.agenda.util;

public class UtilAmigo {
	
	
	public static boolean checkNombre(String nombre){
		boolean result = false;
		if (nombre != null) {
			nombre = nombre.toLowerCase().trim();

			// TODO comprobar mas de un espacio en blanco
			String pattern = "[A-Za-z\\s-'αινσϊρ]{2,}";

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
