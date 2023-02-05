package comp208.dobra;

public class Card {
    int col;
    int row;
    public int resourceId;
    public int actualImgId;

    public Card() {
        this.col = 0;
        this.row = 0;
    }

    public Card(int col, int row) {
        this.col = col;
        this.row = row;
    }

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
