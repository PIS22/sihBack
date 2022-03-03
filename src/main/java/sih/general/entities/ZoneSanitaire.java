package sih.general.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class ZoneSanitaire implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idZS;
	@Column(unique = true,nullable = false)
	private String codZS;
	private String libZS;
	
		public ZoneSanitaire() {
			// TODO Auto-generated constructor stub
		
		}
	
		@ManyToOne(targetEntity = DDS.class, cascade = {CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.EAGER)
		@JoinColumn(name = "iddds", referencedColumnName = "iddds", nullable = false, updatable = true, insertable = true)
		private DDS Dds;
		
		public ZoneSanitaire(String codZS, String libZS, DDS Dds) {
			super();
			this.codZS = codZS;
			this.libZS = libZS;
			this.Dds = Dds;
		}

		public Long getIdZS() {
			return idZS;
		}
		
		public void setIdZS(Long idZS) {
			this.idZS = idZS;
		}

		public String getCodZS() {
			return codZS;
		}

		public void setCodZS(String codZS) {
			this.codZS = codZS;
		}

		public String getlibZS() {
			return libZS;
		}

		public void setLibZS(String libZS) {
			this.libZS = libZS;
		}
		
		public DDS getDds() {
			return Dds;
		}
		public void setDds(DDS ddsDs) {
			Dds = ddsDs;
		}
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((Dds == null) ? 0 : Dds.hashCode());
			result = prime * result + ((codZS == null) ? 0 : codZS.hashCode());
			result = prime * result + ((idZS == null) ? 0 : idZS.hashCode());
			result = prime * result + ((libZS == null) ? 0 : libZS.hashCode());
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
			ZoneSanitaire other = (ZoneSanitaire) obj;
			if (Dds == null) {
				if (other.Dds != null)
					return false;
			} else if (!Dds.equals(other.Dds))
				return false;
			if (codZS == null) {
				if (other.codZS != null)
					return false;
			} else if (!codZS.equals(other.codZS))
				return false;
			if (idZS == null) {
				if (other.idZS != null)
					return false;
			} else if (!idZS.equals(other.idZS))
				return false;
			if (libZS == null) {
				if (other.libZS != null)
					return false;
			} else if (!libZS.equals(other.libZS))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ZoneSanitaire [idZS=" + idZS + ", codZS=" + codZS + ", libZS=" + libZS +", Dds= " + Dds + "]";
		}
		
		public String element() {
			return idZS + "; " +codZS  + "; " +  libZS + "; " +Dds.getLibDds();
			
		}
}	

