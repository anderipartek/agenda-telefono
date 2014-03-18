package com.ipartek.agenda.exceptions;

import com.ipartek.agenda.bean.Amigo;

/**
 * Clase que define los c�digos y mensajes de error.
 * @author Patricia Navascu�s
 * @version 1.0
 * 
 */
public class AmigoException extends Exception {

	int codigoError;
	String mensajeError;

	// codigos y mensajes de error
	public static final int COD_ERROR_CALLE = 1;
	public static final String MSG_ERROR_CALLE = "La longitud minima para calle no es correcta";

	public static final int COD_ERROR_NOMBRE = 2;
	public static final String MSG_ERROR_NOMBRE = "Nombre no valido. Solo letras y m�nimo 3";

	public static final int COD_ERROR_APELLIDO = 3;
	public static final String MSG_ERROR_APELLIDO = "Apellido no valido. Solo letras y m�nimo 3";

	public static final int COD_ERROR_CP = 3;
	public static final String MSG_ERROR_CP = "C�digo Postal no valida, debe tener 5 d�gitos";

	public static final int COD_ERROR_LOCALIDAD = 4;
	public static final String MSG_ERROR_LOCALIDAD = "La longitud minima para localidad no es correcta";
	
	public static final int COD_ERROR_PROVINCIA = 5;
	public static final String MSG_ERROR_PROVINCIA = "La longitud minima para provincia no es correcta";

	
	public static final int COD_ERROR_FIJO = 6;
	public static final String MSG_ERROR_FIJO = "Formato de telefono fijo no valido";

	public static final int COD_ERROR_MOVIL = 7;
	public static final String MSG_ERROR_MOVIL = "Formato de telefono m�vil no valido";

	/**
	 * Constructor de las excepciones.
	 * 
	 * @param codigoError
	 * @param mensajeError
	 */

	public AmigoException(int codigoError, String mensajeError) {
		super();
		this.codigoError = codigoError;
		this.mensajeError = mensajeError;
	}

	// getters y setters
	public int getCodigoError() {
		return codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}

}
