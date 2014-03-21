package com.ipartek.agenda.bean;

import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.util.AmigoUtil;

public class Amigo {

	private static int DEFAULT_TELEFONO_VALUE = 0;
	private static int DEFAULT_CP_VALUE = 00000;
	private static String DEFAULT_NOMBRE_VALUE = "NOMBRE";
	private static String DEFAULT_APELLIDO_VALUE = "APELLIDO";
	private static String DEFAULT_CALLE_VALUE = "CALLE";
	private static String DEFAULT_LOCALIDAD_VALUE = "LOCALIDAD";
	private static String DEFAULT_PROVINCIA_VALUE = "PROVINCIA";
	private static String DEFAULT_ANTOTACIONES_VALUE = "ANOTACIONES";
	// ATRIBUTOS
	private int id;
	private String nombre;
	private String apellido;
	private String calle;
	private int cp;
	private String localidad;
	private String provincia;
	private String movil;
	private String fijo;
	private String anotaciones;

	public Amigo() {
		// this.id = 0;
		this.nombre = DEFAULT_NOMBRE_VALUE;
		this.apellido = DEFAULT_APELLIDO_VALUE;
		this.movil = String.valueOf(DEFAULT_TELEFONO_VALUE);
		this.fijo = String.valueOf(DEFAULT_TELEFONO_VALUE);
		this.calle = DEFAULT_CALLE_VALUE;
		this.provincia = DEFAULT_PROVINCIA_VALUE;
		this.localidad = DEFAULT_LOCALIDAD_VALUE;
		this.cp = DEFAULT_CP_VALUE;
		this.anotaciones = DEFAULT_ANTOTACIONES_VALUE;
	}

	public Amigo(final String nombre, final String apellido, final String movil, final String fijo, final String calle, final String provincia,
			final String localidad, final int cp, final String anotaciones) throws AmigoException {
		this();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setMovil(movil);
		this.setFijo(fijo);
		this.setCalle(calle);
		this.setProvincia(provincia);
		this.setLocalidad(localidad);
		this.setCp(cp);
		this.setAnotaciones(anotaciones);
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

	public String getCalle() {
		return calle;
	}

	public int getCp() {
		return cp;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getMovil() {
		return movil;
	}

	public String getFijo() {
		return fijo;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) throws AmigoException {
		/*
		 * if (AmigoUtil.checkNombre(nombre)) { this.nombre = AmigoUtil.toCapitalCase(nombre); } else { this.nombre = DEFAULT_NOMBRE_VALUE; throw new
		 * AmigoException(AmigoException.COD_ERROR_NOMBRE, AmigoException.MSG_ERROR_NOMBRE); }
		 */
		this.nombre = nombre;
	}

	public void setApellido(String apellido) throws AmigoException {
		/*
		 * if (AmigoUtil.checkNombre(apellido)) { this.apellido = AmigoUtil.toCapitalCase(apellido); } else { this.apellido = DEFAULT_APELLIDO_VALUE;
		 * throw new AmigoException(AmigoException.COD_ERROR_APELLIDO, AmigoException.MSG_ERROR_APELLIDO); }
		 */
		this.apellido = apellido;
	}

	public void setCalle(String calle) throws AmigoException {

		this.calle = calle;

	}

	public void setCp(final int codigoPostal) throws AmigoException {

		this.cp = cp;

	}

	public void setLocalidad(String localidad) throws AmigoException {

		this.localidad = localidad;

	}

	public void setProvincia(String provincia) throws AmigoException {

		this.provincia = provincia;

	}

	public void setMovil(String movil) throws AmigoException {
		if (AmigoUtil.checkNumero(movil)) {
			this.movil = movil;
		} else {
			this.movil = String.valueOf(DEFAULT_TELEFONO_VALUE);
			throw new AmigoException(AmigoException.COD_ERROR_MOVIL, AmigoException.MSG_ERROR_MOVIL);
		}

	}

	public void setFijo(String fijo) throws AmigoException {
		if (AmigoUtil.checkNumero(fijo)) {
			this.fijo = fijo;
		} else {
			this.fijo = String.valueOf(DEFAULT_TELEFONO_VALUE);
			throw new AmigoException(AmigoException.COD_ERROR_FIJO, AmigoException.MSG_ERROR_FIJO);
		}

	}

	public void setAnotaciones(String anotaciones) throws AmigoException {

		this.anotaciones = anotaciones;

	}

	@Override
	public String toString() {
		return "Amigo [nombre=" + this.nombre + ", this.apellido=" + this.apellido + ", mTelefono=" + this.movil + ", fTelefono=" + this.fijo
				+ ", calle=" + this.calle + ", provincia=" + this.provincia + ", localidad=" + this.localidad + ", codigoPostal=" + this.cp
				+ ", anotaciones=" + this.anotaciones + "]";
	}

}
