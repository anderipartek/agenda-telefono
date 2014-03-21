package com.ipartek.agenda.bean;

public class Amigo {
	
	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private String calle;
	
	private int cp;
	
	private String localidad;
	
	private String provincia;
	
	private int numMovil;
	
	private int numFijo;
	
	private String anotaciones;
	
	
	
	

	public Amigo() {
		super();
		this.nombre = "Sin especificar";
		this.numMovil = 0;
		//Campos opcionales, por defecto:
		this.apellido = "Sin especificar";
		this.calle = "Sin especificar";
		this.cp = 0;
		this.localidad = "Sin especificar";
		this.provincia = "Sin especificar";
		this.numFijo = 0;
		this.anotaciones = "Sin especificar";
		
	}



	public Amigo(String nombre, int numMovil) {
		super();
		//Campos obligatorios
	
		this.nombre = nombre;
		this.numMovil = numMovil;
		//Campos opcionales, por defecto:
		this.apellido = "Sin especificar";
		this.calle = "Sin especificar";
		this.cp = 0;
		this.localidad = "Sin especificar";
		this.provincia = "Sin especificar";
		this.numFijo = 0;
		this.anotaciones = "Sin especificar";
	}
	
	

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

	public int getNumMovil() {
		return numMovil;
	}

	public void setNumMovil(int numMovil) {
		this.numMovil = numMovil;
	}

	public int getNumFijo() {
		return numFijo;
	}

	public void setNumFijo(int numFijo) {
		this.numFijo = numFijo;
	}

	public String getAnotaciones() {
		return anotaciones;
	}



	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}



	@Override
	public String toString() {
		return "Amigo [nombre=" + nombre + ", apellido=" + apellido + ", calle=" + calle + ", cp=" + cp + ", localidad=" + localidad + ", provincia="
				+ provincia + ", numMovil=" + numMovil + ", numFijo=" + numFijo + "]";
	}
	
}


