package sopra.formation.monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Motif {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 255)
	private String libelle;
	@Column(name = "nb_creneau")
	private int nbCreneau;
	private boolean valide;
	@OneToMany(mappedBy = "motif")
	private List<AdresseMotifPraticien> adresses = new ArrayList<AdresseMotifPraticien>();
	@ManyToOne
	@JoinColumn(name = "specialite_id")
	private Specialite specialite;

	public Motif() {
		super();
	}

	public Motif(String libelle, int nbCreneau, boolean valide) {
		super();
		this.libelle = libelle;
		this.nbCreneau = nbCreneau;
		this.valide = valide;
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

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getNbCreneau() {
		return nbCreneau;
	}

	public void setNbCreneau(int nbCreneau) {
		this.nbCreneau = nbCreneau;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public List<AdresseMotifPraticien> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<AdresseMotifPraticien> adresses) {
		this.adresses = adresses;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

}
