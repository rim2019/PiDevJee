package implementation;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Services.IServiceClientRemote;
//import Services.IServiceEvenementRemote;
import model.Client;
import model.Evenement;

@Stateless
@LocalBean
public class ClientImpl implements IServiceClientRemote  {
	@PersistenceContext
	EntityManager em;
	 
	@Override
	public void affecterClientAEvenement(int clientId, int evenId) {
		Client client = em.find(Client.class, clientId);
		Evenement even = em.find(Evenement.class, evenId);
		List <Client> lclient=even.getClients();
		List <Evenement> levenement=client.getEvenements();
		
		lclient.add(client);
		levenement.add(even);
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
