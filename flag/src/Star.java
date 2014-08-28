import java.awt.*;

/**
 * A class that describes a star of particular size and location
 */
public class Star {
    /** The distance the center of the star is on the X axis in relation to the total size of the flag */
    private double ratioX = 0;
    /** The distance the center of the star is on the Y axis in relation to the total size of the flag */
    private double ratioY = 0;
    /** The diameter of the star in relation to the total size of the flag */
    private double ratioD = 0;

    /**
     * Basic rectangle constructor
     * @param ratioX see variable documentation
     * @param ratioY see variable documentation
     * @param ratioD see variable documentation
     */
    public Star(double ratioX, double ratioY, double ratioD) {
        this.ratioX = ratioX;
        this.ratioY = ratioY;
        this.ratioD = ratioD;
    }

    /**
     * Prints the star
     * @param g graphics
     */
    public void drawStar(Graphics g, Color color) {
        g.setColor(color);
        g.fillOval((int) (Display.centerXOffset + ratioX * Display.flagHeight),
                (int) (Display.centerYOffset + ratioY * Display.flagHeight),
                (int) (ratioD * Display.flagHeight),
                (int) (ratioD * Display.flagHeight));
    }
}
