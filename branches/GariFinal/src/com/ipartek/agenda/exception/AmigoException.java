package com.ipartek.agenda.exception;



/**
 * Clase para gestionar las excepciones propias de un alumno
 * Se lanzaran excepciones cuando no sean correctos:
 * <ol>
 * 	<li>Nombre y apellido</li>
 * 	<li>Edad</li>
 * 	<li>DNI</li>
 * 	<li>Email</li>
 * 	<li>Sexo</li>
 * </ol>
 * 
 * @author Ibai Sainz-Aja Depardieu
 * @version 1.0
 *
 */
public class AmigoException extends Exception {

	int codigoError;
	String mensajeError;
	
	//codigos y mensajes de error
	
	
	public static final int COD_ERROR_NOMBRE = 1;
	public static final String MSG_ERROR_NOMBRE = "Nombre no valido. Solo letras y mínimo 3";
	
	public static final int COD_ERROR_APELLIDO =2;
	public static final String MSG_ERROR_APELLIDO = "Formato de apellido no valido. Solo letras y mínimo 3.";

	
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
	
	
	/*public static void main(String[] atgs){
		try {
			Alumno bueno = new Alumno();
			System.out.println(bueno.toString());
			
			Alumno malo = new Alumno();
			malo.setSexo('C');
			System.out.println(malo.toString());
		} catch (AlumnoException e) {
			System.out.println(e.getMensajeError());
			e.printStackTrace();
		}
		
	}*/

}
