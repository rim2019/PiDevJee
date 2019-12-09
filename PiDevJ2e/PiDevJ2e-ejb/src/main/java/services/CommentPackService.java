package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import RemoteService.ICommentPackService;
import RemoteService.ICommentService;
import RemoteService.IOffreService;
import model.Client;
import model.Comment;
import model.CommentPack;
import model.Offre;
import model.Pack;


@Stateless
@LocalBean

public class CommentPackService implements ICommentPackService {
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void addCommentPack(CommentPack comment, int idPack, int idClient) {
		Pack pack = em.find(Pack.class, idPack);
		Client client = em.find(Client.class, idClient);
		
		em.persist(comment);
		comment.setPack(pack);
		comment.setClient(client);
		
		
	}

	@Override
	public void deleteCommentPackById(int idComment) {
		CommentPack commentPack = em.find(CommentPack.class, idComment);
		em.remove(commentPack);
		
	}

	

	@Override
	public List<CommentPack> findCommentsByPacks(int idPack) {
		Pack post = em.find(Pack.class, idPack);
		Query query = em.createQuery("SELECT c FROM CommentPack c where c.pack=:idPack").setParameter("idPack", post);
		
		return query.getResultList();
	}
	
	@Override
	public void updateComment(Comment comment) {
		System.out.println("modifier");
		
		//Comment co = new Comment();
		//co = em.find(Comment.class, comment.getIdC());
		//co.setDescription(comment.getDescription());
		//co=comment;
		//em.merge(co);
		
		em.merge(comment);
		
	}
	
	@Override
	public Comment findCommentById(int id) {
		Comment off = new Comment();

		off = em.find(Comment.class, id);
        System.out.println(off);
		return off;

	}
	
	
	

	

}
