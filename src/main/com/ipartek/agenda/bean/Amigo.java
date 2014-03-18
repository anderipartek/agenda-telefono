package com.ipartek.agenda.bean;

/**
 * Clase BEAN para crear amigos de la AgendaOnline con todos los datos requeridos por la aplicacion
 * 
 * @author Erlantz Romero Parra
 * @version 1.0
 * 
 */
public class Amigo {

	// ATRIBUTOS
	private int id; // IDENTIFICADOR BBDD
	private String nombre;
	private String apellido;
	private String mTelefono; // TELEFONO MOVIL
	private String fTelefono; // TELEFONO FIJO
	private String calle;
	private String provincia;
	private String localidad;
	private int codigoPostal; // POR DEFECTO 48900
	private String anotaciones; // COMENTARIOS SOBRE EL AMIGO

	// CONSTRUCTORES
	/**
	 * Constructor por defecto
	 */
	public Amigo() {
		// this.id = 0;
		this.nombre = "Nombre";
		this.apellido = "Apellido";
		this.mTelefono = "666666666";
		this.fTelefono = "999999999";
		this.calle = "Calle";
		this.provincia = "Provincia";
		this.localidad = "Localidad";
		this.codigoPostal = 48900;
		this.anotaciones = "Anotaciones";
	}

	/**
	 * Constructor con parametros
	 */
	public Amigo(final String nombre, final String apellido,
			final String mTelefono, final String fTelefono, final String calle,
			final String provincia, final String localidad,
			final int codigoPostal, final String anotaciones) {
		this();
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setMTelefono(mTelefono);
		this.setFTelefono(fTelefono);
		this.setCalle(calle);
		this.setProvincia(provincia);
		this.setLocalidad(localidad);
		this.setCodigoPostal(codigoPostal);
		this.setAnotaciones(anotaciones);
	}

	// GETTERS - SETTERS
	public void setId(final int id) {
		this.id = id;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(final String apellido) {
		this.apellido = apellido;
	}

	public void setMTelefono(final String mTelefono) {
		this.mTelefono = mTelefono;
	}

	public void setFTelefono(final String fTelefono) {
		this.fTelefono = fTelefono;
	}

	public void setCalle(final String calle) {
		this.calle = calle;
	}

	public void setProvincia(final String provincia) {
		this.provincia = provincia;
	}

	public void setLocalidad(final String localidad) {
		this.localidad = localidad;
	}

	public void setCodigoPostal(final int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public void setAnotaciones(final String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getMTelefono() {
		return mTelefono;
	}

	public String getFTelefono() {
		return fTelefono;
	}

	public String getCalle() {
		return calle;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getLocalidad() {
		return localidad;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	@Override
	public String toString() {
		return "Amigo [nombre=" + this.nombre + ", this.apellido="
				+ this.apellido + ", mTelefono=" + this.mTelefono
				+ ", fTelefono=" + this.fTelefono + ", calle=" + this.calle
				+ ", provincia=" + this.provincia + ", localidad="
				+ this.localidad + ", codigoPostal=" + this.codigoPostal
				+ ", anotaciones=" + this.anotaciones + "]";
	}

}