package com.ipartek.agenda.excepciones;

/**
 * Esto es una clase para gestionar las excepciones propias de un Amigo Se lanzaran excepciones cuando no sean correctos:
 * <ol>
 * <li>El Nombre y Apellido</li>
 * <li>El numero de telefono</li>
 * <li>El codigo postal</li>
 * </ol>
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class AmigoExcepcion extends Exception {
	// ATRIBUTOS
	int codigoError;
	String mensajeError;

	// ////// CODIGOS Y MENSAJES DE ERROR PARA CAPTURA DE EXCEPCION ////////

	// CODIGOS DE ERROR
	public static final int COD_ERROR_TELEFONO = 100;
	public static final int COD_ERROR_CP = 101;
	public static final int COD_ERROR_NOMBRE = 102;
	public static final int COD_ERROR_APELLIDO = 103;
	// MENSAJES DE ERROR
	public static final String MSG_ERROR_TELEFONO = "El numero de telefono no es válido [movil 666666666] [fijo 999999999]";
	public static final String MSG_ERROR_CP = "El codigo postal introducido no es correcto [48900]";
	public static final String MSG_ERROR_NOMBRE = "El campo [NOMBRE] debe ser :> Mayor de 3 caracteres , no numeros , no simbolos";
	public static final String MSG_ERROR_APELLIDO = "El campo [APELLIDO] debe ser :> Mayor de 3 caracteres , no numeros , no simbolos";

	// CONSTRUCTIORES
	public AmigoExcepcion(int codigoError, String msjError) {
		super();
		this.codigoError = codigoError;
		this.mensajeError = msjError;
	}

	// GETTERS
	public int getCodigoError() {
		return codigoError;
	}

	public String getMensajeError() {
		return mensajeError;
	}
}