package managedBeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceContext;

import model.Agent;
import model.Chat;
import services.AgentService;


@ManagedBean(name ="AgentBean")
@SessionScoped
public class AgentBean implements Serializable {
    @PersistenceContext(unitName = "AppGestionInterventionPU")
    
  
 
	private static final long serialVersionUID = 1L;
	private int agentId;private Date dateRecruitment;private String nom;
    private String prenom;private int salary;private String typeofContract;private String adresse;

    @EJB
 	AgentService agentService;
	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public Date getDateRecruitment() {
		return dateRecruitment;
	}

	public void setDateRecruitment(Date dateRecruitment) {
		this.dateRecruitment = dateRecruitment;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getTypeofContract() {
		return typeofContract;
	}

	public void setTypeofContract(String typeofContract) {
		this.typeofContract = typeofContract;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public AgentBean(int agentId, Date dateRecruitment, String nom, String prenom, int salary, String typeofContract,
			String adresse) {
		super();
		this.agentId = agentId;
		this.dateRecruitment = dateRecruitment;
		this.nom = nom;
		this.prenom = prenom;
		this.salary = salary;
		this.typeofContract = typeofContract;
		this.adresse = adresse;
	}

	public AgentBean(String nom, String prenom, int salary, String typeofContract, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salary = salary;
		this.typeofContract = typeofContract;
		this.adresse = adresse;
	}

	public AgentBean() {
		super();
	
	}
	private List<Agent> agents;
	public List<Agent> getAgents() {
		agents =  agentService.getAllagents();
		return agents;
		}
	public int AgentIdToBeUpdated;
	
	public AgentBean(String nom, String prenom, String typeofContract, String adresse,int salary,
			Integer agentIdToBeUpdated) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.typeofContract = typeofContract;
		this.salary = salary;
	
		
		AgentIdToBeUpdated = agentIdToBeUpdated;
	}

	public int getAgentIdToBeUpdated() {
		return AgentIdToBeUpdated;
	}

	public void setAgentIdToBeUpdated(int agentIdToBeUpdated) {
		AgentIdToBeUpdated = agentIdToBeUpdated;
	}

	public void add() { 
		agentService.envoyerAgent(new Agent(nom,prenom,adresse,salary,typeofContract));
		
		}
	public void deleteagent(int agentId)
	{
	agentService.deleteagent(agentId);
	}
	public void updateAgent()
	{ agentService.updateAgent(new Agent(typeofContract, nom,prenom, AgentIdToBeUpdated, adresse)); }
	public void mettreajour(Agent empl)
	{
	this.setNom(empl.getNom());
	this.setPrenom(empl.getPrenom());
	this.setSalary(empl.getSalary());
    this.setTypeofContract(empl.getTypeofContract());
	this.setAgentIdToBeUpdated(empl.getAgentId());
	}
}
