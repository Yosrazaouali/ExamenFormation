package tn.esprit.spring.Services.Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.ApprenantRepository;
import tn.esprit.spring.Repository.FormateurRepository;
import tn.esprit.spring.Repository.FormationRepository;
import tn.esprit.spring.Services.Interfaces.FormationService;
import tn.esprit.spring.entities.Apprenant;
import tn.esprit.spring.entities.Formateur;
import tn.esprit.spring.entities.Formation;

@Slf4j
@Service
public class FormationServiceImpl implements FormationService {
	@Autowired
	FormationRepository formationRepository;
	@Autowired
	FormateurRepository formateurRepository;
	@Autowired
	ApprenantRepository apprenantRepository;

	@Override
	public void ajouterFormationAffecterFormateur(Formation formation, Integer idFormateur) {
		Formateur fr=formateurRepository.findById(idFormateur).get();
		formation.setFormateur(fr);
		formationRepository.save(formation);
	}
	@Override
	public void affecterApprenantFormation(Integer idApprenant, Integer idFormation) {
		Apprenant ap=apprenantRepository.findById(idApprenant).get();
		Formation fr=formationRepository.findById(idFormation).get();
		if(fr.getNbrMaxParticipant()>fr.getApprenants().size()) {
		fr.getApprenants().add(ap);
		formationRepository.save(fr);
		}
		else {
			log.info("le nombre maximal est atteint");
		}
	}
	@Override
	public Integer getRevenuByFormation(Integer idFormation) {
		Formation formation=formationRepository.findById(idFormation).get();
		return formation.getFrais()*formation.getApprenants().size();
	}
}
