import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JComponent {
    private static BufferedImage yes;
    private static BufferedImage no;
    private static BufferedImage time;

    public Display() {
        try {
            yes = ImageIO.read(new File("src/yes.png"));
            no = ImageIO.read(new File("src/no.png"));
            time = ImageIO.read(new File("src/time.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        repaint();
    }

    public void paint(Graphics g) {
        if (Main.rand > 0.51) {
            g.drawImage(yes, 0, 0, null);
        } else if (Main.rand < 0.49) {
            g.drawImage(no, 0, 0, null);
        } else {
            g.drawImage(time, 0, 0, null);
        }
    }
}