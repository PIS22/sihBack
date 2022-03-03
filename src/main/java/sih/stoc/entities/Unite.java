package sih.stoc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity
public class Unite extends Audit<String> implements Serializable {
	@Id
	@Column(nullable = false, unique = true, updatable = true)
	private String codUnit;
	@Column(nullable = false)
	private String libUnit;
	
	public Unite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Unite(String codUnit, String libUnit) {
		super();
		this.codUnit = codUnit;
		this.libUnit = libUnit;
	}

	public String getCodUnit() {
		return codUnit;
	}

	public void setCodUnit(String codUnit) {
		this.codUnit = codUnit;
	}

	public String getLibUnit() {
		return libUnit;
	}

	public void setLibUnit(String libUnit) {
		this.libUnit = libUnit;
	}
	
	public String //List<String> 
	element(){
		List<String> chps= new ArrayList<String>();
		chps.add(getCodUnit());
		chps.add(getLibUnit());
		return "chps";
	}


}
