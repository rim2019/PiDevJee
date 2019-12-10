package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import Service.OffreService;
import Service.PackService;
import model.Offre;
import model.Pack;

@ManagedBean(name="pack")
@SessionScoped
public class PackBean implements Serializable {
	private Pack Packdetail;
	//private Offre offre =new Offre();
	private List<Pack> listePack;
	
	
	@EJB
	private PackService PS;
	

	public List<Pack> getListePack() {
		
		return PS.getAllPacks();
	}
	
	
public String DoGetPacksDetails(int id){
		
	Packdetail =PS.findPackById(id);
		return "/xhtml/detailPack?faces-redirect=true";
	}

	
	
	


	public PackService getPS() {
		return PS;
	}


	public void setPS(PackService pS) {
		PS = pS;
	}


	public void setListePack(List<Pack> listePack) {
		this.listePack = listePack;
	}

	

	public Pack getPackdetail() {
		return Packdetail;
	}
	public void setPackdetail(Pack packdetail) {
		Packdetail = packdetail;
	}
	

}
