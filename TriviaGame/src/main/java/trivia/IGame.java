package trivia;

public interface IGame {

	void addPlayer(String playerName);

	boolean startGame();

	boolean canRoll();

	void roll(int roll);

	boolean handleCorrectAnswer();

	void handleWrongAnswer();

}