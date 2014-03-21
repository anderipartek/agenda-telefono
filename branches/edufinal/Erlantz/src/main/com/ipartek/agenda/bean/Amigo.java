package com.ipartek.agenda.bean;

import com.ipartek.agenda.excepciones.AmigoExcepcion;
import com.ipartek.agenda.utiles.AmigoUtil;

/**
 * @
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class Amigo {

	/**
	 * 
	 */
	private static final int DEFAULT_TELEFONO_VALUE = 0;
	/**
	 * 
	 */
	private static final int DEFAULT_CP_VALUE = 00000;
	/**
	 * 
	 */
	private static final String DEFAULT_NOMBRE_VALUE = "NOMBRE";
	/**
	 * 
	 */
	private static final String DEFAULT_APELLIDO_VALUE = "APELLIDO";
	/**
	 * 
	 */
	private static final String DEFAULT_CALLE_VALUE = "CALLE";
	/**
	 * 
	 */
	private static final String DEFAULT_LOCALIDAD_VALUE = "LOCALIDAD";
	/**
	 * 
	 */
	private static final String DEFAULT_PROVINCIA_VALUE = "PROVINCIA";
	/**
	 * 
	 */
	private static final String DEFAULT_ANTOTACIONES_VALUE = "ANOTACIONES";

	// ATRIBUTOS
	/**
	 * 
	 */
	private int id; // IDENTIFICADOR BBDD
	/**
	 * 
	 */
	private String nombre;
	/**
	 * 
	 */
	private String apellido;
	/**
	 * 
	 */
	private String mTelefono; // TELEFONO MOVIL
	/**
	 * 
	 */
	private String fTelefono; // TELEFONO FIJO
	/**
	 * 
	 */
	private String calle;
	/**
	 * 
	 */
	private String provincia;
	/**
	 * 
	 */
	private String localidad;
	/**
	 * 
	 */
	private int codigoPostal; // POR DEFECTO 48900
	/**
	 * 
	 */
	private String anotaciones; // COMENTARIOS SOBRE EL AMIGO

	// CONSTRUCTORES
	/**
	 * Constructor por defecto.
	 */
	public Amigo() {
		// this.id = 0;
		this.nombre = DEFAULT_NOMBRE_VALUE;
		this.apellido = DEFAULT_APELLIDO_VALUE;
		this.mTelefono = String.valueOf(DEFAULT_TELEFONO_VALUE);
		this.fTelefono = String.valueOf(DEFAULT_TELEFONO_VALUE);
		this.calle = DEFAULT_CALLE_VALUE;
		this.provincia = DEFAULT_PROVINCIA_VALUE;
		this.localidad = DEFAULT_LOCALIDAD_VALUE;
		this.codigoPostal = DEFAULT_CP_VALUE;
		this.anotaciones = DEFAULT_ANTOTACIONES_VALUE;
	}

	/**
	 * Constructor con parametros.
	 * 
	 * @param cNombre Nombre del amigo
	 * @param cApellido Apellido del amigo
	 * @param cMTelefono Móvil
	 * @param cFTelefono Fijo
	 * @param cCalle Calle
	 * @param cProvincia Provincia
	 * @param cLocalidad Localidad
	 * @param cCodigoPostal Codigo Postal
	 * @param cAnotaciones Comentarios
	 * @throws AmigoExcepcion Excepciones para nombre/apellido telefonos y
	 *             codigo postal
	 */
	public Amigo(final String cNombre, final String cApellido,
			final String cMTelefono, final String cFTelefono,
			final String cCalle, final String cProvincia,
			final String cLocalidad, final int cCodigoPostal,
			final String cAnotaciones) throws AmigoExcepcion {
		this();
		this.setNombre(cNombre);
		this.setApellido(cApellido);
		this.setMTelefono(cMTelefono);
		this.setFTelefono(cFTelefono);
		this.setCalle(cCalle);
		this.setProvincia(cProvincia);
		this.setLocalidad(cLocalidad);
		this.setCodigoPostal(cCodigoPostal);
		this.setAnotaciones(cAnotaciones);
	}

	// GETTERS - SETTERS
	/**
	 * 
	 * @param cId Identificador
	 */
	public final void setId(final int cId) {
		this.id = cId;
	}

	/**
	 * 
	 * @param cNombre nombre del amigo
	 * @throws AmigoExcepcion Excepcion en caso de no cumplir los parametros
	 *             establecidos en el checkNombre
	 */
	public final void setNombre(final String cNombre) throws AmigoExcepcion {
		if (AmigoUtil.checkNombre(cNombre)) {
			this.nombre = cNombre;
		} else {
			this.nombre = "";
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_NOMBRE,
					AmigoExcepcion.MSG_ERROR_NOMBRE);
		}
	}

	/**
	 * 
	 * @param cApellido apellido del amigo
	 * @throws AmigoExcepcion Excepcion en caso de no cumplir los parametros
	 *             establecidos en el checkNombre
	 */
	public final void setApellido(final String cApellido) throws AmigoExcepcion {
		if (AmigoUtil.checkNombre(cApellido)) {
			this.apellido = cApellido;
		} else {
			this.apellido = "";
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_APELLIDO,
					AmigoExcepcion.MSG_ERROR_APELLIDO);
		}
	}

	/**
	 * 
	 * @param cMTelefono Telefono movil
	 * @throws AmigoExcepcion Excepcion en caso de no cumplir los parametros
	 *             establecidos en el checkNumeros
	 */
	public final void setMTelefono(final String cMTelefono)
			throws AmigoExcepcion {
		if (AmigoUtil.checkNumeros(cMTelefono)) {
			this.mTelefono = cMTelefono;
		} else {
			this.mTelefono = "0";
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_TELEFONO,
					AmigoExcepcion.MSG_ERROR_TELEFONO);
		}
	}

	/**
	 * 
	 * @param cFTelefono Telefono fijo
	 * @throws AmigoExcepcion Excepcion en caso de no cumplir los parametros
	 *             establecidos en el checkNumeros
	 */
	public final void setFTelefono(final String cFTelefono)
			throws AmigoExcepcion {
		if (AmigoUtil.checkNumeros(cFTelefono)) {
			this.fTelefono = cFTelefono;
		} else {
			this.fTelefono = "0";
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_TELEFONO,
					AmigoExcepcion.MSG_ERROR_TELEFONO);
		}
	}

	/**
	 * 
	 * @param cCalle calle
	 */
	public final void setCalle(final String cCalle) {
		if (!cCalle.isEmpty()) {
			this.calle = cCalle;
		} else {
			this.calle = "";
		}
	}

	/**
	 * 
	 * @param cProvincia provincia
	 */
	public final void setProvincia(final String cProvincia) {
		if (!cProvincia.isEmpty()) {
			this.provincia = cProvincia;
		} else {
			this.provincia = "";
		}
	}

	/**
	 * 
	 * @param cLocalidad localidad
	 */
	public final void setLocalidad(final String cLocalidad) {
		if (!cLocalidad.isEmpty()) {
			this.localidad = cLocalidad;
		} else {
			this.localidad = "";
		}
	}

	/**
	 * 
	 * @param cCodigoPostal codigo postal
	 * @throws AmigoExcepcion Excepcion en caso de no cumplir los parametros
	 *             establecidos en el checkCP
	 */
	public final void setCodigoPostal(final int cCodigoPostal)
			throws AmigoExcepcion {
		if (AmigoUtil.checkCP(cCodigoPostal)) {
			this.codigoPostal = cCodigoPostal;
		} else {
			this.codigoPostal = 0;
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_CP,
					AmigoExcepcion.MSG_ERROR_CP);
		}
	}

	/**
	 * 
	 * @param cAnotaciones comentarios sobre el amigo
	 */
	public final void setAnotaciones(final String cAnotaciones) {
		if (!cAnotaciones.isEmpty()) {
			this.anotaciones = cAnotaciones;
		} else {
			this.anotaciones = "";
		}
	}

	/**
	 * 
	 * @return [INT] identificador
	 */
	public final int getId() {
		return id;
	}

	/**
	 * 
	 * @return [STRING] nombre
	 */
	public final String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @return [STRING] apellido
	 */
	public final String getApellido() {
		return apellido;
	}

	/**
	 * 
	 * @return [STRING] telefono movil
	 */
	public final String getMTelefono() {
		return mTelefono;
	}

	/**
	 * 
	 * @return [STRING] telefono fijo
	 */
	public final String getFTelefono() {
		return fTelefono;
	}

	/**
	 * 
	 * @return [STRING] calle
	 */
	public final String getCalle() {
		return calle;
	}

	/**
	 * 
	 * @return [STRING] provincia
	 */
	public final String getProvincia() {
		return provincia;
	}

	/**
	 * 
	 * @return [STRING] localidad
	 */
	public final String getLocalidad() {
		return localidad;
	}

	/**
	 * 
	 * @return [INT] codigo postal
	 */
	public final int getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * 
	 * @return [STRING] anotaciones
	 */
	public final String getAnotaciones() {
		return anotaciones;
	}

	@Override
	public final String toString() {
		return "Amigo [nombre=" + this.nombre + ", this.apellido="
				+ this.apellido + ", mTelefono=" + this.mTelefono
				+ ", fTelefono=" + this.fTelefono + ", calle=" + this.calle
				+ ", provincia=" + this.provincia + ", localidad="
				+ this.localidad + ", codigoPostal=" + this.codigoPostal
				+ ", anotaciones=" + this.anotaciones + "]";
	}

}
