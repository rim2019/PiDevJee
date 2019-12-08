package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Chats database table.
 * 
 */
@Entity
@Table(name="Chats")
@NamedQuery(name="Chat.findAll", query="SELECT c FROM Chat c")
public class Chat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ChatId")
	private int chatId;

	@Column(name="Contenu")
	private String contenu;

	@Column(name="DateMessage")
	private Date dateMessage;

	@Column(name="ReceiverId")
	private int receiverId;

	private int senderId;

	private int vue;



	public int getChatId() {
		return this.chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Date getDateMessage() {
		return this.dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public int getReceiverId() {
		return this.receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getSenderId() {
		return this.senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getVue() {
		return this.vue;
	}

	public void setVue(int vue) {
		this.vue = vue;
	}

	public Chat(int chatId, String contenu, Date dateMessage, int receiverId, int senderId, int vue) {
		super();
		this.chatId = chatId;
		this.contenu = contenu;
		this.dateMessage = dateMessage;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.vue = vue;
	}

	public Chat(int chatId, String contenu, int receiverId, int senderId, int vue) {
		super();
		this.chatId = chatId;
		this.contenu = contenu;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.vue = vue;
	}

	public Chat(String contenu, int receiverId, int senderId, int vue) {
		super();
		this.contenu = contenu;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.vue = vue;
	}

	public Chat() {


		// TODO Auto-generated constructor stub
	}

	

}