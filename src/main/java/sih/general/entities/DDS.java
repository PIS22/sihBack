package sih.general.entities;

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
public class DDS implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long iddds;
@Column(unique = true, nullable = false, length = 10)
private String codDds;
@Column(unique = true, nullable = false)
private String libDds;
	
	public DDS() {
		// TODO Auto-generated constructor stub
	}

	public DDS(String codDds, String libDds) {
		super();
		this.codDds = codDds;
		this.libDds = libDds;
	}

	public Long getIddds() {
		return iddds;
	}

	public void setIddds(Long iddds) {
		this.iddds = iddds;
	}

	public String getCodDds() {
		return codDds;
	}

	public void setCodDds(String codDds) {
		this.codDds = codDds;
	}

	public String getLibDds() {
		return libDds;
	}

	public void setLibDds(String libDds) {
		this.libDds = libDds;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codDds == null) ? 0 : codDds.hashCode());
		result = prime * result + ((iddds == null) ? 0 : iddds.hashCode());
		result = prime * result + ((libDds == null) ? 0 : libDds.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DDS other = (DDS) obj;
		if (codDds == null) {
			if (other.codDds != null)
				return false;
		} else if (!codDds.equals(other.codDds))
			return false;
		if (iddds == null) {
			if (other.iddds != null)
				return false;
		} else if (!iddds.equals(other.iddds))
			return false;
		if (libDds == null) {
			if (other.libDds != null)
				return false;
		} else if (!libDds.equals(other.libDds))
			return false;
		return true;
	}

	public String element() {
		return "DDS(" + iddds + "; " + codDds + "; " + libDds + ")";
	}

	@Override
	public String toString() {
		return "DDS [iddds=" + iddds + ", codDds=" + codDds + ", libDds=" + libDds + "]";
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
	
}
