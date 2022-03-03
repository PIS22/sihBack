package sih.securite.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity 
@Data @NoArgsConstructor @AllArgsConstructor
public class Domaine implements Serializable{
	@Id
	private String nomDom;
	//@LazyCollection
	@ManyToMany(targetEntity = Objet.class, fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "DomaineObjet")
	
	private List<Objet> entites=new ArrayList<>();
	public Domaine() {
		// TODO Auto-generated constructor stub
	}

	public Domaine(String nomDom, List<Objet> entites) {
		super();
		this.nomDom = nomDom;
		this.entites = entites;
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
	
	@Override
	public String toString() {
		return "Domaine [nomDom=" + nomDom + ", entites=" + entites + "]";
	}
	

}
