package sopra.formation.monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Adresse {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 255)
	private String rue;
	@Column(name = "code_postal", length = 10)
	private String codePostal;
	@Column(length = 100)
	private String ville;
	@OneToMany(mappedBy = "adresse")
	private List<Patient> patients = new ArrayList<Patient>();
	@OneToMany(mappedBy = "adresse")
	private List<Creneau> creneaux = new ArrayList<Creneau>();
	@OneToMany(mappedBy = "adresse")
	private List<AdresseMotifPraticien> motifs = new ArrayList<AdresseMotifPraticien>();

	public Adresse() {
		super();
	}

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Creneau> getCreneaux() {
		return creneaux;
	}

	public void setCreneaux(List<Creneau> creneaux) {
		this.creneaux = creneaux;
	}

	public List<AdresseMotifPraticien> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<AdresseMotifPraticien> motifs) {
		this.motifs = motifs;
	}

}
