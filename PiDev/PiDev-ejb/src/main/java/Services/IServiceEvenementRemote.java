package Services;




import java.util.List;

import javax.ejb.Remote;


import model.Evenement;


@Remote
public interface IServiceEvenementRemote {


	
	public int ajouterEvenement(Evenement e);
	public void updateEvenement(Evenement e);
	public List<Evenement> getAllEvenements();
	public void deleteEvenementById(int employeId);

	public List<Evenement> searchEvenements(String criteria) ;
	public void affecterClientAEvenement(int clientId, int evenId) ;

	public void supprimerClientAEvenement(int clientId, int evenId) ;


}
