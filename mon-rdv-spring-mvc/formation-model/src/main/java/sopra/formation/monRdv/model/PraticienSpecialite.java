package sopra.formation.monRdv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "praticien_specialite")
public class PraticienSpecialite {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@ManyToOne
	@JoinColumn(name = "specialite_id")
	private Specialite specialite;

	public PraticienSpecialite() {
		super();
	}

	public PraticienSpecialite(Praticien praticien, Specialite specialite) {
		super();
		this.praticien = praticien;
		this.specialite = specialite;
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

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

}
