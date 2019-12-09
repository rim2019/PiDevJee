package Service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import RemoteService.ICommentService;
import RemoteService.IOffreService;
import model.Client;
import model.Comment;
import model.Offre;


@Stateless
@LocalBean

public class CommentService implements ICommentService {
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void addComment(Comment comment, int idOffre, int idClient) {
		Offre offre = em.find(Offre.class, idOffre);
		Client client = em.find(Client.class, idClient);
		
		em.persist(comment);
		comment.setOffre(offre);
		comment.setClient(client);
		
		
	}

	@Override
	public void deleteCommentById(int idComment) {
		Comment comment = em.find(Comment.class, idComment);
		em.remove(comment);
		
	}

	

	@Override
	public List<Comment> findCommentsByOffres(int idOffre) {
		Offre post = em.find(Offre.class, idOffre);
		Query query = em.createQuery("select c from Comment c where c.offre=:idOffre").setParameter("idOffre", post);
		
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
