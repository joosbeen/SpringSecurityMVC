package com.newsoft.spring.dao;

public class CommonResponce {

	private boolean estado;
	private String tipo;
	private String mensaje;

	public CommonResponce() {
		super();
	}

	public CommonResponce(boolean estado, String tipo, String mensaje) {
		super();
		this.estado = estado;
		this.tipo = tipo;
		this.mensaje = mensaje;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
