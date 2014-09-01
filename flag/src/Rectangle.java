/*
 * AP Computer Science Flag Project
 * Code written by Rafi Long
 * See code for documentation
 */

import java.awt.*;

/**
 * Describes a rectangle of particular size and location in relation to the height of the flag
 * Draws the rectangle
 */
public class Rectangle {
    /** The distance the rectangle is on the X axis in relation to the total size of the flag */
    private double ratioX = 0;
    /** The distance the rectangle is on the Y axis in relation to the total size of the flag */
    private double ratioY = 0;
    /** The width of the rectangle in relation to the total size of the flag */
    private double ratioW = 0;
    /** The height of the rectangle in relation to the total size of the flag */
    private double ratioH = 0;

    /**
     * Basic rectangle constructor
     * @param ratioX see variable documentation
     * @param ratioY see variable documentation
     * @param ratioW see variable documentation
     * @param ratioH see variable documentation
     */
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
     * @param g graphics
     */
    public void drawRectangle(Graphics g, Color color) {
        g.setColor(color);
        g.fillRect((int) (Display.centerXOffset + ratioX * Display.flagHeight),
                (int) (Display.centerYOffset + ratioY * Display.flagHeight),
                (int) (ratioW * Display.flagHeight),
                (int) (ratioH * Display.flagHeight) + 1);
    }
}
