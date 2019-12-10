package RemoteService;

import java.util.List;

import javax.ejb.Remote;

import model.Offre;
import model.Pack;
import model.Produit;



@Remote
public interface IProduitService {


	
	List<Produit> findProduitById(int id);

}
