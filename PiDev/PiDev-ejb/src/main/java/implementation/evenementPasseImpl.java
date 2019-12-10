package implementation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import Services.IServiceEvenementPasseRemote;

import model.EvenementPass;

@Stateless
@LocalBean
public class evenementPasseImpl  implements IServiceEvenementPasseRemote{
	@PersistenceContext
	EntityManager em;

	
	@Override
	public List<EvenementPass> getAllEvenementsPasse()
	{
		
		
		List<EvenementPass> emp = em.createQuery("Select e from EvenementPass e", EvenementPass.class).getResultList();
	   
		 return emp;
	}

	@Override
	public List<EvenementPass> getAllEvenementsComplet() {
		 List<EvenementPass> eveneComplet = new ArrayList();
		 List<EvenementPass> emp = em.createQuery("Select e from EvenementPass e", EvenementPass.class).getResultList();
		 
		 for (EvenementPass evenementPass : emp) {
			if(evenementPass.getDescription().equals("Complet"))
			{
				
				eveneComplet.add(evenementPass);
				
			}
		}
		 return eveneComplet;
		 
	}
	@Override
	public List<EvenementPass> getAllEvenementsAnnule() {
		 List<EvenementPass> eveneComplet = new ArrayList();
		 List<EvenementPass> emp = em.createQuery("Select e from EvenementPass e", EvenementPass.class).getResultList();
		 
		 for (EvenementPass evenementPass : emp) {
			if(evenementPass.getDescription().equals("Annule"))
			{
				
				eveneComplet.add(evenementPass);
				
			}
		}
		 return eveneComplet;
	}
	@Override
	public List<EvenementPass> getAllEvenementsReussi() {
		 List<EvenementPass> eveneComplet = new ArrayList();
		 List<EvenementPass> emp = em.createQuery("Select e from EvenementPass e", EvenementPass.class).getResultList();
		 
		 for (EvenementPass evenementPass : emp) {
			if(evenementPass.getDescription().equals("Effectue"))
			{
				
				eveneComplet.add(evenementPass);
				
			}
		}
		 return eveneComplet;
	}
	
	public static Comparator<EvenementPass> ComparatorParticip = new Comparator<EvenementPass>() {

		@Override
		public int compare(EvenementPass o1, EvenementPass o2) {
			// TODO Auto-generated method stub
			return (int) (o1.getNbParticipants()-o2.getNbParticipants());
		}
		
		
	};
	@Override
	public List<EvenementPass> getAllEvenementsTopMois() {
		 List<EvenementPass> eveneComplet = new ArrayList<EvenementPass>();
		 List<EvenementPass> eveneTop = new ArrayList<EvenementPass>();
		 List<EvenementPass> emp = em.createQuery("Select e from EvenementPass e", EvenementPass.class).getResultList();
		 
		 for (EvenementPass evenementPass : emp) {
			if(evenementPass.getDescription().equals("Effectue") || evenementPass.getDescription().equals("Complet") )
			{
				
				
				eveneComplet.add(evenementPass);
				
			}
		}
		 Collections.sort(eveneComplet,ComparatorParticip);
		EvenementPass i= eveneComplet.get(0);
		 
		 eveneTop.add(i );
		 
		 return eveneTop;
	}
	
	@Override
	public List<EvenementPass> getAllEvenementsBad() {
		 List<EvenementPass> eveneComplet = new ArrayList<EvenementPass>();
		 List<EvenementPass> eveneTop = new ArrayList<EvenementPass>();
		 List<EvenementPass> emp = em.createQuery("Select e from EvenementPass e", EvenementPass.class).getResultList();
		 
		 for (EvenementPass evenementPass : emp) {
			if(evenementPass.getDescription().equals("Effectue") || evenementPass.getDescription().equals("Complet") )
			{
				
				
				eveneComplet.add(evenementPass);
				
			}
		}
		 Collections.sort(eveneComplet,ComparatorParticip);
		EvenementPass i= eveneComplet.get(eveneComplet.size()-1);
		 
		 eveneTop.add(i );
		 
		 return eveneTop;
	}
}
