package Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import RemoteService.ICommentService;
import RemoteService.IOffreService;
import RemoteService.IQuizService;
import model.Client;
import model.Comment;
import model.Offre;
import model.Quiz;


@Stateless
@LocalBean

public class QuizService implements IQuizService {
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public void addQuiz(Quiz quiz) {
		
		em.persist(quiz);
		
		
	}

	@Override
	public void deleteQuizById(int idQuiz) {
		Quiz quiz = em.find(Quiz.class, idQuiz);
		em.remove(quiz);
		
	}

	

	@Override
	public List<Quiz> getQuiz() {
    	
    	TypedQuery<Quiz> jpql = em.createQuery("select q from Quiz q", Quiz.class);
		List<Quiz> results = jpql.getResultList();
		return results;

	}
	
	
	  @Override
		public void updateQuiz(Quiz q) {
		  Quiz qu = em.find(Quiz.class,q.getIdQ());
			qu = q;
			em.merge(qu);

		}
	  @Override
		public List<Quiz> findCommentById() {
		 
		  List<Quiz> LQ = new ArrayList<Quiz>();
			
		  
		  for (int i = 0 ; i <3 ; i++)
		  {
			  int randomInt = ThreadLocalRandom.current().nextInt(8, 14);System.out.println(randomInt);
				TypedQuery<Quiz> jpql = em.createQuery("select q from Quiz q WHERE id = :id", Quiz.class).setParameter("id", randomInt);
				  LQ.add(jpql.getSingleResult());
		  }
		  
			
			
			
			
			return LQ;

		}

}
