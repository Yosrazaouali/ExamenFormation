package tn.esprit.spring.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.Repository.ApprenantRepository;
import tn.esprit.spring.Repository.FormationRepository;
import tn.esprit.spring.Services.Interfaces.ApprenantService;
import tn.esprit.spring.entities.Apprenant;
import tn.esprit.spring.entities.Formation;

@Slf4j
@Service
public class ApprenantServiceImpl implements ApprenantService {
	@Autowired
	ApprenantRepository apprenantRepository;
	@Autowired
	FormationRepository formationRepository;

	@Override
	public void ajouterApprenant(Apprenant ap) {
		apprenantRepository.save(ap);
		
	}
    //fixedRate , fixedDelay : en millisecondes
	//cron=" * * * * * * " <<<< cron=" 0 0 0 1 1 SAT "<<< cron=" */30 * * * * * "
	@Scheduled(fixedDelay = 30000)
	@Override
	public void getNbrApprenantByFormation() {
//		formationRepository.findAll().stream()
//		.forEach(f->{
//			log.info("La formation" +f.getTitre()+ "contient" +f.getApprenants().size());
//		});
		List<Formation> frms=formationRepository.findAll();
		for(Formation f : frms) {
			log.info("La formation     " +f.getTitre()+ "     contient    " +f.getApprenants().size());
		}
	}
}
