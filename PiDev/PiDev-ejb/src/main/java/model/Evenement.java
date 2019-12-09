package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the evenements database table.
 * 
 */
@Entity
@Table(name="evenements")
@NamedQuery(name="Evenement.findAll", query="SELECT e FROM Evenement e")
public class Evenement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEvenement;



	//bi-directional many-to-many association to Client
	@ManyToMany(mappedBy="evenements")
	private List<Client> clients;

	@Temporal (TemporalType.DATE)
	private Date dateEvenement;

	private String description;
	@Enumerated(EnumType.STRING)
	private typeEven image;
	@Enumerated(EnumType.STRING)
	private LocalisationEven localisation;

	private int nbInteresses;

	private int nbParticipants;

	private int nombrePlace;

	public Evenement() {
	}
	public Evenement(int idEvenement, Date date,String description,typeEven image, LocalisationEven localisation,
			int nbInteresses, int nbParticipants,int nombrePlace) {
		super();
		this.idEvenement = idEvenement;
	
		this.description = description;
		this.image = image;
		this.localisation = localisation;
		this.nbInteresses = nbInteresses;
		this.nbParticipants = nbParticipants;
		this.nombrePlace=nombrePlace;
	
	}
	public Evenement( Date dateEvenement,String description, typeEven image, LocalisationEven localisation,
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
	public Evenement( String description, typeEven image, LocalisationEven localisation,
			int nbInteresses, int nbParticipants) {
		super();
	
		this.description = description;
		this.image = image;
		this.localisation = localisation;
		this.nbInteresses = nbInteresses;
		this.nbParticipants = nbParticipants;
	
	}
	
	
	public Evenement(Date dateEvenement,String description, LocalisationEven localisation, int nbInteresses, int nbParticipants) {
		super();
		this.dateEvenement=dateEvenement;
		this.description = description;
		this.localisation = localisation;
		this.nbInteresses = nbInteresses;
		this.nbParticipants = nbParticipants;
	}
	public int getIdEvenement() {
		return idEvenement;
	}
	public void setIdEvenement(int idEvenement) {
		this.idEvenement = idEvenement;
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
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


}