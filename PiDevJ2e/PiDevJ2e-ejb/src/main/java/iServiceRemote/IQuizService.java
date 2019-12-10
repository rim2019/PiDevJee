package RemoteService;

import java.util.List;

import model.Quiz;

public interface IQuizService {

	void addQuiz(Quiz quiz);

	void deleteQuizById(int idQuiz);

	List<Quiz> getQuiz();

	

	void updateQuiz(Quiz q);

	List<Quiz> findCommentById();



}
