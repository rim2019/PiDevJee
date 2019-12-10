package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import Service.OffreService;
import model.Offre;

@ManagedBean(name="offre")
@SessionScoped
public class OffreBean implements Serializable {
	Offre offredetail=new Offre();
	//private Offre offre =new Offre();
	private List<Offre> listeOffre;
	
	
	@EJB
	private OffreService OS;
	

	public List<Offre> getListeOffre() {
		
		return OS.getAllOffres();
	}


	public void setListeOffre(List<Offre> listeOffre) {
		listeOffre = listeOffre;
	}
	
public String DoGetOffreDetails(int id){
		
		offredetail =OS.findOffreById(id);
		return "/xhtml/detailoffres?faces-redirect=true";
	}


public Offre getOffredetail() {
	return offredetail;
}


public void setOffredetail(Offre offredetail) {
	this.offredetail = offredetail;
}


public OffreService getOS() {
	return OS;
}


public void setOS(OffreService oS) {
	OS = oS;
}
	

	
	

}
