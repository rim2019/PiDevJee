package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Rating database table.
 * 
 */
@Entity
@NamedQuery(name="Rating.findAll", query="SELECT r FROM Rating r")
public class Rating implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idR;

	private int nbr;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idC")
	private Client client;

	//bi-directional many-to-one association to Offre
	@ManyToOne
	@JoinColumn(name="idO")
	private Offre offre;

	public Rating() {
	}

	public int getIdR() {
		return this.idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public int getNbr() {
		return this.nbr;
	}

	public void setNbr(int nbr) {
		this.nbr = nbr;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Offre getOffre() {
		return this.offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

}