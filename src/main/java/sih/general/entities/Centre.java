package sih.general.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

@SuppressWarnings("serial")
@Entity
public class Centre extends Audit<Utilisateur> implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCentre;
	@Column(unique = true,nullable = false)
	private String codCentre;
	private String libCentre;
	
	public Centre() {
		// TODO Auto-generated constructor stub
	}
	

	@ManyToOne(targetEntity = Commune.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCom", referencedColumnName = "idCom", nullable = false, updatable = true, insertable = true)
	private Commune com;
	
	@ManyToOne(targetEntity = TypeCentre.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idtypeCentre", referencedColumnName = "idtypeCentre", nullable = false, updatable = true, insertable = true)
	private TypeCentre typeCentre;
	
	public Centre(String codCentre, String libCentre, Commune com, TypeCentre typeCentre) {
		super();
		this.codCentre = codCentre;
		this.libCentre = libCentre;
		this.com = com;
		this.typeCentre = typeCentre;
	}
	
	
	public void setIdCentre(Long idCentre) {
		this.idCentre = idCentre;
	}
	public Long getIdCentre() {
		return idCentre;
	}
	public void setCodCentre(String codCentre) {
		this.codCentre = codCentre;
	}
	public String getCodCentre() {
		return codCentre;
	}
	public void setLibCentre(String libCentre) {
		this.libCentre = libCentre;
	}
	public String getLibCentre() {
		return libCentre;
	}
	
	public void setCom(Commune com) {
		this.com = com;
	}
	public Commune getCom() {
		return com;
	}
	public void setTypeCentre(TypeCentre typeCentre) {
		this.typeCentre = typeCentre;
	}
	public TypeCentre getTypeCentre() {
		return typeCentre;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Centre [idCentre=" + idCentre + ", codCentre=" + codCentre + ", libCentre=" + libCentre + ", Com = "+com+", typeCentre = "+typeCentre+"]";
	}
	
	public String element() {
	return idCentre + "; " + codCentre + "; " + libCentre + "; " + com.getLibCom()+";"+typeCentre.getLibTypeCentre();
}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
		
}


