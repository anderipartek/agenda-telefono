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
	private String cp;
	private String localidad;
	private String Provincia;
	private int fijo;
	private int movil;
	private String anotaciones;
	
	// Constructor
	public Amigo(int id, String nombre, String apellido, String cp, String localidad, String provincia, int fijo, int movil, String anotaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cp = cp;
		this.localidad = localidad;
		Provincia = provincia;
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
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return Provincia;
	}
	public void setProvincia(String provincia) {
		Provincia = provincia;
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
		return "Amigo [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cp=" + cp + ", localidad=" + localidad + ", Provincia="
				+ Provincia + ", fijo=" + fijo + ", movil=" + movil + ", anotaciones=" + anotaciones + "]";
	}
	
	
	
	
	
}
