package com.ipartek.agenda.util;

public class AmigoUtil {

	// Método para comprobar que el nombre del alumno es al menos un caracter.
	static public boolean checkNombre(String nombre) {
		boolean result = false;
		if (nombre != null) {

			String pattern = "[a-z\\s-'áéíóúñ]{2,}";
			result = nombre.matches(pattern);

		}
		return result;
	}

	// Metodo para comprobar los numeros de telefono
	static public boolean checkNumero(String telefono) {
		boolean result = false;
		if (telefono.matches("[0-9]{9}")) {
			result = true;
		}
		return result;

	}

	static public String toCapitalCase(String cadena) {
		char _char = Character.toUpperCase(cadena.charAt(0));
		String subcadena = cadena.substring(1, cadena.length());

		return _char + subcadena.toLowerCase();
	}
}
