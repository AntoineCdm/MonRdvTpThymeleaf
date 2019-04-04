package sopra.formation.monRdv.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Creneau {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "rdv_id")
	private Rdv rdv;
	@ManyToOne
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;

	public Creneau() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}
	
	

}
