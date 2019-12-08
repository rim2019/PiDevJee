package iServiceRemote;

import java.util.List;

import javax.ejb.Remote;

import model.Agent;
import model.Chat;
@Remote
public interface AgentServiceRemote {
	public int envoyerAgent(Agent agent) ;
	public List<Agent> getAllagents();
	public void deleteagent(int AgentId);
	public void updateAgent(Agent agent);
}
