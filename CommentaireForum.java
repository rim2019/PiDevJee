package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the CommentaireForums database table.
 * 
 */
@Entity
@Table(name="CommentaireForums")
@NamedQuery(name="CommentaireForum.findAll", query="SELECT c FROM CommentaireForum c")
public class CommentaireForum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCommentaire")
	private int idCommentaire;

	@Column(name="CommentBody")
	private String commentBody;

	@Column(name="DateComment")
	private Date dateComment;

	@Column(name="IdPubComment")
	private int idPubComment;

	@Column(name="UsernameComment")
	private String usernameComment;

	public CommentaireForum() {
	}

	public int getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getCommentBody() {
		return this.commentBody;
	}

	public void setCommentBody(String commentBody) {
		this.commentBody = commentBody;
	}

	public Date getDateComment() {
		return this.dateComment;
	}

	public void setDateComment(Date dateComment) {
		this.dateComment = dateComment;
	}

	public int getIdPubComment() {
		return this.idPubComment;
	}

	public void setIdPubComment(int idPubComment) {
		this.idPubComment = idPubComment;
	}

	public String getUsernameComment() {
		return this.usernameComment;
	}

	public void setUsernameComment(String usernameComment) {
		this.usernameComment = usernameComment;
	}

	public CommentaireForum(String commentBody, Date dateComment, int idPubComment, String usernameComment) {
		
		this.commentBody = commentBody;
		this.dateComment = dateComment;
		this.idPubComment = idPubComment;
		this.usernameComment = usernameComment;
	}
	

}