package sopra.formation.monRdv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.monRdv.model.AdresseMotifPraticien;

public interface IAdresseMotifPraticien extends JpaRepository<AdresseMotifPraticien, Long>{
	@Query("select amp.praticien from AdresseMotifPraticien amp where amp.praticien.id = :praticienId")
	public List<AdresseMotifPraticien> findAllByPraticien(@Param("praticienId") Long praticienId); 
}
