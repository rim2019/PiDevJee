package model;

import java.io.Serializable;
import javax.persistence.*;


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

	@Column(name="Nom")
	private String nom;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Client(int clientId, String nom) {
		super();
		this.clientId = clientId;
		this.nom = nom;
	}
	

}