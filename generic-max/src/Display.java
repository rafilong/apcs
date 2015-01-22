import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A display class
 */
public class Display extends JComponent {
    private static BufferedImage max;

    public Display() {
        try {
            max = ImageIO.read(new File("max.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void paintComponent(Graphics g) {
        g.drawImage(max, 0, 0, null);
    }
}
