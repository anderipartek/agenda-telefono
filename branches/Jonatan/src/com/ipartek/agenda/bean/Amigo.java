package com.ipartek.agenda.bean;

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

	public Amigo(String nombre, String apellido, String calle, int cp, String localidad, String provincia, int movil, int fijo, String anotaciones) {
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getCp() {
		return this.cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getMovil() {
		return this.movil;
	}

	public void setMovil(int movil) {
		this.movil = movil;
	}

	public int getFijo() {
		return this.fijo;
	}

	public void setFijo(int fijo) {
		this.fijo = fijo;
	}

	public String getAnotaciones() {
		return this.anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	@Override
	public String toString() {
		return "Amigo [id=" + this.id + ", nombre=" + this.nombre + ", apellido=" + this.apellido + ", calle=" + this.calle + ", cp=" + this.cp
				+ ", localidad=" + this.localidad + ", provincia=" + this.provincia + ", movil=" + this.movil + ", fijo=" + this.fijo
				+ ", anotaciones=" + this.anotaciones + "]";
	}
}
