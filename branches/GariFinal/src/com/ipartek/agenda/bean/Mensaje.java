package com.ipartek.agenda.bean;
/**
 * Encapsula los manesahes para mostrar en el font end o capa de la vista de la APPweb
 * @author Garikoitz Elorrieta Mediavilla
 *
 */
public class Mensaje {
	



	private String msg;
	private int codigo;
	private TIPO_MENSAJE Tipo;
	
	
	/**
	 * Clase intrna quue soporta el tipo de mensaje a mostrar
	 * 
	 *
	 */
	public enum TIPO_MENSAJE {
		INFO, WARNING, ERROR;
		}
	
	
	public Mensaje(String msg, int codigo, TIPO_MENSAJE tipo) {
		super();
		this.msg = msg;
		this.codigo = codigo;
		Tipo = tipo;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public TIPO_MENSAJE getTipo() {
		return Tipo;
	}


	public void setTipo(TIPO_MENSAJE tipo) {
		Tipo = tipo;
	}


	@Override
	public String toString() {
		return "Mensaje [msg=" + msg + ", codigo=" + codigo + ", Tipo=" + Tipo
				+ "]";
	}
	
	
	

}
