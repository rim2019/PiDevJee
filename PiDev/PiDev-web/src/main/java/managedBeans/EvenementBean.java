package managedBeans;



import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.servlet.http.Part;



import implementation.ClientImpl;
import implementation.evenementImpl;
import model.Evenement;
import model.LocalisationEven;
import model.typeEven;


@ManagedBean(name ="evenementBean")
@SessionScoped
public class EvenementBean{

    /**
     * Default constructor. 
     */
	
//	private int idEvenement;
//	@Temporal(TemporalType.DATE)
	private Date dateEvenement;

	private String description;

	private typeEven image;

	private LocalisationEven localisation;

	private int nbInteresses=0;

	private int nbParticipants;
	
	private Integer employeIdToBeUpdated;
	private String criteria;
	private int nombrePlace;
	@EJB
	evenementImpl evenementService;
	@EJB
	ClientImpl clientService;
	




	
	public void addEvenement() throws IOException 
	{
		
		      SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");  
	           Date date = new Date();  
	         if(	-date.getDate()+this.getDateEvenement().getDate()>=2  && this.getNombrePlace()>4)
	             {
	            	this.setNbInteresses(0);
	             	this.setNbParticipants(0);
	              	this.setDescription("Disponible");
	             	this.description="Disponible";
	             	
	             	evenementService.ajouterEvenement(new Evenement(dateEvenement,description,image, localisation,
				                                             nbInteresses,nbParticipants,nombrePlace));
		         }
   }
	
	
	public void updateEvenement() throws IOException
	{
		
	      SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");  
          Date date = new Date();  
              if(	-date.getDate()+this.getDateEvenement().getDate()>=2  && this.getNombrePlace()>4)
                 {
		
            	  evenementService.updateEvenement(new Evenement(employeIdToBeUpdated,dateEvenement,description,image, localisation,
			                                                     nbInteresses,nbParticipants,nombrePlace ));
		           } 
    }
	

	public void participerEvenement(){
		
		if( this.getNbInteresses()==0)
		{
		//SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		       this.setNbParticipants(this.getNbParticipants()+1);
		       evenementService.updateEvenement(new Evenement(dateEvenement,description,image, localisation,
				nbInteresses,nbParticipants,nombrePlace));
		        this.setNbInteresses(1);
		
		}
		
		
}
	
	public void annulerparticiperEvenement(int evenementId){
		
		
		if( this.getNbInteresses()==1)
		{
	       int Clientid=1;
	       evenementService.supprimerClientAEvenement(Clientid, evenementId);
	       this.setNbInteresses(1);
		
		}
		
		}
	
	private List<Evenement> evenements;

	public List<Evenement> getEvenements()
	{
		
	
	       evenements = evenementService.getAllEvenementss();
	 
	        return evenements;
	}
	
	//Affecter
	public void affecter(int evenementId)
	{
		if( this.getNbInteresses()==0)
		{
	       int Clientid=1;
	       evenementService.affecterClientAEvenement(Clientid,evenementId);
	       this.setNbInteresses(1);
		}
		else if( this.getNbInteresses()==1)
		{ 
			 int Clientid=1;
			 evenementService.supprimerClientAEvenement(Clientid, evenementId);
		
	       this.setNbInteresses(0);
		}
	}
	
	//Supprimer
	public void removeEvenement(int evenementId)
	{
		evenementService.deleteEvenementById(evenementId);
	}
	
	
    public EvenementBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	







	public EvenementBean(Date dateEvenement, String description,typeEven image, LocalisationEven localisation, int nbInteresses,
			int nbParticipants, Integer employeIdToBeUpdated, int nombrePlace, evenementImpl employeService,
			List<Evenement> evenements)
	{
		
		this.dateEvenement = dateEvenement;
		this.description = description;
		this.image = image;
		this.localisation = localisation;
		this.nbInteresses = nbInteresses;
		this.nbParticipants = nbParticipants;
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	
		this.nombrePlace = nombrePlace;
		this.evenementService = employeService;
		this.evenements = evenements;
	}

	public void displayEvenement(Evenement empl)
	{
	this.setDateEvenement(empl.getDateEvenement());
	this.setDescription(empl.getDescription());
	this.setImage(empl.getImage());
	this.setLocalisation(empl.getLocalisation());
	this.setNbInteresses(empl.getNbInteresses());
	this.setNbParticipants(empl.getNbParticipants());
	this.setEmployeIdToBeUpdated(empl.getIdEvenement());
	this.setNombrePlace(empl.getNombrePlace());
         System.out.println(this.getEmployeIdToBeUpdated());
         System.out.println("test");

	}
	
	
	
	//Rechercher
	public void filterEvenements()
	{
		this.evenements = evenementService.searchEvenements(criteria);
		System.out.println(criteria);
	}
	
	//Modifier
	public void modifierEvenement(Evenement empl) throws IOException
	{
		
	
	this.setDateEvenement(empl.getDateEvenement());
	this.setDescription(empl.getDescription());
	this.setImage(empl.getImage());
	this.setLocalisation(empl.getLocalisation());
	this.setNbInteresses(empl.getNbInteresses());
	this.setNbParticipants(empl.getNbParticipants());
	this.setEmployeIdToBeUpdated(empl.getIdEvenement());
	this.setImage(empl.getImage());
    this.setNombrePlace(empl.getNombrePlace());
 
	}
	
	
	
	

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}


	public Date getDateEvenement() {
		return dateEvenement;
	}

	public void setEmployeIdToBeUpdated(Integer employeIdToBeUpdated) {
		this.employeIdToBeUpdated = employeIdToBeUpdated;
	}

	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}



	public Integer getEmployeIdToBeUpdated() {
		return employeIdToBeUpdated;
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



	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public int getNbParticipants() {
		return nbParticipants;
	}



	public void setNbParticipants(int nbParticipants) {
		this.nbParticipants = nbParticipants;
	}
	
     public String getCriteria() {
		return criteria;
	}


	public void setCriteria(String criteria) {
		this.criteria = criteria;
	}


	@PostConstruct
	public void init() {
		
		dateEvenement = new Date();

	}



}
