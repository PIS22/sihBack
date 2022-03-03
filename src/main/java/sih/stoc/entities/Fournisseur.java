package sih.stoc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity

public class Fournisseur implements Serializable {
@Id
@Column(updatable = true)
private String codFour;
private String libFour;
	
	public Fournisseur() {
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(String codFour, String libFour) {
		super();
		this.codFour = codFour;
		this.libFour = libFour;
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
	
	public String element() {
		return "Fournisseur(" + codFour + "; " + libFour + ")";
	}

	@Override
	public String toString() {
		return "Fournisseur [ codFour=" + codFour + ", libFour=" + libFour + "]";
	}



}
