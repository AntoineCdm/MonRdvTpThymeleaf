package sopra.formation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import sopra.formation.monRdv.model.Adresse;
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

		Adresse adresse1 = new Adresse("10 rue de la Paix", "75008", "PARIS");
		adresse1 = adresseRepo.save(adresse1);

		context.close();
	}
}
