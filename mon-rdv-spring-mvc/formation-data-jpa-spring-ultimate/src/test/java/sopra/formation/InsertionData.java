package sopra.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.monRdv.model.Adresse;
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
	public static void main(String[] args) {

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
		Utilisateur utilisateur3 = new Utilisateur("jdubourg", "motdepasse", Type.PRATICIEN);
		utilisateur3 = utilisateurRepo.save(utilisateur3);
		Utilisateur utilisateur4 = new Utilisateur("jsarpoulet", "securite", Type.PRATICIEN);
		utilisateur4 = utilisateurRepo.save(utilisateur4);
		Utilisateur utilisateur5 = new Utilisateur("gbouchentouf", "ordinateur", Type.ADMINISTRATEUR);
		utilisateur5 = utilisateurRepo.save(utilisateur5);

		Specialite specialite1 =new Specialite("Orthopediste", true);
		specialite1 = specialiteRepo.save(specialite1);
		Specialite specialite2 =new Specialite("Orthopediste", true);
		specialite2 = specialiteRepo.save(specialite2);
		Specialite specialite3 =new Specialite("Orthopediste", true);
		specialite3 = specialiteRepo.save(specialite3);
		Specialite specialite4 =new Specialite("Orthopediste", true);
		specialite4 = specialiteRepo.save(specialite4);
		Specialite specialite5 =new Specialite("Orthopediste", true);
		specialite5 = specialiteRepo.save(specialite5);
		
		context.close();
	}
}
