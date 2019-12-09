package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the Offres database table.
 * 
 */
@Entity
@Table(name="Offres")
@NamedQuery(name="Offre.findAll", query="SELECT o FROM Offre o")
public class Offre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdOffresProduit")
	private int idOffresProduit;

	@Column(name="DateDebut")
	private Timestamp dateDebut;

	@Column(name="DateFin")
	private Timestamp dateFin;

	private String image;

	@Column(name="NouveauPrix")
	private double nouveauPrix;

	@Column(name="PourcentageDeReduction")
	private double pourcentageDeReduction;

	@Column(name="QtDeProduit")
	private int qtDeProduit;

	//bi-directional one-to-one association to Produit
	@OneToOne
	@JoinColumn(name="IdOffresProduit")
	private Produit produit;

	public Offre() {
	}

	public int getIdOffresProduit() {
		return this.idOffresProduit;
	}

	public void setIdOffresProduit(int idOffresProduit) {
		this.idOffresProduit = idOffresProduit;
	}

	public Timestamp getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Timestamp getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getNouveauPrix() {
		return this.nouveauPrix;
	}

	public void setNouveauPrix(double nouveauPrix) {
		this.nouveauPrix = nouveauPrix;
	}

	public double getPourcentageDeReduction() {
		return this.pourcentageDeReduction;
	}

	public void setPourcentageDeReduction(double pourcentageDeReduction) {
		this.pourcentageDeReduction = pourcentageDeReduction;
	}

	public int getQtDeProduit() {
		return this.qtDeProduit;
	}

	public void setQtDeProduit(int qtDeProduit) {
		this.qtDeProduit = qtDeProduit;
	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}