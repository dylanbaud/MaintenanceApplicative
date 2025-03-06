package trivia;

import java.util.ArrayList;

public class Game implements IGame {
    ArrayList<Player> players = new ArrayList<>();
    QuestionManager questionManager;
    Player currentPlayer;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        questionManager = new QuestionManager();
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        }
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public void roll(int roll) {
        System.out.println(currentPlayer + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                currentPlayer.setInPenaltyBox(false);
                isGettingOutOfPenaltyBox = true;
                System.out.println(currentPlayer + " is getting out of the penalty box");

                currentPlayer.movePlayer(roll);
                questionManager.askQuestion(currentPlayer.getPlace());
            } else {
                System.out.println(currentPlayer + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            currentPlayer.movePlayer(roll);
            questionManager.askQuestion(currentPlayer.getPlace());
        }
    }


    public void changePlayer() {
        if (players.indexOf(currentPlayer) + 1 == players.size()) {
            currentPlayer = players.get(0);
        } else {
            currentPlayer = players.get(players.indexOf(currentPlayer) + 1);
        }
    }

    public boolean handleCorrectAnswer() {
        if (currentPlayer.isInPenaltyBox()) {
            if (isGettingOutOfPenaltyBox) {
                return correctAnswer();
            } else {
                changePlayer();
                return true;
            }
        } else {
            return correctAnswer();
        }
    }

    public boolean correctAnswer() {
        System.out.println("Answer was correct!!!!");
        currentPlayer.incrementPurse();
        System.out.println(currentPlayer
                + " now has "
                + currentPlayer.getPurse()
                + " Gold Coins.");

        boolean winner = currentPlayer.didPlayerWin();
        if (!winner) {
            changePlayer();
        }
        return winner;
    }

    public void handleWrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);
        changePlayer();
    }
}
