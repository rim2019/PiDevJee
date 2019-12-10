package managedBeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import implementation.evenementImpl;
import implementation.evenementPasseImpl;
import model.Evenement;
import model.EvenementPass;
import model.LocalisationEven;
import model.typeEven;

/**
 * Session Bean implementation class EvenementPasseBean
 */
@ManagedBean(name ="evenementPasseBean")
@SessionScoped
public class EvenementPasseBean {
	private Date dateEvenement;

	private String description;

	private typeEven image;

	private LocalisationEven localisation;

	private int nbInteresses;

	private int nbParticipants;
	private int clientId;
	private Integer employeIdToBeUpdated;
private int nbComplet;
private int nbAnnule;
private int nbReussi;
	private int nombrePlace;
	@EJB
	evenementPasseImpl evenementPasseService;
	

	
    /**
     * Default constructor. 
     */
    public EvenementPasseBean() {
    	super();
     
    }
    
	private List<EvenementPass> evenementPasses;

	public List<EvenementPass> getEvenementsPasse()
	{
		
	
		evenementPasses= evenementPasseService.getAllEvenementsPasse();
	 
	        return evenementPasses;
	}
	
	public List<EvenementPass> getEvenementsComplet()
	{
		
	
		evenementPasses= evenementPasseService.getAllEvenementsComplet();
        this.setNbComplet( evenementPasses.size());
	        return evenementPasses;
	}
	public List<EvenementPass> getEvenementsAnnule()
	{
		
	
		evenementPasses= evenementPasseService.getAllEvenementsAnnule();
        this.setNbAnnule( evenementPasses.size());
	        return evenementPasses;
	}
	public List<EvenementPass> getEvenementsReussi()
	{
		
	
		evenementPasses= evenementPasseService.getAllEvenementsReussi();
        this.setNbReussi( evenementPasses.size());
	        return evenementPasses;
	}
	public List<EvenementPass> getEvenementsTop()
	{
		
	
		evenementPasses= evenementPasseService.getAllEvenementsTopMois();
    
	        return evenementPasses;
	}
	
	public List<EvenementPass> getEvenementsBad()
	{
		
	
		evenementPasses= evenementPasseService.getAllEvenementsBad();
    
	        return evenementPasses;
	}
	public EvenementPasseBean(Date dateEvenement, String description,typeEven image, LocalisationEven localisation, int nbInteresses,
			int nbParticipants, Integer employeIdToBeUpdated, int nombrePlace, evenementPasseImpl evenementPasseService,
			List<EvenementPass> evenementsPasse)
	{
		super();
		this.dateEvenement = dateEvenement;
		this.description = description;
		this.image = image;
		this.localisation = localisation;
		this.nbInteresses = nbInteresses;
		this.nbParticipants = nbParticipants;
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	
		this.nombrePlace = nombrePlace;
		this.evenementPasseService = evenementPasseService;
		this.evenementPasses = evenementsPasse;
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
	}

	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public int getNbComplet() {
		return nbComplet;
	}

	public void setNbComplet(int nbComplet) {
		this.nbComplet = nbComplet;
	}

	public int getNbAnnule() {
		return nbAnnule;
	}

	public void setNbAnnule(int nbAnnule) {
		this.nbAnnule = nbAnnule;
	}

	public int getNbReussi() {
		return nbReussi;
	}

	public void setNbReussi(int nbReussi) {
		this.nbReussi = nbReussi;
	}


	

}
