package ManagedBeans;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Catalogue;
import pid.service.*;

@ManagedBean(name="CatalogueBeans")
@SessionScoped
public class CatalogueBeans {

	@EJB
	CatalogueService Catalogueservices;
	
	private int idcatalogue;
	private String name;
	private String Cataloguename;
	private int prodid;
	private Date datedebut;
	private List<Catalogue> Catalogue;
	private Catalogue CatalogueToUpadate;

	
	public List<Catalogue> getCat() {
		Catalogue=Catalogueservices.findAllCatalogues();
		return Catalogue;
	}
	
	public String addCatalogue() {
		Catalogue Catalogue = new Catalogue();
		Catalogue.setNomCatalogue(name);
		Catalogue.setNomCatalogue(Cataloguename);
		Catalogue.setDateDebut(datedebut);
	
		//formation.setType(Type);
		Catalogueservices.addCatalogue(Catalogue);
		return null;
	}
	
	public String editCatalogue(Catalogue Catalogue) {
		setCatalogueToUpadate(Catalogue);
		return "UpdateTrainer";
	}
	public String updateCatalogue() {
		Catalogueservices.updateCatalogue(CatalogueToUpadate);
		return "FormationList";
		
		
	}
	public String removeCatalogue(Catalogue Catalogue) {
		Catalogueservices.deleteCatalogue(Catalogue);
		return null;
	}
	public CatalogueService getCatalogueservices() {
		return Catalogueservices;
	}
	public void setCatalogueservices(CatalogueService Catalogueservices) {
		this.Catalogueservices = Catalogueservices;
	}

	public List<Catalogue> getCatalogue() {
		Catalogue=Catalogueservices.findAllCatalogues();
		return Catalogue;
	}
	public void setCatalogue(List<Catalogue> Catalogue) {
		this.Catalogue = Catalogue;
	}
	public Catalogue getCatalogueToUpadate() {
		return CatalogueToUpadate;
	}
	public void setCatalogueToUpadate(Catalogue CatalogueToUpadate) {
		this.CatalogueToUpadate = CatalogueToUpadate;
	}
	////////////////Getters And Setters//////////////////////////
	public int getIdcatalogue() {
		return idcatalogue;
	}

	public void setIdcatalogue(int idcatalogue) {
		this.idcatalogue = idcatalogue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCataloguename() {
		return Cataloguename;
	}

	public void setCataloguename(String cataloguename) {
		Cataloguename = cataloguename;
	}

	public int getProdid() {
		return prodid;
	}

	public void setProdid(int prodid) {
		this.prodid = prodid;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	////////////////////////////////////////
	
}