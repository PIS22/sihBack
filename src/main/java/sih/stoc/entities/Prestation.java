package sih.stoc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity
public class Prestation extends Audit<Prestation> implements Serializable{
	@Id
	@Column(unique = false, nullable = false, updatable = true, length = 10)
	private String codPrest;
	@Column(nullable = false)
	private String libPrest;
	private String libCourt;
	private String descript;
	@Column(nullable = false)
	private double prix;

	public Prestation() {
		// TODO Auto-generated constructor stub
	}

	public Prestation(String codPrest, String libPrest, String libCourt, String desc, double prix) {
		super();
		this.codPrest = codPrest;
		this.libPrest = libPrest;
		this.libCourt = libCourt;
		this.descript = desc;
		this.prix = prix;
	}

	public String getCodPrest() {
		return codPrest;
	}

	public void setCodPrest(String codPrest) {
		this.codPrest = codPrest;
	}

	public String getLibPrest() {
		return libPrest;
	}

	public void setLibPrest(String libPrest) {
		this.libPrest = libPrest;
	}

	public String getLibCourt() {
		return libCourt;
	}

	public void setLibCourt(String libCourt) {
		this.libCourt = libCourt;
	}

	public String getDesc() {
		return descript;
	}

	public void setDesc(String desc) {
		this.descript = desc;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Prestation [codPrest=" + codPrest + ", libPrest=" + libPrest + ", libCourt="
				+ libCourt + ", desc=" + descript + ", prix=" + prix + "]";
	}

	public String element() {
		return  codPrest + "; " + libPrest + "; "+ libCourt + "; " + descript + "; " + prix;
	}

}
