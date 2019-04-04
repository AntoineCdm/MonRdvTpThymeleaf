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
public class Specialite {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(length = 255)
	private String specialite;
	private boolean valide;
	@OneToMany(mappedBy = "specialite")
	private List<Motif> motifs = new ArrayList<Motif>();
	@OneToMany(mappedBy = "specialite")
	private List<PraticienSpecialite> praticiens = new ArrayList<PraticienSpecialite>();

	public Specialite() {
		super();
	}

	public Specialite(String specialite, boolean valide) {
		super();
		this.specialite = specialite;
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

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public List<Motif> getMotifs() {
		return motifs;
	}

	public void setMotifs(List<Motif> motifs) {
		this.motifs = motifs;
	}

	public List<PraticienSpecialite> getPraticiens() {
		return praticiens;
	}

	public void setPraticiens(List<PraticienSpecialite> praticiens) {
		this.praticiens = praticiens;
	}

}
