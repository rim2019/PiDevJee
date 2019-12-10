package implementation;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import Services.IServiceEvenementRemote;
import model.Client;
import model.Evenement;
import model.EvenementPass;








@Stateless
@LocalBean
public class evenementImpl implements IServiceEvenementRemote {
	@PersistenceContext
	EntityManager em;
	public static final String ACCOUNT_SID = "AC762aca95100b9519d73d662b5a03f98f";
	public static final String AUTH_TOKEN = "06d07a04d9cbc127efc3c44d27987c08";
	
	@Override
	public void affecterClientAEvenement(int clientId, int evenId) 
	{
		Client client = em.find(Client.class, clientId);
		Evenement even = em.find(Evenement.class, evenId);
		List <Client> lclient=even.getClients();
		List <Evenement> levenement=client.getEvenements();
		
		lclient.add(client);
		levenement.add(even);
		
		if (even.getDescription().equals("Disponible"))
		{
			
		    even.setNombrePlace(even.getNombrePlace()-1);
		    even.setNbParticipants(even.getNbParticipants()+1);
	
                  if(even.getNombrePlace()==0) 
                  {
			         String s="Complet";
			          even.setDescription(s);
			
                   }
       
       
            
		}

	
		even.setClients(lclient);
		client.setEvenements(levenement);
		
		if(even.getClients().isEmpty())
		{
			even.getClients().add(client);
			
		}else if( !even.getClients().contains(client) ){
			
			even.getClients().add(client);
		}

	}
	
	

	public int ajouterEvenementPasse(EvenementPass employe)
	{
		em.persist(employe);
		return employe.getIdEvenementPasse();
	}
	
	@Override
	public int ajouterEvenement(Evenement employe) {
		
	/*	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		Message message = Message

					
				.creator(new PhoneNumber("+21653026634"), new PhoneNumber("+19386669146"), "  Chère cliente, cher client on a un nouvel evenement pour vous  le  "
						+ employe.getDateEvenement() + "  a " + employe.getLocalisation() +" c'est un evenement " + employe.getImage()+" .Pour plus d'information visiter notre site Web opérateur.com ")
				.create();
			System.out.println(message.getSid());*/
		em.persist(employe);
		return employe.getIdEvenement();
	}
	


	public List<Evenement> getAllEvenementss()
	{
		
		
		List<Evenement> emp = em.createQuery("Select e from Evenement e", Evenement.class).getResultList();
	    List<Evenement> ev= new ArrayList<Evenement>();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");  
        Date date = new Date();  
           System.out.println(formatter.format(date));  
     
     
        for (Evenement evenement : emp)
        {
    	
            if (evenement.getDateEvenement().toString().equals(formatter.format(date) ))
               {	 System.out.println("Date Egal");
                      evenement.setDescription("Effectue");
                      ajouterEvenementPasse(new EvenementPass(evenement.getDateEvenement(),evenement.getDescription(),evenement.getImage(), evenement.getLocalisation(),
 			        	evenement.getNbInteresses(),evenement.getNbParticipants(),evenement.getNombrePlace()));
         
 
               }
    

           if(-date.getDate()+evenement.getDateEvenement().getDate()==1 && (evenement.getNbParticipants()<evenement.getNombrePlace()))
                {
        	        evenement.setDescription("annule");
        	
        	    }
           
	    }

		 return emp;
	}
	

	@Override
	public List<Evenement> getAllEvenements()
	{
		
		List<Evenement> emp = em.createQuery("Select e from Evenement e", Evenement.class).getResultList();
	    List<Evenement> ev= new ArrayList<Evenement>();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyy-MM-dd");  
        Date date = new Date();  
           System.out.println(formatter.format(date));  
     
     
        for (Evenement evenement : emp)
        {
    	
            if (evenement.getDateEvenement().toString().equals(formatter.format(date) ))
               {	 System.out.println("Date Egal");
                      ajouterEvenementPasse(new EvenementPass(evenement.getDateEvenement(),evenement.getDescription(),evenement.getImage(), evenement.getLocalisation(),
 			        	evenement.getNbInteresses(),evenement.getNbParticipants(),evenement.getNombrePlace()));
         
 
               }
    

           if(-date.getDate()+evenement.getDateEvenement().getDate()==1 && (evenement.getNbParticipants()<evenement.getNombrePlace()))
                {
        	        evenement.setDescription("annule");
        	
        	    }
           
	    }

		 return emp;
	}
	
	
	
	@Override
	public void updateEvenement(Evenement e)
	{
		Evenement emp = em.find(Evenement.class, e.getIdEvenement()); 
		emp.setImage(e.getImage());
		emp.setDescription(e.getDescription()); 
		emp.setLocalisation(e.getLocalisation()); 
		emp.setNbInteresses(e.getNbInteresses()); 
		emp.setNbParticipants(e.getNbParticipants()); 
	
		emp.setNombrePlace(e.getNombrePlace()); 
	}



	
	
	
	@Override
	public List<Evenement> searchEvenements(String criteria) {
		return em.createQuery("Select e from Evenement e where description like '%"+criteria+"%'",Evenement.class).getResultList();
	}
		
	@Override
	public void deleteEvenementById(int evenementId)
	{
		Evenement evenement = em.find(Evenement.class, evenementId);
		

		em.remove(evenement);
	}
	@Override
	public void supprimerClientAEvenement(int clientId, int evenId) 
	{
		
	      
		Client client = em.find(Client.class, clientId);
		Evenement even = em.find(Evenement.class, evenId);
		List <Client> lclient=even.getClients();
		List <Evenement> levenement=client.getEvenements();
		even.setNbParticipants(even.getNbParticipants()-1);
		even.setNombrePlace(even.getNombrePlace()+1);
		lclient.remove(client);
		levenement.remove(even);
		


	
		even.setClients(lclient);
		client.setEvenements(levenement);
		
		if(even.getClients().isEmpty())
		{
			even.getClients().add(client);
			
		}else if( !even.getClients().contains(client) ){
			
			even.getClients().add(client);
		}

	}
}
