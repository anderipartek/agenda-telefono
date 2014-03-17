package com.ipartek.agenda.main.bean;
/**
 * Clase Amigo donde se gestiona todos los datos de éste
 * @author Saray Carralero
 *
 */
public class Amigo {
	private String nombre;
	private String apellido;
	private String calle;
	private String localidad;
	private String anotaciones;
	private String provincia;
	private int cp;
	private int tFijo;
	private int tMovil;
	
	public Amigo(String nombre, String apellido, String calle,
			String localidad, String anotaciones, String provincia, int cp,
			int tFijo, int tMovil) {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCalle(calle);
		this.setLocalidad(localidad);
		this.setAnotaciones(anotaciones);
		this.setProvincia(provincia);
		this.setCp(cp);
		this.settMovil(tMovil);
		this.settFijo(tFijo);
	}
	
	

	public Amigo() {
		super();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCalle(calle);
		this.setLocalidad(localidad);
		this.setAnotaciones(anotaciones);
		this.setProvincia(provincia);
		this.setCp(cp);
		this.settMovil(tMovil);
		this.settFijo(tFijo);
		
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

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int gettFijo() {
		return tFijo;
	}

	public void settFijo(int tFijo) {
		this.tFijo = tFijo;
	}

	public int gettMovil() {
		return tMovil;
	}

	public void settMovil(int tMovil) {
		this.tMovil = tMovil;
	}
	
}
