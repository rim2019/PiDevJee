package pid.interfaces;

import java.util.List;

import model.Catalogue;

public interface CatalogueInterface {
	Catalogue findByCatalogueById(int Id);
	List<Catalogue> findAllCatalogues();
	void addCatalogue(Catalogue catalogue);
	void updateCatalogue(Catalogue catalogue);
	void deleteCatalogue(Catalogue catalogue);
}
