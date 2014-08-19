/*
 * Cow Project
 * Written by Rafi Long
 *
 * See code for documentation
 * Description of classes and methods are included in JavaDocs
 */

import javax.swing.*;
import java.awt.*;

/**
 * Display class
 */
public class Display extends JComponent {

    /**
     * No need for content in constructor: display automatically paints on create
     */
    public Display() {

    }

    /**
     * Includes all the individual body parts of the cow
     * Organized by body part
     * Paints each body part
     * @param g graphics
     */
    public void paint(Graphics g) {
        //body
        g.setColor(Color.BLACK);
        g.fillRect(20, 100, 300, 150);
        //head
        g.fillRect(280, 70, 80, 70);
        //back right leg
        g.fillRect(20, 250, 20, 40);
        //back left leg
        g.fillRect(60, 250, 20, 35);
        //front right leg
        g.fillRect(260, 250, 20, 40);
        //front left leg
        g.fillRect(300, 250, 20, 35);
        //eyes
        g.setColor(Color.WHITE);
        g.fillRect(290, 90, 20, 10);
        g.fillRect(330, 90, 20, 10);
        g.setColor(Color.BLACK);
        g.fillRect(295, 92, 10, 6);
        g.fillRect(335, 92, 10, 6);
        //spots
        g.setColor(Color.WHITE);
        g.fillRect(50, 120, 70, 30);
        g.fillRect(190, 130, 90, 60);
        g.fillRect(90, 200, 50, 20);
    }
}
