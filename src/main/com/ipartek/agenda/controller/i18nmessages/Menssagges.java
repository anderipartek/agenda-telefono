package com.ipartek.agenda.controller.i18nmessages;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ipartek.agenda.controller.MainServlet;

/**
 * Clase para gestionar el uso de un idioma u otro
 * 
 * @author Patricia Navascués
 * @version 1.0
 * 
 */
public class Menssagges {

	static final Logger LOG = Logger.getLogger(Menssagges.class);

	// Variables de configuración del idioma
	public static final String OP_CASTELLANO = "es_ES";
	public static final String OP_ENGLISH = "en_EN";
	public static final String NOMBRE_PAQUETE = "com.ipartek.agenda.controller.i18nmessages.i18nmessages";

	public Menssagges() {
		
		PropertyConfigurator.configure("./config/log4j.properties");
	}

	/**
	 * Método para obtener el lenguaje a usar en la aplicación.
	 * 
	 * @param request
	 * @return Objeto con informació a cerca del idioma.
	 */
	public static Locale getLanguage(HttpServletRequest request) {
		// Locale por defecto Español
		Locale locale = new Locale(OP_CASTELLANO);

		// obtener lenguaje de la session del usuario
		String language = (String) request.getSession().getAttribute("language");

		if (language != null) {
			locale = new Locale(language);
		}
		LOG.debug("language: " + language + " locale: " + locale);
		// Cargar resourceBundle o properties dependiente del idioma

		// Debemos indicara el package donde se encuentra y el nombre del
		// /properties sin la extension del locale
		
		
		return locale;
	}
}
