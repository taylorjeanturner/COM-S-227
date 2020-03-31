package hw2;

public class TennisMatch {
	/**
	 * Creates a tennis match
	 * 
	 * @author Taylor Turner
	 */
	/**
	 * Creates a player 1 and player 2 for the tennis match
	 */
	private TennisPlayer player1, player2;
	/**
	 * Keeps track of which player is the server and which end they're in
	 */
	private int server, serverEnd;
	/**
	 * Checks if ball is in play
	 */
	private boolean ballInPlay;
	/**
	 * Checks if ball has been served
	 */
	private boolean ballServed;
	/**
	 * Checks if there has been a serve fault
	 */
	private boolean serveFault;
	/**
	 * Checks if game is over or not
	 */
	private boolean gameOver;
	/**
	 * Checks if player has won best of two of three sets
	 */
	private boolean bestOfThree;
	/**
	 * Tracks number of faults
	 */
	private int faultNumber;
	/**
	 * Tracks how many sets have been played
	 */
	private int setNumber;
	/**
	 * Tracks which side of the court the ball is on. 0 if not in play
	 */
	private int ball;

	/**
	 * Creates a new tennis match
	 * 
	 * @param p1Name           The name of the first player
	 * @param p2Name           The name of the second player
	 * @param playBestOfThree  Match is best-of-3 sets if true; else best of 5
	 * @param initialServer    Specifies which player serves first
	 * @param initialServerEnd Specifies which end the initial server starts on
	 */
	public TennisMatch(String p1Name, String p2Name, boolean playBestOfThree, int initialServer, int initialServerEnd) {

		bestOfThree = playBestOfThree;
		ballServed = false;
		ballInPlay = false;
		gameOver = false;
		setNumber = 0;
		server = initialServer;
		serverEnd = initialServerEnd;
		faultNumber = 0;
		ball = 0;
		if (server == 1) {
			player1 = new TennisPlayer(p1Name, serverEnd);
			player2 = new TennisPlayer(p2Name, serverEnd % 2 + 1);
		} else if (server == 2) {
			player2 = new TennisPlayer(p2Name, serverEnd);
			player1 = new TennisPlayer(p1Name, serverEnd % 2 + 1);
		}
	}

	/**
	 * Serves the ball. Does nothing if game is over
	 */
	public void serve() {
		serveFault = false;
		if (gameOver != true) {
			ballServed = true;
			ballInPlay = true;
			ball = server % 2 + 1;
		}
	}

	/**
	 * Registers a serve fault. Does nothing if the ball if not being served. Two
	 * serve faults yield a game point for the receiver.
	 */
	public void fault() {
		if (ballServed = true) {
			ballServed = false;
			serveFault = true;
			faultNumber++;
			if (faultNumber == 2) {
				if (server == 1) {
					incrementGamePoints(player2, player1);
					faultNumber = 0;
				} else {
					incrementGamePoints(player1, player2);
					faultNumber = 0;
				}
			}
		}
	}

	/**
	 * Reverses the direction of the ball. Ball is no longer being served. Does
	 * nothing if the ball is not in play.
	 */
	public void returnBall() {
		if (ballInPlay == true) {
			ball = ball % 2 + 1;
			ballServed = false;
			faultNumber = 0;
		}
	}

	/**
	 * Takes the ball out of play. The player who last served or returned the ball
	 * scores a game point.
	 */
	public void failedReturn() {

		if (ball == 1) {
			incrementGamePoints(player2, player1);
		} else {
			incrementGamePoints(player1, player2);
		}

		ballServed = false;
	}

	/**
	 * Ends the current point early without a point being scored.
	 */
	public void let() {
		ballServed = false;
		ballInPlay = false;
	}

	/**
	 * Returns the match score p1-p2
	 * 
	 * @return the match score
	 */
	public java.lang.String getMatchScore() {
		return "Match score: " + player1.getMatchPoints() + "-" + player2.getMatchPoints();
	}

	/**
	 * Returns the set score set score p1-p2
	 * 
	 * @return the set score
	 */
	public java.lang.String getSetScore() {
		return "Set score: " + player1.getSetPoints() + "-" + player2.getSetPoints();
	}

	/**
	 * Returns the game score p1-p2, Advantage name or Deuce. (See section 5)
	 * 
	 * @return the game score
	 */
	public java.lang.String getGameScore() {
		String score;
		String p1Score = null;
		String p2Score = null;
		int p1 = player1.getGamePoints();
		int p2 = player2.getGamePoints();
		if ((p1 >= 4) && (p1 == p2 + 1)) {
			score = "Advantage " + player1.getName();
		} else if ((p2 >= 4) && (p2 == p1 + 1)) {
			score = "Advantage " + player2.getName();
		} else if (((p1 == p2) && (p1 >= 3) && (p2 >= 3))) {
			score = "Deuce";
		} else if (((p1 + 1 == p2) && (p1 >= 3) && (p2 >= 3))) {
			score = "Game";
		} else if (((p2 + 1 == p1) && (p1 >= 3) && (p2 >= 3))) {
			score = "Game";
		} else if (p1 >= 4) {
			score = "Game";
		} else if (p2 >= 4) {
			score = "Game";
		} else {

			if (p1 == 0) {
				p1Score = "Love";
			}
			if (p1 == 1) {
				p1Score = "15";
			}
			if (p1 == 2) {
				p1Score = "30";
			}
			if (p1 == 3) {
				p1Score = "40";
			}
			if (p2 == 0) {
				p2Score = "Love";
			}
			if (p2 == 1) {
				p2Score = "15";
			}
			if (p2 == 2) {
				p2Score = "30";
			}
			if (p2 == 3) {
				p2Score = "40";
			}

			score = p1Score + "-" + p2Score;
		}
		return "Game score: " + score;
	}

	/**
	 * Set the game, set, and match scores
	 * 
	 * @param p1Game  Player 1's game score
	 * @param p2Game  Player 2's game score
	 * @param p1Set   Player 1's set score
	 * @param p2Set   Player 2's set score
	 * @param p1Match Player 1's match score
	 * @param p2Match Player 2's match score
	 */
	public void setScore(int p1Game, int p2Game, int p1Set, int p2Set, int p1Match, int p2Match) {
		player1.setGamePoints(p1Game);
		player2.setGamePoints(p2Game);
		player1.setSetPoints(p1Set);
		player2.setSetPoints(p2Set);
		player1.setMatchPoints(p1Match);
		player2.setMatchPoints(p2Match);
	}

	/**
	 * Returns the full game, set, and match score
	 * 
	 * @return the score
	 */
	public java.lang.String getScore() {
		return getGameScore() + "\n" + getSetScore() + "\n" + getMatchScore();
	}

	/**
	 * Sets the game score
	 * 
	 * @param p1Game Player 1's new game score
	 * @param p2Game Player 2's new game score
	 */
	public void setGameScore(int p1Game, int p2Game) {
		player1.setGamePoints(p1Game);
		player2.setGamePoints(p2Game);
	}

	/**
	 * Sets the set score
	 * 
	 * @param p1Set Player 1's new set score
	 * @param p2Set Player 2's new set score
	 */
	public void setSetScore(int p1Set, int p2Set) {
		player1.setSetPoints(p1Set);
		player2.setSetPoints(p2Set);
	}

	/**
	 * Sets the match score
	 * 
	 * @param p1Match Player 1's new match score
	 * @param p2Match Player 2's new match score
	 */
	public void setMatchScore(int p1Match, int p2Match) {
		player1.setMatchPoints(p1Match);
		player2.setMatchPoints(p2Match);
	}

	/**
	 * Sets the server
	 * 
	 * @param player The new server
	 */
	public void setServe(int player) {
		if (player == 1) {
			server = 1;
		}
		if (player == 2) {
			server = 2;
		}
	}

	/**
	 * Sets the server's end
	 * 
	 * @param end The new end
	 */
	public void setServerEnd(int end) {
		serverEnd = end;
	}

	/**
	 * Returns the winner's name, or an error message if the match is not over
	 * 
	 * @return the winner's name or an error message if the match is not over
	 */
	public java.lang.String getWinner() {

		if (player1.getMatchPoints() > player2.getMatchPoints()) {
			return player1.getName();
		}
		if (player2.getMatchPoints() > player1.getMatchPoints()) {
			return player2.getName();
		}

		return "Game is not over";
	}

	/**
	 * Swaps the ends of the two players
	 */
	public void changeEnds() {

		int x = player1.getEnd();
		player1.setEnd(player2.getEnd());
		player2.setEnd(x);

	}

	/**
	 * Swaps the server and the receiver
	 */
	public void changeServer() {
		server = (server % 2) + 1;
	}

	/**
	 * Adds one game point to addTo's game total. Zeros game score and increments
	 * set score if game has ended. Removes ball from play. Clears faults.
	 * 
	 * @param addTo The player who has scored
	 * @param noAdd The other player
	 */
	public void incrementGamePoints(TennisPlayer addTo, TennisPlayer noAdd) {
		addTo.incrementGamePoints();
		if (addTo.getGamePoints() >= 4) {
			if ((Math.abs(addTo.getGamePoints() - noAdd.getGamePoints())) >= 2) {

				incrementSetPoints(addTo, noAdd);
				addTo.setGamePoints(0);
				noAdd.setGamePoints(0);
			}
			ballInPlay = false;
			faultNumber = 0;
		}
	}

	/**
	 * Adds one set point to addTo's total. Zeros set score and increments match
	 * score if set has ended. Changes server. Changes ends after odd numbered sets.
	 * 
	 * @param addTo The player who scored the point
	 * @param noAdd The other player
	 */
	public void incrementSetPoints(TennisPlayer addTo, TennisPlayer noAdd) {
		addTo.incrementSetPoints();
		changeServer();
		setNumber++;
		if (addTo.getSetPoints() >= 6) {
			if ((Math.abs(addTo.getSetPoints() - noAdd.getSetPoints())) >= 2) {

				incrementMatchPoints(addTo, noAdd);
				setNumber = 0;
				setGameScore(0, 0);
			}
		}
		if (setNumber % 2 == 1) {
			changeEnds();
		}

	}

	/**
	 * Adds one match point to addTo's total. Sets game over if match has ended.
	 * 
	 * @param addTo The player who has scored a point
	 * @param noAdd The other player
	 */
	public void incrementMatchPoints(TennisPlayer addTo, TennisPlayer noAdd) {
		addTo.incrementMatchPoints();
		if (getBestOfThree() == true) {
			setSetScore(0, 0);
			setNumber = 0;
		}
	}

	/**
	 * Returns p1's end
	 * 
	 * @return p1's end
	 */
	public int getP1End() {
		return player1.getEnd();
	}

	/**
	 * Returns p2's end
	 * 
	 * @return p2's end
	 */
	public int getP2End() {
		return player2.getEnd();
	}

	/**
	 * Returns serve fault status
	 * 
	 * @return serve fault status
	 */
	public boolean getServeFault() {
		return serveFault;
	}

	/**
	 * Returns the server's name or "No server"
	 * 
	 * @return the server's name or "No sever"
	 */
	public java.lang.String getServer() {
		if (server == 1) {
			return player1.getName();
		} else if (server == 2) {
			return player2.getName();
		} else {
			return "No server";
		}

	}

	/**
	 * Returns the reveiver's name or "No receiver"
	 * 
	 * @return the receiver's name
	 */
	public java.lang.String getReceiver() {
		if (server == 1) {
			return player2.getName();
		} else if (server == 2) {
			return player1.getName();
		} else {
			return "No receiver";
		}

	}

	/**
	 * Returns the name of the player whom the ball is heading toward or "Ball not
	 * in play"
	 * 
	 * @return ballTo's name or "Ball not in play"
	 */
	public java.lang.String getBallTo() {
		if (ball == 2) {
			return player1.getName();
		} else if (ball == 1) {
			return player2.getName();
		} else {
			return "Ball not in play";
		}
	}

	/**
	 * Returns the name of the player who last successfully served or returned the
	 * ball or "Ball not in play"
	 * 
	 * @return ballFrom's name or "Ball not in play"
	 */
	public java.lang.String getBallFrom() {
		if (ball == 2) {
			return player2.getName();
		} else if (ball == 1) {
			return player1.getName();
		} else {
			return "Ball not in play";
		}
	}

	/**
	 * Returns ballInPlay
	 * 
	 * @return ballInPlay
	 */
	public boolean getBallInPlay() {
		return ballInPlay;
	}

	/**
	 * Returns ballServed
	 * 
	 * @return ballServed
	 */
	public boolean getBallServed() {
		return ballServed;
	}

	/**
	 * Returns bestOfThree
	 * 
	 * @return bestOfThree
	 */
	public boolean getBestOfThree() {
		if (setNumber == 3
				&& (((player1.getSetPoints() - player2.getSetPoints()) == 1)
						|| (player2.getSetPoints() - player1.getSetPoints()) == 1)
				|| (player1.getSetPoints() >= 2) || (player2.getSetPoints() >= 2)) {
			bestOfThree = true;
		} else if (setNumber == 5
				&& (((player1.getSetPoints() - player2.getSetPoints()) == 2)
						|| (player2.getSetPoints() - player1.getSetPoints()) == 2)
				|| (player1.getSetPoints() >= 3) || (player2.getSetPoints() >= 3)) {
			bestOfThree = false;
		} else {
			bestOfThree = false;
		}

		return bestOfThree;
	}

	/**
	 * Returns gameOver
	 * 
	 * @return gameOver
	 */
	public boolean getGameOver() {

		return gameOver;
	}

	/**
	 * Returns player's name
	 * 
	 * @param player The player
	 * @return player's name
	 */
	public java.lang.String getName(int player) {
		if (player == 1) {
			return player1.getName();
		}
		if (player == 2) {
			return player2.getName();
		} else {
			return null;
		}
	}
}