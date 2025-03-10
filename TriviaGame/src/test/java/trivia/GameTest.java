
package trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameTest {

    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
        game.add("Chet");
        game.add("Pat");
        game.add("Sue");
    }

    @Test
    public void caracterizationTest() {
        // runs 10.000 "random" games to see the output of old and new code mathces
        for (int seed = 1; seed < 10_000; seed++) {
            testSeed(seed, false);
        }
    }

    private void testSeed(int seed, boolean printExpected) {
        String expectedOutput = extractOutput(new Random(seed), new GameOld());
        if (printExpected) {
            System.out.println(expectedOutput);
        }
        String actualOutput = extractOutput(new Random(seed), new Game());
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    @Disabled("enable back and set a particular seed to see the output")
    public void oneSeed() {
        testSeed(1, true);
    }

    private String extractOutput(Random rand, IGame aGame) {
        PrintStream old = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (PrintStream inmemory = new PrintStream(baos)) {
            // WARNING: System.out.println() doesn't work in this try {} as the sysout is captured and recorded in memory.
            System.setOut(inmemory);

            aGame.add("Chet");
            aGame.add("Pat");
            aGame.add("Sue");

            boolean winner = false;
            do {
                aGame.roll(rand.nextInt(5) + 1);

                if (rand.nextInt(9) == 7) {
                    aGame.handleWrongAnswer();
                } else {
                    winner = aGame.handleCorrectAnswer();
                }

            } while (!winner);
        } finally {
            System.setOut(old);
        }

        return new String(baos.toByteArray());
    }


    @Test
    public void testAddPlayer() {
        assertEquals(3, game.players.size());
        assertEquals("Chet", game.players.get(0).getName());
        assertEquals("Pat", game.players.get(1).getName());
        assertEquals("Sue", game.players.get(2).getName());
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
    public void testWinner(){
        Player player = game.currentPlayer;
        player.setPurse(6);
        assertTrue(player.didPlayerWin());
    }

    @Test
    public void testExitPenaltyBox(){
        Player player = game.currentPlayer;
        player.setInPenaltyBox(true);
        game.roll(3);
        assertFalse(player.isInPenaltyBox());
    }

    @Test
    public void testNotExitPenaltyBox(){
        Player player = game.currentPlayer;
        player.setInPenaltyBox(true);
        game.roll(2);
        assertTrue(player.isInPenaltyBox());
    }

    @Test
    public void testNextPlayer(){
        Player player = game.currentPlayer;
        game.nextPlayer();
        assertNotEquals(player, game.currentPlayer);
    }

    @Test
    public void testNextPlayerLast(){
        game.currentPlayer = game.players.get(2);
        game.nextPlayer();
        assertEquals(game.players.get(0), game.currentPlayer);
    }
}
