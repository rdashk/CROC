package dz_3;

public class Cage extends ChessBoard{

    private int x;
    private int y;

    // Array of letters for column
    private Character[] letters = new Character[]{
            'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h'
    };

    /**
     * Constructor coordinates
     * @param x - value of column
     * @param y - value of line
     */
    public Cage(int x, int y) {

        // if value x is wrong
        if (x < 0 || x > 7) {
            throw new IllegalArgumentException();
        }

        // if value y is wrong
        if (y < 0 || y > 7) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Getting x value
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Setting new value of x
     * @param x - new value x
     */
    public void setX(int x) {

        // if value x is wrong
        if (x < 0 || x > 7) {
            throw new IllegalArgumentException();
        }
        this.x = x;
    }

    /**
     * Getting y value
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Setting new value of y
     * @param y - new value y
     */
    public void setY(int y) {

        // if value y is wrong
        if (y < 0 || y > 7) {
            throw new IllegalArgumentException();
        }
        this.y = y;
    }

    @Override
    public String toString() {
        return "" + letters[x] + (y+1);
    }
}
