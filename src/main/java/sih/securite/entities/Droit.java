package sih.securite.entities;

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
public class Droit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idDrt;
	@Column(unique = true, nullable = false, length = 10)
	private String LibDrt;
	
	public Droit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Droit(String libDrt) {
		super();
		LibDrt = libDrt;
	}

	public Long getIdDrt() {
		return idDrt;
	}

	public void setIdDrt(Long idDrt) {
		this.idDrt = idDrt;
	}

	public String getLibDrt() {
		return LibDrt;
	}

	public void setLibDrt(String libDrt) {
		LibDrt = libDrt;
	}

	public String element() {
		return "Droit( " + idDrt + "; " + LibDrt + ")";
	}

	@Override
	public String toString() {
		return idDrt + ", LibDrt=" + LibDrt;
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
	
}
