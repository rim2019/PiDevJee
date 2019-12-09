package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Quiz database table.
 * 
 */
@Entity
@NamedQuery(name="Quiz.findAll", query="SELECT q FROM Quiz q")
public class Quiz implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idQ;

	private String choix1;

	private String choix2;

	private String choix3;

	private String question;

	private String reponse;

	public Quiz() {
	}

	public int getIdQ() {
		return this.idQ;
	}

	public void setIdQ(int idQ) {
		this.idQ = idQ;
	}

	public String getChoix1() {
		return this.choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return this.choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return this.choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getReponse() {
		return this.reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public Quiz(int idQ, String choix1, String choix2, String choix3, String question, String reponse) {
		super();
		this.idQ = idQ;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.question = question;
		this.reponse = reponse;
	}

	public Quiz(String choix1, String choix2, String choix3, String question, String reponse) {
		super();
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.question = question;
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Quiz [idQ=" + idQ + ", choix1=" + choix1 + ", choix2=" + choix2 + ", choix3=" + choix3 + ", question="
				+ question + ", reponse=" + reponse + "]";
	}
	
	

}