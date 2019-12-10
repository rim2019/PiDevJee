package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RatingPack database table.
 * 
 */
@Entity
@NamedQuery(name="RatingPack.findAll", query="SELECT r FROM RatingPack r")
public class RatingPack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdR")
	private int idR;

	private int nbr;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="idC")
	private Client client;

	//bi-directional many-to-one association to Pack
	@ManyToOne
	@JoinColumn(name="idP")
	private Pack pack;

	public RatingPack() {
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

	public Pack getPack() {
		return this.pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

}