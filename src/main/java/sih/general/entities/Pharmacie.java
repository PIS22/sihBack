package sih.general.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

import java.io.Serializable;


@SuppressWarnings("serial")
@Entity
public class Pharmacie extends Audit<Utilisateur> implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPharma;
	@Column(unique = true,nullable = false)
	private String codPharma;
	private String libPharma;
	private String adrPharma;
	
	public Pharmacie() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne(targetEntity = Commune.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCom", referencedColumnName = "idCom", nullable = false, updatable = true, insertable = true)
	private Commune com;
	
	public Pharmacie(String codPharma, String libPharma, String adrPharma, Commune com) {
		super();
		this.codPharma = codPharma;
		this.libPharma = libPharma;
		this.adrPharma = adrPharma;
		this.com = com;
	}
	public void setAdrPharma(String adrPharma) {
		this.adrPharma = adrPharma;
	}
	public String getAdrPharma() {
		return adrPharma;
	}
	public void setCodPharma(String codPharma) {
		this.codPharma = codPharma;
	}
	public String getCodPharma() {
		return codPharma;
	}
	public void setIdPharma(Long idPharma) {
		this.idPharma = idPharma;
	}
	public Long getIdPharma() {
		return idPharma;
	}
	public void setLibPharma(String libPharma) {
		this.libPharma = libPharma;
	}
	public String getLibPharma() {
		return libPharma;
	}
	
	public void setCom(Commune com) {
		this.com = com;
	}
	
	public Commune getCom() {
		return com;
	}
		
	@Override
	public String toString() {
		return "Pharmacie [idPharma=" + idPharma + ", codPharma=" + codPharma + ", libPharma=" + libPharma + ", AdrPharma=" + adrPharma +", Com = "+com+"]";
	}
	public String element() {
	
		return idPharma + "; " +codPharma  + "; " +  libPharma + "; "+ adrPharma+";" +com.getLibCom();
	}

}

