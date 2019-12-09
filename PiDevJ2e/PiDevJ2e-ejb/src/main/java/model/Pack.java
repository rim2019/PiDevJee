package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Packs database table.
 * 
 */
@Entity
@Table(name="Packs")
@NamedQuery(name="Pack.findAll", query="SELECT p FROM Pack p")
public class Pack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdPackProduit")
	private int idPackProduit;

	@Column(name="DateDebut")
	private Timestamp dateDebut;

	@Column(name="DateFin")
	private Timestamp dateFin;

	private String image;

	@Column(name="NouveauPrixTotaleProduit")
	private double nouveauPrixTotaleProduit;

	@Column(name="PourcentageDeReduction")
	private double pourcentageDeReduction;

	@Column(name="PrixTotaleProduitorig")
	private double prixTotaleProduitorig;

	@Column(name="QtDeProduit")
	private int qtDeProduit;

	//bi-directional many-to-many association to Produit
	@ManyToMany(mappedBy="packs",fetch = FetchType.EAGER)
	private List<Produit> produits;

	public Pack() {
	}

	//bi-directional one-to-one association to Offre
		@OneToOne(mappedBy="produit")
		private Offre offre;

		
	public int getIdPackProduit() {
		return this.idPackProduit;
	}

	public void setIdPackProduit(int idPackProduit) {
		this.idPackProduit = idPackProduit;
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

	public double getNouveauPrixTotaleProduit() {
		return this.nouveauPrixTotaleProduit;
	}

	public void setNouveauPrixTotaleProduit(double nouveauPrixTotaleProduit) {
		this.nouveauPrixTotaleProduit = nouveauPrixTotaleProduit;
	}

	public double getPourcentageDeReduction() {
		return this.pourcentageDeReduction;
	}

	public void setPourcentageDeReduction(double pourcentageDeReduction) {
		this.pourcentageDeReduction = pourcentageDeReduction;
	}

	public double getPrixTotaleProduitorig() {
		return this.prixTotaleProduitorig;
	}

	public void setPrixTotaleProduitorig(double prixTotaleProduitorig) {
		this.prixTotaleProduitorig = prixTotaleProduitorig;
	}

	public int getQtDeProduit() {
		return this.qtDeProduit;
	}

	public void setQtDeProduit(int qtDeProduit) {
		this.qtDeProduit = qtDeProduit;
	}

	public List<Produit> getProduits() {
		return this.produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}