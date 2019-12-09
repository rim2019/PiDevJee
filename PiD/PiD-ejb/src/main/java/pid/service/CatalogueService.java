package pid.service;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Catalogue;
import pid.interfaces.CatalogueInterface;



@Stateless
@LocalBean
public class CatalogueService implements CatalogueInterface {
	@PersistenceContext(unitName="PI-ejb")
	EntityManager entityManager;


	@Override
	public Catalogue findByCatalogueById(int Id) {
		return entityManager.find(Catalogue.class, Id);
	}

	@Override
	public List<Catalogue> findAllCatalogues() {
		TypedQuery<Catalogue> query = entityManager.createQuery("SELECT c FROM Catalogue c", Catalogue.class);
		return query.getResultList();
	}
	@Override
	public void addCatalogue(Catalogue catalogue) {
		entityManager.persist(catalogue);	
	}
	@Override
	public void updateCatalogue(Catalogue catalogue) {
		entityManager.merge(catalogue);
		}

	@Override
	public void deleteCatalogue(Catalogue catalogue) {
		entityManager.remove(entityManager.find(Catalogue.class, catalogue.getIdCatalogue()));
	}

}
