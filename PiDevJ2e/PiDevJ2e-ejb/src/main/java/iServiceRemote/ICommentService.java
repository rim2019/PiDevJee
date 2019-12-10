package RemoteService;

import java.util.List;

import javax.ejb.Remote;

import model.Comment;
import model.Offre;



@Remote
public interface ICommentService {

	void addComment(Comment comment, int idPost, int idUser);

	void deleteCommentById(int idComment);

	List<Comment> findCommentsByOffres(int idOffre);

	void updateComment(Comment comment);

	Comment findCommentById(int id);

	

}
