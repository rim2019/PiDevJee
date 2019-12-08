package Services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Blogs;





@Stateless
@LocalBean
public class ForumService {
	@PersistenceContext
	EntityManager em;
	
	public void ajouterPublication(Blogs forum) {
		Date date = new Date(); 
		forum.setDateforum(date);
		em.persist(forum);
		
	}
	
public List<Blogs> getAllPub() {
		
		TypedQuery<Blogs> query=em.createQuery("SELECT b FROM Blogs b",Blogs.class);
		return query.getResultList();
		
	}
	
}
