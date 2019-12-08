package services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iServiceRemote.AgentServiceRemote;
import model.Agent;
@Stateless
@LocalBean
public class AgentService implements AgentServiceRemote {
	@PersistenceContext
	EntityManager em;
	@Override
	public int envoyerAgent(Agent agent) {
		em.persist(agent);
		return agent.getAgentId();
	}

	@Override
	public List<Agent> getAllagents() {
		List<Agent> emp= em.createQuery("select e from Agent  e", Agent.class).getResultList();
		return emp; 
	}

	@Override
	public void deleteagent(int agentId) {
		Agent agent = em.find(Agent.class,agentId );
		em.remove(agent);

	}

	@Override
	public void updateAgent(Agent agent) {
		Agent emp = em.find(Agent.class, agent.getAgentId()); 
		emp.setAgentId(agent.getAgentId()); 
		emp.setDateRecruitment(agent.getDateRecruitment()); 
		emp.setAdresse(agent.getAdresse());
		emp.setSalary(agent.getSalary());
		emp.setNom(agent.getNom());
		emp.setPrenom(agent.getPrenom());
		emp.setTypeofContract(agent.getTypeofContract());

	}

}
