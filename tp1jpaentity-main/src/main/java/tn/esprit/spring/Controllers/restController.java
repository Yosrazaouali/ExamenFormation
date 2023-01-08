package tn.esprit.spring.Controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Apprenant;
import tn.esprit.spring.entities.Formateur;
import tn.esprit.spring.entities.Formation;
import tn.esprit.spring.Services.Interfaces.ApprenantService;
import tn.esprit.spring.Services.Interfaces.FormateurService ;
import tn.esprit.spring.Services.Interfaces.FormationService;


@RestController
public class restController {
	@Autowired
	FormateurService formateurService;
	@Autowired
	ApprenantService apprenantService;
	@Autowired
	FormationService formationService;
	
	@PostMapping("/addFormateur")
	public void ajouterFormateur(@RequestBody Formateur f) {
		formateurService.ajouterFormateur(f);
	}
	@PostMapping("/addApprenant")
	public void ajouterApprenant(@RequestBody Apprenant ap) {
		apprenantService.ajouterApprenant(ap);
	}
	@PostMapping("/ajouterAffecterFormationFormateur/{idFormateur}")
	public void ajouterFormationAffecterFormateur(@RequestBody Formation formation,@PathVariable Integer idFormateur) {
		formationService.ajouterFormationAffecterFormateur(formation, idFormateur);
	}
	@PutMapping("/affectApprenantFormation/{idApprenant}/{idFormation}")
	public void affecterApprenantFormation(@PathVariable Integer idApprenant,@PathVariable Integer idFormation) {
		formationService.affecterApprenantFormation(idApprenant, idFormation);
	}
	@GetMapping("/getNbrAppByFormation")
	public void getNbrApprenantByFormation() {
		apprenantService.getNbrApprenantByFormation();
	}
	@GetMapping("/getRemuneration/{idFormateur}/{dateDebut}/{dateFin}")
	public Integer getFormateurRemunerationByDate(
			@PathVariable("idFormateur") Integer idFormateur, 
			@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, 
			@PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin
			) {
		return formateurService.getFormateurRemunerationByDate(idFormateur, dateDebut, dateFin);
	}
	@GetMapping("/revenue/{idFormation}")
	public Integer getRevenuByFormation(@PathVariable Integer idFormation) {
		return formationService.getRevenuByFormation(idFormation);
	}

}
