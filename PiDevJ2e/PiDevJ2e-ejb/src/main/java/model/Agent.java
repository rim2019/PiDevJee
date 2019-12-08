package model;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the Agents database table.
 * 
 */
@Entity
@Table(name="Agents")
@NamedQuery(name="Agent.findAll", query="SELECT a FROM Agent a")
public class Agent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AgentId")
	private int agentId;

	private String adresse;
	@Column(name="DateRecruitment")
	private Date dateRecruitment;

	private String nom;

	private String prenom;

	private int salary;

	private String typeofContract;

	public Agent() {
	}

	public int getAgentId() {
		return this.agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDateRecruitment() {
		return this.dateRecruitment;
	}

	public void setDateRecruitment(Date dateRecruitment) {
		this.dateRecruitment = dateRecruitment;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getTypeofContract() {
		return this.typeofContract;
	}

	public void setTypeofContract(String typeofContract) {
		this.typeofContract = typeofContract;
	}

	public Agent(String adresse, String nom, String prenom, int salary, String typeofContract) {
		super();
		this.adresse = adresse;
		this.nom = nom;
		this.salary = salary;
		this.prenom = prenom;
		this.typeofContract = typeofContract;
	}

	public Agent(int agentId, String adresse, String nom, String prenom, int salary, String typeofContract) {
		super();
		this.agentId = agentId;
		this.adresse = adresse;
		this.nom = nom;
		this.prenom = prenom;
		this.salary = salary;
		this.typeofContract = typeofContract;
	}
	

}