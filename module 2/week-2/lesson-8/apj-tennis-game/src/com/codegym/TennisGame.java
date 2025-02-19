package src.com.codegym;

public class TennisGame {

    public static final int LOVE = 0;
    public static final int FIFTEEN = 1;
    public static final int THIRTY = 2;
    public static final int FORTY = 3;

    public static String getScore(String player1Name, String player2Name, int scorePlayer1, int scorePlayer2) {
        StringBuilder score = new StringBuilder();
        if (scorePlayer1 == scorePlayer2) {
            score = getEqualScore(scorePlayer1);
        } else if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            score = getAdvantageOrWin(scorePlayer1, scorePlayer2);
        } else {
            getNormalScore(scorePlayer1, scorePlayer2, score);
        }
        return score.toString();
    }

    private static void getNormalScore(int scorePlayer1, int scorePlayer2, StringBuilder score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = scorePlayer1;
            else {
                score.append("-");
                tempScore = scorePlayer2;
            }
            switch (tempScore) {
                case LOVE:
                    score.append("Love");
                    break;
                case FIFTEEN:
                    score.append("Fifteen");
                    break;
                case THIRTY:
                    score.append("Thirty");
                    break;
                case FORTY:
                    score.append("Forty");
                    break;
            }
        }
    }

    private static StringBuilder getAdvantageOrWin(int scorePlayer1, int scorePlayer2) {
        StringBuilder score;
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) score = new StringBuilder("Advantage player1");
        else if (minusResult == -1) score = new StringBuilder("Advantage player2");
        else if (minusResult >= 2) score = new StringBuilder("Win for player1");
        else score = new StringBuilder("Win for player2");
        return score;
    }

    private static StringBuilder getEqualScore(int scorePlayer1) {
        StringBuilder score;
        switch (scorePlayer1) {
            case LOVE:
                score = new StringBuilder("Love-All");
                break;
            case FIFTEEN:
                score = new StringBuilder("Fifteen-All");
                break;
            case THIRTY:
                score = new StringBuilder("Thirty-All");
                break;
            case FORTY:
                score = new StringBuilder("Forty-All");
                break;
            default:
                score = new StringBuilder("Deuce");
                break;

        }
        return score;
    }
}