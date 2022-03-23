
package sih.general.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import sih.securite.config.Audit;
import sih.securite.entities.Utilisateur;

@SuppressWarnings("serial")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Arrondissement extends Audit<Utilisateur> implements Serializable {

    @OneToMany(mappedBy = "arrondissement")
    private List<Quartier> quartiers;
   
    @Id
    private String id;
    private int code;
    private String nom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateSave;
    @ManyToOne
    private Commune commune;
    @Transient
    private String idUser;
    
	public List<Quartier> getQuartiers() {
		return quartiers;
	}

	public void setQuartiers(List<Quartier> quartiers) {
		this.quartiers = quartiers;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateSave() {
		return dateSave;
	}

	public void setDateSave(Date dateSave) {
		this.dateSave = dateSave;
	}

	public Commune getCommune() {
		return commune;
	}

	public void setCommune(Commune commune) {
		this.commune = commune;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((commune == null) ? 0 : commune.hashCode());
		result = prime * result + ((dateSave == null) ? 0 : dateSave.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((quartiers == null) ? 0 : quartiers.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arrondissement other = (Arrondissement) obj;
		if (code != other.code)
			return false;
		if (commune == null) {
			if (other.commune != null)
				return false;
		} else if (!commune.equals(other.commune))
			return false;
		if (dateSave == null) {
			if (other.dateSave != null)
				return false;
		} else if (!dateSave.equals(other.dateSave))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (quartiers == null) {
			if (other.quartiers != null)
				return false;
		} else if (!quartiers.equals(other.quartiers))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Arrondissement [quartiers=" + quartiers + ", id=" + id + ", code=" + code + ", nom=" + nom
				+ ", dateSave=" + dateSave + ", commune=" + commune + ", idUser=" + idUser + "]";
	}
}
