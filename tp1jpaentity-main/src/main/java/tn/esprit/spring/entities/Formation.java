package tn.esprit.spring.entities;



import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Formation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
     private Integer idFormation;
	private String titre;
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	private Date dateDebut;
	private Date dateFin;
	private Integer nbrHeures;
	private Integer nbrMaxParticipant;
	private Integer frais;
	
	
	@ManyToOne
	Formateur formateur;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Apprenant> apprenants;
	
}
