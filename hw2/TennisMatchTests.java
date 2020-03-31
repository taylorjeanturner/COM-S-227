package hw2;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
public class TennisMatchTests {
	private TennisMatch tm;
	
	@Before
	public void setup()	{
		tm = new TennisMatch("P1", "P2", true, 1, 1); //DO NOT EDIT! (if these values are changed, the test results will be incorrect)
		//Match is initialized before each test is run.
	}
	
	@Test
	public void testInitial()	{
		assertEquals("The ball should not have been served yet.\n", false, tm.getBallServed());
		assertEquals("The game should not be over yet.\n", false, tm.getGameOver());
		assertEquals("The ball should not be in play yet.\n", false, tm.getBallInPlay());
		assertEquals("The bestOfThree value is not correct.\n", true, tm.getBestOfThree());
		assertEquals("The initial server is not correct.\n", tm.getName(1), tm.getServer());
		assertEquals("The receiver is not correct.\n", tm.getName(2), tm.getReceiver());
		//Checks to see if getGameScore() returns "Love-Love" regardless of capitalization. If not: the assertEquals method is checked. else: ignored 
		if (!(tm.getGameScore().equalsIgnoreCase("Love-Love")) && !(tm.getGameScore().equalsIgnoreCase("Game score: Love-Love")))	{
			assertEquals("The initial game score is not correct.\n", "Love-Love", tm.getGameScore());
		}
		assertEquals("The initial set score is not correct.\n", "0-0",tm.getSetScore());
		assertEquals("The initial match score is not correct.\n", "0-0",tm.getMatchScore());	
	}
	@Test
	public void testBooleans()	{
		tm.serve();//Player 1 serves the ball
		assertEquals("The ballFrom value is not correct.\n", tm.getServer(), tm.getBallFrom());
		assertEquals("The ballTo value is not correct.\n", tm.getReceiver(), tm.getBallTo());
		assertEquals("The ball should be in play after being served.\n", true, tm.getBallInPlay());
		assertEquals("The ballServed should be true after being served.\n", true, tm.getBallServed());
		tm.returnBall();// Player 2 returns the ball
		assertEquals("The ballFrom value is not correct.\n", tm.getReceiver(), tm.getBallFrom());
		assertEquals("The ballTo value is not correct.\n", tm.getServer(), tm.getBallTo());
		assertEquals("The ball should still be in play after being returned (after being served).\n", true, tm.getBallInPlay());
		assertEquals("The ballServed should be false after being returned.\n", false, tm.getBallServed());
		tm.failedReturn();// Player 1 fails to return the ball. Player 2 scores a point
		assertEquals("The ball should not be in play after a failed return.\n", false, tm.getBallInPlay());
		assertEquals("The ballServed should not be true after a failed return.\n", false, tm.getBallServed());
		tm.serve();
		tm.fault();//Player 1 faults while serving
		assertEquals("The serveFault value is not correct.\n", true, tm.getServeFault());
		tm.serve();
		tm.fault();//Player 1 faults while serving, giving a point to player 2
		if (!(tm.getGameScore().equalsIgnoreCase("Love-30")) && !(tm.getGameScore().equalsIgnoreCase("Game score: Love-30")))	{
			assertEquals("The initial game score is not correct.\n", "Love-30", tm.getGameScore());
		}
	}
	@Test
	public void testGame1()	{
		tm.serve();
		tm.returnBall();
		tm.failedReturn();
		//Checks to see if getGameScore() returns "Love-15" regardless of capitalization. If not: the assertEquals method is checked. else: ignored 
		if (!(tm.getGameScore().equalsIgnoreCase("Love-15")) && !(tm.getGameScore().equalsIgnoreCase("Game score: Love-15")))	{
			assertEquals("The initial game score is not correct.\n", "Love-15", tm.getGameScore());
		}
		tm.serve();//Player 1 serves the ball again
		assertEquals("The server should not have changed.\n", tm.getName(1), tm.getServer());
		assertEquals("The ballTo value is not correct.\n", tm.getReceiver(), tm.getBallTo());
		tm.returnBall();
		tm.failedReturn();// Player 2 scores a 2nd point
		
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores a 3rd point
		if (!(tm.getGameScore().equalsIgnoreCase("Love-40")) && !(tm.getGameScore().equalsIgnoreCase("Game score: Love-40")))	{
			assertEquals("The game score is not correct.\n", "Love-40", tm.getGameScore());
		}
		tm.serve();
		tm.failedReturn();//Player 1 scores a point
		
		tm.serve();
		tm.failedReturn();//Player 1 scores a 2nd point
		if (!(tm.getGameScore().equalsIgnoreCase("30-40")) && !(tm.getGameScore().equalsIgnoreCase("Game score: 30-40")))	{
			assertEquals("The game score is not correct.\n", "30-40", tm.getGameScore());
		}
		tm.serve();
		tm.failedReturn();//Player 1 scores a 3rd point, putting the score at deuce
		if (!(tm.getGameScore().equalsIgnoreCase("Deuce")))	{
			assertEquals("The game score is not correct.\n", "Deuce", tm.getGameScore());
		}
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores another point, giving him advantage
		if (!(tm.getGameScore().equalsIgnoreCase("Advantage " + tm.getName(2))) && !(tm.getGameScore().equalsIgnoreCase("Advantage: " + tm.getName(2))))	{
			assertEquals("The game score is not correct.\n", ("Advantage: " + tm.getName(2)), tm.getGameScore());
		}
		tm.serve();
		tm.failedReturn();// Player 1 scores another point, putting the score at deuce again
		if (!(tm.getGameScore().equalsIgnoreCase("Deuce")))	{
			assertEquals("The game score is not correct.\n", "Deuce", tm.getGameScore());
		}
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores another point, giving him advantage
		if (!(tm.getGameScore().equalsIgnoreCase("Advantage " + tm.getName(2))) && !(tm.getGameScore().equalsIgnoreCase("Advantage: " + tm.getName(2))))	{
			assertEquals("The game score is not correct.\n", ("Advantage: " + tm.getName(2)), tm.getGameScore());
		}
		tm.serve();
		tm.returnBall();
		tm.failedReturn();// Player 2 scores another point, winning him the game
		
		//Game 1 ends. Players switch sides (odd-games only), and the server is switched
		
		if (!(tm.getSetScore().equalsIgnoreCase("0-1") && !(tm.getSetScore().equalsIgnoreCase("Set score: 0-1"))))	{
			assertEquals("The Set score is not correct after p2 won a game.\n", "0-1", tm.getSetScore());
		}
		if (!(tm.getGameScore().equalsIgnoreCase("Love-Love")) && !(tm.getGameScore().equalsIgnoreCase("Game score: Love-Love")))	{
			assertEquals("The game score is not correct after a game has been one (the gameScore values should be reset when a game is won).\n", "Love-Love", tm.getGameScore());
		}
		assertEquals("The server is not correct.\n", tm.getName(2), tm.getServer());
		assertEquals("The receiver is not correct.\n", tm.getName(1), tm.getReceiver());
		assertEquals("The player 1 side is not correct.\n", tm.getP1End(), 2);
		assertEquals("The player 2 side is not correct.\n", tm.getP2End(), 1);
		tm.setGameScore(3, 0);
		tm.serve();
		tm.returnBall();
		tm.failedReturn();//Player 1 scores a point and wins game 2
		if (!(tm.getSetScore().equalsIgnoreCase("1-1") && !(tm.getSetScore().equalsIgnoreCase("Set score: 1-1"))))	{
			assertEquals("The Set score is not correct after p1 won a game.\n", "1-1", tm.getSetScore());
		}
		assertEquals("The player 1 end.\n", tm.getP1End(), 2);
		assertEquals("The server is not correct.\n", tm.getName(1), tm.getServer());
	}
	@Test
	public void testGame2()	{
		tm.setScore(2, 2, 5, 5, 1, 1);
		if (!(tm.getSetScore().equalsIgnoreCase("Game score: 30-30\nSet score: 5-5\nMatch score: 1-1")))	{
			assertEquals("The getScore() accessor is not returning the right values. (possibly an issue with setScore() method)\n", "Game score: 30-30\nSet score: 5-5\nMatch score: 1-1", tm.getScore());
		}
	}

}
