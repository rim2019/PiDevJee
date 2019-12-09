package RemoteService;

import java.util.List;

import javax.ejb.Remote;

import model.Comment;
import model.CommentPack;
import model.Offre;



@Remote
public interface ICommentPackService {

	void addCommentPack(CommentPack comment, int idPost, int idUser);

	void deleteCommentPackById(int idComment);

	List<CommentPack> findCommentsByPacks(int idOffre);

	void updateComment(Comment comment);

	Comment findCommentById(int id);

	

}
