package sih.compta.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class  Localisation implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idLoc;
	@Column(unique = true)
	private String codLoc;
	private String libLoc;
	public Localisation() {
		// TODO Auto-generated constructor stub
	}

	public Localisation(Long idLoc, String codLoc, String libLoc) {
		super();
		this.idLoc = idLoc;
		this.codLoc = codLoc;
		this.libLoc = libLoc;
	}

	public Long getIdLoc() {
		return idLoc;
	}

	public void setIdLoc(Long idLoc) {
		this.idLoc = idLoc;
	}

	public String getCodLoc() {
		return codLoc;
	}

	public void setCodLoc(String codLoc) {
		this.codLoc = codLoc;
	}

	public String getLibLoc() {
		return libLoc;
	}

	public void setLibLoc(String libLoc) {
		this.libLoc = libLoc;
	}

	@Override
	public String toString() {
		return "Localisation [idLoc=" + idLoc + ", codLoc=" + codLoc + ", libLoc=" + libLoc  + "]";
	}

	public String element() {
		return idLoc + "; " + codLoc + "; " + libLoc;
	}	

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
	
}
