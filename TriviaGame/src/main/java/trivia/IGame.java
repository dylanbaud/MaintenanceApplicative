package trivia;

public interface IGame {

	void addPlayer(String playerName);

	boolean startGame();

	void roll(int roll);

	boolean handleCorrectAnswer();

	void handleWrongAnswer();

}