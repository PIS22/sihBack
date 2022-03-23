package sih.general.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;


@SuppressWarnings("serial")
@Entity
public class Commune extends Audit<Utilisateur> implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCom;
	@Column(unique = true,nullable = false)
	private String codCom;
	private String libCom;
	
	public Commune() {
		
		// TODO Auto-generated constructor stub
	}
		
	@ManyToOne(targetEntity = ZoneSanitaire.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idZS", referencedColumnName = "idZS", nullable = false, updatable = true, insertable = true)
	private ZoneSanitaire ZS;

		public Commune(String codCom, String libCom, ZoneSanitaire ZS) {
		super();
		this.codCom = codCom;
		this.libCom = libCom;
		this.ZS = ZS;
	}
	
	
	public Long getIdCom() {
		return idCom;
	}
	public void setIdCom(Long idCom) {
		this.idCom = idCom;
	}
	
	public String getCodCom() {
		return codCom;
	}
	
	public void setCodCom(String codCom) {
		this.codCom = codCom;
	}
	
	public String getLibCom() {
		return libCom;
	}
	
	public void setLibCom(String libCom) {
		this.libCom = libCom;
	}
	public void setZS(ZoneSanitaire ZS) {
		this.ZS = ZS;
	}
	public ZoneSanitaire getZS() {
		return ZS;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ZS == null) ? 0 : ZS.hashCode());
		result = prime * result + ((codCom == null) ? 0 : codCom.hashCode());
		result = prime * result + ((idCom == null) ? 0 : idCom.hashCode());
		result = prime * result + ((libCom == null) ? 0 : libCom.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commune other = (Commune) obj;
		if (ZS == null) {
			if (other.ZS != null)
				return false;
		} else if (!ZS.equals(other.ZS))
			return false;
		if (codCom == null) {
			if (other.codCom != null)
				return false;
		} else if (!codCom.equals(other.codCom))
			return false;
		if (idCom == null) {
			if (other.idCom != null)
				return false;
		} else if (!idCom.equals(other.idCom))
			return false;
		if (libCom == null) {
			if (other.libCom != null)
				return false;
		} else if (!libCom.equals(other.libCom))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ZoneSanitaire [idCom=" + idCom + ", codCom=" + codCom + ", libCom=" + libCom +", dDs= " +ZS+ "]";
	}	
	
	public String element() {
		return idCom + "; " +codCom  + "; " +  libCom + "; " + ZS.getlibZS();
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
	
}
