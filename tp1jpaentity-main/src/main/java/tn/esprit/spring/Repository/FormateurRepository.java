package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Formateur;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur, Integer> {

}
