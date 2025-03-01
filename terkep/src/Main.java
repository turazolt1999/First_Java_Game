import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;

/**
 * A jatekot inditja el
 */
public class Main {
    public static void main(String[] args) throws LineUnavailableException {
        JFrame jatek = new JFrame();
        Kezdolap myFrame = new Kezdolap(jatek);
    }
}
