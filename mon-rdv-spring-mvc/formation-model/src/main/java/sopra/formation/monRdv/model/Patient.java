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
public class Patient {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 100)
	private String nom;
	@Column(length = 100)
	private String prenom;
	private int age;
	@Column(length = 255)
	private String mail;
	@Column(length = 20)
	private String tel;
	@Column(name = "numero_carte_vitale", length = 30)
	private String numeroCarteVitale;
	private boolean principal;
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;
	@OneToMany(mappedBy = "patient")
	private List<Rdv> rdvs = new ArrayList<Rdv>();
	@ManyToOne
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Patient() {
		super();
	}

	public Patient(String nom, String prenom, int age, String mail, String tel, String numeroCarteVitale,
			boolean principal) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mail = mail;
		this.tel = tel;
		this.numeroCarteVitale = numeroCarteVitale;
		this.principal = principal;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getNumeroCarteVitale() {
		return numeroCarteVitale;
	}

	public void setNumeroCarteVitale(String numeroCarteVitale) {
		this.numeroCarteVitale = numeroCarteVitale;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

}
