package com.ipartek.agenda.bean;

/**
 * Clase para definir las caracteristicas de un Amigo
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
	 * Constructor para inicializar todos los datos salvo el id que lo da la BBDD.	
	 * @param nombre
	 * @param apellido
	 * @param cp
	 * @param movil
	 * @param localidad
	 * @param calle
	 * @param fijo
	 * @param provincia
	 * @param anotaciones
	 */
	public Amigo(String nombre, String apellido, int cp, int movil, String localidad, String calle, int fijo, String provincia, String anotaciones) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cp = cp;
		this.movil = movil;
		this.localidad = localidad;
		this.calle = calle;
		this.fijo = fijo;
		this.provincia = provincia;
		this.anotaciones = anotaciones;
	}

	/**
	 * Constructor inicializando los campos.
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param calle
	 * @param cp
	 * @param localidad
	 * @param provincia
	 * @param fijo
	 * @param movil
	 * @param anotaciones
	 */
	public Amigo(int id, String nombre, String apellido, String calle, int cp, String localidad, String provincia, int fijo, int movil,
			String anotaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.cp = cp;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fijo = fijo;
		this.movil = movil;
		this.anotaciones = anotaciones;
	}
	
	

	// getters y setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public int getFijo() {
		return fijo;
	}
	public void setFijo(int fijo) {
		this.fijo = fijo;
	}
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil) {
		this.movil = movil;
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
