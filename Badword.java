package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Badword database table.
 * 
 */
@Entity
@NamedQuery(name="Badword.findAll", query="SELECT b FROM Badword b")
public class Badword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBadword;

	private String wordBadword;

	public Badword() {
	}

	public int getIdBadword() {
		return this.idBadword;
	}

	public void setIdBadword(int idBadword) {
		this.idBadword = idBadword;
	}

	public String getWordBadword() {
		return this.wordBadword;
	}

	public void setWordBadword(String wordBadword) {
		this.wordBadword = wordBadword;
	}

}