package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import RemoteService.IOffreService;
import RemoteService.IPackService;
import RemoteService.IProduitService;
import model.Comment;
import model.Offre;
import model.Pack;
import model.Produit;

@Stateless
@LocalBean
public class ProduitService implements IProduitService {

	
	
	@PersistenceContext
	EntityManager em;
	
	
	
		
	@Override
	public List<Produit> findProduitById(int id) {
		
		//pack = em.find(Offre.class, id);
		TypedQuery<Produit> query = em.createQuery("SELECT p FROM Produit p "+
		"INNER JOIN  PackProduits pt ON p.idProduit = pt.Produit_IdProduit "+
		"INNER JOIN  Pack t ON pt.Pack_IdPackProduit = t.idPackProduit WHERE  t.idPackProduit=1"  
				, Produit.class);

		List<Produit> results=query.getResultList();

	//	return emp.setParameter();
     
		return results;

	}
	
	
	
}
