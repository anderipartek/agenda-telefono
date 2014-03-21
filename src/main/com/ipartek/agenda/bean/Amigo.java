package com.ipartek.agenda.bean;

import com.ipartek.agenda.exceptions.AmigoException;
import com.ipartek.agenda.util.AmigoUtil;

/**
 * Clase para definir las caracteristicas de un Amigo.
 * 
 * @author Patricia Navascués
 * @version 1.0
 * 
 */
public class Amigo {

	private int id;
	private String nombre;
	private String apellido;
	private String calle;
	private int cp;
	private String localidad;
	private String provincia;
	private int fijo;
	private int movil;
	private String anotaciones;

	// Constructores
	/**
	 * Constructor por defecto. Pone a null todos los campos.
	 */
	public Amigo() {
		super();
	}

	/**
	 * Constructor para inicializar todos los datos salvo el id que lo da la
	 * BBDD.
	 * 
	 * @param nombre
	 * @param apellido
	 * @param cp
	 * @param movil
	 * @param localidad
	 * @param calle
	 * @param fijo
	 * @param provincia
	 * @param anotaciones
	 * @throws AmigoException 
	 */
	public Amigo(String nombre, String apellido, int cp, int movil, String localidad, String calle, int fijo, String provincia, String anotaciones) throws AmigoException {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCp(cp);
		this.setMovil(movil);
		this.setLocalidad(localidad);
		this.setCalle(calle);
		this.setFijo(fijo);
		this.setProvincia(provincia);
		this.setAnotaciones(anotaciones);
	}

	/**
	 * Constructor inicializando los campos.
	 * 
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param movil
	 * @param cp
	 * @param localidad
	 * @param provincia
	 * @param fijo
	 * @param calle
	 * @param anotaciones
	 * @throws AmigoException 
	 */
	public Amigo(int id, String nombre, String apellido, int cp, int movil, String localidad, String provincia, int fijo, String calle,
			String anotaciones) throws AmigoException {
		super();
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCp(cp);
		this.setMovil(movil);
		this.setLocalidad(localidad);
		this.setCalle(calle);
		this.setFijo(fijo);
		this.setProvincia(provincia);
		this.setAnotaciones(anotaciones);
	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return AmigoUtil.toCapitalCase(nombre);
	}

	public void setNombre(String nombre) throws AmigoException {
		if (AmigoUtil.checkNombre(nombre)) {
			this.nombre = nombre;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_NOMBRE, 
					AmigoException.MSG_ERROR_NOMBRE);
		}
	}

	public String getApellido() {
		
		return AmigoUtil.toCapitalCase(apellido);
	}

	public void setApellido(String apellido) throws AmigoException {
		if (AmigoUtil.checkApellido(apellido)) {
			this.apellido = apellido;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_APELLIDO, 
					AmigoException.MSG_ERROR_APELLIDO);
		}
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) throws AmigoException {
		if (AmigoUtil.checkCalle(calle)) {
			this.calle = calle;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_CALLE, 
					AmigoException.MSG_ERROR_CALLE);
		}

	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) throws AmigoException {
		if (AmigoUtil.checkCodigoPostal(cp)) {
			this.cp = cp;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_CP, 
					AmigoException.MSG_ERROR_CP);
		}
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) throws AmigoException {
		if (AmigoUtil.checkLocalidad(localidad)) {
			this.localidad = localidad;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_LOCALIDAD, 
					AmigoException.MSG_ERROR_LOCALIDAD);
		}
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) throws AmigoException {
		if (AmigoUtil.checkProvincia(provincia)) {
			this.provincia = provincia;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_PROVINCIA,
					AmigoException.MSG_ERROR_PROVINCIA);
		}
	}

	public int getFijo() {
		return fijo;
	}

	public void setFijo(int fijo) throws AmigoException {
		if (AmigoUtil.checkTelefonosFijos(fijo)) {
			this.fijo = fijo;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_FIJO, 
					AmigoException.MSG_ERROR_FIJO);
		}
	}

	public int getMovil() {
		return movil;
	}

	public void setMovil(int movil) throws AmigoException {
		if (AmigoUtil.checkTelefonosMoviles(movil)) {
			this.movil = movil;
		} else {
			throw new AmigoException(
					AmigoException.COD_ERROR_MOVIL,
					AmigoException.MSG_ERROR_MOVIL);
		}

	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	@Override
	public String toString() {
		return "Amigo [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", calle=" + calle + ", cp=" + cp + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", fijo=" + fijo + ", movil=" + movil + ", anotaciones=" + anotaciones + "]";
	}

}
