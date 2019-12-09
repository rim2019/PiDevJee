package RemoteService;

import java.util.List;

import javax.ejb.Remote;

import model.Offre;
import model.Pack;
import model.Produit;



@Remote
public interface IPackService {


	List<Pack> getAllPacks();

	Pack findPackById(int id);

	Produit findProduitById(int id);

}
