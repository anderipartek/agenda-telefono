package com.ipartek.agenda.exception;

/**
 * Clase para gestionar las excepciones propias de un contacto
 * Se lanzaran excepciones cuando no sean correctos:
 * <ol>
 * 	<li>Nombre y apellido</li>
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


public class ContactoException {
	
	int codigoError;
	String mensajeError;
	
	//codigos y mensajes de error
	public static final int COD_ERROR_CALLE = 1;
	public static final String MSG_ERROR_CALLE = "Formato de calle no valido, letras, numeros y minimo 7 caracteres";

	public static final int COD_ERROR_NOMBRE = 2;
	public static final String MSG_ERROR_NOMBRE = "Nombre no valido. Solo letras y mínimo 3";
	
	public static final int COD_ERROR_CP = 3;
	public static final String MSG_ERROR_EDAD = "Codigo postal no valida, debe de estar entre 18 y 99";
	
	public static final int COD_ERROR_DNI = 4;
	public static final String MSG_ERROR_DNI = "Formato de DNI incorrecto. 8digitos y una letra en mayuscula";
	
	public static final int COD_ERROR_EMAIL = 5;
	public static final String MSG_ERROR_EMAIL = "Formato de email no valido";
	
	public static final int COD_ERROR_APELLIDO = 6;
	public static final String MSG_ERROR_APELLIDO = "Formato de apellido no valido. Solo letras y mínimo 3.";

}
