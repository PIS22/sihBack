package sih.stoc.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Service {
	@Id
	Long ids;

	public Long getIds() {
		return ids;
	}

	public void setIds(Long ids) {
		this.ids = ids;
	}

}
