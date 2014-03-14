package com.ipartek.agenda.bean;
/**
 * Bean representativo de un amigo. Incluye los siguientes atributos:
 * 
 *  <ol>
 *  <li>nombre</li>
 *  <li>apellido</li>
 *  <li>calle</li>
 *  <li>cp</li>
 *  <li>localidad</li>
 *  <li>provincia</li>
 *  <li>movil</li>
 *  <li>fijo</li>
 *  <li>anotaciones</li>
 *  </ol>
 *  
 * @author Curso
 *
 */
public class Amigo {
	
	private String nombre;
	private String apellido;
	private String calle;
	private String localidad;
	private String provincia;
	private StringBuilder anotaciones;
	private String fijo;
	private String movil;
	private int cp;
	
	
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
	public StringBuilder getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(StringBuilder anotaciones) {
		this.anotaciones = anotaciones;
	}
	public String getFijo() {
		return fijo;
	}
	public void setFijo(String fijo) {
		this.fijo = fijo;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	

}
