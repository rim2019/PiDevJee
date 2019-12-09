package managedBeans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Agent;
import model.Chat;
import services.AgentSevice;
import services.ChatService;


@ManagedBean(name ="AgentBean")
@SessionScoped
public class AgentBean  implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date dateRecruitment;private int salary;private int typeofContract;private int agentId;
	  private  Agent agent= new Agent();
	  @EJB
	  AgentSevice agentService;
	public Date getDateRecruitment() {
		return dateRecruitment;
	}
	public void setDateRecruitment(Date dateRecruitment) {
		this.dateRecruitment = dateRecruitment;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getTypeofContract() {
		return typeofContract;
	}
	public void setTypeofContract(int typeofContract) {
		this.typeofContract = typeofContract;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public AgentSevice getAgentService() {
		return agentService;
	}
	public void setAgentService(AgentSevice agentService) {
		this.agentService = agentService;
	}
	public AgentBean(int salary, int typeofContract, Agent agent,
			AgentSevice agentService) {
		super();
	
		this.salary = salary;
		this.typeofContract = typeofContract;

		this.agent = agent;
		this.agentService = agentService;
	}
	public AgentBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void add() { 
		//agentService.envoyerAgent(new Agent(salary,typeofContract ));
		
		}
	
	private List<Agent> agents;
	public List<Agent> getAgents() {
		agents =  agentService.getAllagents();
		return agents ;
		}
	public void deleteagent(int AgentId)
	{
	agentService.deleteagent(AgentId);
	}
	//public void updateEmploye()
	//{ agentService.updateAgent(new Agent(salary,agentId,typeofContract )); }
}
