package bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;

import RemoteService.IOffreService;



@ManagedBean
public class ChartView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel1 = new PieChartModel();
	private PieChartModel pieModel2;
	@EJB
	private IOffreService service;

	/*@PostConstruct
	public void init() {
		createPieModels();
	}*/

	public PieChartModel getPieModel1() {
		long res1 = service.getNombreRequestJPQL();
		long res2 = service.getNombreRequestMusJPQL();
		long res3 = service.getNombreRequestTheJPQL();
		long res4 = service.getNombreRequestLitJPQL();
		long res5 = service.getPoureRequestJPQL();
		this.pieModel1.set("<15", res1 * 100 / res5);
		this.pieModel1.set("<30", res2 * 100 / res5);
		this.pieModel1.set("<64", res3 * 100 / res5);
		this.pieModel1.set(">65", res4 * 100 / res5);

		this.pieModel1.setTitle("Pourcentage of Reduction <15 && <30 && <64 && >65 %");
		this.pieModel1.setLegendPosition("w");
		this.pieModel1.setShadow(false);
		return pieModel1;
	}

	public PieChartModel getPieModel2() {
		return pieModel2;
	}

	private void createPieModels() {
		createPieModel1();

	}

	private void createPieModel1() {

	
	}

	public void setPieModel1(PieChartModel pieModel1) {
		
		this.pieModel1 = pieModel1;
	}
	
	

}