package sih.stoc.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ReceptionDet implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String idDet;
	private double qteLiv;
	private LocalDate exp;
	private double pu;
	private String observation;
	@ManyToOne(targetEntity = Reception.class)
	private Reception recep;
	private CommandeDet detCom;
	
	public ReceptionDet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceptionDet(String idDet, double qteLiv, LocalDate exp, double pu, String observation, Reception recep,
			CommandeDet detCom) {
		super();
		this.idDet = idDet;
		this.qteLiv = qteLiv;
		this.exp = exp;
		this.pu = pu;
		this.observation = observation;
		this.recep = recep;
		this.detCom = detCom;
	}

	public String getIdDet() {
		return idDet;
	}

	public void setIdDet(String idDet) {
		this.idDet = idDet;
	}

	public double getQteLiv() {
		return qteLiv;
	}

	public void setQteLiv(double qteLiv) {
		this.qteLiv = qteLiv;
	}

	public LocalDate getExp() {
		return exp;
	}

	public void setExp(LocalDate exp) {
		this.exp = exp;
	}

	public double getPu() {
		return pu;
	}

	public void setPu(double pu) {
		this.pu = pu;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Reception getRecep() {
		return recep;
	}

	public void setRecep(Reception recep) {
		this.recep = recep;
	}

	public CommandeDet getDetCom() {
		return detCom;
	}

	public void setDetCom(CommandeDet detCom) {
		this.detCom = detCom;
	}

	@Override
	public String toString() {
		return "ReceptionDet [idDet=" + idDet + ", qteLiv=" + qteLiv + ", exp=" + exp + ", pu=" + pu + ", observation="
				+ observation + ", recep=" + recep + ", detCom=" + detCom + "]";
	}

}
