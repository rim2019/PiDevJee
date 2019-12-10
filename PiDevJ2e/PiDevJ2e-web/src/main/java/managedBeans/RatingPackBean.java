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
import Service.RatingPackService;
import model.Comment;
import model.Rating;
import model.RatingPack;
@ManagedBean(name="ratingPack")
@SessionScoped
public class RatingPackBean implements Serializable {

	private RatingPack rating =new RatingPack();
	
	private int nbrr ;
	@PersistenceContext
	 // I include this because you will need to // lookup your entities based on submitted values 
	private transient EntityManager em;
	
	@EJB
	private RatingPackService ROS;
	
	
	
	public int getNbrr() {
		return nbrr;
	}
	public void setNbrr(int nbrr) {
		this.nbrr = nbrr;
	}
	
	public void addRating(int ido) {
		
		ROS.addRatingPack(rating,ido,1);
		//comment =new Comment();
		System.out.println("aaaaaaaaaaaaaaajout");
	}
	
public int VerifRating(int ido) {
		
		return ROS.VerifRatingParId(ido,1);
	}

public RatingPack getRating() {
	return rating;
}

public void setRating(RatingPack rating) {
	this.rating = rating;
}

public EntityManager getEm() {
	return em;
}

public void setEm(EntityManager em) {
	this.em = em;
}

public RatingPackService getROS() {
	return ROS;
}

public void setROS(RatingPackService rOS) {
	ROS = rOS;
}
	
	
	
}
