package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Reclamations database table.
 * 
 */
@Entity
@Table(name="Reclamations")
@NamedQuery(name="Reclamation.findAll", query="SELECT r FROM Reclamation r")
public class Reclamation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReclamationId")
	private int reclamationId;

	@Column(name="DateReclamation")
	private Date dateReclamation;

	@Column(name="Delai")
	private int delai;

	@Column(name="Description")
	private String description;

	@Column(name="EtatReclamation")
	private int etatReclamation;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="ReclamationId")
	private Client client;

	public Reclamation() {
	}

	public int getReclamationId() {
		return this.reclamationId;
	}

	public void setReclamationId(int reclamationId) {
		this.reclamationId = reclamationId;
	}

	public Date getDateReclamation() {
		return this.dateReclamation;
	}

	public void setDateReclamation(Date dateReclamation) {
		this.dateReclamation = dateReclamation;
	}

	public int getDelai() {
		return this.delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEtatReclamation() {
		return this.etatReclamation;
	}

	public void setEtatReclamation(int etatReclamation) {
		this.etatReclamation = etatReclamation;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}