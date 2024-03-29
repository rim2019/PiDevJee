package Service;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import RemoteService.IRatingOffreService;
import model.Client;

import model.Offre;
import model.Rating;


@Stateless
@LocalBean

public class RatingOffreService implements IRatingOffreService {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addRating(Rating rating,int idOffre, int idClient) {
		Rating r = new Rating();
		
		Offre offre = em.find(Offre.class, idOffre);
		Client client = em.find(Client.class, idClient);
		r.setOffre(offre);
		r.setClient(client);
		r.setNbr(rating.getNbr());
		em.persist(r);
		
	}
	
	@Override
	public int VerifRatingParId(int idOffre, int idClient) {
		Offre offre = em.find(Offre.class, idOffre);
		Client client = em.find(Client.class, idClient);
		List<Rating>emp = em.createQuery("select r from Rating r", Rating.class).getResultList();
	
		for (Rating rating : emp) {
			if (rating.getOffre().getIdOffresProduit()==idOffre && rating.getClient().getClientId() == idClient)
				return rating.getNbr();
		}
		
		return 0;
		
	}
	
	@Override
	public float MoyenneRatingParId(int idOffre) {
		Offre offre = em.find(Offre.class, idOffre);
		List<Rating>emp = em.createQuery("select r from Rating r where r.offre.idOffresProduit="+idOffre, Rating.class)
				.getResultList();
	
		int x = 0;
		int nbr = 0;
		for (Rating rating : emp) {
			nbr++;
			x = x + rating.getNbr();
		}
		
		return x/nbr;
		
	}
	
		

}
