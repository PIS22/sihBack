package sih.general.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@SuppressWarnings("serial")
@Entity
@AllArgsConstructor @NoArgsConstructor @Data @ EqualsAndHashCode @ToString
public class Site implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSit;
	private String libSit;
	private String adresse;
	private String tel;
	private String dCreat;
	
	public Long getIdSit() {
		return idSit;
	}

	public void setIdSit(Long idSit) {
		this.idSit = idSit;
	}

	public String getLibSit() {
		return libSit;
	}

	public void setLibSit(String libSit) {
		this.libSit = libSit;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getdCreat() {
		return dCreat;
	}

	public void setdCreat(String dCreat) {
		this.dCreat = dCreat;
	}

	/*private String element() {
		return String.valueOf(idSit)+"; "+libSit+"; "+adresse+"; "+tel+"; "+dCreat;
	}*/

}
