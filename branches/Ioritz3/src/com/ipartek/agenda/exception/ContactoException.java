package com.ipartek.agenda.exception;

/**
 * Clase para gestionar las excepciones propias de un contacto
 * Se lanzaran excepciones cuando no sean correctos:
 * <ol>
 * 	<li>Nombre</li>
 * 	<li>Apellido</li>
 * 	<li>Calle</li>
 * 	<li>CP</li>
 * 	<li>Localidad</li>
 * 	<li>Provincia</li>
 * 	<li>Movil</li>
 * 	<li>Fijo</li>
 * 	<li>Anotaciones</li>
 * </ol>
 * 
 * @author Ioritz Bereikua Etxebarria
 * @version 1.0
 *
 */


public class ContactoException extends Exception{
	
	
	int codigoError;
	String mensajeError;
	
	//codigos y mensajes de error
	public static final int COD_ERROR_CALLE = 1;
	public static final String MSG_ERROR_CALLE = "Formato de calle no valido, letras, numeros y minimo 15 caracteres";

	public static final int COD_ERROR_NOMBRE = 2;
	public static final String MSG_ERROR_NOMBRE = "Nombre no valido. Solo letras y mínimo 3";
	
	public static final int COD_ERROR_CP = 3;
	public static final String MSG_ERROR_EDAD = "Codigo postal no valida, debe de estar entre 18 y 99";
	
	public static final int COD_ERROR_LOCALIDAD = 4;
	public static final String MSG_ERROR_LOCALIDAD = "Formato de Localidad incorrecto. Minimo 2 caracteres";

	
	public static final int COD_ERROR_APELLIDO = 5;
	public static final String MSG_ERROR_APELLIDO = "Formato de apellido no valido. Solo letras y mínimo 3.";
	
	public static final int COD_ERROR_PROVINCIA = 6;
	public static final String MSG_ERROR_PROVINCIA= "Formato de Provincia incorrecto. Minimo 3 caracteres";
	
	public static final int COD_ERROR_MOVIL = 7;
	public static final String MSG_ERROR_MOVIL = "Formato de Telefono movil incorrecto. Tiene que tener 9 numeros";
	
	public static final int COD_ERROR_FIJO = 8;
	public static final String MSG_ERROR_FIJO = "Formato de Telefono fijo incorrecto. Tiene que tener 9 numeros";
	
	public static final int COD_ERROR_ANOTACIONES = 9;
	public static final String MSG_ERROR_ANOTACIONES = "Formato de Anotaciones incorrecto. Tiene que tener como minimo 3 caracteres";

	// CONSTRUCTIORES
	public ContactoException(int codErrorNombre, String msgErrorNombre) {
		super();
		this.codigoError = codErrorNombre;
		this.mensajeError= msgErrorNombre;
	}

	// GETTERS	
	public int getCodigoError() {
		return codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}
}
