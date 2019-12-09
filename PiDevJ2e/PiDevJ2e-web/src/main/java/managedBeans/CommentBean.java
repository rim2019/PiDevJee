package bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.QueryParam;

import Service.CommentService;
import Service.OffreService;
import model.Client;
import model.Comment;
import model.Offre;


@ManagedBean(name="comment")
@SessionScoped
public class CommentBean implements Serializable {
	
	private Comment comment =new Comment();
	private Comment co =new Comment();
	@PersistenceContext
	 // I include this because you will need to // lookup your entities based on submitted values 
	private transient EntityManager em;
	int idC;
	Date date;
	String description;
	private Client client;
	private Offre offre;
	private String desc;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	public int getIdC() {
		return idC;
	}


	public void setIdC(int idC) {
		this.idC = idC;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Offre getOffre() {
		return offre;
	}


	public void setOffre(Offre offre) {
		this.offre = offre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@EJB
	private CommentService CS;
	
	public void addComment() {
		System.out.println("aaaaaaaa");
		LocalDate localdate;
		localdate=LocalDate.now();
		Date date = java.sql.Date.valueOf(localdate);
		comment.setDate(date);
		CS.addComment(comment,1, 1);
		comment =new Comment();
	}


	public void deleteCommentById(int idCommment) {
		System.out.println("aaaaaaaa");System.out.println("aaaaaaaa");System.out.println("aaaaaaaa");
		CS.deleteCommentById(idCommment);
		
	}

	private List<Comment> comments;
	public List<Comment> findCommentsByOffres(int idOffre) {
	
		comments=CS.findCommentsByOffres(idOffre);
		return comments;
	}
	
	
	public void modifierComm(Comment comment)
	{
		this.setIdC(comment.getIdC());
		this.setDate(comment.getDate());
		this.setClient(comment.getClient());
		this.setOffre(comment.getOffre());		
		this.setDescription(comment.getDescription());
		
	}
	
	public void DoUpdateComment(/*Comment d*/)
	{
		co.setDescription(desc);
	   CS.updateComment(co);	
	   System.out.println("modifier ");
	}
	
	public void DoFindCommentid(Comment c)
	{
		co = c;
	   System.out.println(co.getDescription());
	}


	
	public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}


	public CommentService getCS() {
		return CS;
	}


	public void setCS(CommentService cS) {
		CS = cS;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}


	public Comment getCo() {
		return co;
	}


	public void setCo(Comment co) {
		this.co = co;
	}
	
	
	
	
	
	

}
