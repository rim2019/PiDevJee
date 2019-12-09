package managedBeans;

import java.io.Serializable;



import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import model.LocalisationEven;
import model.typeEven;


/**
 * Session Bean implementation class Data
 */
@ManagedBean(name = "data")
@ApplicationScoped
public class Data implements Serializable {
private static final long serialVersionUID = 1L;


public typeEven[] getRoles() { return typeEven.values(); }

public LocalisationEven[] getLocalisation() { return LocalisationEven.values(); }

@Enumerated(EnumType.STRING)
private typeEven role;

@Enumerated(EnumType.STRING)
private typeEven localisationEnum;

}