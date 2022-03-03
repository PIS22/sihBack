package sih.securite.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
///La relation utilisateur groupe
public class UserGroup implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idUsGpe;
	private Date deb;
	private Date fin;
	@ManyToOne
	private Utilisateur user;
	@ManyToOne
	private Groupe group;

	public UserGroup() {
		// TODO Auto-generated constructor stub
	}

	public UserGroup(Date deb, Date fin, Utilisateur user, Groupe group) {
		super();
		this.deb = deb;
		this.fin = fin;
		this.user = user;
		this.group = group;
	}

	public Long getIdUsGpe() {
		return idUsGpe;
	}

	public void setIdUsGpe(Long idUsGpe) {
		this.idUsGpe = idUsGpe;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Groupe getGroup() {
		return group;
	}

	public void setGroup(Groupe group) {
		this.group = group;
	}

	public Date getDeb() {
		return deb;
	}

	public void setDeb(Date deb) {
		this.deb = deb;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "UserGroup [idUsGpe=" + idUsGpe + ", deb=" + deb + ", fin=" + fin + ", user=" + user + ", group=" + group
				+ "]";
	}

	public String element() {
		return  idUsGpe + ";" + deb + ";" + fin + ";" + user.getIdUser() +" "+user.getLogin()+ ";" + group.getIdGpe()+
				" "+group.getLibGpe();
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}

}
