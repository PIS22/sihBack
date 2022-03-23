package sih.facturation.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import sih.general.entities.Exercice;
import sih.securite.config.Audit;

@Entity
public class OperationCaisse extends Audit<String> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3037682167677070694L;
	@Id
	private String numOp;
	private int ordre;
	private LocalDateTime datOp;
	private String typeOp;
	private String libOp;
	@ManyToOne(targetEntity = Caisse.class)
	private Caisse caisse;
	@ManyToOne(cascade = {CascadeType.DETACH}, targetEntity = ModePaiement.class)
	private ModePaiement modep;
	private String obsOp;
	@ManyToOne(targetEntity = Exercice.class)
	private Exercice exo;
	
	public OperationCaisse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperationCaisse(LocalDateTime datOp, String typeOp, String libOp, Caisse caisse, ModePaiement modep,
			String obsOp, Exercice exo) {
		super();
		this.datOp = datOp;
		this.typeOp = typeOp;
		this.libOp = libOp;
		this.caisse = caisse;
		this.modep = modep;
		this.obsOp = obsOp;
		this.exo = exo;
	}

	public String getNumOp() {
		return numOp;
	}

	public void setNumOp(String numOp) {
		this.numOp = numOp;
	}

	public int getOrdre() {
		return ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	public LocalDateTime getDatOp() {
		return datOp;
	}

	public void setDatOp(LocalDateTime datOp) {
		this.datOp = datOp;
	}

	public String getTypeOp() {
		return typeOp;
	}

	public void setTypeOp(String typeOp) {
		this.typeOp = typeOp;
	}

	public String getLibOp() {
		return libOp;
	}

	public void setLibOp(String libOp) {
		this.libOp = libOp;
	}

	public Caisse getCaisse() {
		return caisse;
	}

	public void setCaisse(Caisse caisse) {
		this.caisse = caisse;
	}

	public ModePaiement getModep() {
		return modep;
	}

	public void setModep(ModePaiement modep) {
		this.modep = modep;
	}

	public String getObsOp() {
		return obsOp;
	}

	public void setObsOp(String obsOp) {
		this.obsOp = obsOp;
	}

	public Exercice getExo() {
		return exo;
	}

	public void setExo(Exercice exo) {
		this.exo = exo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OperationCaisse [numOp=" + numOp + ", ordre=" + ordre + ", datOp=" + datOp + ", typeOp=" + typeOp
				+ ", libOp=" + libOp + ", caisse=" + caisse + ", modep=" + modep + ", obsOp=" + obsOp + ", exo=" + exo
				+ "]";
	}
	
	

}
