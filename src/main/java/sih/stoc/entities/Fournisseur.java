package sih.stoc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity

public class Fournisseur extends Audit<String> implements Serializable {
@Id
@Column(updatable = true)
private String codFour;
private String libFour;
private Long ifuFour;
private String telFour;
private String adrFour;
private String rcc;


	
	public Fournisseur() {
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(String codFour, String libFour, String telFour, String adrFour, Long ifuFour, String rcc) {
		super();
		this.codFour = codFour;
		this.libFour = libFour;
		this.telFour = telFour;
		this.adrFour = adrFour;
		this.ifuFour = ifuFour;
		this.rcc=rcc;
	}
	
	public String getCodFour() {
		return codFour;
	}

	public void setCodFour(String codFour) {
		this.codFour = codFour;
	}

	public String getLibFour() {
		return libFour;
	}

	public void setLibFour(String libFour) {
		this.libFour = libFour;
	}
	

	public String getAdrFour() {
		return adrFour;
	}

	public void setAdrFour(String adrFour) {
		this.adrFour = adrFour;
	}
	

	public Long getIfuFour() {
		return ifuFour;
	}

	public void setIfuFour(Long ifuFour) {
		this.ifuFour = ifuFour;
	}
	

	public String getTelFour() {
		return telFour;
	}

	public void setTelFour(String telFour) {
		this.telFour = telFour;
	}

	public String getRcc() {
		return rcc;
	}

	public void setRcc(String rcc) {
		this.rcc = rcc;
	}

	@Override
	public String toString() {
		return "Fournisseur [codFour=" + codFour + ", libFour=" + libFour + ", ifuFour=" + ifuFour + ", telFour="
				+ telFour + ", adrFour=" + adrFour + ", rcc=" + rcc + "]";
	}


}
