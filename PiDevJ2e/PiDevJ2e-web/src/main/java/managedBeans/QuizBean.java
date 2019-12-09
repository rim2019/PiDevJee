package bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.QueryParam;


import Service.CommentService;
import Service.OffreService;
import Service.QuizService;
import model.Comment;
import model.Offre;
import model.Quiz;


@ManagedBean(name="quiz")
@SessionScoped
public class QuizBean implements Serializable {
	
	@PersistenceContext
	private transient EntityManager em;
	@EJB
	private QuizService QS;
	private static List<Quiz> listeQuiz=new ArrayList<>();
	private Quiz quiz =new Quiz();
	private List<Quiz> filteredCars;
	private Quiz selectedCar;
	private List<Quiz> quizs;
	
	private List<Quiz> LQ;
	
	private String Choix1;
	private String Choix2;
	private String Choix3;
	private int Succed = 0;
	
	
	public void CheckResponse()
	{
		int score = 0;
		if (Choix1.equals(LQ.get(0).getReponse()))
			score++;
		if (Choix2.equals(LQ.get(1).getReponse()))
			score++;
		if (Choix3.equals(LQ.get(2).getReponse()))
			score++;
		
		if (score == 3)
		{
			this.valider();
			this.Succed = 1;
		}else {
			this.Succed = 2;
		}
		
	}

	
	public void addQuiz() {
		
		QS.addQuiz(quiz);
		quiz=new Quiz();
	;
	}


	public void deleteQuizById(int idQuiz) {
		
		QS.deleteQuizById(idQuiz);
		
	}

	
	
public List<Quiz> DoGetAllQuiz(){
		
	listeQuiz =QS.getQuiz();
		return listeQuiz;
	}

public void DoUpdateQuiz()
{
	QS.updateQuiz(selectedCar);
	
}


public void valider()
{
	try {
		String from = "mahdi.bouassida@esprit.tn";
		String pass = "bouassida1996";
		String to = "mahdi.bouassida@esprit.tn";
		String subject = "Acceptation";
		String messageText = "Vous avez gangner un Code de Promo Felicitation";

		String host = "smtp.gmail.com";

		boolean sessionDebug = false;

		Properties props = System.getProperties();

		props.put("mail.smtp.starttls.enable", "true");

		props.put("mail.smtp.host", host);

		props.put("mail.smtp.port", "587");

		props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.starttls.required", "true");

		Session mailSession = Session.getDefaultInstance(props, null);

		mailSession.setDebug(sessionDebug);

		Message msg = new MimeMessage(mailSession);

		msg.setFrom(new InternetAddress(from));

		InternetAddress[] address = { new InternetAddress(to) };

		msg.setRecipients(Message.RecipientType.TO, address);

		msg.setSubject(subject);
		msg.setSentDate(new Date());

		msg.setText(messageText);

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(host, from, pass);

		transport.sendMessage(msg, msg.getAllRecipients());

		transport.close();

		System.out.println("message send successfully");

	} catch (Exception ex)

	{
		System.out.println(ex);

	}
	
	}

	
	
	public int getSucced() {
		return Succed;
	}


	public void setSucced(int succed) {
		Succed = succed;
	}


	public String getChoix1() {
		return Choix1;
	}
	public void setChoix1(String choix1) {
		Choix1 = choix1;
	}
	public String getChoix3() {
		return Choix3;
	}
	public String getChoix2() {
		return Choix2;
	}
	public void setChoix2(String choix2) {
		Choix2 = choix2;
	}
	public void setChoix3(String choix3) {
		Choix3 = choix3;
	}
	
	
	public void getRandomQuiz()
	{
		this.LQ = QS.findCommentById();
	}
	
	
	public List<Quiz> getLQ() {
		return LQ;
	}
	public void setLQ(List<Quiz> lQ) {
		LQ = lQ;
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	//public Quiz[] color3List;



public Quiz getQuiz() {
	return quiz;
}


public void setQuiz(Quiz quiz) {
	this.quiz = quiz;
}


public List<Quiz> getFilteredCars() {
	return filteredCars;
}


public void setFilteredCars(List<Quiz> filteredCars) {
	this.filteredCars = filteredCars;
}


public Quiz getSelectedCar() {
	return selectedCar;
}


public void setSelectedCar(Quiz selectedCar) {
	this.selectedCar = selectedCar;
}


public EntityManager getEm() {
	return em;
}


public void setEm(EntityManager em) {
	this.em = em;
}


public QuizService getQS() {
	return QS;
}


public void setQS(QuizService qS) {
	QS = qS;
}


public List<Quiz> getQuizs() {
	return quizs;
}


public void setQuizs(List<Quiz> quizs) {
	this.quizs = quizs;
}



public static List<Quiz> getListeQuiz() {
	return listeQuiz;
}


public static void setListeQuiz(List<Quiz> listeQuiz) {
	QuizBean.listeQuiz = listeQuiz;
}


public String redirectToQuiz(){
	return "/xhtml/indextest?faces-redirect=true";
}
	
	
	
	
	

}
