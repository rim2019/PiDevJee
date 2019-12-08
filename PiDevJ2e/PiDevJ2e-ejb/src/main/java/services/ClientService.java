package Services;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Client;


@Stateless
@LocalBean
public class ClientService {

	@PersistenceContext
	EntityManager em;
	
	public void Spins()
	{
		TypedQuery<String> query=em.createQuery("SELECT c.nomClient FROM Client c",String.class);
		// Random randomGenerator=new Random();
		
		 List<String>lc=new ArrayList<>();
		 lc=query.getResultList();
		 System.out.println(lc);
		// int index = randomGenerator.nextInt(query.getResultList().size());
		// Client winner=query.getResultList().get(index);
		// System.out.println(winner.getNomClient());
	}
	
	
	
}
