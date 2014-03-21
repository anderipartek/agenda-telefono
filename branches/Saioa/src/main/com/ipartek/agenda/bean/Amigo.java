package com.ipartek.agenda.bean;



/**
 * Clase que contiene el objeto Amigo
 * @author Eduardo Monterrubio
 *
 */
public class Amigo {
	//---------------ATRIBUTOS----------------------
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
	//---------------------CONSTRUCTORES-------------------
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
			String anotaciones)  {
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
	public void setNombre(String nombre)  {
		
			this.nombre = nombre;
		
		
	}
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo que testea el apellido pasado por parametro
	 * @param apellido
	 * @throws AmigoException
	 */
	public void setApellido(String apellido) {
		
		this.apellido = apellido;
	
		
	}
	public String getCalle() {
		return calle;
	}
	/**
	 * Metodo que testea la calle pasado por parametro
	 * @param calle
	 * @throws AmigoException
	 */
	public void setCalle(String calle)  {
	
			this.calle = calle;
		
		
	}
	public int getCp() {
		return cp;
	}
	/**
	 * Metodo que testea el CP
	 * @param cp
	 * @throws AmigoException
	 */
	public void setCp(int cp)  {
	
		this.cp = cp;
		
	}
	public String getLocalidad() {
		return localidad;
	}
	/**
	 * Metodo que testea la localidad
	 * @param localidad
	 * @throws AmigoException
	 */
	public void setLocalidad(String localidad)  {
	
		this.localidad = localidad;
	  
	}
	public String getProvincia() {
		return provincia;
	}
	/**
	 * Metodo que testea la provincia
	 * @param provincia
	 * @throws AmigoException
	 */
	public void setProvincia(String provincia) {
		
		   this.provincia = provincia;
	
	}
	public int getMovil() {
		return movil;
	}
	/**
	 * Metodo que testea el movil
	 * @param movil
	 * @throws AmigoException
	 */
	public void setMovil(int movil) {
	
		this.movil = movil;
	
	}
	public int getFijo() {
		return fijo;
	}
	/**
	 * Metodo que testea el telefono fijo
	 * @param fijo
	 * @throws AmigoException
	 */
	public void setFijo(int fijo)  {
	
		this.fijo = fijo;
	
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
