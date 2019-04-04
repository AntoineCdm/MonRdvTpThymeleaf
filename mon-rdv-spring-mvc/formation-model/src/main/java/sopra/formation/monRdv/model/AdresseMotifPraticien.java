package sopra.formation.monRdv.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "adresse_motif_praticien")
public class AdresseMotifPraticien {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "adresse_id")
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name = "motif_id")
	private Motif motif;
	@ManyToOne
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@OneToMany(mappedBy = "adresseMotifPraticien")
	private List<Rdv> rdvs = new ArrayList<Rdv>();

	public AdresseMotifPraticien() {
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

}
