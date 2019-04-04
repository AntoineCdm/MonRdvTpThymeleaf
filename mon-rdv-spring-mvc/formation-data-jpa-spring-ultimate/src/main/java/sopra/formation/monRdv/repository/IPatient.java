package sopra.formation.monRdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.monRdv.model.Patient;

public interface IPatient extends JpaRepository<Patient, Long> {

}
