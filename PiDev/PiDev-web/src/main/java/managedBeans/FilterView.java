package managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import implementation.CarService;
import model.Car;

/**
 * Session Bean implementation class FilterView
 */
@Named("dtFilterView")
@ViewScoped
public class FilterView implements Serializable {
 
    private List<Car> cars1;
    private List<Car> cars2;
 
    private List<Car> filteredCars1;
    private List<Car> filteredCars2;
 
    @Inject
    private CarService service;
 
    @PostConstruct
    public void init() {
        cars1 = service.createCars(10);
        cars2 = service.createCars(10);
    }
 
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
 
        if (value == null) {
            return false;
        }
 
        return ((Comparable) value).compareTo(getInteger(filterText)) > 0;
    }
 
    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);
 
        Car car = (Car) value;
        return car.getId().toLowerCase().contains(filterText)
                || car.getBrand().toLowerCase().contains(filterText)
                || car.getColor().toLowerCase().contains(filterText)
                //|| (car.isSold() ? "sold" : "sale").contains(filterText)
                || car.getYear() < filterInt
                || car.getPrice() < filterInt;
    }
 
    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
 
    public List<String> getBrands() {
        return service.getBrands();
    }
 
    public List<String> getColors() {
        return service.getColors();
    }
 
    public List<Car> getCars1() {
        return cars1;
    }
 
    public List<Car> getCars2() {
        return cars2;
    }
 
    public List<Car> getFilteredCars1() {
        return filteredCars1;
    }
 
    public void setFilteredCars1(List<Car> filteredCars1) {
        this.filteredCars1 = filteredCars1;
    }
 
    public List<Car> getFilteredCars2() {
        return filteredCars2;
    }
 
    public void setFilteredCars2(List<Car> filteredCars2) {
        this.filteredCars2 = filteredCars2;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
}