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

	private String image;

	private String localisation;

	private int nbInteresses;

	private int nbParticipants;
	private int clientId;
	private Integer employeIdToBeUpdated;
	private Part img;
	private int nombrePlace;
	@EJB
	evenementImpl employeService;
	@EJB
	ClientImpl clientService;
	
public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}

public void upload() throws IOException {
	
	InputStream in =img.getInputStream();
	File f = new File("C:\\Users\\Sarra\\Desktop\\upload"+img.getSubmittedFileName());
	f.createNewFile();
	FileOutputStream out = new FileOutputStream(f);

	System.out.println("image"+f.getPath());
	this.setImage(f.getPath());
	out.close();
	
}
	
	public void addEvenement() throws IOException {
		
	
		//SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		employeService.ajouterEmploye(new Evenement(dateEvenement,description,image, localisation,
				nbInteresses,nbParticipants,nombrePlace));
		}
public void recherche() {
	
	
}
	public void participerEvenement(){
		
		
		//SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.setNbParticipants(this.getNbParticipants()+1);
		employeService.updateEvenement(new Evenement(dateEvenement,description,image, localisation,
				nbInteresses,nbParticipants,nombrePlace));
		}
	
	
	private List<Evenement> evenements;

	public List<Evenement> getEvenements() {
		
	
	evenements = employeService.getAllEvenements();
	
	return evenements;
	}
	
	
	public void affecter(int evenementId) {
		
	int Clientid=1;
	//int evenementId;
	employeService.affecterClientAEvenement(Clientid,evenementId);
	}
	
	
	public void removeEvenement(int evenementId)
	{
	employeService.deleteEvenementById(evenementId);
	}
    public EvenementBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	







	public EvenementBean(Date dateEvenement, String description, String image, String localisation, int nbInteresses,
			int nbParticipants, Integer employeIdToBeUpdated, Part img, int nombrePlace, evenementImpl employeService,
			List<Evenement> evenements)
	{
		super();
		this.dateEvenement = dateEvenement;
		this.description = description;
		this.image = image;
		this.localisation = localisation;
		this.nbInteresses = nbInteresses;
		this.nbParticipants = nbParticipants;
		this.employeIdToBeUpdated = employeIdToBeUpdated;
		this.img = img;
		this.nombrePlace = nombrePlace;
		this.employeService = employeService;
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
	
	
	
	
	public void updateEvenement() throws IOException
	
	{ 
		InputStream in =img.getInputStream();
		File f = new File("C:\\Users\\Sarra\\Desktop\\upload"+img.getSubmittedFileName());
		f.createNewFile();
		FileOutputStream out = new FileOutputStream(f);
		
		
		System.out.println("image"+f.getPath());
		this.setImage(f.getPath());
		out.close();
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		employeService.updateEvenement(new Evenement(employeIdToBeUpdated,dateEvenement,description,image, localisation,
			nbInteresses,nbParticipants,nombrePlace )); }
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



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}




	public String getLocalisation() {
		return localisation;
	}



	public void setLocalisation(String localisation) {
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
     @PostConstruct
	public void init() {
		
		dateEvenement = new Date();

	}



}
