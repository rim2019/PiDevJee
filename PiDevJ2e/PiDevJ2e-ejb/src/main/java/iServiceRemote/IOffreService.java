package RemoteService;

import java.util.List;

import javax.ejb.Remote;

import model.Offre;



@Remote
public interface IOffreService {

	List<Offre> getAllOffres();

	Offre findOffreById(int id);

	long getNombreRequestJPQL();

	long getNombreRequestMusJPQL();

	long getNombreRequestTheJPQL();

	long getNombreRequestLitJPQL();

	long getPoureRequestJPQL();

}
