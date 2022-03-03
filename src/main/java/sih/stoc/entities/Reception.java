package sih.stoc.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.general.entities.Exercice;

@Entity
public class Reception {

	@Id
	private String numRecep;
	private LocalDateTime datRecep;
	private String obsRecept;
	private int ordre;
	@ManyToOne(targetEntity = Commande.class)
	@JoinColumn(referencedColumnName = "numCom", name = "commande" )
	private Commande com;
	@ManyToOne(targetEntity = Exercice.class)
	@JoinColumn(name = "exo", referencedColumnName = "codExo")
	private Exercice exo;
	
	public Reception() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reception(LocalDateTime datRecep, String obsRecept, Commande com, Exercice exo) {
		super();
		this.datRecep = datRecep;
		this.obsRecept = obsRecept;
		this.com = com;
		this.exo = exo;
	}

	public String getNumRecep() {
		return numRecep;
	}

	public void setNumRecep(String numRecep) {
		this.numRecep = numRecep;
	}

	public LocalDateTime getDatRecep() {
		return datRecep;
	}

	public void setDatRecep(LocalDateTime datRecep) {
		this.datRecep = datRecep;
	}

	public String getObsRecept() {
		return obsRecept;
	}

	public void setObsRecept(String obsRecept) {
		this.obsRecept = obsRecept;
	}

	public Commande getCom() {
		return com;
	}

	public void setCom(Commande com) {
		this.com = com;
	}

	public Exercice getExo() {
		return exo;
	}

	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	@Override
	public String toString() {
		return "Reception [numRecep=" + numRecep + ", datRecep=" + datRecep + ", obsRecept=" + obsRecept + ", ordre="
				+ ordre + ", com=" + com + ", exo=" + exo + "]";
	}
	
}
