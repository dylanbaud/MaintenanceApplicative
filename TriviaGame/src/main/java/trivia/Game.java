package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game implements IGame {
    ArrayList<Player> players = new ArrayList<>();

    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    Player currentPlayer;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(("Rock Question " + i));
        }
    }

    public boolean add(String playerName) {
        players.add(new Player(playerName));
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public void roll(int roll) {

        if (currentPlayer == null) {
            currentPlayer = players.get(0);
        }

        System.out.println(currentPlayer + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                System.out.println(currentPlayer + " is getting out of the penalty box");

                movePlayer(roll);
            } else {
                System.out.println(currentPlayer + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }
        } else {
            movePlayer(roll);
        }
    }

    private void movePlayer(int roll) {
        currentPlayer.setPlace(currentPlayer.getPlace() + roll);
        if (currentPlayer.getPlace() > 12)
            currentPlayer.setPlace(currentPlayer.getPlace() - 12);

        System.out.println(currentPlayer
                + "'s new location is "
                + currentPlayer.getPlace());
        askQuestion();
    }

    private void askQuestion() {
        String category = currentCategory();
        System.out.println("The category is " + category);
        switch (category) {
            case "Pop":
                System.out.println(popQuestions.remove(0));
                break;
            case "Science":
                System.out.println(scienceQuestions.remove(0));
                break;
            case "Sports":
                System.out.println(sportsQuestions.remove(0));
                break;
            case "Rock":
                System.out.println(rockQuestions.remove(0));
                break;
        }
    }

    private String currentCategory() {
        switch ((currentPlayer.getPlace() - 1)%4) {
            case 0:
                return "Pop";
            case 1:
                return "Science";
            case 2:
                return "Sports";
            default:
                return "Rock";
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
                return answerWasCorrect();
            } else {
                changePlayer();
                return true;
            }

        } else {
            return answerWasCorrect();
        }
    }

    public boolean answerWasCorrect() {
        System.out.println("Answer was correct!!!!");
        currentPlayer.setPurse(currentPlayer.getPurse() + 1);
        System.out.println(currentPlayer
                + " now has "
                + currentPlayer.getPurse()
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        changePlayer();
        return winner;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);
        changePlayer();
        return true;
    }


    private boolean didPlayerWin() {
        return !(currentPlayer.getPurse() == 6);
    }
}
