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

import java.io.Serializable;

@SuppressWarnings("serial")
@Entity
public class ServicesSpecialises implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idServS;
	@Column(unique = true,nullable = false)
	private String codServS;
	private String libServS;
	
	
	public ServicesSpecialises() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne(targetEntity = Centre.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCentre", referencedColumnName = "idCentre", nullable = false, updatable = true, insertable = true)
	private Centre centre;
	
	public ServicesSpecialises(String codServS, String libServS, Centre centre) {
		super();
		this.codServS = codServS;
		this.libServS = libServS;
		this.centre = centre;
	}
	
	
	public void setCodServS(String codServS) {
		this.codServS = codServS;
	}
	public String getCodServS() {
		return codServS;
	}
	public void setIdServS(Long idServS) {
		this.idServS = idServS;
	}
	public Long getIdServS() {
		return idServS;
	}
	public void setLibServS(String libServS) {
		this.libServS = libServS;
	}
	public String getLibServS() {
		return libServS;
	}
	
	public void setCentre(Centre centre) {
		this.centre = centre;
	}
	
	public Centre getCentre() {
		return centre;
	}
	
	@Override
	public String toString() {
		return "ServicesSpecialises [idServS=" + idServS + ", codServS=" + codServS + ", libServS=" + libServS + ", centre ="+centre+"]";
	}


	public String element() {
		
		return idServS+";"+ codServS +";"+libServS +";"+ centre.getLibCentre();
	}	
	
}