package sopra.formation.monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Praticien {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 100)
	@NotEmpty(message="Veuillez renseigner votre nom")
	@Size(min = 3, max=40, message="L'intitule doit comprendre au minimum 3 caractères (100 max)")
	private String nom;
	@Column(length = 100)
	@NotEmpty(message="Veuillez renseigner votre nom")
	@Size(min = 3, max=40, message="L'intitule doit comprendre au minimum 3 caractères (100 max)")
	private String prenom;
	@Column(length = 255)
	@NotEmpty(message="Champ requis")
	private String mail;
	@Column(length = 15)
	@NotEmpty(message="Champ requis")
	private String tel;
	@Column(name = "duree_creneau")
	private int dureeCreneau;
	@OneToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "praticien")
	private List<AdresseMotifPraticien> motifs = new ArrayList<AdresseMotifPraticien>();
	@OneToMany(mappedBy = "praticien")
	private List<Creneau> creneaux = new ArrayList<Creneau>();
	@OneToMany(mappedBy = "praticien")
	private List<PraticienSpecialite> specialites = new ArrayList<PraticienSpecialite>();

	public Praticien() {
		super();
	}

	public Praticien(String nom, String prenom, String mail, String tel, int dureeCreneau) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.tel = tel;
		this.dureeCreneau = dureeCreneau;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getDureeCreneau() {
		return dureeCreneau;
	}

	public void setDureeCreneau(int dureeCreneau) {
		this.dureeCreneau = dureeCreneau;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
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

	public List<PraticienSpecialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<PraticienSpecialite> specialites) {
		this.specialites = specialites;
	}

}
