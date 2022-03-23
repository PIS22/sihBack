package sih.compta.entities;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sih.facturation.entities.Caisse;

@Entity
public class CompteCaisse {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComCas;

	private Date debComCas;
	
	private Date finComCas;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Compte.class)
	@JoinColumn(name="idCpte", referencedColumnName = "idCpte", nullable = false)
	private Compte compte;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Caisse.class)
	//@JoinColumn(name="codeCaisse", referencedColumnName = "codeCaisse", nullable = false)
	private Caisse caisse;

	public CompteCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCaisse(Long idComCas, Date debComCas, Date finComCas, Compte compte,
			Caisse caisse) {
		super();
		this.idComCas = idComCas;
		this.debComCas = debComCas;
		this.finComCas = finComCas;
		this.compte = compte;
		this.caisse = caisse;
	}

	public Long getIdComCas() {
		return idComCas;
	}

	public void setIdComCas(Long idComCas) {
		this.idComCas = idComCas;
	}

	public Date getdebComCas() {
		return debComCas;
	}

	public void setdebComCas(Date debComCas) {
		this.debComCas = debComCas;
	}

	public Date getfinComCas() {
		return finComCas;
	}

	public void setfinComCas(Date finComCas) {
		this.finComCas = finComCas;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	@Override
	public String toString() {
		return "AffectComptToCaisse [idComCas=" + idComCas + ", debComCas=" + debComCas
				+ ", finComCas=" + finComCas + ", compte=" + compte + ", caisse=" + caisse + "]";
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}

	public String element() {
		return idComCas + "; " + debComCas
				+ "; " + finComCas + "; " + compte + "; " + caisse ;
	}
	
	

}
