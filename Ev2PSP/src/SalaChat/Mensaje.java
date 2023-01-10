package SalaChat;

import java.io.Serializable;
import java.util.Date;

public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;
	Date fechaHora;
	String texto;
	String emisor;

	public Mensaje(String texto, String emisor) {
		super();
		this.fechaHora = new Date();
		this.texto = texto;
		this.emisor = emisor;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getEmisor() {
		return emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	@Override
	public String toString() {
		return "(" + fechaHora + ") " + emisor + ": " + texto;
	}

}
