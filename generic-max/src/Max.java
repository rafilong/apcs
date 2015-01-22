import javax.swing.*;

/**
 * Generic Max Homework
 * Coded by Rafi Long
 */
public class Max {

    public static void main(String args[]) {
        Display display = new Display();

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(440, 440);
        frame.setLocation(200, 100);
        frame.setVisible(true);

        frame.add(display);
        display.repaint();
    }
}
