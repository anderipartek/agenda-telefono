package com.ipartek.agenda.bean;

import com.ipartek.agenda.enumeration.TIPO_MENSAJE;

/**
 * Encapsula los mensajes para mostrar en el frontend de la AppWeb.
 * 
 * @author Ibai Sainz-Aja Depardieu
 * @version 1.0
 */
public class Mensaje {

	private String msg;
	private int codigo;
	private TIPO_MENSAJE tipo;

	/**
	 * Constructor con poarametros.
	 * 
	 * @param msgParam mensaje a enviar
	 * @param codigoParam del mensaje
	 * @param tipoParam del mensaje
	 */
	public Mensaje(final String msgParam, final int codigoParam, 
			final TIPO_MENSAJE tipoParam) {
		super();
		this.msg = msgParam;
		this.codigo = codigoParam;
		this.tipo = tipoParam;
	}

	/**
	 * Getter del mensaje.
	 * @return el mensaje
	 */
	public final String getMsg() {
		return msg;
	}

	/**
	 * Setter del mensaje.
	 * @param msgParam el mensaje
	 */
	public final void setMsg(final String msgParam) {
		this.msg = msgParam;
	}

	/**
	 * Getter del codigo.
	 * @return codigo
	 */
	public final int getCodigo() {
		return codigo;
	}

	/**
	 * Setter del codigo.
	 * @param codigoParam el codigo
	 */
	public final void setCodigo(final int codigoParam) {
		this.codigo = codigoParam;
	}

	/**
	 * Getter del tipo.
	 * @return tipo
	 */
	public final TIPO_MENSAJE getTipo() {
		return tipo;
	}

	/**
	 * Setter del mensaje.
	 * @param tipoParam del mensaje
	 */
	public final void setTipo(final TIPO_MENSAJE tipoParam) {
		this.tipo = tipoParam;
	}

}
