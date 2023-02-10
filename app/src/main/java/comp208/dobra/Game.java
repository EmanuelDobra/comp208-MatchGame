package comp208.dobra;

/**
 * Game class that has the basic stats of the matching game
 * score - the amount of moves the user makes to find all matches
 * matchingPairs - the amount of pairs matched
 * increaseScore() - increments score
 * increaseMatchingPairs - increments matchingPairs
 * Game() - constructor setting stats to 0
 */
public class Game {
    int score;
    int matchingPairs;

    public Game() {
        this.score = 0;
        this.matchingPairs = 0;
    }

    public void increaseScore() {
        this.score++;
    }
    public void incrementMatchingPairs() { this.matchingPairs++; }
}
