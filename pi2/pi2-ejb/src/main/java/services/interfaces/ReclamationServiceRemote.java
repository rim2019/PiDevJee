package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import model.Reclamation;


@Remote
public interface ReclamationServiceRemote {
	public List<Reclamation> getAllReclamations();
}
