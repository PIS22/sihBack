package sih.facturation.entities;

import java.time.LocalDateTime;

public class VentePeriode {
	LocalDateTime deb;
	LocalDateTime fin;
	Long us;
	String cais;
	
	public VentePeriode() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VentePeriode(LocalDateTime deb, LocalDateTime fin, Long us, String cais) {
		super();
		this.deb = deb;
		this.fin = fin;
		this.us = us;
		this.cais = cais;
	}

	public LocalDateTime getDeb() {
		return deb;
	}

	public void setDeb(LocalDateTime deb) {
		this.deb = deb;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public Long getUs() {
		return us;
	}

	public void setUs(Long us) {
		this.us = us;
	}

	public String getCais() {
		return cais;
	}

	public void setCais(String cais) {
		this.cais = cais;
	}

}
