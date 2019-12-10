package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import Service.OffreService;
import Service.PackService;
import Service.ProduitService;
import model.Offre;
import model.Pack;
import model.Produit;

@ManagedBean(name="produit")
@SessionScoped
public class ProduitBean implements Serializable {
	List<Produit>  Packdetail;
	//private Offre offre =new Offre();
	private List<Pack> listePack;
	
	
	@EJB
	private ProduitService PPS;
	

	
	
public String  DoGetProduitDetails(int id){
		
	Packdetail =PPS.findProduitById(id);
		return "/xhtml/detailPack?faces-redirect=true";
	}

	
	
	


	

	public void setListePack(List<Pack> listePack) {
		this.listePack = listePack;
	}

	

	
	

}
