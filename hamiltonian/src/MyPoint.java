/**
 * A myPoint class that supports getX, setX, getY, and setY
 * Coded by Rafi Long
 *
 * See methods for more documentation
 */
public class MyPoint {
    /** A coordinate called x, is a value that corresponds to a part of a coordinate */
    private int x;

    /** A coordinate called y, is a value that corresponds to a part of a coordinate */
    private int y;

    /**
     * An empty constructor
     */
    public MyPoint() {

    }

    /**
     * A constructor that assigns x and y values
     * @param x the x of the point
     * @param y the y of the point
     */
    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets x
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the value of this.x to be x
     * @param x the value this.x is to be set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets y
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the value of this.y to be y
     * @param y the value this.y is to be set
     */
    public void setY(int y) {
        this.y = y;
    }
}