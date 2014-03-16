package com.ipartek.agenda.exception;

public class AmigoException extends Exception {
   private int codigo;
   private String mensaje;
   
   private static final int COD_ERROR_NOMBRE=1;
   private static final String MENSAJE_ERROR_NOMBRE="El nombre tiene que contener al menos dos caracteres";
   private static final int COD_ERROR_APELLIDO=2;
   private static final String MENSAJE_ERROR_APELLIDO="El apellido tiene que contener al menos dos caracteres";
   private static final int COD_ERROR_CALLE=3;
   private static final String MENSAJE_ERROR_CALLE="La calle tiene que contener al menos dos caracteres";
   private static final int COD_ERROR_CP=4;
   private static final String MENSAJE_ERROR_CP="El CP tiene que contener cinco digitos";
   private static final int COD_ERROR_LOCALIDAD=5;
   private static final String MENSAJE_ERROR_LOCALIDAD="La localidad tiene que contener al menos un caracter";
   private static final int COD_ERROR_PROVINCIA=6;
   private static final String MENSAJE_ERROR_PROVINCIA="La provincia tiene que contener al menos un caracter";
   private static final int COD_ERROR_MOVIL=7;
   private static final String MENSAJE_ERROR_MOVIL="El movil tiene que contener nueve digitos";
   private static final int COD_ERROR_FIJO=8;
   private static final String MENSAJE_ERROR_FIJO="El fijo tiene que contener nueve digitos";
   private static final int COD_ERROR_ANOTACIONES=9;
   private static final String MENSAJE_ERROR_ANOTACIONES="Las anotaciones tienen que contener al menos dos caracteres";
   
   
   
public AmigoException(int codigo, String mensaje) {
	super();
	this.codigo = codigo;
	this.mensaje = mensaje;
}


   
   
}
