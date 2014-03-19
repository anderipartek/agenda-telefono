package com.ipartek.agenda.excepciones;

/**
 * Clase para controlar las excepciones
 * @author Ion
 *
 */


public class AmigoExcepcion extends Exception{
	
		int codigoError;
		String mensajeError;

		
		public static final int COD_ERROR_TELEFONO = 0;
		public static final int COD_ERROR_CP = 1;
		public static final int COD_ERROR_NOMBRE = 2;
		public static final int COD_ERROR_APELLIDO = 3;

		
		public static final String MSG_ERROR_TELEFONO = "El numero de telefono no es válido";
		public static final String MSG_ERROR_CP = "El codigo postal no es correcto";
		public static final String MSG_ERROR_NOMBRE = "El campo nombredebe ser no es correcto";
		public static final String MSG_ERROR_APELLIDO = "El campo apellido no es correcto";


		public AmigoExcepcion(int codigoError, String msjError) {
			super();
			this.codigoError = codigoError;
			this.mensajeError = msjError;
		}

		public int getCodigoError() {
			return codigoError;
		}

		public String getMensajeError() {
			return mensajeError;
		}
}

