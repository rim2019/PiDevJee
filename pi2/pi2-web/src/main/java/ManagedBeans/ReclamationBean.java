package ManagedBeans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name = "ReclamationBean")
@SessionScoped
public class ReclamationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Date dateReclamation;
	private int delai;
	private String description;
	private int etatReclamation;
	
}
