package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Apprenant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idApprenant;
	private String nom;
	private String prenom;
	private Integer telephone;
	private String email;
	
	@ManyToMany(mappedBy ="apprenants", cascade = CascadeType.ALL)
	private List<Formation> formations;
}
