package bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.rowset.spi.SyncFactory;

import Service.CommentService;
import Service.RatingOffreService;
import model.Comment;
import model.Rating;
@ManagedBean(name="rating")
@SessionScoped
public class RatingOffreBean implements Serializable {

	private Rating rating =new Rating();
	
	private int nbrr ;
	@PersistenceContext
	 // I include this because you will need to // lookup your entities based on submitted values 
	private transient EntityManager em;
	
	@EJB
	private RatingOffreService ROS;
	
	
	
	public int getNbrr() {
		return nbrr;
	}
	public void setNbrr(int nbrr) {
		this.nbrr = nbrr;
	}
	
	public void addRating(int ido) {
		
		ROS.addRating(rating,ido,1);
		//comment =new Comment();
		System.out.println("aaaaaaaaaaaaaaajout");
	}
	
public int VerifRating(int ido) {
		
		return ROS.VerifRatingParId(ido,1);
	}

public int MoyenneRating(int ido) {
	
	return (int)ROS.MoyenneRatingParId(ido);
}



public Rating getRating() {
	return rating;
}

public void setRating(Rating rating) {
	this.rating = rating;
}

public EntityManager getEm() {
	return em;
}

public void setEm(EntityManager em) {
	this.em = em;
}

public RatingOffreService getROS() {
	return ROS;
}

public void setROS(RatingOffreService rOS) {
	ROS = rOS;
}
	
	
	
}
