package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Formation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import  tn.esprit.spring.entities.Formation;
import tn.esprit.spring.entities.Niveau;
import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer> {
}
