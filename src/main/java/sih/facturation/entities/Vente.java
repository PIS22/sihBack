package sih.facturation.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sih.general.entities.Exercice;
import sih.securite.config.Audit;
//import sih.stoc.entities.Client;
import sih.stoc.entities.Client;

@EnableJpaAuditing
@SuppressWarnings("serial")
@Entity
public class Vente extends Audit<String> implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idVente;
	private LocalDateTime dateVente;
	private int ordre;
	@ManyToOne(targetEntity = Client.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "idClient", referencedColumnName = "idCli", nullable = true, updatable = true, insertable = true)
	private Client Cli;//
	
	@ManyToOne(targetEntity = Caisse.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Caisse caisse;//
	
	@ManyToOne(targetEntity = ModePaiement.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private ModePaiement mopai;//
	
	private String Obs;
	private boolean valide;
	private boolean cloture;
	
	@ManyToOne(targetEntity = Exercice.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Exercice exo;//
	
	public Vente() {
		// TODO Auto-generated constructor stub
	}

	public Vente(LocalDateTime dateVente, Client cli, Caisse caisse, ModePaiement mopai, String obs, boolean valide,
			boolean cloture, Exercice exo) {
		super();
		this.dateVente = dateVente;
		Cli = cli;
		this.caisse = caisse;
		this.mopai = mopai;
		Obs = obs;
		this.valide = valide;
		this.cloture = cloture;
		this.exo = exo;
	}

	public String getIdVente() {
		return idVente;
	}

	public void setIdVente(String idVente) {
		this.idVente = idVente;
	}

	public LocalDateTime getDateVente() {
		return dateVente;
	}

	public void setDateVente(LocalDateTime dateVente) {
		this.dateVente = dateVente;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public Client getCli() {
		return Cli;
	}

	public void setCli(Client cli) {
		Cli = cli;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public ModePaiement getMopai() {
		return mopai;
	}

	public void setMopai(ModePaiement mopai) {
		this.mopai = mopai;
	}

	public String getObs() {
		return Obs;
	}

	public void setObs(String obs) {
		Obs = obs;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public boolean isCloture() {
		return cloture;
	}

	public void setCloture(boolean cloture) {
		this.cloture = cloture;
	}

	public Exercice getExo() {
		return exo;
	}

	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	@Override
	public String toString() {
		return "Vente [idVente=" + idVente + ", dateVente=" + dateVente + ", ordre=" + ordre + ", Cli=" + Cli
				+ ", caisse=" + caisse + ", mopai=" + mopai + ", Obs=" + Obs + ", valide=" + valide + ", cloture="
				+ cloture + ", exo=" + exo + "]";
	}
	
	/*@ManyToOne(targetEntity = Caisse.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Caisse caisse;//
	
	@ManyToOne(targetEntity = Caisse.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Caisse caisse;//*/

}


