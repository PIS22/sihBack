package sih.stoc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import sih.securite.config.Audit;

@Entity
public class Service extends Audit<String> {
	@Id
	Long ids;

	public Long getIds() {
		return ids;
	}

	public void setIds(Long ids) {
		this.ids = ids;
	}

}
