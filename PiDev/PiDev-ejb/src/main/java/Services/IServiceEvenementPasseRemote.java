package Services;

import java.util.List;

import javax.ejb.Remote;


import model.EvenementPass;

@Remote
public interface IServiceEvenementPasseRemote {

	public List<EvenementPass> getAllEvenementsPasse();

	public List<EvenementPass> getAllEvenementsComplet();
	

	public List<EvenementPass> getAllEvenementsAnnule();
	

	public List<EvenementPass> getAllEvenementsReussi();
	public List<EvenementPass> getAllEvenementsTopMois();
	public List<EvenementPass> getAllEvenementsBad();
}
