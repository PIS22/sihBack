package sih.compta.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class TypeAmort implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTypAmo;
	private String codeTypAmor;
	private String libTypAmo;
	
	public TypeAmort() {
		// TODO Auto-generated constructor stub
	}

	public TypeAmort(Long idTypAmo, String codeTypAmor, String libTypAmo) {
		super();
		this.idTypAmo = idTypAmo;
		this.codeTypAmor = codeTypAmor;
		this.libTypAmo = libTypAmo;
	}

	public Long getIdTypAmo() {
		return idTypAmo;
	}

	public void setIdTypAmo(Long idTypAmo) {
		this.idTypAmo = idTypAmo;
	}

	public String getCodeTypAmor() {
		return codeTypAmor;
	}

	public void setCodeTypAmor(String codeTypAmor) {
		this.codeTypAmor = codeTypAmor;
	}

	public String getLibTypAmo() {
		return libTypAmo;
	}

	public void setLibTypAmo(String libTypAmo) {
		this.libTypAmo = libTypAmo;
	}

	@Override
	public String toString() {
		return "TypeAmort{" +
				"idTypAmo=" + idTypAmo +
				", codeTypAmor='" + codeTypAmor + '\'' +
				", libTypAmo='" + libTypAmo + '\'' +
				'}';
	}

	public String element() {
		return idTypAmo +"; " + codeTypAmor + "; " + libTypAmo;
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}

}
