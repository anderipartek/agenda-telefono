package com.ipartek.agenda.bean;

public class Mensajes {
	private String mensaje;
	private int codigo;
	private String tipo;

	public Mensajes(String mensaje, int codigo, String tipo) {
		super();
		this.mensaje = mensaje;
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
