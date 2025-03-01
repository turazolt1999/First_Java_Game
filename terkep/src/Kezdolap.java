import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * A kezdooldal menuponotot jeleniti meg
 *
 * @version 1.0
 */
public class Kezdolap extends JFrame implements ActionListener {
    public JFrame jatek;
    public JButton newgameButton = new JButton();
    public JButton kilepesButton = new JButton();
    public JLabel logo = new JLabel();
    public JLabel background = new JLabel();
    public Font betutipus = new Font("Comic Sans", Font.PLAIN, 15);
    public Clip clip = AudioSystem.getClip();

    public Kezdolap(JFrame jatekok) throws LineUnavailableException {
        hatter();
        gombok();
        logo();
        zene("music/menu.wav");

        this.jatek = jatekok;
        ImageIcon icon = new ImageIcon("img/icon.png");
        jatek.setIconImage(icon.getImage());
        jatek.setTitle("The Peculiar Expedition by Turesz");
        jatek.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jatek.setLayout(null);
        jatek.setResizable(false);
        jatek.setSize(1280, 720);
        jatek.setVisible(true);
        jatek.add(logo);
        jatek.add(newgameButton);
        jatek.add(kilepesButton);
        jatek.add(background);
    }

    /**
     * A hatterkepet jeleniti meg
     */
    public void hatter() {
        ImageIcon hatter = new ImageIcon("img/background.png");
        background.setIcon(hatter);
        background.setBounds(0, 0, 1280, 720);
    }

    /**
     * Gombok generalasa, pozicionalasa
     */
    public void gombok() {
        newgameButton.setBounds(590, 330, 120, 35);
        newgameButton.addActionListener(this);
        newgameButton.setText("Játék");
        newgameButton.setFocusable(false); // a betűk miatt
        newgameButton.setFont(betutipus);
        newgameButton.setBackground(new Color(0xBAB243));

        kilepesButton.setBounds(590, 380, 120, 35);
        kilepesButton.addActionListener(this);
        kilepesButton.setText("Kilépés");
        kilepesButton.setFocusable(false); // a betűk miatt
        kilepesButton.setFont(betutipus);
        kilepesButton.setBackground(new Color(0xBAB243));
    }

    /**
     * A logo megjelenitese
     */
    public void logo() {
        ImageIcon image1 = new ImageIcon("img/title32.png");

        logo.setIcon(image1);
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setBounds(350, 75, 600, 250); // a háttérben elhelyezve
    }

    /**
     * Zene elinditasa
     *
     * @param name fajl helyenek leirasa
     */
    public void zene(String name) {
        File zene = new File(name);
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(zene);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        try {
            clip.open(audioStream);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-20.0f);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Gombok interakcioinak beallítasa
     *
     * @param e A vart gomb
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newgameButton) {
            jatek.getContentPane().removeAll();
            jatek.repaint();
            clip.stop();
            try {
                new Display(jatek);
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
        }
        if (e.getSource() == kilepesButton) {
            System.exit(0);
        }
    }
}
