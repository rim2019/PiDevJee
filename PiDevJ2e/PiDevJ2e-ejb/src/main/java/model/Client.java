package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Clients database table.
 * 
 */
@Entity
@Table(name="Clients")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ClientId")
	private int clientId;

	@Column(name="AdresseClient")
	private String adresseClient;

	@Column(name="AgeClient")
	private String ageClient;

	@Column(name="EmailClient")
	private String emailClient;

	//private int idQ;

	@Column(name="NomClient")
	private String nomClient;

	@Column(name="NumeroClient")
	private String numeroClient;

	@Column(name="RoleClient")
	private String roleClient;

	@Column(name="TypeClient")
	private String typeClient;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="client")
	private List<Comment> comments;

	//bi-directional many-to-one association to CommentPack
	@OneToMany(mappedBy="client")
	private List<CommentPack> commentPacks;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="client")
	private List<Rating> ratings;

	//bi-directional many-to-one association to RatingPack
	@OneToMany(mappedBy="client")
	private List<RatingPack> ratingPacks;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getAdresseClient() {
		return this.adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public String getAgeClient() {
		return this.ageClient;
	}

	public void setAgeClient(String ageClient) {
		this.ageClient = ageClient;
	}

	public String getEmailClient() {
		return this.emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	/*public int getIdQ() {
		return this.idQ;
	}

	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}*/

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getNumeroClient() {
		return this.numeroClient;
	}

	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}

	public String getRoleClient() {
		return this.roleClient;
	}

	public void setRoleClient(String roleClient) {
		this.roleClient = roleClient;
	}

	public String getTypeClient() {
		return this.typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setClient(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setClient(null);

		return comment;
	}

	public List<CommentPack> getCommentPacks() {
		return this.commentPacks;
	}

	public void setCommentPacks(List<CommentPack> commentPacks) {
		this.commentPacks = commentPacks;
	}

	public CommentPack addCommentPack(CommentPack commentPack) {
		getCommentPacks().add(commentPack);
		commentPack.setClient(this);

		return commentPack;
	}

	public CommentPack removeCommentPack(CommentPack commentPack) {
		getCommentPacks().remove(commentPack);
		commentPack.setClient(null);

		return commentPack;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setClient(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setClient(null);

		return rating;
	}

	public List<RatingPack> getRatingPacks() {
		return this.ratingPacks;
	}

	public void setRatingPacks(List<RatingPack> ratingPacks) {
		this.ratingPacks = ratingPacks;
	}

	public RatingPack addRatingPack(RatingPack ratingPack) {
		getRatingPacks().add(ratingPack);
		ratingPack.setClient(this);

		return ratingPack;
	}

	public RatingPack removeRatingPack(RatingPack ratingPack) {
		getRatingPacks().remove(ratingPack);
		ratingPack.setClient(null);

		return ratingPack;
	}

}