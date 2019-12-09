package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the CommentPack database table.
 * 
 */
@Entity
@NamedQuery(name="CommentPack.findAll", query="SELECT c FROM CommentPack c")
public class CommentPack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idC;

	private Date date;

	private String description;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;

	//bi-directional many-to-one association to Pack
	@ManyToOne
	@JoinColumn(name="idPack")
	private Pack pack;

	public CommentPack() {
	}

	public int getIdC() {
		return this.idC;
	}

	public void setIdC(int idC) {
		this.idC = idC;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Pack getPack() {
		return this.pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

}