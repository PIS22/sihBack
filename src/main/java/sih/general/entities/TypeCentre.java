package sih.general.entities;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

@SuppressWarnings("serial")
@Entity
public class TypeCentre extends Audit<Utilisateur> implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTypeCentre;
	@Column(unique = true,nullable = false)
	private String codTypeCentre;
	private String libTypeCentre;
	
	public TypeCentre() {
		// TODO Auto-generated constructor stub
	}
	
	public TypeCentre(String codTypeCentre, String libTypeCentre) {
		super();
		this.codTypeCentre = codTypeCentre;
		this.libTypeCentre = libTypeCentre;
	}
	
	public void setCodTypeCentre(String codTypeCentre) {
		this.codTypeCentre = codTypeCentre;
	}
	public void setIdTypeCentre(Long idTypeCentre) {
		this.idTypeCentre = idTypeCentre;
	}
	public void setLibTypeCentre(String libTypeCentre) {
		this.libTypeCentre = libTypeCentre;
	}
	public String getCodTypeCentre() {
		return codTypeCentre;
	}
	public Long getIdTypeCentre() {
		return idTypeCentre;
	}
	public String getLibTypeCentre() {
		return libTypeCentre;
	}
	
	@Override
	public String toString() {
		return "TypeCentre [idTypeCentre=" + idTypeCentre + ", codTypeCentre=" + codTypeCentre + ", libTypeCentre=" + libTypeCentre + "]";
	}

	public String element() {
		
		return idTypeCentre+";"+codTypeCentre +";"+ libTypeCentre ;
	}	
	

	//public String element () {
		
		
//	}
		
}


