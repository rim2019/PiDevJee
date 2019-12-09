package service.implementation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Reclamation;
import services.interfaces.ReclamationServiceRemote;

@Stateless
@LocalBean
public class ReclamationService implements ReclamationServiceRemote {
	@PersistenceContext
	EntityManager em;


	@Override
	public List<Reclamation> getAllReclamations() {
		// TODO Auto-generated method stub
		List<Reclamation> cont = em.createQuery("Select e from Reclamation e",
				Reclamation.class).getResultList();
				return cont;
	}

}
