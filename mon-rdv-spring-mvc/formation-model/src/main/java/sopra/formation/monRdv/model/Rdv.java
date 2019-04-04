package sopra.formation.monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Rdv {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private boolean annulation;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@OneToMany(mappedBy = "rdv")
	private List<Creneau> creneaux = new ArrayList<Creneau>();
	@ManyToOne
	@JoinColumn(name = "adresse_motif_praticien_id")
	private AdresseMotifPraticien adresseMotifPraticien;

	public Rdv() {
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

	public boolean isAnnulation() {
		return annulation;
	}

	public void setAnnulation(boolean annulation) {
		this.annulation = annulation;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	public AdresseMotifPraticien getAdresseMotifPraticien() {
		return adresseMotifPraticien;
	}

	public void setAdresseMotifPraticien(AdresseMotifPraticien adresseMotifPraticien) {
		this.adresseMotifPraticien = adresseMotifPraticien;
	}

}
