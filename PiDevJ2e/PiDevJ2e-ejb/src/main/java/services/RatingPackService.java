package Service;



import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



import RemoteService.IRatingOffreService;
import RemoteService.IRatingPackService;
import model.Client;

import model.Offre;
import model.Pack;
import model.Rating;
import model.RatingPack;


@Stateless
@LocalBean

public class RatingPackService implements IRatingPackService {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addRatingPack(RatingPack rating,int idPack, int idClient) {
		RatingPack r = new RatingPack();
		
		Pack pack = em.find(Pack.class, idPack);
		Client client = em.find(Client.class, idClient);
		r.setPack(pack);
		r.setClient(client);
		r.setNbr(rating.getNbr());
		em.persist(r);
		
	}
	
	@Override
	public int VerifRatingParId(int idPack, int idClient) {
		Pack offre = em.find(Pack.class, idPack);
		Client client = em.find(Client.class, idClient);
		List<RatingPack>emp = em.createQuery("SELECT r FROM RatingPack r", RatingPack.class).getResultList();
	
		for (RatingPack rating : emp) {
			if (rating.getPack().getIdPackProduit()==idPack && rating.getClient().getClientId() == idClient)
				return rating.getNbr();
		}
		
		return 0;
		
	}
	
		

}
