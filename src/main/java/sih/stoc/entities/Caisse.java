package sih.stoc.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode @ToString
@EnableJpaAuditing(modifyOnCreate = true, setDates = true)
public class Caisse extends Audit<String> implements Serializable {
	@Id
	@Column(updatable = true)
	private String codCai;
	private String libCai;
	
	public String getCodCai() {
		return codCai;
	}
	public void setCodCai(String codCai) {
		this.codCai = codCai;
	}
	public String getLibCai() {
		return libCai;
	}
	public void setLibCai(String libCai) {
		this.libCai = libCai;
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}
	
}
