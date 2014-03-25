package com.ipartek.agenda.bean;

import com.ipartek.agenda.exception.ContactoException;
import com.ipartek.agenda.util.ContactoUtil;




import java.util.ArrayList;
import java.util.Comparator;


/**
 * Clase para definir a los amigos en la agenda
 * @author Ioritz Bereikua Etxebarria
 *
 */
public class Contacto {
	
	
	//ATRIBUTOS
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
	 * Constructor por defecto
	 */
	
	public Contacto() throws ContactoException{
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
	
	
	
	
	public Contacto(String nombre, String apellido, String calle, int cp, String localidad, String provincia, int movil, int fijo,
			String anotaciones) throws ContactoException {
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
	
	
	
	//GENERATE GETTERS AND SETTERS
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
	public void setCp(int cp){
		this.cp = cp;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad){
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia){
		this.provincia = provincia;
	}
	public int getMovil() {
		return movil;
	}
	public void setMovil(int movil){
		this.movil = movil;
	}
	public int getFijo() {
		return fijo;
	}
	public void setFijo(int fijo){
		this.fijo = fijo;
	}
	public String getAnotaciones() {
		return anotaciones;
	}
	public void setAnotaciones(String anotaciones){
		this.anotaciones = anotaciones;
	}




	@Override
	public String toString() {
		return "Contacto [nombre=" + this.nombre + ", apellido=" + this.apellido + ", calle=" + this.calle + ", cp=" + this.cp + ", localidad="
				+ this.localidad + ", provincia=" + this.provincia + ", movil=" + this.movil + ", fijo=" + this.fijo + ", anotaciones=" + this.anotaciones + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
