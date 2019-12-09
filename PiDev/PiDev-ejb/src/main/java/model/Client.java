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

	private int interesse;

	@Column(name="NomClient")
	private String nomClient;

	@Column(name="NumeroClient")
	private int numeroClient;

	private int participe;

	@Column(name="PasswordClient")
	private String passwordClient;

	@Column(name="Points")
	private int points;

	@Column(name="RoleClient")
	private String roleClient;

	@Column(name="TypeClient")
	private String typeClient;

	//bi-directional many-to-many association to Evenement
	@ManyToMany
	@JoinTable(
		name="EvenementClient"
		, joinColumns={
			@JoinColumn(name="clients")
			}
		, inverseJoinColumns={
			@JoinColumn(name="evenement")
			}
		)
	
	private List<Evenement> evenements;

	public Client() {
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Object getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public int getAgeClient() {
		return ageClient;
	}

	public void setAgeClient(int ageClient) {
		this.ageClient = ageClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public int getInteresse() {
		return interesse;
	}

	public void setInteresse(int interesse) {
		this.interesse = interesse;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public int getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
	}

	public int getParticipe() {
		return participe;
	}

	public void setParticipe(int participe) {
		this.participe = participe;
	}

	public String getPasswordClient() {
		return passwordClient;
	}

	public void setPasswordClient(String passwordClient) {
		this.passwordClient = passwordClient;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getRoleClient() {
		return roleClient;
	}

	public void setRoleClient(String roleClient) {
		this.roleClient = roleClient;
	}

	public String getTypeClient() {
		return typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}