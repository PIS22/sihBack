package sih.securite.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Disposer {
	@Id
	@GeneratedValue
	private Long idDis;	
	private boolean ajout;
	private boolean modif;
	private boolean supp;
	@ManyToOne(targetEntity = Groupe.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idGpe", referencedColumnName = "idGpe", nullable = false, updatable = true, insertable = true)
	private Groupe grpe;
	@ManyToOne(targetEntity = Objet.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "obj", referencedColumnName = "libObj", nullable = false, updatable = true, insertable = true)
	private Objet obj;

	public Disposer() {
		
	}

	public Disposer(boolean ajout, boolean modif, boolean supp, Groupe grpe, Objet obj) {
		super();
		this.ajout = ajout;
		this.modif = modif;
		this.supp = supp;
		this.grpe = grpe;
		this.obj = obj;
	}

	public Long getIdDis() {
		return idDis;
	}

	public void setIdDis(Long idDis) {
		this.idDis = idDis;
	}

	public boolean isAjout() {
		return ajout;
	}

	public void setAjout(boolean ajout) {
		this.ajout = ajout;
	}

	public boolean isModif() {
		return modif;
	}

	public void setModif(boolean modif) {
		this.modif = modif;
	}

	public boolean isSupp() {
		return supp;
	}

	public void setSupp(boolean supp) {
		this.supp = supp;
	}

	public Groupe getGrpe() {
		return grpe;
	}

	public void setGrpe(Groupe grpe) {
		this.grpe = grpe;
	}

	public Objet getObj() {
		return obj;
	}

	public void setObj(Objet obj) {
		this.obj = obj;
	}
	
	public String elemennt() {
		return getIdDis()+";"+isAjout()+";"+isModif()+";"+isSupp()+";"+getGrpe().getLibGpe()+";"+getObj().getLibObj();
	}

	
}
