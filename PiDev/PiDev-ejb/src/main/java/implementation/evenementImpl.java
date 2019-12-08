package implementation;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Services.IServiceEvenementRemote;
import model.Client;
import model.Evenement;








@Stateless
@LocalBean
public class evenementImpl implements IServiceEvenementRemote {
	@PersistenceContext
	EntityManager em;

	
	
	public void affecterClientAEvenement(int clientId, int evenId) {
		Client client = em.find(Client.class, clientId);
		Evenement even = em.find(Evenement.class, evenId);
		List <Client> lclient=even.getClients();
		List <Evenement> levenement=client.getEvenements();
		
		lclient.add(client);
		levenement.add(even);
		
		if (even.getDescription().equals("dispo")) {
			
		even.setNombrePlace(even.getNombrePlace()-1);
		even.setNbParticipants(even.getNbParticipants()+1);
	
         if(even.getNombrePlace()==0) {
			  String s="Complet";
			   even.setDescription(s);
			
		}
       
         SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");  
         Date date = new Date();  
         System.out.println(formatter.format(date));  
         System.out.println(even.getDateEvenement().toString());
         if (even.getDateEvenement().toString().equals(formatter.format(date) ))
        		 System.out.println("Date Egal");
         else  System.out.println("Date inegal");
		}

		//even.set(even.getNombrePlace()-1);
		even.setClients(lclient);
		client.setEvenements(levenement);
		
		
		
		if(even.getClients().isEmpty())
		{
			even.getClients().add(client);
			
		}else if( !even.getClients().contains(client) ){
			
			even.getClients().add(client);
		}

	}
	@Override
	public int ajouterEvenement(Evenement employe) {
		em.persist(employe);
		return employe.getIdEvenement();
	}
	public int ajouterEmploye(Evenement employe) {
		em.persist(employe);
		return employe.getIdEvenement();
	}
	
	public List<Evenement> recherche(String x) {
		
		List<Evenement> emp = em.createQuery("Select e from Evenement e", Evenement.class).getResultList();
		List<Evenement> ev= new ArrayList<Evenement>();
		
		
		for (Evenement eve : emp) {
			if(eve.getDescription()==x)
			{ev.add(eve);
				return ev;}
		
			
			
			
		}
		 return emp;
		
	}
	
	

	@Override
	public List<Evenement> getAllEvenements() {
		
		
		List<Evenement> emp = em.createQuery("Select e from Evenement e", Evenement.class).getResultList();
	List<Evenement> ev= new ArrayList<Evenement>();
	 SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");  
     Date date = new Date();  
     System.out.println(formatter.format(date));  
     
     
     for (Evenement evenement : emp) {
    	 System.out.println(evenement.getDateEvenement().toString());
         if (evenement.getDateEvenement().toString().equals(formatter.format(date) ))
        		 System.out.println("Date Egal");
         else  System.out.println("Date inegal");
	}
   
		
	/*	for (Evenement eve : emp) {
			if(eve.getDescription()==x)
			{ev.add(eve);
				return ev;}
		
			
			
			
		}*/
		 return emp;	}
	@Override
	public void updateEvenement(Evenement e) {
		Evenement emp = em.find(Evenement.class, e.getIdEvenement()); 
		emp.setDescription(e.getDescription()); 
		emp.setLocalisation(e.getLocalisation()); 
		emp.setNbInteresses(e.getNbInteresses()); 
		emp.setNbParticipants(e.getNbParticipants()); 
	
		
	}



	@Override
	public void supprimerEvenement(Evenement e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteEvenementById(int evenementId) {
		Evenement evenement = em.find(Evenement.class, evenementId);
		
		//Desaffecter l'employe de tous les departements
		//c'est le bout master qui permet de mettre a jour
		//la table d'association
		/*for(Departement dep : employe.getDepartements()){
			dep.getEmployes().remove(employe);
		}
		*/
		em.remove(evenement);
	}

}
