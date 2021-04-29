package com.summitthai.tennis_legacy20;

public class tennisScore {

	private static int love = 0;
	private static int fifteen = 1;
	private static int thirty = 2;
	private static int forty = 3;
	private static int over = 4;

	private String nameFor(int score) {
		if (score == fifteen) {
			return Point.Fifteen.name();
		}

		return Point.Love.name();
	}

	private enum Point {
		Love(love), Fifteen(fifteen), Thirty(thirty), Forty(forty), OverForty(over);

		private final int score;

		private Point(int score) {
			this.score = score;
		}

		public Point fromScore(int score) {
			return null;
		}

		public int getScore() {
			return score;
		}

	}

	private int m_score1 = 0;
	private int m_score2 = 0;
	private String player1Name;
	private String player2Name;

//	public TennisGame1(String player1Name, String player2Name) {
//		        this.player1Name = player1Name;
//		        this.player2Name = player2Name;
//		    }

	public void wonPoint(String playerName) {
		if (playerName == "player1") {
			m_score1 += 1;
		} else {
			m_score2 += 1;
		}
	}

	private String scoreForPossibleWin() {
		String score;
		int minusResult = m_score1 - m_score2;
		if (minusResult == 1) {
			score = "Advantage player1";
		} else if (minusResult == -1) {
			score = "Advantage player2";
		} else if (minusResult >= 2) {
			score = "Win for player1";
		} else {
			score = "Win for player2";
		}
		return score;
	}

	private boolean tie() {
		return m_score1 == m_score2;
	}

	private boolean possibleWin() {
		return m_score1 >= over || m_score2 >= over;
	}

}
