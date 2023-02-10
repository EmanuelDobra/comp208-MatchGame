package comp208.dobra;

/**
 * Card class that defines a card in our matching game
 * col - column position
 * row - row position
 * resourceId - the id of what's currently displayed to the user
 * actualImgId - the id of the card's identity - the matching image
 */
public class Card {
    int col;
    int row;
    public int resourceId;
    public int actualImgId;

    // default constructor
    public Card() {
        this.col = 0;
        this.row = 0;
    }

    // constructor with col and row given
    public Card(int col, int row) {
        this.col = col;
        this.row = row;
    }

    // setters
    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
    public void setActualImgId(int imgId) {
        this.actualImgId = imgId;
    }
}
