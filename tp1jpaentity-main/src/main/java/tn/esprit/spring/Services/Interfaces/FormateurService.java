package tn.esprit.spring.Services.Interfaces;

import java.util.Date;


import tn.esprit.spring.entities.Formateur;

public interface FormateurService {
	void ajouterFormateur(Formateur f);

	public Integer getFormateurRemunerationByDate(Integer idFormateur, Date dateDebut, Date dateFin);

}
