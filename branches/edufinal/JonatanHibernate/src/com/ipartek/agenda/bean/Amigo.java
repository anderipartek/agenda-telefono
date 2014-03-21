package com.ipartek.agenda.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "amigos")
public class Amigo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "calle")
	private String calle;
	@Column(name = "cp")
	private int cp;
	@Column(name = "localidad")
	private String localidad;
	@Column(name = "provincia")
	private String provincia;
	@Column(name = "movil")
	private int movil;
	@Column(name = "fijo")
	private int fijo;
	@Column(name = "anotaciones")
	private String anotaciones;

	public Amigo() {
		super();

		this.id = -1;
		this.nombre = "probando";
		this.apellido = "hibernate";
		this.calle = "";
		this.cp = 0;
		this.localidad = "";
		this.provincia = "";
		this.movil = 0;
		this.fijo = 0;
		this.anotaciones = "";

	}

	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param calle
	 * @param cp
	 * @param localidad
	 * @param provincia
	 * @param movil
	 * @param fijo
	 * @param anotaciones
	 */
	public Amigo(final String nombre, final String apellido, final String calle, final int cp, final String localidad, final String provincia,
			final int movil, final int fijo, final String anotaciones) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.cp = cp;
		this.localidad = localidad;
		this.provincia = provincia;
		this.movil = movil;
		this.fijo = fijo;
		this.anotaciones = anotaciones;
	}

	/**
	 * 
	 * @return long
	 */
	public final long getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public final void setId(final long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return String
	 */
	public final String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return String
	 */
	public final String getApellido() {
		return this.apellido;
	}

	/**
	 * 
	 * @param apellido
	 *            String
	 */
	public final void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	/**
	 * 
	 * @return String
	 */
	public final String getCalle() {
		return this.calle;
	}

	/**
	 * 
	 * @param calle
	 *            String
	 */
	public final void setCalle(final String calle) {
		this.calle = calle;
	}

	/**
	 * 
	 * @return int
	 */
	public final int getCp() {
		return this.cp;
	}

	/**
	 * 
	 * @param cp
	 *            int
	 */
	public final void setCp(final int cp) {
		this.cp = cp;
	}

	/**
	 * 
	 * @return String
	 */
	public final String getLocalidad() {
		return this.localidad;
	}

	/**
	 * 
	 * @param localidad
	 *            String
	 */
	public final void setLocalidad(final String localidad) {
		this.localidad = localidad;
	}

	/**
	 * 
	 * @return String
	 */
	public final String getProvincia() {
		return this.provincia;
	}

	/**
	 * 
	 * @param provincia
	 *            String
	 */
	public final void setProvincia(final String provincia) {
		this.provincia = provincia;
	}

	/**
	 * 
	 * @return int
	 */
	public final int getMovil() {
		return this.movil;
	}

	/**
	 * 
	 * @param movil
	 *            int
	 */
	public final void setMovil(final int movil) {
		this.movil = movil;
	}

	/**
	 * 
	 * @return int
	 */
	public final int getFijo() {
		return this.fijo;
	}

	/**
	 * 
	 * @param fijo
	 *            int
	 */
	public final void setFijo(final int fijo) {
		this.fijo = fijo;
	}

	/**
	 * 
	 * @return String
	 */
	public final String getAnotaciones() {
		return this.anotaciones;
	}

	/**
	 * 
	 * @param anotaciones
	 *            String
	 */
	public final void setAnotaciones(final String anotaciones) {
		this.anotaciones = anotaciones;
	}

	@Override
	public final String toString() {
		return "Amigo [id=" + this.id + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", calle=" + this.calle + ", cp=" + this.cp
				+ ", localidad=" + this.localidad + ", provincia=" + this.provincia + ", movil=" + this.movil + ", fijo=" + this.fijo
				+ ", anotaciones=" + this.anotaciones + "]";
	}
}
