package RemoteService;

import java.util.List;

import javax.ejb.Remote;

import model.Comment;
import model.Offre;
import model.Rating;
import model.RatingPack;



@Remote
public interface IRatingPackService {

	void addRatingPack(RatingPack rating, int idOffre, int idClient);

	int VerifRatingParId(int idPack, int idClient);

		

}
