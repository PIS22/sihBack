package sih.facturation.entities;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "ModePaiement")
public class ModePaiement implements Serializable {
	@Id
	@Column(name = "codeModPay", length = 2)
	@PrimaryKeyJoinColumn(name = "ModPay_PK")
	private String codeModPay;
	@Column(name="libeModPay",nullable = false, length = 30, unique = true, updatable = true)
	private String libeModPay;
	
	public ModePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModePaiement(String codeModPay, String libeModPay) {
		super();
		this.codeModPay = codeModPay;
		this.libeModPay = libeModPay;
	}

	public String getCodeModPay() {
		return codeModPay;
	}

	public void setCodeModPay(String codeModPay) {
		this.codeModPay = codeModPay;
	}

	public String getLibeModPay() {
		return libeModPay;
	}

	public void setLibeModPay(String libeModPay) {
		this.libeModPay = libeModPay;
	}

	@Override
	public String toString() {
		return "ModePaiement [codeModPay=" + codeModPay + ", libeModPay=" + libeModPay + "]";
	}
	
	public String element() {
		return codeModPay + "; " + libeModPay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeModPay, libeModPay);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ModePaiement other = (ModePaiement) obj;
		return Objects.equals(codeModPay, other.codeModPay) && Objects.equals(libeModPay, other.libeModPay);
	}

	public List<String> structure(){
		List<String> ch= new ArrayList<>();
		for(Field f: this.getClass().getFields()) {
			ch.add(f.getName());
		}
		return ch;
	}

}