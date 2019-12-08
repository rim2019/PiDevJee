package iServiceRemote;



import java.util.ArrayList;

import javax.ejb.Remote;


import model.Client;


@Remote
public interface EmployeServiceRemote {

	
void ajouterEmp(Client e);
void ajouterEmp1() ;

ArrayList<Client> getAll();
public Client getEmp(int id);


}