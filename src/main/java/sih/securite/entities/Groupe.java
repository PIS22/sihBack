package sih.securite.entities;

import java.lang.reflect.Field;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
////Il est question des groupes utilisateurs Le groupe patient ou utilisateur sera créé par défaut ainsi que le groupe admin
///Le groupe patient étant celui le plus accessible à tous
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idGpe;
	@Column(unique = true, nullable = false, length = 10)
	private String libGpe;
	private String desGpe; //Description du groupe
	/*@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "GroupDomaine")
	private Set<Domaine> domaines=new ArrayList<>();*/
	
	public Groupe() {
		// TODO Auto-generated constructor stub
	}

	public Groupe(String libGpe, String desGpe) {
		this.libGpe = libGpe;
		this.desGpe = desGpe;
	//	this.domaines = domaines;
	}

	public int getIdGpe() {
		return idGpe;
	}

	public void setIdGpe(int idGpe) {
		this.idGpe = idGpe;
	}

	public String getLibGpe() {
		return libGpe;
	}

	public void setLibGpe(String libGpe) {
		this.libGpe = libGpe;
	}

	public String getdesGpe() {
		return desGpe;
	}

	public void setdesGpe(String desGpe) {
		this.desGpe = desGpe;
	}

	/*public List<Domaine> getDomaines() {
		return domaines;
	}

	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}*/

	@Override
	public String toString() {
		return "Groupe [idGpe=" + idGpe + ", libGpe=" + libGpe + ", desGpe=" + desGpe + "]";
	}

	public String[] structure(){
		String[] ch= {};
		for(Field f: this.getClass().getFields()) {
			ch[ch.length]=f.getName();
		}
		return ch;
	}
	
	public String element() {
		return idGpe + "; " + libGpe + "; " + desGpe;
	}


}
