package sopra.formation.monRdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.monRdv.model.Rdv;

public interface IRdv extends JpaRepository<Rdv, Long>{

}
