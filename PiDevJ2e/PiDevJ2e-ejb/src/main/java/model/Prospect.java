package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Prospects database table.
 * 
 */
@Entity
@Table(name="Prospects")
@NamedQuery(name="Prospect.findAll", query="SELECT p FROM Prospect p")
public class Prospect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdProspect")
	private int idProspect;

	@Column(name="AdresseMailProspect")
	private String adresseMailProspect;

	@Column(name="NomProspect")
	private String nomProspect;

	@Column(name="NumeroProspect")
	private String numeroProspect;

	@Column(name="OperateurProspect")
	private String operateurProspect;

	@Column(name="TypeProspect")
	private String typeProspect;

	public Prospect() {
	}

	public int getIdProspect() {
		return this.idProspect;
	}

	public void setIdProspect(int idProspect) {
		this.idProspect = idProspect;
	}

	public String getAdresseMailProspect() {
		return this.adresseMailProspect;
	}

	public void setAdresseMailProspect(String adresseMailProspect) {
		this.adresseMailProspect = adresseMailProspect;
	}

	public String getNomProspect() {
		return this.nomProspect;
	}

	public void setNomProspect(String nomProspect) {
		this.nomProspect = nomProspect;
	}

	public String getNumeroProspect() {
		return this.numeroProspect;
	}

	public void setNumeroProspect(String numeroProspect) {
		this.numeroProspect = numeroProspect;
	}

	public String getOperateurProspect() {
		return this.operateurProspect;
	}

	public void setOperateurProspect(String operateurProspect) {
		this.operateurProspect = operateurProspect;
	}

	public String getTypeProspect() {
		return this.typeProspect;
	}

	public void setTypeProspect(String typeProspect) {
		this.typeProspect = typeProspect;
	}

}