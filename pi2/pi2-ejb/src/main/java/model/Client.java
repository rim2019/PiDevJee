package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	@Column(name="AdresseClient")
	private String adresseClient;

	@Column(name="AgeClient")
	private int ageClient;

	@Column(name="EmailClient")
	private String emailClient;

	@Column(name="NomClient")
	private String nomClient;

	@Column(name="NumeroClient")
	private int numeroClient;

	@Column(name="PasswordClient")
	private String passwordClient;

	@Column(name="Points")
	private int points;

	@Column(name="RoleClient")
	private String roleClient;

	@Column(name="TypeClient")
	private String typeClient;

	//bi-directional many-to-one association to Reclamation
	@OneToMany(mappedBy="client")
	private List<Reclamation> reclamations;

	public Client() {
	}

	public int getClientId() {
		return this.clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getAdresseClient() {
		return this.adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public int getAgeClient() {
		return this.ageClient;
	}

	public void setAgeClient(int ageClient) {
		this.ageClient = ageClient;
	}

	public String getEmailClient() {
		return this.emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public int getNumeroClient() {
		return this.numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}

	public String getPasswordClient() {
		return this.passwordClient;
	}

	public void setPasswordClient(String passwordClient) {
		this.passwordClient = passwordClient;
	}

	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getRoleClient() {
		return this.roleClient;
	}

	public void setRoleClient(String roleClient) {
		this.roleClient = roleClient;
	}

	public String getTypeClient() {
		return this.typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public List<Reclamation> getReclamations() {
		return this.reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public Reclamation addReclamation(Reclamation reclamation) {
		getReclamations().add(reclamation);
		reclamation.setClient(this);

		return reclamation;
	}

	public Reclamation removeReclamation(Reclamation reclamation) {
		getReclamations().remove(reclamation);
		reclamation.setClient(null);

		return reclamation;
	}

}