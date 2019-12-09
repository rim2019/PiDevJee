package RemoteService;

import java.util.List;

import javax.ejb.Remote;

import model.Comment;
import model.Offre;
import model.Rating;



@Remote
public interface IRatingOffreService {

	void addRating(Rating rating, int idOffre, int idClient);

	int VerifRatingParId(int idOffre, int idClient);

	float MoyenneRatingParId(int idOffre);

	
	

}
