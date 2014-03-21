package com.ipartek.agenda.bean;

public class Amigo {

	// ATRIBUTOS
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
	
	//CONSTRUCTOR
	public Amigo(int id, String nombre, String apellido, String calle, int cp, String localidad, String provincia, int movil, int fijo,
			String anotaciones) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCalle(calle);
		this.setCp(cp);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setMovil(movil);
		this.setFijo(fijo);
		this.setAnotaciones(anotaciones);
	}
	
	public Amigo() {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCalle(calle);
		this.setCp(cp);
		this.setLocalidad(localidad);
		this.setProvincia(provincia);
		this.setMovil(movil);
		this.setFijo(fijo);
		this.setAnotaciones(anotaciones);
	}
	//GETTERS Y SETTERS
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
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil) {
		this.movil = movil;
	}
	public int getFijo() {
		return fijo;
	}
	public void setFijo(int fijo) {
		this.fijo = fijo;
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
				+ ", provincia=" + provincia + ", movil=" + movil + ", fijo=" + fijo + ", anotaciones=" + anotaciones + "]";
	}	
	
}
