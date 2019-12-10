package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Produits database table.
 * 
 */
@Entity
@Table(name="Produits")
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdProduit")
	private int idProduit;

	@Column(name="Name")
	private String name;

	@Column(name="Prix")
	private double prix;

	//bi-directional many-to-many association to Pack
	@ManyToMany
	@JoinTable(
		name="PackProduits"
		, joinColumns={
			@JoinColumn(name="Produit_IdProduit")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Pack_IdPackProduit")
			}
		)
	private List<Pack> packs;

	public Produit() {
	}

	public int getIdProduit() {
		return this.idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrix() {
		return this.prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Pack> getPacks() {
		return this.packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

}