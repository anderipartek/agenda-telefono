package com.ipartek.agenda.bean;

/**
 * Clase para gerstionar los amigos.
 * 
 * @author Ibai Sainz-Aja
 * @version 1.0
 */
public class Amigo {

	private int id;
	private String nombre;
	private String apellido;
	private String calle;
	private int cp;
	private String localidad;
	private String provincia;
	private int movil;
	private int fijo;
	private String anotaciones;

	/**
	 * Constructor por defecto.
	 */
	public Amigo() {
		super();

		this.id = -1;
		this.nombre = "";
		this.apellido = "";
		this.calle = "";
		this.cp = 0;
		this.localidad = "";
		this.provincia = "";
		this.movil = 0;
		this.fijo = 0;
		this.anotaciones = "";

	}

	/**
	 * Constructor con parametros.
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
	public Amigo(final String nombre, final String apellido,
			final String calle, final int cp, final String localidad,
			final String provincia, final int movil, final int fijo,
			final String anotaciones) {
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
	 * Getter del id.
	 * 
	 * @return id
	 */
	public final int getId() {
		return this.id;
	}

	/**
	 * Setter de id.
	 * 
	 * @param idParam
	 *            del amigo
	 */
	public final void setId(final int idParam) {
		this.id = idParam;
	}

	/**
	 * Getter del nombre.
	 * 
	 * @return nombre
	 */
	public final String getNombre() {
		return this.nombre;
	}

	/**
	 * Setter del nombre.
	 * 
	 * @param nombreParam
	 *            del alumno
	 */
	public final void setNombre(final String nombreParam) {
		this.nombre = nombreParam;
	}

	/**
	 * Getterdel apellido.
	 * 
	 * @return apellido
	 */
	public final String getApellido() {
		return this.apellido;
	}

	/**
	 * Setter del apellido.
	 * 
	 * @param apellidoParam
	 *            del amigo
	 */
	public final void setApellido(final String apellidoParam) {
		this.apellido = apellidoParam;
	}

	/**
	 * Getter de la calle.
	 * 
	 * @return calle del amigo
	 */
	public final String getCalle() {
		return this.calle;
	}

	/**
	 * Setter de la calle.
	 * 
	 * @param calleParam
	 *            del amigo
	 */
	public final void setCalle(final String calleParam) {
		this.calle = calleParam;
	}

	/**
	 * Getter del cp.
	 * 
	 * @return cp
	 */
	public final int getCp() {
		return this.cp;
	}

	/**
	 * Setter del cp.
	 * 
	 * @param cpParam
	 *            del alumno
	 */
	public final void setCp(final int cpParam) {
		this.cp = cpParam;
	}

	/**
	 * Getter de la localidad.
	 * 
	 * @return localidad
	 */
	public final String getLocalidad() {
		return this.localidad;
	}

	/**
	 * Setter de la localidad.
	 * 
	 * @param localidadParam
	 *            del amigo
	 */
	public final void setLocalidad(final String localidadParam) {
		this.localidad = localidadParam;
	}

	/**
	 * Getter de la provincia.
	 * 
	 * @return provincia
	 */
	public final String getProvincia() {
		return this.provincia;
	}

	/**
	 * Setter de la provincia.
	 * 
	 * @param provinciaParam
	 *            del amigo
	 */
	public final void setProvincia(final String provinciaParam) {
		this.provincia = provinciaParam;
	}

	/**
	 * Getter del movil.
	 * 
	 * @return movil
	 */
	public final int getMovil() {
		return this.movil;
	}

	/**
	 * Setter del movil.
	 * 
	 * @param movilParam
	 *            del amigo
	 */
	public final void setMovil(final int movilParam) {
		this.movil = movilParam;
	}

	/**
	 * Getter del fijo.
	 * 
	 * @return fijo.
	 */
	public final int getFijo() {
		return this.fijo;
	}

	/**
	 * Setter del fijo.
	 * 
	 * @param fijoParam
	 *            del amigo
	 */
	public final void setFijo(final int fijoParam) {
		this.fijo = fijoParam;
	}

	/**
	 * Getter de anotaciones.
	 * 
	 * @return anotaciones
	 */
	public final String getAnotaciones() {
		return this.anotaciones;
	}

	/**
	 * Setter de anotaciones.
	 * 
	 * @param anotacionesParam
	 *            del amigo
	 */
	public final void setAnotaciones(final String anotacionesParam) {
		this.anotaciones = anotacionesParam;
	}

	@Override
	public final String toString() {
		return "Amigo [id=" + this.id + ", nombre=" + this.nombre
				+ ", apellido=" + this.apellido + ", calle=" + this.calle
				+ ", cp=" + this.cp + ", localidad=" + this.localidad
				+ ", provincia=" + this.provincia + ", movil=" + this.movil
				+ ", fijo=" + this.fijo + ", anotaciones=" + this.anotaciones
				+ "]";
	}
}
