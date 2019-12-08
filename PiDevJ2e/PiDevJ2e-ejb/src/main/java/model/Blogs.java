package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Blogs database table.
 * 
 */
@Entity
@NamedQuery(name="Blogs.findAll", query="SELECT b FROM Blogs b")
public class Blogs implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdForum")
	private int idForum;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Dateforum")
	private Date dateforum;

	@Column(name="DescriptionForum")
	private String descriptionForum;

	@Column(name="SujetForum")
	private String sujetForum;

	@Column(name="UsernameForum")
	private String usernameForum;

	public Blogs() {
	}

	public Blogs(Date dateforum, String descriptionForum, String sujetForum, String usernameForum) {
		
		this.dateforum = dateforum;
		this.descriptionForum = descriptionForum;
		this.sujetForum = sujetForum;
		this.usernameForum = usernameForum;
	}

	public int getIdForum() {
		return this.idForum;
	}

	public void setIdForum(int idForum) {
		this.idForum = idForum;
	}

	public Date getDateforum() {
		return this.dateforum;
	}

	public void setDateforum(Date dateforum) {
		this.dateforum = dateforum;
	}

	public String getDescriptionForum() {
		return this.descriptionForum;
	}

	public void setDescriptionForum(String descriptionForum) {
		this.descriptionForum = descriptionForum;
	}

	public String getSujetForum() {
		return this.sujetForum;
	}

	public void setSujetForum(String sujetForum) {
		this.sujetForum = sujetForum;
	}

	public String getUsernameForum() {
		return this.usernameForum;
	}

	public void setUsernameForum(String usernameForum) {
		this.usernameForum = usernameForum;
	}

}