package com.ipartek.agenda.exception;
/**
 * Clase que contiene la excepción AmigoException que se lanza al crear el objeto Amigo
 * @author Eduardo Monterrubio
 *
 */
public class AmigoException extends Exception {
   private int codigo;
   private String mensaje;
   
   public static final int COD_ERROR_NOMBRE=1;
   public static final String MENSAJE_ERROR_NOMBRE="ERROR:El nombre tiene que contener al menos dos caracteres";
   public static final int COD_ERROR_APELLIDO=2;
   public static final String MENSAJE_ERROR_APELLIDO="ERROR:El apellido tiene que contener al menos dos caracteres";
   public static final int COD_ERROR_CALLE=3;
   public static final String MENSAJE_ERROR_CALLE="ERROR:La calle tiene que contener al menos dos caracteres";
   public static final int COD_ERROR_CP=4;
   public static final String MENSAJE_ERROR_CP="ERROR:El CP tiene que contener cinco digitos";
   public static final int COD_ERROR_LOCALIDAD=5;
   public static final String MENSAJE_ERROR_LOCALIDAD="ERROR:La localidad tiene que contener al menos un caracter";
   public static final int COD_ERROR_PROVINCIA=6;
   public static final String MENSAJE_ERROR_PROVINCIA="ERROR:La provincia tiene que contener al menos un caracter";
   public static final int COD_ERROR_MOVIL=7;
   public static final String MENSAJE_ERROR_MOVIL="ERROR:El movil tiene que contener nueve digitos";
   public static final int COD_ERROR_FIJO=8;
   public static final String MENSAJE_ERROR_FIJO="ERROR:El fijo tiene que contener nueve digitos";
   public static final int COD_ERROR_ANOTACIONES=9;
   public static final String MENSAJE_ERROR_ANOTACIONES="ERROR:Las anotaciones tienen que contener al menos dos caracteres";
   
   
 /**
  * Constructor con parametros  
  * @param codigo
  * @param mensaje
  */
public AmigoException(int codigo, String mensaje) {
	super();
	this.codigo = codigo;
	this.mensaje = mensaje;
}



public int getCodigo() {
	return codigo;
}



public String getMensaje() {
	return mensaje;
}






   
   
}
