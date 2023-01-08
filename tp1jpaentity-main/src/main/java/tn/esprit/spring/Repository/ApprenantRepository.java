package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Apprenant;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Integer> {

}