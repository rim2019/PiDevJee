package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import RemoteService.IOffreService;
import RemoteService.IPackService;
import model.Comment;
import model.Offre;
import model.Pack;
import model.Produit;

@Stateless
@LocalBean
public class PackService implements IPackService {

	
	
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public List<Pack> getAllPacks() {
		List<Pack> emp = em.createQuery("SELECT p FROM Pack p ", Pack.class).getResultList();
		return emp;
	}
		
	@Override
	public Pack findPackById(int id) {
		Pack pack = null;

		//pack = em.find(Offre.class, id);
		 pack = em.createQuery("SELECT p FROM Pack p where p.idPackProduit="+id, Pack.class).getSingleResult();

	//	return emp.setParameter();
		return pack;

		
	}
	
	@Override
	public Produit findProduitById(int id) {
		Produit produit = new Produit();

		produit = em.find(Produit.class, id);
		//List<Produit> emp = em.createQuery("SELECT * FROM Produit p  WHERE p.idProduit =1"  
			//	, Produit.class).getResultList();

	
		return produit;

	}
	
	

	
}
