package sopra.formation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.monRdv.model.Adresse;
import sopra.formation.monRdv.model.AdresseMotifPraticien;
import sopra.formation.monRdv.model.Creneau;
import sopra.formation.monRdv.model.Motif;
import sopra.formation.monRdv.model.Patient;
import sopra.formation.monRdv.model.Praticien;
import sopra.formation.monRdv.model.PraticienSpecialite;
import sopra.formation.monRdv.model.Rdv;
import sopra.formation.monRdv.model.Specialite;
import sopra.formation.monRdv.model.Type;
import sopra.formation.monRdv.model.Utilisateur;
import sopra.formation.monRdv.repository.IAdresse;
import sopra.formation.monRdv.repository.IAdresseMotifPraticien;
import sopra.formation.monRdv.repository.ICreneau;
import sopra.formation.monRdv.repository.IMotif;
import sopra.formation.monRdv.repository.IPatient;
import sopra.formation.monRdv.repository.IPraticien;
import sopra.formation.monRdv.repository.IPraticienSpecialite;
import sopra.formation.monRdv.repository.IRdv;
import sopra.formation.monRdv.repository.ISpecialite;
import sopra.formation.monRdv.repository.IUtilisateur;

public class InsertionData {
	public static void main(String[] args) throws ParseException {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		IAdresse adresseRepo = context.getBean(IAdresse.class);
		IUtilisateur utilisateurRepo = context.getBean(IUtilisateur.class);
		ISpecialite specialiteRepo = context.getBean(ISpecialite.class);
		IPraticien praticienRepo = context.getBean(IPraticien.class);
		IMotif motifRepo = context.getBean(IMotif.class);
		IAdresseMotifPraticien adresseMotifPraticienRepo = context.getBean(IAdresseMotifPraticien.class);
		IPraticienSpecialite praticienSpecialiteRepo = context.getBean(IPraticienSpecialite.class);
		IPatient patientRepo = context.getBean(IPatient.class);
		IRdv rdvRepo = context.getBean(IRdv.class);
		ICreneau creneauRepo = context.getBean(ICreneau.class);
		
		SimpleDateFormat parser=new SimpleDateFormat("dd/MM/yyy HH:mm");

		Adresse adresse1 = new Adresse("10 rue de la Paix", "75008", "Paris");
		adresse1 = adresseRepo.save(adresse1);
		Adresse adresse2 = new Adresse("54 rue de la Chenille", "33000", "Bordeaux");
		adresse2 = adresseRepo.save(adresse2);
		Adresse adresse3 = new Adresse("15 rue des Chateaux", "56000", "Vannes");
		adresse3 = adresseRepo.save(adresse3);
		Adresse adresse4 = new Adresse("961 rue du Scarabee", "03000", "Vichy");
		adresse4 = adresseRepo.save(adresse4);
		Adresse adresse5 = new Adresse("42 avenue JFK", "33700", "Merignac");
		adresse5 = adresseRepo.save(adresse5);

		Utilisateur utilisateur1 = new Utilisateur("ldederen", "password", Type.PATIENT);
		utilisateur1 = utilisateurRepo.save(utilisateur1);
		Utilisateur utilisateur2 = new Utilisateur("acuneo", "123456", Type.PATIENT);
		utilisateur2 = utilisateurRepo.save(utilisateur2);
		Utilisateur utilisateur3 = new Utilisateur("gcaumes", "motdepasse", Type.PRATICIEN);
		utilisateur3 = utilisateurRepo.save(utilisateur3);
		Utilisateur utilisateur4 = new Utilisateur("jmanem", "securite", Type.PRATICIEN);
		utilisateur4 = utilisateurRepo.save(utilisateur4);
		Utilisateur utilisateur5 = new Utilisateur("esultan", "ordinateur", Type.ADMINISTRATEUR);
		utilisateur5 = utilisateurRepo.save(utilisateur5);

		Specialite specialite1 = new Specialite("Orthopediste", true);
		specialite1 = specialiteRepo.save(specialite1);
		Specialite specialite2 = new Specialite("Generaliste", true);
		specialite2 = specialiteRepo.save(specialite2);
		Specialite specialite3 = new Specialite("Urologue", false);
		specialite3 = specialiteRepo.save(specialite3);
		Specialite specialite4 = new Specialite("Cardiologue", true);
		specialite4 = specialiteRepo.save(specialite4);
		Specialite specialite5 = new Specialite("Kinesitherapeute", true);
		specialite5 = specialiteRepo.save(specialite5);

		Praticien praticien1 = new Praticien("Caumes", "Géraldine", "g.caumes@gmail.com", "06-12-34-56-78", 15);
		praticien1.setUtilisateur(utilisateur3);
		praticien1 = praticienRepo.save(praticien1);
		Praticien praticien2 = new Praticien("Manem", "Julien", "j.manem@gmail.com", "06-68-97-42-93", 30);
		praticien2.setUtilisateur(utilisateur4);
		praticien2 = praticienRepo.save(praticien2);

		Motif motif1 = new Motif("Consultation", 1, true);
		motif1.setSpecialite(specialite2);
		motif1 = motifRepo.save(motif1);
		Motif motif2 = new Motif("PTH", 4, true);
		motif2.setSpecialite(specialite1);
		motif2 = motifRepo.save(motif2);
		Motif motif3 = new Motif("PTG", 2, false);
		motif3.setSpecialite(specialite1);
		motif3 = motifRepo.save(motif3);
		Motif motif4 = new Motif("PTH", 10, true);
		motif4.setSpecialite(specialite1);
		motif4 = motifRepo.save(motif4);

		AdresseMotifPraticien adp1 = new AdresseMotifPraticien();
		adp1.setAdresse(adresse1);
		adp1.setMotif(motif2);
		adp1.setPraticien(praticien1);
		adp1 = adresseMotifPraticienRepo.save(adp1);
		AdresseMotifPraticien adp2 = new AdresseMotifPraticien();
		adp2.setAdresse(adresse2);
		adp2.setMotif(motif1);
		adp2.setPraticien(praticien2);
		adp2 = adresseMotifPraticienRepo.save(adp2);

		PraticienSpecialite ps1 = new PraticienSpecialite(praticien1, specialite1);
		ps1 = praticienSpecialiteRepo.save(ps1);
		PraticienSpecialite ps2 = new PraticienSpecialite(praticien2, specialite2);
		ps2 = praticienSpecialiteRepo.save(ps2);

		Patient patient1 = new Patient("Dederen", "Loic", 25, "l.dederen@gmail.com", "06-68-97-84-63",
				"193059304824113", true);
		patient1.setAdresse(adresse3);
		patient1.setUtilisateur(utilisateur1);
		patient1 = patientRepo.save(patient1);
		Patient patient2 = new Patient("Dederen", "Edith", 25, "e.dederen@gmail.com", "06-68-56-84-63",
				"293119305024113", false);
		patient2.setAdresse(adresse3);
		patient2.setUtilisateur(utilisateur1);
		patient2 = patientRepo.save(patient2);
		Patient patient3 = new Patient("Cuneo", "Antoine", 27, "a.cuneo@gmail.com", "06-97-63-84-89", "191129305024113",
				true);
		patient3.setAdresse(adresse5);
		patient3.setUtilisateur(utilisateur2);
		patient3 = patientRepo.save(patient3);

		Rdv rdv1 = new Rdv();
		rdv1.setAdresseMotifPraticien(adp1);
		rdv1.setPatient(patient1);
		rdv1.setAnnulation(false);
		rdv1 = rdvRepo.save(rdv1);
		Rdv rdv2 = new Rdv();
		rdv2.setAdresseMotifPraticien(adp1);
		rdv2.setPatient(patient3);
		rdv2.setAnnulation(false);
		rdv2 = rdvRepo.save(rdv2);
		Rdv rdv3 = new Rdv();
		rdv3.setAdresseMotifPraticien(adp2);
		rdv3.setPatient(patient1);
		rdv3.setAnnulation(false);
		rdv3 = rdvRepo.save(rdv3);

		Date date1=parser.parse("05/04/2019 11:00");
		Date date2=parser.parse("10/04/2019 14:00");
		Date date3=parser.parse("05/04/2019 15:00");
		
		Creneau creneau1 = new Creneau();
		creneau1.setDate(date1);
		creneau1.setRdv(rdv1);
		creneau1.setAdresse(rdv1.getAdresseMotifPraticien().getAdresse());
		creneau1.setPraticien(rdv1.getAdresseMotifPraticien().getPraticien());
		creneau1 = creneauRepo.save(creneau1);
		Creneau creneau2 = new Creneau();
		creneau2.setDate(date2);
		creneau2.setRdv(rdv2);
		creneau2.setAdresse(rdv2.getAdresseMotifPraticien().getAdresse());
		creneau2.setPraticien(rdv2.getAdresseMotifPraticien().getPraticien());
		creneau2 = creneauRepo.save(creneau2);
		Creneau creneau3 = new Creneau();
		creneau3.setDate(date3);
		creneau3.setRdv(rdv3);
		creneau3.setAdresse(rdv3.getAdresseMotifPraticien().getAdresse());
		creneau3.setPraticien(rdv3.getAdresseMotifPraticien().getPraticien());
		creneau3 = creneauRepo.save(creneau3);
		
		context.close();
	}
}
