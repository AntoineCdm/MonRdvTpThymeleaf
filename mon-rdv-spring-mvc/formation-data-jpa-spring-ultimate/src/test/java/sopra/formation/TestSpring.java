package sopra.formation;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	public static void main(String[] args) {
		
		
		Logger logger = Logger.getLogger("sopra.formation.TestSpring");
		
		logger.trace("J'écris dans mon log !!!");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//
//		IClientRepository clientRepo = context.getBean(IClientRepository.class);
//		IFormationRepository formationRepo = context.getBean(IFormationRepository.class);
//
//		Client sopraSteria = new Client("32682006500083", "SOPRA STERIA GROUP", StatutJuridique.SA);
//		sopraSteria = clientRepo.save(sopraSteria);
//
//		Date dtFormation = new Date(2019L);
//		Formation ajc = new Formation("JAVA", "Les oubliés", dtFormation);
//		ajc = formationRepo.save(ajc);
//
//		Optional<Formation> optAjc = formationRepo.findById(ajc.getId());
//
//		if (optAjc.isPresent()) {
//			Formation ajcFind = optAjc.get();
//		}

	}
}
