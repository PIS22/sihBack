package sih.securite.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
/*/ Il s'agit ici d'une table dans laquelle seront repertoriées toutes les table de la base de donnée, 
 * aux fin de déterminer quel est la marge de maneouvre de chaque groupe utilisateur par rapport à chacune d'elles*/
public class Objet implements Serializable {
	@Id
	private String libObj;
	
	private String chps;
	
	public Objet() {
		// TODO Auto-generated constructor stub
	}

	public Objet(String libObj, String chps) {
		super();
		this.libObj = libObj;
		this.chps= chps;
	}

	@Override
	public String toString() {
		return "Objet [libObj=" + libObj + "]";
		
	}

	public String getLibObj() {
		return libObj;
	}

	public void setLibObj(String libObj) {
		this.libObj = libObj;
	}

	public String getChps() {
		return chps;
	}

	public void setChps(String chps) {
		this.chps = chps;
	}

	public String structure(){
		return "codExo; libExo; debExo; finExo; etaExo";
	}
}
