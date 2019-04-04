package sopra.formation.monRdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.monRdv.model.Adresse;


public interface IAdresse extends JpaRepository<Adresse, Long>{
//	List<Adresse> findByNom(String nom);
//
//	List<Adresse> findByDuree(int duree);
	
//	public Adresse save(Adresse adresse);

//	@Query("select m from Matiere m join m.formateurs f where f.nom = :monNom")
//	List<Matiere> findAllByFormateur(@Param("monNom") String nom);
}
