package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;


/**
 * The persistent class for the Catalogues database table.
 * 
 */
@Entity
@Table(name="Catalogues")
@NamedQuery(name="Catalogue.findAll", query="SELECT c FROM Catalogue c")
public class Catalogue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCatalogue")
	private int idCatalogue;

	@Column(name="date_debut")
	private Date dateDebut;

	private String nom;

	@Column(name="NomCatalogue")
	private String nomCatalogue;

	@Column(name="ProdId")
	private int prodId;

	public Catalogue() {
	}

	public int getIdCatalogue() {
		return this.idCatalogue;
	}

	public void setIdCatalogue(int idCatalogue) {
		this.idCatalogue = idCatalogue;
	}

	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNomCatalogue() {
		return this.nomCatalogue;
	}

	public void setNomCatalogue(String nomCatalogue) {
		this.nomCatalogue = nomCatalogue;
	}

	public int getProdId() {
		return this.prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

}