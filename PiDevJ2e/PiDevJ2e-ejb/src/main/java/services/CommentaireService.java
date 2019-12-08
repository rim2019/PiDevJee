package Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import model.Blogs;
import model.Client;
import model.CommentaireForum;





@Stateless
@LocalBean
public class CommentaireService {
	@PersistenceContext
	EntityManager em;
	int tentatives =0;
	public void AddComment(CommentaireForum c)
	{
		
		Blogs b =em.find(Blogs.class,c.getIdPubComment());
		int  id=b.getIdForum();
		 c.setIdPubComment(id);
		Date date=new Date();
		c.setDateComment(date);
		 TypedQuery<String> query = em.createQuery("SELECT b.wordBadword FROM Badword b",String.class);
		 List<String>ls=new ArrayList<>();
		 ls=query.getResultList();
		 System.out.println(ls);
		 String cc=c.getCommentBody();
		 String[] splited = cc.split("\\s+");
		 Boolean  bb=false;
		 for (int x=0; x<splited.length; x++){
             for (int i=0;i<ls.size();i++){
                 if (ls.get(i).equals(splited[x])){
                 bb=true;
                 tentatives++;
                if(tentatives==3)
                {
               	 System.out.println("rawaaaa7 ");
               	 try {
   					TimeUnit.MINUTES.sleep(1);
   				} catch (InterruptedException e) {
   					// TODO Auto-generated catch block
   					e.printStackTrace();
   				}
                }
                break;
                 }}}
		 if(bb==false)
		 {
			 LocalDate today = LocalDate.now();
			 LocalDate another = LocalDate.of(2020,01,10);
			 if(today.compareTo(another)==0) {
				 System.out.println("kifkif"); 
			 
			 TypedQuery<Integer> query1=em.createQuery("SELECT c.clientId FROM Client c",Integer.class);
				Random randomGenerator=new Random();
				
				 List<Integer>lc=new ArrayList<>();
				 lc=query1.getResultList();
				 System.out.println(lc);
				int index = randomGenerator.nextInt(lc.size());
					 int winner=lc.get(index);
					 System.out.println(winner);
					 Query query3  =em.createQuery("update Client c set c.pointsClient=c.pointsClient+10 where c.clientId=:id");
					 query3.setParameter("id",winner); 
					 int modified = query3.executeUpdate();
					 
			 }
			 em.persist(c);	
		 }else {
			
			
		}
	}
	public List<CommentaireForum> getComBlog(int id) {
		TypedQuery<CommentaireForum> query=em.createQuery("SELECT c FROM CommentaireForum c WHERE c.idPubComment=:id",CommentaireForum.class);
		query.setParameter("id",id);
		return query.getResultList();
	}
	
	public void DeleteComment(int id)
	{
		CommentaireForum cf=em.find(CommentaireForum.class,id);
	em.remove(cf);
	}
	
}
