package sih.facturation.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import sih.securite.config.Audit;

@Entity
public class Caisse extends Audit<String> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String codCai;
	private String libCai;
	
	public Caisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Caisse(String codCai, String libCai) {
		super();
		this.codCai = codCai;
		this.libCai = libCai;
	}

	public String getCodCai() {
		return codCai;
	}

	public void setCodCai(String codCai) {
		this.codCai = codCai;
	}

	public String getLibCai() {
		return libCai;
	}

	public void setLibCai(String libCai) {
		this.libCai = libCai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Caisse [codCai=" + codCai + ", libCai=" + libCai + "]";
	}
	

}
