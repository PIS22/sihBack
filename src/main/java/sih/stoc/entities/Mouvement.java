package sih.stoc.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.general.entities.Exercice;
import sih.securite.config.Audit;

@Entity
public class Mouvement extends Audit<String> implements Serializable {

	private static final long serialVersionUID = 2998917017406461951L;
	@Id
	private String numMvt;
	private LocalDateTime datMvt;
	private String typMvt;
	private String sensMvt;
	private String obsMvt;
	private int ordre;
	@ManyToOne(targetEntity = Exercice.class)
	private Exercice exo;
	@ManyToOne(targetEntity = Commande.class)
	@JoinColumn(referencedColumnName = "numCom", name = "commande", nullable = true )
	private Commande com;
	/*@ManyToOne(targetEntity = Commande.class)
	@JoinColumn(referencedColumnName = "numCom", name = "commande", nullable = true )
	private Commande com;
	@ManyToOne(targetEntity = Commande.class)
	@JoinColumn(referencedColumnName = "numCom", name = "commande", nullable = true )
	private Commande com;*/
	
	public Mouvement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mouvement(LocalDateTime datMvt, String typMvt, String sensMvt, String obsMvt, Exercice exo) {
		super();
		this.datMvt = datMvt;
		this.typMvt = typMvt;
		this.sensMvt = sensMvt;
		this.obsMvt = obsMvt;
		this.exo = exo;
	}

	public String getNumMvt() {
		return numMvt;
	}

	public void setNumMvt(String numMvt) {
		this.numMvt = numMvt;
	}

	public LocalDateTime getDatMvt() {
		return datMvt;
	}

	public void setDatMvt(LocalDateTime datMvt) {
		this.datMvt = datMvt;
	}

	public String getTypMvt() {
		return typMvt;
	}

	public void setTypMvt(String typMvt) {
		this.typMvt = typMvt;
	}

	public String getSensMvt() {
		return sensMvt;
	}

	public void setSensMvt(String sensMvt) {
		this.sensMvt = sensMvt;
	}

	public String getObsMvt() {
		return obsMvt;
	}

	public void setObsMvt(String obsMvt) {
		this.obsMvt = obsMvt;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Exercice getExo() {
		return exo;
	}

	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	public Commande getCom() {
		return com;
	}

	public void setCom(Commande com) {
		this.com = com;
	}

}
