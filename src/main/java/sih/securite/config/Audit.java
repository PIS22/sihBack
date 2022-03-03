package sih.securite.config;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
public abstract class Audit<U> {
	
	@CreatedDate
	protected LocalDateTime creeLe;
	@CreatedBy
	protected String createur;
	
	@LastModifiedDate
	protected LocalDateTime modifieLe;
	@LastModifiedBy
	protected String editeur;
	public LocalDateTime getCreeLe() {
		return creeLe;
	}
	public void setCreeLe(LocalDateTime creeLe) {
		this.creeLe = creeLe;
	}
	public String getCreateur() {
		return createur;
	}
	public void setCreateur(String createur) {
		this.createur = createur;
	}
	public LocalDateTime getModifieLe() {
		return modifieLe;
	}
	public void setModifieLe(LocalDateTime modifieLe) {
		this.modifieLe = modifieLe;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	
	
	
	
}
