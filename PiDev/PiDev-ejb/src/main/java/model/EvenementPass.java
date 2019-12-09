package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the evenementPasses database table.
 * 
 */
@Entity
@Table(name="evenementPasses")
@NamedQuery(name="EvenementPass.findAll", query="SELECT e FROM EvenementPass e")
public class EvenementPass implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvenementPasse;

	private Date dateEvenement;

	private String description;

	@Enumerated(EnumType.STRING)
	private typeEven image;
	@Enumerated(EnumType.STRING)
	private LocalisationEven localisation;

	private int nbInteresses;

	private int nbParticipants;

	private int nombrePlace;

	public EvenementPass() {
	}

	public int getIdEvenementPasse() {
		return this.idEvenementPasse;
	}

	public void setIdEvenementPasse(int idEvenementPasse) {
		this.idEvenementPasse = idEvenementPasse;
	}

	public Date getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public typeEven getImage() {
		return image;
	}

	public void setImage(typeEven image) {
		this.image = image;
	}

	public LocalisationEven getLocalisation() {
		return localisation;
	}

	public void setLocalisation(LocalisationEven localisation) {
		this.localisation = localisation;
	}

	public int getNbInteresses() {
		return nbInteresses;
	}

	public void setNbInteresses(int nbInteresses) {
		this.nbInteresses = nbInteresses;
	}

	public int getNbParticipants() {
		return nbParticipants;
	}

	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public EvenementPass( Date dateEvenement,String description, typeEven image, LocalisationEven localisation,
			int nbInteresses, int nbParticipants,int nombrePlace) {
		super();
	
		this.dateEvenement =dateEvenement;
		this.description = description;
		this.image = image;
		this.localisation = localisation;
		this.nbInteresses = nbInteresses;
		this.nbParticipants = nbParticipants;
		this.nombrePlace=nombrePlace;
	
	}
	

}