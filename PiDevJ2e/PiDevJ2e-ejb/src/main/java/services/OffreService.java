package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import RemoteService.IOffreService;
import model.Comment;
import model.Offre;

@Stateless
@LocalBean
public class OffreService implements IOffreService {

	
	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<Offre> getAllOffres() {
		List<Offre> emp = em.createQuery("SELECT o FROM Offre o ", Offre.class).getResultList();
		return emp;
	}
	
	@Override
	public Offre findOffreById(int id) {
		Offre off = new Offre();

		off = em.find(Offre.class, id);
        System.out.println(off);
		return off;

	}
	@Override
	public long getNombreRequestJPQL() {
		
		  TypedQuery<Long> query = em.createQuery(
			   "SELECT COUNT(d) FROM Offre  d where d.pourcentageDeReduction <=15", Long.class);
			  long results =query.getSingleResult();
			  return results;
	}
	@Override
	public long getNombreRequestMusJPQL() {
		
		  TypedQuery<Long> query = em.createQuery(
			   "SELECT COUNT(d) FROM Offre  d where d.pourcentageDeReduction <=40", Long.class);
			  long results =query.getSingleResult();
			  return results;
	}
	@Override
	public long getNombreRequestTheJPQL() {
		
		  TypedQuery<Long> query = em.createQuery(
			   "SELECT COUNT(d) FROM Offre  d where d.pourcentageDeReduction <=64", Long.class);
			  long results =query.getSingleResult();
			  return results;
	}
	@Override
	public long getNombreRequestLitJPQL() {
		
		  TypedQuery<Long> query = em.createQuery(
			   "SELECT COUNT(d) FROM Offre  d where d.pourcentageDeReduction >65", Long.class);
			  long results =query.getSingleResult();
			  return results;
	}
	@Override
	public long getPoureRequestJPQL() {
		
		  TypedQuery<Long> query = em.createQuery(
			   "SELECT COUNT(d) FROM Offre  d ", Long.class);
			  long results =query.getSingleResult();
			  return results;
	}
	
	
	
	
	

	
}
