package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
public class Formateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idFormateur;
	private String nom;
	private String prenom;
	private Integer tarifHoraire;
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy ="formateur")
	private List<Formation> formations;
}
