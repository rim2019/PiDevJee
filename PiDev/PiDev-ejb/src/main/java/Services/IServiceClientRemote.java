package Services;

import javax.ejb.Remote;

@Remote
public interface IServiceClientRemote {
	public void affecterClientAEvenement(int employeId, int depId);
}
