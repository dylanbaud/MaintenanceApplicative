
package trivia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.addPlayer("Sue");
        game.startGame();
    }

    @Test
    public void testAddPlayer() {
        assertEquals(3, game.players.size());
        assertEquals("Chet", game.players.get(0).getName());
        assertEquals("Pat", game.players.get(1).getName());
        assertEquals("Sue", game.players.get(2).getName());
    }

    @Test
    public void testAddPlayerGameStarted() {
        game.startGame();
        game.addPlayer("John");
        assertEquals(3, game.players.size());
    }

    @Test
    public void testAddPlayerAlreadyExists() {
        Game game = new Game();
        game.addPlayer("Chet");
        game.addPlayer("Chet");
        assertEquals(1, game.players.size());
    }

    @Test
    public void testStartGameWithLessThanTwoPlayers() {
        Game game = new Game();
        game.addPlayer("Chet");
        assertFalse(game.startGame());
    }

    @Test
    public void testStartGameWithMoreThanSixPlayers() {
        Game game = new Game();
        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.addPlayer("Sue");
        game.addPlayer("John");
        game.addPlayer("Jane");
        game.addPlayer("Doe");
        game.addPlayer("Smith");
        assertFalse(game.startGame());
    }

    @Test
    public void testRoll() {
        game.roll(2);
        assertEquals(3, game.currentPlayer.getPlace());
    }

    @Test
    public void testHandleCorrectAnswer() {
        Player player = game.currentPlayer;
        game.roll(2);
        boolean winner = game.handleCorrectAnswer();
        assertEquals(1, player.getPurse());
        assertFalse(winner);
    }

    @Test
    public void testHandleCorrectAnswerWinner() {
        Player player = game.currentPlayer;
        player.setPurse(5);
        game.roll(2);
        boolean winner = game.handleCorrectAnswer();
        assertEquals(6, player.getPurse());
        assertTrue(winner);
    }

    @Test
    public void testHandleCorrectAnswerPenaltyBox() {
        Player player = game.currentPlayer;
        player.setInPenaltyBox(true);
        game.roll(2);
        boolean winner = game.handleCorrectAnswer();
        assertEquals(0, player.getPurse());
        assertFalse(winner);
    }

    @Test
    public void testHandleCorrectAnswerPenaltyBoxAndGetOut() {
        Player player = game.currentPlayer;
        player.setInPenaltyBox(true);
        game.roll(3);
        game.handleCorrectAnswer();
        assertEquals(1, player.getPurse());
    }

    @Test
    public void testHandleWrongAnswer() {
        Player player = game.currentPlayer;
        game.roll(2);
        game.handleWrongAnswer();
        assertEquals(0, player.getPurse());
        assertTrue(player.isInPenaltyBox());
    }

    @Test
    public void testWinner() {
        Player player = game.currentPlayer;
        player.setPurse(6);
        assertTrue(player.didPlayerWin());
    }

    @Test
    public void testExitPenaltyBox() {
        Player player = game.currentPlayer;
        player.setInPenaltyBox(true);
        game.roll(3);
        assertFalse(player.isInPenaltyBox());
    }

    @Test
    public void testNotExitPenaltyBox() {
        Player player = game.currentPlayer;
        player.setInPenaltyBox(true);
        game.roll(2);
        assertTrue(player.isInPenaltyBox());
    }

    @Test
    public void testNextPlayer() {
        Player player = game.currentPlayer;
        game.nextPlayer();
        assertNotEquals(player, game.currentPlayer);
    }

    @Test
    public void testNextPlayerLast() {
        game.currentPlayer = game.players.get(2);
        game.nextPlayer();
        assertEquals(game.players.get(0), game.currentPlayer);
    }

    @Test
    public void testMovePlayer() {
        game.movePlayer(2);
        assertEquals(3, game.currentPlayer.getPlace());
    }

    @Test
    public void testMovePlayerPassCases() {
        game.currentPlayer.setPlace(11);
        game.movePlayer(2);
        assertEquals(1, game.currentPlayer.getPlace());
    }
}
