package tn.esprit.spring.Services.Interfaces;


import tn.esprit.spring.entities.Formation;

public interface FormationService {
	void ajouterFormationAffecterFormateur(Formation formation, Integer idFormateur);
	void affecterApprenantFormation(Integer idApprenant , Integer idFormation);
	public Integer getRevenuByFormation(Integer idFormation);
	


}
