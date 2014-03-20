package com.ipartek.agenda.bean;

import com.ipartek.agenda.enumeration.TIPO_MENSAJE;


/**
 * Encapsula los mensajes para mostrar en el frontend de la AppWeb
 * @author Eduardo Monterrubio Robledo
 * @version 1.0
 */
public class Mensaje {
	
	private String msg;
	private int codigo;
	private TIPO_MENSAJE tipo;
	
		
	public Mensaje(String msg, int codigo, TIPO_MENSAJE tipo) {
		super();
		this.msg = msg;
		this.codigo = codigo;
		this.tipo = tipo;
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
		return tipo;
	}
	public void setTipo(TIPO_MENSAJE tipo) {
		this.tipo = tipo;
	}
	
	

}
