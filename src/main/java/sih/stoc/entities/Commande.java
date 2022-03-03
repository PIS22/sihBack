package sih.stoc.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sih.general.entities.Exercice;
import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity
@EnableJpaAuditing
public class Commande extends Audit<String> implements Serializable {
	@Id
	private String numCom;
	private Date datCom;
	private int delLiv;
	private boolean valide;
	private boolean active;
	private int ordre;
	@ManyToOne(targetEntity = Fournisseur.class)
	@JoinColumn(referencedColumnName = "codFour", nullable = false)
	private Fournisseur frs;
	@ManyToOne(targetEntity = Exercice.class)
	@JoinColumn(nullable = false, referencedColumnName = "codExo")
	private Exercice exo;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Date datCom, int delLiv, boolean valide, boolean active, Fournisseur frs, Exercice exo) {
		super();
		this.datCom = datCom;
		this.delLiv = delLiv;
		this.valide = valide;
		this.active = active;
		this.frs = frs;
		this.exo = exo;
	}

	public String getNumCom() {
		return numCom;
	}

	public void setNumCom(String numCom) {
		this.numCom = numCom;
	}

	public Date getDatCom() {
		return datCom;
	}

	public void setDatCom(Date datCom) {
		this.datCom = datCom;
	}

	public int getDelLiv() {
		return delLiv;
	}

	public void setDelLiv(int delLiv) {
		this.delLiv = delLiv;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Fournisseur getFrs() {
		return frs;
	}

	public void setFrs(Fournisseur frs) {
		this.frs = frs;
	}

	public Exercice getExo() {
		return exo;
	}

	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	@Override
	public String toString() {
		return "Commande [numCom=" + numCom + ", datCom=" + datCom + ", delLiv=" + delLiv + ", valide=" + valide
				+ ", active=" + active + ", ordre=" + ordre + ", frs=" + frs + ", exo=" + exo + "]";
	}

}
