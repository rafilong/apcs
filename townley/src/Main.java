import javax.swing.*;

public class Main {
    public static double rand = Math.random();
    public static Display display = new Display();
    public static JFrame frame = new JFrame();

    public static void main(String args[]) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(415, 430);
        frame.setLocation(200, 100);
        frame.setVisible(true);

        frame.add(display);
        display.repaint();
    }
}
