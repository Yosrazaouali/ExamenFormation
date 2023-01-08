package tn.esprit.spring.Services.Implementation;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.Repository.FormateurRepository;
import tn.esprit.spring.Services.Interfaces.FormateurService;
import tn.esprit.spring.entities.Formateur;
import tn.esprit.spring.entities.Formation;

@Service
public class FormateurServiceImpl implements FormateurService {
	@Autowired
	FormateurRepository formateurRepository;

	@Override
	public void ajouterFormateur(Formateur f) {
		formateurRepository.save(f);
		
	}

	@Override
	public Integer getFormateurRemunerationByDate(Integer idFormateur, Date dateDebut, Date dateFin) {
	Formateur fr=formateurRepository.findById(idFormateur).get();
	List<Formation> frms=fr.getFormations();
	Integer remuneration=0;
	for(Formation f :frms) {
		if(f.getDateDebut().after(dateDebut) &&f.getDateFin().before(dateFin)) {
			remuneration+=f.getNbrHeures()*f.getFormateur().getTarifHoraire();
		}
	}
	return remuneration;
		
	}
	
	

}
