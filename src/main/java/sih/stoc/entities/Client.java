package sih.stoc.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import sih.securite.config.Audit;

@SuppressWarnings("serial")
@Entity
public class Client extends Audit<String> implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long idCli;
	private String ident;
	@Column(nullable = true)
	private String sigle;
	private String telCli;
	private String adrCli;
	private String rcc;
	private Long ifuCli;
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String ident, String sigle, String telCli, String adrCli, String rcc, Long ifuCli) {
		super();
		this.ident = ident;
		this.sigle = sigle;
		this.telCli = telCli;
		this.adrCli = adrCli;
		this.rcc = rcc;
		this.ifuCli = ifuCli;
	}

	public Long getIdCli() {
		return idCli;
	}

	public void setIdCli(Long idCli) {
		this.idCli = idCli;
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public String getTelCli() {
		return telCli;
	}

	public void setTelCli(String telCli) {
		this.telCli = telCli;
	}

	public String getAdrCli() {
		return adrCli;
	}

	public void setAdrCli(String adrCli) {
		this.adrCli = adrCli;
	}

	public String getRcc() {
		return rcc;
	}

	public void setRcc(String rcc) {
		this.rcc = rcc;
	}

	public Long getIfuCli() {
		return ifuCli;
	}

	public void setIfuCli(Long ifuCli) {
		this.ifuCli = ifuCli;
	}
	
	
}
