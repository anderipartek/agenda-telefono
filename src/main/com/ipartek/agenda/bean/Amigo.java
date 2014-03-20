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

	private static final int DEFAULT_TELEFONO_VALUE = 0;
	private static final int DEFAULT_CP_VALUE = 00000;
	private static final String DEFAULT_NOMBRE_VALUE = "NOMBRE";
	private static final String DEFAULT_APELLIDO_VALUE = "APELLIDO";
	private static final String DEFAULT_CALLE_VALUE = "CALLE";
	private static final String DEFAULT_LOCALIDAD_VALUE = "LOCALIDAD";
	private static final String DEFAULT_PROVINCIA_VALUE = "PROVINCIA";
	private static final String DEFAULT_ANTOTACIONES_VALUE = "ANOTACIONES";
	// ATRIBUTOS
	private int id; // IDENTIFICADOR BBDD
	private String nombre;
	private String apellido;
	private String mTelefono; // TELEFONO MOVIL
	private String fTelefono; // TELEFONO FIJO
	private String calle;
	private String provincia;
	private String localidad;
	private int codigoPostal; // POR DEFECTO 48900
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
	 * @throws AmigoExcepcion
	 */
	public Amigo(final String nombre, final String apellido,
			final String mTelefono, final String fTelefono, final String calle,
			final String provincia, final String localidad,
			final int codigoPostal, final String anotaciones)
			throws AmigoExcepcion {
		this();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setMTelefono(mTelefono);
		this.setFTelefono(fTelefono);
		this.setCalle(calle);
		this.setProvincia(provincia);
		this.setLocalidad(localidad);
		this.setCodigoPostal(codigoPostal);
		this.setAnotaciones(anotaciones);
	}

	// GETTERS - SETTERS
	public void setId(final int id) {
		this.id = id;
	}

	public void setNombre(final String nombre) throws AmigoExcepcion {
		if (AmigoUtil.checkNombre(nombre)) {
			this.nombre = nombre;
		} else {
			this.nombre = DEFAULT_NOMBRE_VALUE;
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_NOMBRE,
					AmigoExcepcion.MSG_ERROR_NOMBRE);
		}
	}

	public final void setApellido(final String apellido) throws AmigoExcepcion {
		if (AmigoUtil.checkNombre(apellido)) {
			this.apellido = apellido;
		} else {
			this.apellido = DEFAULT_APELLIDO_VALUE;
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_APELLIDO,
					AmigoExcepcion.MSG_ERROR_APELLIDO);
		}
	}

	public void setMTelefono(final String mTelefono) throws AmigoExcepcion {
		if (AmigoUtil.checkNumeros(mTelefono)) {
			this.mTelefono = mTelefono;
		} else {
			// VALOR POR DEFECTO
			this.mTelefono = String.valueOf(DEFAULT_TELEFONO_VALUE);
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_TELEFONO,
					AmigoExcepcion.MSG_ERROR_TELEFONO);
		}
	}

	public void setFTelefono(final String fTelefono) throws AmigoExcepcion {
		if (AmigoUtil.checkNumeros(fTelefono)) {
			this.fTelefono = fTelefono;
		} else {
			// VALOR POR DEFECTO
			this.fTelefono = String.valueOf(DEFAULT_TELEFONO_VALUE);
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_TELEFONO,
					AmigoExcepcion.MSG_ERROR_TELEFONO);
		}
	}

	public void setCalle(final String calle) {
		this.calle = calle;
	}

	public void setProvincia(final String provincia) {
		this.provincia = provincia;
	}

	public void setLocalidad(final String localidad) {
		this.localidad = localidad;
	}

	public void setCodigoPostal(final int codigoPostal) throws AmigoExcepcion {
		if (AmigoUtil.checkCP(codigoPostal)) {
			this.codigoPostal = codigoPostal;
		} else {
			// VALOR POR DEFECTO
			this.codigoPostal = DEFAULT_CP_VALUE;
			throw new AmigoExcepcion(AmigoExcepcion.COD_ERROR_CP,
					AmigoExcepcion.MSG_ERROR_CP);
		}
	}

	public void setAnotaciones(final String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getMTelefono() {
		return mTelefono;
	}

	public String getFTelefono() {
		return fTelefono;
	}

	public String getCalle() {
		return calle;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	@Override
	public String toString() {
		return "Amigo [nombre=" + this.nombre + ", this.apellido="
				+ this.apellido + ", mTelefono=" + this.mTelefono
				+ ", fTelefono=" + this.fTelefono + ", calle=" + this.calle
				+ ", provincia=" + this.provincia + ", localidad="
				+ this.localidad + ", codigoPostal=" + this.codigoPostal
				+ ", anotaciones=" + this.anotaciones + "]";
	}

}
