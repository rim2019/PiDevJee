package services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import iServiceRemote.MessageServiceRemote;
import model.Chat;



@Stateless
@LocalBean
public class ChatService implements MessageServiceRemote {
	@PersistenceContext
	EntityManager em;
	@Override
	public int envoyerMessage(Chat chat) {
		
		em.persist(chat);
		return chat.getChatId();
	}
	@Override
	public List<Chat> getAllchats() {
		List<Chat> emp= em.createQuery("select e from Chat e", Chat.class).getResultList();
		return emp; 
	}
	@Override
	public void deletechat(int chatId) {
	Chat chat = em.find(Chat.class, chatId);
		
	
		
		
		em.remove(chat);
		
	}
	@Override
	public void updateEmploye(Chat chat) {
		Chat emp = em.find(Chat.class, chat.getChatId()); 
		emp.setChatId(chat.getChatId()); 
		emp.setSenderId(chat.getSenderId()); 
		emp.setReceiverId(chat.getReceiverId()); 
		emp.setContenu(chat.getContenu()); 
		emp.setDateMessage(chat.getDateMessage()); 
		emp.setVue(chat.getVue()); 
		
		
	}


	

}
