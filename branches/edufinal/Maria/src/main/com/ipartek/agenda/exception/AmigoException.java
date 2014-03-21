package com.ipartek.agenda.exception;

public class AmigoException extends Exception {
	int codigoError;
	String mensajeError;

	// codigos y mensajes de error
	public static final int COD_ERROR_MOVIL = 1;
	public static final String MSG_ERROR_MOVIL = "Formato de movil no valido, 9 digitos";

	public static final int COD_ERROR_NOMBRE = 2;
	public static final String MSG_ERROR_NOMBRE = "Nombre no valido. Solo letras y mínimo 3";

	public static final int COD_ERROR_CP = 3;
	public static final String MSG_ERROR_CP = "CP no valido";

	public static final int COD_ERROR_PROVINCIA = 4;
	public static final String MSG_ERROR_PROVINCIA = "Formato de provincia incorrecto";

	public static final int COD_ERROR_LOCALIDAD = 5;
	public static final String MSG_ERROR_LOCALIDAD = "Formato de localidad no valido";

	public static final int COD_ERROR_APELLIDO = 6;
	public static final String MSG_ERROR_APELLIDO = "Formato de apellido no valido. Solo letras y mínimo 3.";

	public static final int COD_ERROR_FIJO = 7;
	public static final String MSG_ERROR_FIJO = "Formato de fijo no valido, 9 digitos";

	public static final int COD_ERROR_CALLE = 8;
	public static final String MSG_ERROR_CALLE = "Formato de calle no valido";

	public static final int COD_ERROR_ANOTACIONES = 9;
	public static final String MSG_ERROR_ANOTACIONES = "Formato de anotaciones no valido";

	public AmigoException(int codigoError, String mensajeError) {
		super();
		this.codigoError = codigoError;
		this.mensajeError = mensajeError;
	}

	public int getCodigoError() {
		return codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}
}
