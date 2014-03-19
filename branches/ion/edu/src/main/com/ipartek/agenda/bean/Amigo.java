package com.ipartek.agenda.bean;

import com.ipartek.agenda.exception.AmigoException;
import com.ipartek.agenda.util.UtilAmigo;
/**
 * Clase que contiene el objeto Amigo
 * @author Eduardo Monterrubio
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
    private int movil;
    private int fijo;
    private String anotaciones;
    /**
     * Constructor sin parametros
     */
    public Amigo(){
    	nombre="Sinespecificar";
    	apellido="Sinespecificar";
    	calle="Sinespecificar";
    	cp=11111;
    	localidad="Sin especificar";
    	provincia="Sinespecificar";
    	movil=666666666;
    	fijo=946666666;
    	anotaciones="Sin especificar";
    }
    /**
     * Constructor con parametros
     * @param id
     * @param nombre
     * @param apellido
     * @param calle
     * @param cp
     * @param localidad
     * @param provincia
     * @param movil
     * @param fijo
     * @param anotaciones
     * @throws AmigoException
     */
	public Amigo(int id, String nombre, String apellido, String calle, int cp,
			String localidad, String provincia, int movil, int fijo,
			String anotaciones) throws AmigoException {
		super();
		this.setId(id);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo que testea el nombre pasado por parametro
	 * @param nombre
	 * @throws AmigoException
	 */
	public void setNombre(String nombre) throws AmigoException {
		if (UtilAmigo.checkNombre(nombre)){
			this.nombre = nombre;
		}
		else throw new AmigoException(AmigoException.COD_ERROR_NOMBRE,AmigoException.MENSAJE_ERROR_NOMBRE);
		
	}
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo que testea el apellido pasado por parametro
	 * @param apellido
	 * @throws AmigoException
	 */
	public void setApellido(String apellido) throws AmigoException {
		if (UtilAmigo.checkNombre(apellido)){
		this.apellido = apellido;
		}
		else throw new AmigoException(AmigoException.COD_ERROR_APELLIDO,AmigoException.MENSAJE_ERROR_APELLIDO);
		
	}
	public String getCalle() {
		return calle;
	}
	/**
	 * Metodo que testea la calle pasado por parametro
	 * @param calle
	 * @throws AmigoException
	 */
	public void setCalle(String calle) throws AmigoException {
		if (UtilAmigo.checkNombre(calle)){
			this.calle = calle;
		}
		else throw new AmigoException(AmigoException.COD_ERROR_CALLE,AmigoException.MENSAJE_ERROR_CALLE);
		
	}
	public int getCp() {
		return cp;
	}
	/**
	 * Metodo que testea el CP
	 * @param cp
	 * @throws AmigoException
	 */
	public void setCp(int cp) throws AmigoException {
		if (UtilAmigo.checkCP(cp)){
		this.cp = cp;
		}
		else throw new AmigoException(AmigoException.COD_ERROR_CP,AmigoException.MENSAJE_ERROR_CP);
	}
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * Metodo que testea la localidad
	 * @param localidad
	 * @throws AmigoException
	 */
	public void setLocalidad(String localidad) throws AmigoException {
		if (UtilAmigo.checkNombre(localidad)){
		this.localidad = localidad;
	    }
		else throw new AmigoException(AmigoException.COD_ERROR_LOCALIDAD,AmigoException.MENSAJE_ERROR_LOCALIDAD);
	}
	public String getProvincia() {
		return provincia;
	}
	/**
	 * Metodo que testea la provincia
	 * @param provincia
	 * @throws AmigoException
	 */
	public void setProvincia(String provincia) throws AmigoException {
		if (UtilAmigo.checkNombre(provincia)){
		   this.provincia = provincia;
		}
		else throw new AmigoException(AmigoException.COD_ERROR_PROVINCIA,AmigoException.MENSAJE_ERROR_PROVINCIA);
	}
	public int getMovil() {
		return movil;
	}
	/**
	 * Metodo que testea el movil
	 * @param movil
	 * @throws AmigoException
	 */
	public void setMovil(int movil) throws AmigoException {
		if (UtilAmigo.checkMovil(movil)){
		this.movil = movil;
		}
		else throw new AmigoException(AmigoException.COD_ERROR_MOVIL,AmigoException.MENSAJE_ERROR_MOVIL);
	}
	public int getFijo() {
		return fijo;
	}
	/**
	 * Metodo que testea el telefono fijo
	 * @param fijo
	 * @throws AmigoException
	 */
	public void setFijo(int fijo) throws AmigoException {
		if (UtilAmigo.checkFijo(fijo)){
		this.fijo = fijo;
		}
		else throw new AmigoException(AmigoException.COD_ERROR_FIJO,AmigoException.MENSAJE_ERROR_FIJO);
	}
	public String getAnotaciones() {
		return anotaciones;
	}
	/**
	 * Metodo que teatea las anotaciones
	 * @param anotaciones
	 */
	public void setAnotaciones(String anotaciones){
		this.anotaciones = anotaciones;
	}
	@Override
	public String toString() {
		return "Amigo [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", calle=" + calle + ", cp=" + cp + ", localidad="
				+ localidad + ", provincia=" + provincia + ", movil=" + movil
				+ ", fijo=" + fijo + ", anotaciones=" + anotaciones + "]";
	}
    
    
    
}
