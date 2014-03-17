package com.ipartek.agenda.bean;


/**
 * Clase para definir a los amigos en la agenda
 * @author Ioritz
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
	
	public Contacto() {
		super();
		this.setNombre("Sin especificar");
		this.setApellido("Sin especificar");
		this.setCalle("Sin especificar");
		this.setCp(48200);
		this.setLocalidad("Sin especificar");
		this.setProvincia("Sin especificar");
		this.setMovil(666666666);
		this.setFijo(946555555);
		this.setAnotaciones("Sin especificar");
		
	}
	
	
	
	
	public Contacto(String nombre, String apellido, String calle, int cp, String localidad, String provincia, int movil, int fijo,
			String anotaciones) {
		super();
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
	
	
	
	
	
	
	
	
	
	

}
