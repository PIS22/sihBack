package sih.compta.entities;

import javax.persistence.*;

import sih.general.entities.Exercice;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
public class CompteBudget implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idLigBdg;
    private double proposition;
    private double vote;
    private double accord;
    private double realisation;
    private double engagement;
    @ManyToOne(targetEntity = TypeBudget.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idTypBdg", referencedColumnName = "idTypBdg")
    private TypeBudget typBdg;
    @ManyToOne(targetEntity = Compte.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCpte", referencedColumnName = "idCpte")
    private Compte cpte;
    @ManyToOne(targetEntity = Exercice.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "codExo", referencedColumnName = "codExo")
    private Exercice exo;

    public CompteBudget() {
    }


    public CompteBudget(Long idLigBdg, double proposition, double vote, double accord, double realisation,
			double engagement, TypeBudget typBdg, Compte cpte, Exercice exo) {
		super();
		this.idLigBdg = idLigBdg;
		this.proposition = proposition;
		this.vote = vote;
		this.accord = accord;
		this.realisation = realisation;
		this.engagement = engagement;
		this.typBdg = typBdg;
		this.cpte = cpte;
		this.exo = exo;
	}


	public Long getIdLigBdg() {
        return idLigBdg;
    }

    public void setIdLigBdg(Long idLigBdg) {
        this.idLigBdg = idLigBdg;
    }

    public double getProposition() {
        return proposition;
    }

    public void setProposition(double propositionMaire) {
        proposition = propositionMaire;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double voteCoseil) {
        this.vote = voteCoseil;
    }

    public double getAccord() {
        return accord;
    }

    public void setAccord(double accord) {
        this.accord = accord;
    }

    public double getRealisation() {
        return realisation;
    }

    public void setRealisation(double realisation) {
        this.realisation = realisation;
    }

    public double getEngagement() {
        return engagement;
    }

    public void setEngagement(double engagement) {
        this.engagement = engagement;
    }

    public TypeBudget getTypBdg() {
        return typBdg;
    }

    public void setTypBdg(TypeBudget typBdg) {
        this.typBdg = typBdg;
    }

    public Compte getCpte() {
        return cpte;
    }

    public void setCpte(Compte cpte) {
        this.cpte = cpte;
    }

    public Exercice getExo() {
        return exo;
    }

    public void setExo(Exercice exo) {
        this.exo = exo;
    }

    @Override
    public String toString() {
        return "LigneBudgetaire{" +
                "idLigBdg=" + idLigBdg +
                ", Proposition=" + proposition +
                ", voteCoseil=" + vote +
                ", accord=" + accord +
                ", realisation=" + realisation +
                ", engagement=" + engagement +
                ", typBdg=" + typBdg +
                ", cpte=" + cpte +
                ", exo=" + exo +
                '}';
    }

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}

}
