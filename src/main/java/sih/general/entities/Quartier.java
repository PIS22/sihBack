package sih.general.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Quartier extends Audit<Utilisateur> implements Serializable {
    
    @Id
    private String id;
    private String description;
    private double superficie;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSave;
    private int nombreHabitant;
    @ManyToOne
    private Arrondissement arrondissement;
    @Transient
    private String idUser;
    private String nameClasse;

    public String getNameClasse() {
        return nameClasse;
    }

    public void setNameClasse(String nameClasse) {
        this.nameClasse = nameClasse;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public Date getDateSave() {
        return dateSave;
    }

    public void setDateSave(Date dateSave) {
        this.dateSave = dateSave;
    }

    public int getNombreHabitant() {
        return nombreHabitant;
    }

    public void setNombreHabitant(int nombreHabitant) {
        this.nombreHabitant = nombreHabitant;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quartier)) {
            return false;
        }
        Quartier other = (Quartier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quartier[ id=" + id + " ]";
    }
    
}
