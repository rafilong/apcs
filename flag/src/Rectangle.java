import java.awt.*;

/**
 * A class that describes a rectangle of particular size and location
 */
public class Rectangle {
    /**
     * The distance the rectangle is on the X axis in relation to the total size of the flag
     */
    private double ratioX = 0;

    /**
     * The distance the rectangle is on the Y axis in relation to the total size of the flag
     */
    private double ratioY = 0;

    /**
     * The width of the rectangle in relation to the total size of the flag
     */
    private double ratioW = 0;

    /**
     * The height of the rectangle in relation to the total size of the flag
     */
    private double ratioH = 0;

    public Rectangle(double ratioX, double ratioY, double ratioW, double ratioH) {
        this.ratioX = ratioX;
        this.ratioY = ratioY;
        this.ratioW = ratioW;
        this.ratioH = ratioH;
    }

    /**
     * Returns the x
     * @return ratioX
     */
    public double getRatioX() {
        return ratioX;
    }

    /**
     * Returns the y
     * @return ratioY
     */
    public double getRatioY() {
        return ratioY;
    }

    /**
     * Returns the width
     * @return ratioW
     */
    public double getRatioW() {
        return ratioW;
    }

    /**
     * Returns the height
     * @return ratioH
     */
    public double getRatioH() {
        return ratioH;
    }

    /**
     * Prints the rectangle
     * @param g
     */
    public void drawRectangle(Graphics g) {

    }
}