package sopra.formation.monRdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.monRdv.model.Utilisateur;

public interface IUtilisateur extends JpaRepository<Utilisateur, Long>{

}
