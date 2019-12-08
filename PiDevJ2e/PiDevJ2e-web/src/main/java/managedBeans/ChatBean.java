package managedBeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Chat;
import services.ChatService;


@ManagedBean(name ="ChatBean")
@SessionScoped
public class ChatBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int chatId;private String contenu;private Date dateMessage;private int receiverId;
     private int senderId;private int vue;
     private  Chat chat= new Chat();
     @EJB
 	ChatService chatService;
     @PostConstruct
     public void init() {
    	 dateMessage = new Date();
    	 
     }
	public ChatBean(int chatId, String contenu, Date dateMessage, int receiverId, int senderId, int vue, Chat chat,
			ChatService chatService, List<Chat> chats) {
		super();
		this.chatId = chatId;
		this.contenu = contenu;
		this.dateMessage = dateMessage;
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.vue = vue;
		this.chat = chat;
		this.chatService = chatService;
		this.chats = chats;
		
	}
	
	public ChatBean(String contenu,  int receiverId, int senderId, int vue,
			ChatService chatService, Integer chatIdToBeUpdated, List<Chat> chats) {
		super();
	
		this.contenu = contenu;
	
		this.receiverId = receiverId;
		this.senderId = senderId;
		this.vue = vue;
		this.chatService = chatService;
		this.chatIdToBeUpdated = chatIdToBeUpdated;
		this.chats = chats;
	}

	private int chatIdToBeUpdated;

	public int getChatId() {
		return chatId;
	}
	public void setChatId(int chatId) {
		this.chatId = chatId;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDateMessage() {
		return dateMessage;
	}
	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getVue() {
		return vue;
	}
	public void setVue(int vue) {
		this.vue = vue;
	}
	public ChatService getChatService() {
		return chatService;
	}
	public void setChatService(ChatService chatService) {
		this.chatService = chatService;
	}
	public ChatBean() {
		super();
		
	} 
	
	public void addChat() { 
		SimpleDateFormat simpleFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("date:"+simpleFormat.format(dateMessage));
		chatService.envoyerMessage(new Chat(contenu,receiverId,senderId,vue));
		
		}
	
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	

	public void setChats(List<Chat> chats) {
		this.chats = chats;
	}

	public int getChatIdToBeUpdated() {
		return chatIdToBeUpdated;
	}
	public void setChatIdToBeUpdated(int chatIdToBeUpdated) {
		this.chatIdToBeUpdated = chatIdToBeUpdated;
	}
	private List<Chat> chats;
	public List<Chat> getChats() {
		chats =  chatService.getAllchats();
		return chats;
		}
	public void deletechat(int chatId)
	{
	chatService.deletechat(chatId);
	}
	public void updateEmploye()
	{ chatService.updateEmploye(new Chat(chatIdToBeUpdated, contenu,receiverId, senderId, vue)); }
	public void mettreajour(Chat empl)
	{
	this.setContenu(empl.getContenu());
	this.setReceiverId(empl.getReceiverId());
	this.setSenderId(empl.getSenderId());
this.setVue(empl.getVue());
	this.setChatIdToBeUpdated(empl.getChatId());
	}
	
}