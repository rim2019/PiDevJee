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

import Service.CommentPackService;
import Service.CommentService;
import Service.OffreService;
import model.Client;
import model.Comment;
import model.CommentPack;
import model.Offre;
import model.Pack;


@ManagedBean(name="commentPack")
@SessionScoped
public class CommentPackBean implements Serializable {
	
	//private Comment comment =new Comment();
	private CommentPack co =new CommentPack();
	@PersistenceContext
	private transient EntityManager em;
	int idC;
	Date date;
	String description;
	private Client client;
	private Pack Pack;
	private String desc;
	private List<CommentPack> comments;

	
	@EJB
	private CommentPackService CS;
	
	public void addComment() {
		LocalDate localdate;
		localdate=LocalDate.now();
		Date date = java.sql.Date.valueOf(localdate);
		co.setDate(date);
		CS.addCommentPack(co,1, 1);
		co =new CommentPack();
	}


	public void deleteCommentById(int idCommment) {

		CS.deleteCommentPackById(idCommment);
		
	}

	public List<CommentPack> findCommentsByPacks(int idOffre) {
	
		comments=CS.findCommentsByPacks(idOffre);
		return comments;
	}
	
	
	public void modifierComm(CommentPack comment)
	{
		this.setIdC(comment.getIdC());
		this.setDate(comment.getDate());
		this.setClient(comment.getClient());
		this.setPack(comment.getPack());		
		this.setDescription(comment.getDescription());
		
	}
	
//	public void DoUpdateComment(/*Comment d*/)
	/*{
		co.setDescription(desc);
	   CS.updateComment(co);	
	   System.out.println("modifier ");
	}
	
	public void DoFindCommentid(Comment c)
	{
		co = c;
	   System.out.println(co.getDescription());
	}

*/
	
	/*public Comment getComment() {
		return comment;
	}


	public void setComment(Comment comment) {
		this.comment = comment;
	}*/


	
	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		this.em = em;
	}
	public CommentPack getCo() {
		return co;
	}
	public void setCo(CommentPack co) {
		this.co = co;
	}
	public CommentPackService getCS() {
		return CS;
	}
	public void setCS(CommentPackService cS) {
		CS = cS;
	}
	public List<CommentPack> getComments() {
		return comments;
	}
	public void setComments(List<CommentPack> comments) {
		this.comments = comments;
	}


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

	public Pack getPack() {
		return Pack;
	}
	public void setPack(Pack pack) {
		Pack = pack;
	}
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	

}
