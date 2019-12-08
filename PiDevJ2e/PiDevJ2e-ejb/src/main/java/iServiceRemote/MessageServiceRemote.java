package iServiceRemote;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import model.Chat;

@Remote
public interface MessageServiceRemote {
	public int envoyerMessage(Chat chat) ;
	public List<Chat> getAllchats();
	public void deletechat(int chatId);
	public void updateEmploye(Chat chat);
	
}
