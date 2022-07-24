import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * A jatek GUI megjelenitesere szolgal
 */
public class Display implements ActionListener {
    public final Felfedezo felfedezo = new Felfedezo("Lakatos Brendon");
    public final Felfedezo rivalis1 = new Felfedezo("Charles Darwin");
    public final Felfedezo rivalis2 = new Felfedezo("Richard Francis Burton");
    public final Felfedezo rivalis3 = new Felfedezo("Johan Huizinga");
    public final JFrame frame;
    public String[] bolti_lista = {"Kötél", "Bozótvágó", "Fáklya", "Üveggolyó", "Hús", "Whiskey", "Csokoládé"};
    public String[] falu_bolti_lista = {"Kötél", "Fáklya", "Gyümölcs", "Hús", "Kábítószer"};
    public String[] elelmiszerek_lista = {"Gyümölcs", "Hús", "Csokoládé", "Kábítószer", "Whiskey"};
    public String[] tars_elso_lista = {"Huang Feihong", "Aleister Crowley", "Dolichohippus"};
    public String[] tars_faluban_lista = {"Amelia Earhart", "Yoh Asakura", "Mahátma Gandhi"};
    public String[] ossz_Slot_lista = {"Kötél", "Bozótvágó", "Fáklya", "Üveggolyó", "Hús", "Whiskey", "Csokoládé", "Gyümölcs", "Kábítószer"};
    public String[] kincsek_lista = {"Arany Amulett", "Arany Sas", "Arany Nyaklánc", "Bronz Tekercs"};
    public JComboBox bolti_lista_box = new JComboBox(bolti_lista);
    public JComboBox falvak_lista_combobox = new JComboBox(falu_bolti_lista);
    public JComboBox elel_box = new JComboBox(elelmiszerek_lista);
    public JComboBox tars_eloszor_box = new JComboBox(tars_elso_lista);
    public JComboBox tars_faluban_box = new JComboBox(tars_faluban_lista);
    public JComboBox hajoraHelyezes_box = new JComboBox(ossz_Slot_lista);
    public JComboBox hajoraLevetel_box = new JComboBox(ossz_Slot_lista);
    public JComboBox eladasra_kivan_box = new JComboBox(ossz_Slot_lista);
    public JComboBox kincsek_box = new JComboBox(kincsek_lista);
    public ImageIcon karakter_photos = new ImageIcon("img/karakter.jpg");
    public Eszkozok kotel = new Eszkozok("Kötél", 11);
    public Eszkozok kotel_falu = new Eszkozok("Kötél", 15);
    public Eszkozok bozotvago = new Eszkozok("Bozótvágó", 12);
    public Eszkozok faklya = new Eszkozok("Fáklya", 8);
    public Eszkozok faklya_falu = new Eszkozok("Fáklya", 12);
    public Eszkozok uveggolyo = new Eszkozok("Üveggolyó", 9);
    public Elelmiszer hus = new Elelmiszer("Hús", 10, 25, false);
    public Elelmiszer hus_falu = new Elelmiszer("Hús", 13, 25, false);
    public Elelmiszer whiskey = new Elelmiszer("Whiskey", 16, 20, true);
    public Elelmiszer csokolade = new Elelmiszer("Csokoládé", 16, 20, false);
    public Elelmiszer gyumulcs = new Elelmiszer("Gyümölcs", 26, 15, false);
    public Elelmiszer kabitoszer = new Elelmiszer("Kábítószer", 32, 20, false);
    public Kincs arany_amulett = new Kincs("Arany Amulett", 230, 100);
    public Kincs arany_sas = new Kincs("Arany Sas", 200, 80);
    public Kincs arany_nyaklanc = new Kincs("Arany Nyaklánc", 350, 150);
    public Kincs bronz_tekercs = new Kincs("Bronz Tekercs", 130, 50);
    public Kereskedo kereskedo = new Kereskedo("Huang Feihong");
    public Katona katona = new Katona("Aleister Crowley");
    public Szamar szamar = new Szamar("Dolichohippus");
    public Felderito felderito = new Felderito("Amelia Earhart");
    public Saman saman = new Saman("Yoh Asakura");
    public Bolcs bolcs = new Bolcs("Mahátma Gandhi");
    public Bolt abc = new Bolt();
    public Bolt cba = new Bolt();

    public JPanel nev_panel = new JPanel();
    public JPanel eladas_panel = new JPanel();
    public JPanel palya_panel = new JPanel();
    public JPanel karakter_info_panel = new JPanel();
    public JPanel iranyit_panel = new JPanel();
    public JPanel vasar_panel = new JPanel();
    public JPanel kincs_panel = new JPanel();
    public JPanel vege_panel = new JPanel();
    public JPanel hajoSlot_panel = new JPanel();
    public JLayeredPane layerPanel = new JLayeredPane();

    public JLabel[][] palya_elemek = new JLabel[13][13];
    public JLabel nev_label = new JLabel();
    public JLabel profilkep_label = new JLabel();
    public JLabel slot_label = new JLabel();
    public JLabel tarsak_label = new JLabel();
    public JLabel karakter_body_label = new JLabel();
    public JLabel hajo_body_label = new JLabel();
    public JLabel vasarlista_label = new JLabel();
    public JLabel eladas_label = new JLabel();
    public JLabel eladas_termekek_label = new JLabel();
    public JLabel kincsek_eladasa_label = new JLabel();
    public JLabel vege_label = new JLabel();
    public JLabel hajoSlot_label = new JLabel();
    public JLabel felfedezoInventHaj_label = new JLabel();
    public JLabel hajoSlotTargy_label = new JLabel();
    public JLabel rivalisok_label = new JLabel();
    public JLabel kincsleiras_label = new JLabel();

    public JButton feladas_button = new JButton();
    public JButton nev_button = new JButton();
    public JButton vasarlas_button = new JButton();
    public JButton eladas_button = new JButton();
    public JButton tars_vasarlas_button = new JButton();
    public JButton hajoraFel_button = new JButton();
    public JButton hajoraLe_button = new JButton();
    public JButton hajoslot_button = new JButton();
    public JButton fel_button = new JButton();
    public JButton le_button = new JButton();
    public JButton jobb_button = new JButton();
    public JButton bal_button = new JButton();
    public JButton vissza_button = new JButton();
    public JButton kilepes_button = new JButton();
    public JButton bolt_button = new JButton();
    public JButton kincsek_eladasa_button = new JButton();
    public JButton kincsek_eladomany_button = new JButton();
    public JButton falvak_vasarlas_button = new JButton();
    public JButton falvak_tars_vasarlas_button = new JButton();
    public JButton plusz_energia_button = new JButton();
    public JButton kincs_bezaras_button = new JButton();

    public Font betutipus = new Font("Comic Sans", Font.PLAIN, 15);
    public Clip clip = AudioSystem.getClip();

    public int x = 0;
    public int y = 0;
    public int hajo_x = 0;
    public int hajo_y = 0;
    public int kuldetes_mozgas = 0;
    public int hajos_mozgas = 0;
    public int tars_eloszor_vasar = 0;
    public int reszeg_lepes = 0;
    public int latokor = 1;
    public int hanyadik_kuldetes = 0;

    public boolean hajoSlotHasznal = false;
    public boolean vasarole = false;
    public boolean falu_vasarole = false;
    public boolean sajnos_vege = false;
    public boolean arany_piramis_megvan = false;

    public JTextField nev_textfield = new JTextField();


    public Random randi = new Random();

    ImageIcon fuvek_photo = new ImageIcon("img/terkep/fuvek.png");

    public Display(JFrame framek) throws LineUnavailableException {
        panelek();
        label();
        palya_elemek();
        iranyitas();
        karakter_infok(felfedezo);
        buttons();
        mozgas(x, y);
        zene("music/game.wav");
        boltLetrehozasa();
        falu_boltLetrehozasa();
        vege(false);
        hajoSlot();
        eladas();
        eladas_panel.setVisible(false);
        nevKeres();

        layerPanel.setBounds(0, 0, 1280, 720);
        layerPanel.add(palya_panel);
        layerPanel.add(karakter_info_panel);
        layerPanel.add(iranyit_panel);
        layerPanel.add(nev_panel, JLayeredPane.DRAG_LAYER);
        layerPanel.add(vasar_panel, JLayeredPane.DRAG_LAYER);
        layerPanel.add(kincs_panel, JLayeredPane.DRAG_LAYER);
        layerPanel.add(vege_panel, JLayeredPane.DRAG_LAYER);
        layerPanel.add(hajoSlot_panel, JLayeredPane.DRAG_LAYER);
        layerPanel.add(eladas_panel, JLayeredPane.DRAG_LAYER);

        this.frame = framek;
        framek.add(layerPanel);
    }

    /**
     * A karakter nevének átálításának megjelenítése
     */
    public void nevKeres() {
        nev_button.addActionListener(this);
        nev_button.setText("Elfogad");
        nev_button.setFocusable(false);
        nev_button.setFont(betutipus);
        nev_button.setBackground(new Color(0xBAB243));

        nev_textfield.setBounds(85, 70, 130, 25);
        nev_button.setBounds(100, 100, 100, 20);

        nev_panel.setBackground(new Color(0x8D2550));
        nev_panel.setBorder(BorderFactory.createLineBorder(new Color(0x452740), 10));
        nev_panel.setBounds(400, 250, 300, 150);
        nev_panel.setLayout(null);

        nev_label.setText("Írd be mi legyen a felfedező neve");
        nev_label.setForeground(new Color(0xFFFFFF));
        nev_label.setBounds(55, -10, 200, 100);

        nev_panel.add(nev_label);
        nev_panel.add(nev_textfield);
        nev_panel.add(nev_button);

        fel_button.setEnabled(false);
        le_button.setEnabled(false);
        jobb_button.setEnabled(false);
        bal_button.setEnabled(false);
        hajoslot_button.setEnabled(false);
    }

    /**
     * JPanelek pozicionalasa
     */
    public void panelek() {
        palya_panel.setBounds(0, 0, 1000, 720);
        palya_panel.setBackground(new Color(0x30B341));

        vege_panel.setBackground(new Color(0xAF2B2B));
        vege_panel.setBorder(BorderFactory.createLineBorder(new Color(0x938E37), 10));
        vege_panel.setLayout(null);

        karakter_info_panel.setBounds(1000, 0, 280, 450);
        karakter_info_panel.setBackground(new Color(0x81B171));
        karakter_info_panel.setLayout(null);

        eladas_panel.setBounds(300, 150, 600, 400);
        eladas_panel.setBackground(new Color(0x3FCB5D));
        eladas_panel.setLayout(null);
        eladas_panel.setBorder(BorderFactory.createLineBorder(new Color(0xA11F8926, true), 10));
    }

    /**
     * JLabelek pozicionalasa
     */
    public void label() {
        vege_label.setForeground(new Color(0));

        slot_label.setFont(betutipus);
        slot_label.setBounds(150, 0, 100, 300);
        slot_label.setHorizontalTextPosition(JLabel.CENTER);
        slot_label.setVerticalTextPosition(JLabel.BOTTOM);

        tarsak_label.setFont(betutipus);
        tarsak_label.setBounds(0, 320, 120, 100);
        tarsak_label.setVerticalTextPosition(JLabel.TOP);
        tarsak_label.setHorizontalAlignment(JLabel.CENTER);

        profilkep_label.setFont(betutipus);
        profilkep_label.setHorizontalTextPosition(JLabel.CENTER);
        profilkep_label.setVerticalTextPosition(JLabel.BOTTOM);
        profilkep_label.setIcon(karakter_photos);
        profilkep_label.setBounds(5, 5, karakter_photos.getIconWidth() + 30, karakter_photos.getIconHeight() + 160);
        profilkep_label.setIconTextGap(10);

        kincsleiras_label.setForeground(Color.WHITE);
        kincsleiras_label.setBounds(20, 0, 250, 170);
    }

    /**
     * Rivalisok generalas
     */
    public void rivalisok() {
        int rand = randi.nextInt(1001);
        {
            if (rand < 100) {
                if (rand == 1) {
                    rivalis1.setHirnev(800);
                } else {
                    int hirnev = rivalis1.getHirnev();
                    rivalis1.setHirnev(hirnev + 50);
                }
            } else if (200 < rand && rand < 300) {
                if (rand == 201) {
                    rivalis2.setHirnev(800);
                } else {
                    int hirnev = rivalis2.getHirnev();
                    rivalis2.setHirnev(hirnev + 35);
                }
            } else if (700 < rand && rand < 800) {
                if (rand == 701) {
                    rivalis3.setHirnev(800);
                } else {
                    int hirnev = rivalis3.getHirnev();
                    rivalis3.setHirnev(hirnev + 20);
                }
            }
        }
    }

    /**
     * Kuldetes bolt generalas
     */
    public void boltLetrehozasa() {
        abc.termekHozzaad(kotel, 17);
        abc.termekHozzaad(bozotvago, 15);
        abc.termekHozzaad(faklya, 17);
        abc.termekHozzaad(uveggolyo, 16);
        abc.termekHozzaad(hus, 19);
        abc.termekHozzaad(whiskey, 16);
        abc.termekHozzaad(csokolade, 15);
    }

    /**
     * Falusi boltok generalas
     */
    public void falu_boltLetrehozasa() {
        cba.termekHozzaad(kotel_falu, 17);
        cba.termekHozzaad(faklya_falu, 12);
        cba.termekHozzaad(gyumulcs, 14);
        cba.termekHozzaad(hus_falu, 19);
        cba.termekHozzaad(kabitoszer, 15);
    }

    /**
     * A Game Over menut jeleniti meg
     *
     * @param megjelenitse Eldonti megjeleniti vagy sem
     */
    public void vege(boolean megjelenitse) {
        if (megjelenitse) {
            vege_panel.add(vege_label);

            bal_button.setEnabled(false);
            jobb_button.setEnabled(false);
            fel_button.setEnabled(false);
            le_button.setEnabled(false);
            plusz_energia_button.setEnabled(false);
            vasarlas_button.setEnabled(false);
            hajoslot_button.setEnabled(false);
            if (this.arany_piramis_megvan) {
                vege_panel.setVisible(true);
                vissza_button.setVisible(true);
                kilepes_button.setVisible(true);
                vege_panel.add(vissza_button);
                vege_panel.add(kilepes_button);
                vege_panel.setBounds(380, 280, 300, 200);
                vege_label.setBounds(10, 0, 280, 130);
                vissza_button.setBounds(35, 140, 120, 35);
                kilepes_button.setBounds(150, 140, 120, 35);
                vege_label.setText("<html><p style=\"text-align: center\"><br>GRATULÁLUNK<br><br>MEGTALÁLTAD AZ ARANYPIRAMIST<br>" +
                        "Dönthetsz, hogy haza mész vagy esetleg folytatod tovább a kalandod!<br>" +
                        "Te vagy a LEGHÍRHEDTEBB FELFEDEZŐ</p></html>");
            }
            if (this.hanyadik_kuldetes == 6) {
                vege_panel.setVisible(true);
                vissza_button.setVisible(false);
                kilepes_button.setVisible(true);
                vege_panel.setBounds(380, 180, 300, 300);
                vege_label.setBounds(20, 10, 270, 200);
                kilepes_button.setBounds(93, 230, 120, 35);
                vege_label.setText("<html><p style=\"text-align: center\"><br>GRATULÁLOK!<br> VÉGE A JÁTÉKNAK!<br>" +
                        "Itt vannak veled együtt az összes felfeldező, akik részt vettek a kalandba!<br>" +
                        "Nézd meg hogy teljesítettél többiekhez képest!<br> <br> " +
                        "<table style=\"text-align: center\">" +
                        "<tr>" +
                        "    <td>" + felfedezo.getNev() + "</td>\n" +
                        "    <td>" + felfedezo.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "<tr>" +
                        "    <td>" + rivalis1.getNev() + "</td>\n" +
                        "    <td>" + rivalis1.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "<tr>" +
                        "    <td>" + rivalis2.getNev() + "</td>\n" +
                        "    <td>" + rivalis2.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "<tr>" +
                        "    <td>" + rivalis3.getNev() + "</td>\n" +
                        "    <td>" + rivalis3.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "</table><br></p></html>");
                eladas_panel.setVisible(false);
                vege_panel.add(kilepes_button);
            }
            if (this.sajnos_vege) {
                vege_panel.setVisible(true);
                vissza_button.setVisible(false);
                kilepes_button.setVisible(true);
                vege_panel.add(kilepes_button);
                vege_panel.setBounds(380, 180, 300, 330);
                vege_label.setBounds(20, 20, 260, 230);
                kilepes_button.setBounds(93, 250, 120, 35);
                vege_label.setText("<html><p style=\"text-align: center\"><br>SAJNÁLOM VÉGE A JÁTÉKNAK<br>" +
                        "Elfogyott az életerőd és egy csapattársad sincs már, vagy feladtad!<br>" +
                        "Itt vannak veled együtt az összes felfeldező, akik részt vettek a kalandba!<br>" +
                        "Nézd meg hogy teljesítettél többiekhez képest!</p><br>" +
                        "<table style=\"text-align: center\">" +
                        "<tr>" +
                        "    <td>" + felfedezo.getNev() + "</td>\n" +
                        "    <td>" + felfedezo.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "<tr>" +
                        "    <td>" + rivalis1.getNev() + "</td>\n" +
                        "    <td>" + rivalis1.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "<tr>" +
                        "    <td>" + rivalis2.getNev() + "</td>\n" +
                        "    <td>" + rivalis2.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "<tr>" +
                        "    <td>" + rivalis3.getNev() + "</td>\n" +
                        "    <td>" + rivalis3.getHirnev() + "</td>\n" +
                        "  </tr>" +
                        "</table><br></p></html>");
            }
        }
    }

    /**
     * Gombok generalasa, pozicionalasa
     */
    public void buttons() {
        vissza_button.addActionListener(this);
        vissza_button.setText("Visszatérés");
        vissza_button.setFocusable(false);
        vissza_button.setFont(betutipus);
        vissza_button.setBackground(new Color(0xBAB243));

        kilepes_button.addActionListener(this);
        kilepes_button.setText("Kilépés");
        kilepes_button.setFocusable(false);
        kilepes_button.setFont(betutipus);
        kilepes_button.setBackground(new Color(0xBAB243));

        bolt_button.setBounds(1080, 590, 100, 30);
        bolt_button.addActionListener(this);
        bolt_button.setText("Bolt");
        bolt_button.setFocusable(false);
        bolt_button.setFont(betutipus);
        bolt_button.setBackground(new Color(0xBAB243));

        hajoslot_button.setBounds(1080, 620, 100, 30);
        hajoslot_button.addActionListener(this);
        hajoslot_button.setText("HajóSlot");
        hajoslot_button.setFocusable(false);
        hajoslot_button.setFont(betutipus);
        hajoslot_button.setBackground(new Color(0xBAB243));

        plusz_energia_button.setBounds(22, 305, 90, 20);
        plusz_energia_button.addActionListener(this);
        plusz_energia_button.setText("+Energia");
        plusz_energia_button.setFocusable(false);
        plusz_energia_button.setFont(new Font("Comic Sans", Font.PLAIN, 10));
        plusz_energia_button.setBackground(new Color(0xBAB243));
        plusz_energia_button.setEnabled(false);

        elel_box.setBounds(22, 285, 90, 20);

        vasarlas_button.setBounds(70, 523, 100, 30);
        vasarlas_button.addActionListener(this);
        vasarlas_button.setText("Megvásárol");
        vasarlas_button.setFocusable(false);
        vasarlas_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        vasarlas_button.setBackground(new Color(0x928B06));

        hajoraFel_button.setBounds(70, 420, 90, 25);
        hajoraFel_button.addActionListener(this);
        hajoraFel_button.setText("+Hajóra");
        hajoraFel_button.setFocusable(false);
        hajoraFel_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        hajoraFel_button.setBackground(new Color(0x928B06));

        hajoraLe_button.setBounds(240, 420, 90, 25);
        hajoraLe_button.addActionListener(this);
        hajoraLe_button.setText("-Hajóról");
        hajoraLe_button.setFocusable(false);
        hajoraLe_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        hajoraLe_button.setBackground(new Color(0x928B06));

        feladas_button.setBounds(160, 455, 80, 25);
        feladas_button.addActionListener(this);
        feladas_button.setText("Feladás");
        feladas_button.setFocusable(false);
        feladas_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        feladas_button.setBackground(new Color(0x928B06));

        tars_vasarlas_button.setBounds(225, 523, 100, 30);
        tars_vasarlas_button.addActionListener(this);
        tars_vasarlas_button.setText("+Társ");
        tars_vasarlas_button.setFocusable(false);
        tars_vasarlas_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        tars_vasarlas_button.setBackground(new Color(0x928B06));

        falvak_tars_vasarlas_button.setBounds(200, 425, 100, 30);
        falvak_tars_vasarlas_button.addActionListener(this);
        falvak_tars_vasarlas_button.setText("+Társ");
        falvak_tars_vasarlas_button.setFocusable(false);
        falvak_tars_vasarlas_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        falvak_tars_vasarlas_button.setBackground(new Color(0x928B06));

        kincs_bezaras_button.setBounds(90, 150, 90, 20);
        kincs_bezaras_button.addActionListener(this);
        kincs_bezaras_button.setText("Rendben");
        kincs_bezaras_button.setFocusable(false);
        kincs_bezaras_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        kincs_bezaras_button.setBackground(new Color(0x928B06));

        falvak_vasarlas_button.setBounds(65, 425, 100, 30);
        falvak_vasarlas_button.addActionListener(this);
        falvak_vasarlas_button.setText("Megvásárol");
        falvak_vasarlas_button.setFocusable(false);
        falvak_vasarlas_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        falvak_vasarlas_button.setBackground(new Color(0x928B06));

        eladas_button.setBounds(70, 330, 100, 30);
        eladas_button.addActionListener(this);
        eladas_button.setText("Eladás");
        eladas_button.setFocusable(false);
        eladas_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        eladas_button.setBackground(new Color(0x928B06));

        kincsek_eladasa_button.setBounds(230, 310, 100, 30);
        kincsek_eladasa_button.addActionListener(this);
        kincsek_eladasa_button.setText("Eladás");
        kincsek_eladasa_button.setFocusable(false);
        kincsek_eladasa_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        kincsek_eladasa_button.setBackground(new Color(0x928B06));

        kincsek_eladomany_button.setBounds(230, 340, 100, 30);
        kincsek_eladomany_button.addActionListener(this);
        kincsek_eladomany_button.setText("Eladományoz");
        kincsek_eladomany_button.setFocusable(false);
        kincsek_eladomany_button.setFont(new Font("Comic Sans", Font.PLAIN, 13));
        kincsek_eladomany_button.setBackground(new Color(0x928B06));
    }

    /**
     * Iranyitasi gombok generalasa, pozicionalasa
     */
    public void iranyitas() {
        fel_button.setBounds(1080, 470, 100, 30);
        fel_button.addActionListener(this);
        fel_button.setText("Fel");
        fel_button.setFocusable(false);
        fel_button.setFont(betutipus);
        fel_button.setBackground(new Color(0xBAB243));

        le_button.setBounds(1080, 530, 100, 30);
        le_button.addActionListener(this);
        le_button.setText("Le");
        le_button.setFocusable(false);
        le_button.setFont(betutipus);
        le_button.setBackground(new Color(0xBAB243));

        bal_button.setBounds(1030, 500, 100, 30);
        bal_button.addActionListener(this);
        bal_button.setText("Balra");
        bal_button.setFocusable(false);
        bal_button.setFont(betutipus);
        bal_button.setBackground(new Color(0xBAB243));

        jobb_button.setBounds(1130, 500, 100, 30);
        jobb_button.addActionListener(this);
        jobb_button.setText("Jobbra");
        jobb_button.setFocusable(false);
        jobb_button.setFont(betutipus);
        jobb_button.setBackground(new Color(0xBAB243));

        layerPanel.add(fel_button);
        layerPanel.add(le_button);
        layerPanel.add(bal_button);
        layerPanel.add(jobb_button);
        layerPanel.add(bolt_button);
        layerPanel.add(hajoslot_button);

        iranyit_panel.setBounds(1000, 0, 280, 720);
        iranyit_panel.setBackground(new Color(0x41C119));
    }

    /**
     * Palya letrehozasa
     */
    public void palya_elemek() {
        ImageIcon fu_photo = new ImageIcon("img/terkep/fu.png");
        ImageIcon piramis_photo = new ImageIcon("img/terkep/arany_piramis.png");
        ImageIcon barlang_photo = new ImageIcon("img/terkep/barlang.png");
        ImageIcon dzsungel_photo = new ImageIcon("img/terkep/dzsungel.png");
        ImageIcon hajo_photo = new ImageIcon("img/terkep/expedicio_hajo.png");
        ImageIcon hegy_photo = new ImageIcon("img/terkep/hegy.png");
        ImageIcon oltar_photo = new ImageIcon("img/terkep/oltar.png");
        ImageIcon tenger_photo = new ImageIcon("img/terkep/tenger.png");
        ImageIcon to_photo = new ImageIcon("img/terkep/to.png");
        ImageIcon nedves_fu_photo = new ImageIcon("img/terkep/nedves_fu.png");
        ImageIcon lava_photo = new ImageIcon("img/terkep/lava.png");
        ImageIcon falvak_photo = new ImageIcon("img/terkep/falvak.png");
        ImageIcon nedves_falvak_photo = new ImageIcon("img/terkep/nedves_falvak.png");
        ImageIcon nedves_oltar_photo = new ImageIcon("img/terkep/nedves_oltar.png");
        ImageIcon nedves_fuvek_photo = new ImageIcon("img/terkep/mini/nedves_fuvek.png");

        int rand = randi.nextInt(101);
        System.out.println(rand);
        String[] elemek = {
                "TTTFCCFTGDFDT",
                "TTFDIFDWNFYTT",
                "TFNIONBNONFDT",
                "TTNOOOGCNTTTT",
                "TFCWOIPFFDXTT",
                "TTFNIGFAGCTTT",
                "TTTFJDFCGFTTT",
                "TFDCGCTDTTTTT",
                "TTTTTTTTTTTTT",
        };
        int a = 0;
        Scanner scanner = null;
        String map;
        if (rand >= 50) {
            map = "terkep/elso.txt";
        } else {
            map = "terkep/elso.txt";
        }
        try {
            scanner = new Scanner(new File(map));
            while (scanner.hasNextLine()) {
                elemek[a] = scanner.nextLine();
                a++;
            }
        } catch (IOException e) {
            System.err.println("Hiba történt: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        for (int i = 0; i < elemek.length; i++) {
            for (int j = 0; j < elemek[i].length(); j++) {
                palya_elemek[i][j] = new JLabel();
                char elem = elemek[i].charAt(j);
                if (elem == 'T') {
                    palya_elemek[i][j].setIcon(tenger_photo);
                    palya_elemek[i][j].setText("T");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, tenger_photo.getIconWidth(), tenger_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'H') {
                    palya_elemek[i][j].setIcon(hajo_photo);
                    palya_elemek[i][j].setText("H");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, hajo_photo.getIconWidth(), hajo_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'O') {
                    palya_elemek[i][j].setIcon(to_photo);
                    palya_elemek[i][j].setText("O");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, to_photo.getIconWidth(), to_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'G') {
                    palya_elemek[i][j].setIcon(hegy_photo);
                    palya_elemek[i][j].setText("G");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, hegy_photo.getIconWidth(), hegy_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'R') {
                    palya_elemek[i][j].setIcon(oltar_photo);
                    palya_elemek[i][j].setText("R");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, oltar_photo.getIconWidth(), oltar_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'D') {
                    palya_elemek[i][j].setIcon(dzsungel_photo);
                    palya_elemek[i][j].setText("D");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, dzsungel_photo.getIconWidth(), dzsungel_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'P') {
                    palya_elemek[i][j].setIcon(piramis_photo);
                    palya_elemek[i][j].setText("P");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, piramis_photo.getIconWidth(), piramis_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'F') {
                    palya_elemek[i][j].setIcon(fu_photo);
                    palya_elemek[i][j].setText("F");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, fu_photo.getIconWidth(), fu_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'N') {
                    palya_elemek[i][j].setIcon(nedves_fu_photo);
                    palya_elemek[i][j].setText("N");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, nedves_fu_photo.getIconWidth(), nedves_fu_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'V') {
                    palya_elemek[i][j].setIcon(lava_photo);
                    palya_elemek[i][j].setText("V");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, lava_photo.getIconWidth(), lava_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'A') {
                    palya_elemek[i][j].setIcon(falvak_photo);
                    palya_elemek[i][j].setText("A");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, lava_photo.getIconWidth(), lava_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'C') {
                    palya_elemek[i][j].setIcon(fuvek_photo);
                    palya_elemek[i][j].setText("C");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, lava_photo.getIconWidth(), lava_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'I') {
                    palya_elemek[i][j].setIcon(nedves_fuvek_photo);
                    palya_elemek[i][j].setText("I");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, lava_photo.getIconWidth(), lava_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'Q') {
                    palya_elemek[i][j].setIcon(nedves_oltar_photo);
                    palya_elemek[i][j].setText("Q");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, lava_photo.getIconWidth(), lava_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'W') {
                    palya_elemek[i][j].setIcon(nedves_falvak_photo);
                    palya_elemek[i][j].setText("W");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, lava_photo.getIconWidth(), lava_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'J') {
                    palya_elemek[i][j].setIcon(barlang_photo);
                    palya_elemek[i][j].setText("J");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, barlang_photo.getIconWidth(), barlang_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'X') {
                    palya_elemek[i][j].setIcon(barlang_photo);
                    palya_elemek[i][j].setText("X");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, barlang_photo.getIconWidth(), barlang_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'B') {
                    palya_elemek[i][j].setIcon(oltar_photo);
                    palya_elemek[i][j].setText("B");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, barlang_photo.getIconWidth(), barlang_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'Y') {
                    palya_elemek[i][j].setIcon(oltar_photo);
                    palya_elemek[i][j].setText("Y");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, barlang_photo.getIconWidth(), barlang_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                } else if (elem == 'K') { //Sima barlang Kifoszott
                    palya_elemek[i][j].setIcon(barlang_photo);
                    palya_elemek[i][j].setText("K");
                    palya_elemek[i][j].setBounds(j * 75 + 12, i * 75 + 2, barlang_photo.getIconWidth(), barlang_photo.getIconHeight());
                    layerPanel.add(palya_elemek[i][j]);
                }
                palya_elemek[i][j].setVisible(false);
            }
        }
    }

    /**
     * A Jatekos adatainak megjelenitesere szolgal
     *
     * @param felfedezo A játékos változója
     */
    public void karakter_infok(Felfedezo felfedezo) {
        int db = 0;
        String inventory = "";
        String fuggoseg;
        String tarsak = "";
        for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
            inventory = inventory +
                    "<tr>\n" +
                    "    <td>" + felfedezo.getSlotok().getTargyak().get(i).getNev() + "</td>\n" +
                    "    <td>" + felfedezo.getSlotok().getTargyak().get(i).getDarab() + "</td>\n" +
                    "  </tr>";
        }
        for (int i = 0; i < felfedezo.tarsak.size(); i++) {
            tarsak = tarsak + felfedezo.tarsak.get(i).getNev() + "<br>";
        }
        if (felfedezo.isFuggo()) {
            fuggoseg = "Függő lett!";
        } else {
            fuggoseg = "Nincs függősége";
            this.reszeg_lepes = 0;
        }
        double energia = felfedezo.getEnergia();
        if (energia <= 0) {
            energia = 0;
        }

        String felfedezo_energia = String.format("%.2f", energia);
        slot_label.setText("<html><b>Slot</b> : <br><p style=\"text-align: top\"><table>" + inventory + " </p><br></table></html>");
        tarsak_label.setText("<html><b>Társak</b> : <p style=\"text-align: center\">" + tarsak + " </p></html>");
        profilkep_label.setText("<html><b>Energia</b> : " + felfedezo_energia + " " +
                "<br> <b>Arany</b> : " + felfedezo.getArany() + "" +
                "<br> <b>Hírnév</b> : " + felfedezo.getHirnev() + "" +
                "<br> <b>Viszony</b> : " + felfedezo.getViszony() + "" +
                "<br> <b>Részeges lépés</b> : " + this.reszeg_lepes + "" +
                "<br> <b>Slot mérete</b> : " + felfedezo.getSlotok().getSlotMax() + "" +
                "<br> <b>" + fuggoseg + "</b></html>");

        karakter_info_panel.add(profilkep_label);
        karakter_info_panel.add(slot_label);
        karakter_info_panel.add(plusz_energia_button);
        karakter_info_panel.add(elel_box);
        karakter_info_panel.add(tarsak_label);


        for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
            if (felfedezo.getSlotok().getTargyak().get(i).isElelmiszer()) {
                db++;
            }
        }
        plusz_energia_button.setEnabled(db > 0);
    }

    /**
     * Zene elinditasa
     *
     * @param name fajl helye
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
     * Ha leszall a hajorol a jatekos, akkor elmenti a helyszint
     *
     * @param x A hajo y koordinataja
     * @param y A hajo x koordinataja
     */
    public void hajo_koordinata(int x, int y) {
        ImageIcon hajo_photo = new ImageIcon("img/terkep/expedicio_hajo.png");
        hajo_body_label.setBounds(0, 0, hajo_photo.getIconWidth(), hajo_photo.getIconHeight());
        hajo_body_label.setIcon(hajo_photo);
        palya_elemek[y][x].add(hajo_body_label);
    }

    /**
     * Ha a kincset megtalalta a jatekos, akkor megjeleniti a GUI
     *
     * @param kincs A Kincs valtozoja
     */
    public void kincs(Kincs kincs) {
        kincs_panel.setBounds(400, 200, 270, 200);
        kincs_panel.setBackground(new Color(0x424233));
        kincs_panel.setLayout(null);
        kincs_panel.setBorder(BorderFactory.createLineBorder(new Color(0x938E37), 10));

        kincsleiras_label.setText("<html><p style=\"text-align: center\">GRATULÁLOK<br>TALÁLTÁL EGY KINCSET!<br>" +
                "<br>Megtaláltad az elveszett " + kincs.getNev() + "-t!" +
                "<br>A Kincs megtalálható lesz a Slotodban!</p></html>");

        fel_button.setEnabled(false);
        le_button.setEnabled(false);
        jobb_button.setEnabled(false);
        bal_button.setEnabled(false);
        bolt_button.setEnabled(false);
        kincs_panel.add(kincsleiras_label);
        kincs_panel.add(kincs_bezaras_button);
    }

    /**
     * Társak elhagyásának generálása
     */
    public void elhagyas() {
        if (felfedezo.getEnergia() <= 0) {
            int rand = randi.nextInt(101);
            System.out.println(rand);
            if (rand <= 8) {
                felfedezo.tarsElhagy();
            }
            karakter_infok(felfedezo);
            if (felfedezo.tarsak.size() == 0) {
                sajnos_vege = true;
                this.vege(true);
            }
        }
        if (this.reszeg_lepes > 30) {
            int rand = randi.nextInt(101);
            if (rand <= 10) {
                felfedezo.tarsElhagy();
            }
        }
    }

    /**
     * Mozgas megjelenitese, és jatekos interakcio
     *
     * @param x A játékos y Koordinátája
     * @param y A játékos x Koordinátája
     */
    public void mozgas(int x, int y) {
        ImageIcon hajo_photo = new ImageIcon("img/terkep/expedicio_hajo.png");
        ImageIcon body = new ImageIcon("img/character_body.png");
        rivalisok();
        if (!felfedezo.isHajonvane()) {
            if (this.hanyadik_kuldetes == 6) {
                vege(true);
            } else {
                this.kuldetes_mozgas = this.kuldetes_mozgas + 1;
                this.hajos_mozgas = 0;
                karakter_body_label.setBounds(16, 0, body.getIconWidth(), body.getIconHeight());
                karakter_body_label.setIcon(body);

                if (palya_elemek[y][x].getText() == "P" && !this.arany_piramis_megvan) {
                    this.arany_piramis_megvan = true;
                    vege(true);
                    felfedezo.setHirnev(felfedezo.getHirnev() + 1000);
                }
                if (palya_elemek[y][x].getText() == "D") {
                    boolean vane = false;
                    for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
                        if (felfedezo.getSlotok().getTargyak().get(i).getNev() == "Bozótvágó") {
                            felfedezo.elhasznal("Bozótvágó");
                            vane = true;
                            palya_elemek[y][x].setIcon(fuvek_photo);
                            palya_elemek[y][x].setText("F");
                        }
                    }
                    if (!vane) {
                        felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    }
                }
                if (palya_elemek[y][x].getText() != "T" || palya_elemek[y][x].getText() != "0") {
                    palya_elemek[y][x].add(karakter_body_label);
                }
                if (palya_elemek[y][x].getText() == "W" || palya_elemek[y][x].getText() == "A") {
                    bolt_button.setEnabled(true);
                    falu_vasarole = true;
                } else {
                    bolt_button.setEnabled(false);
                }
                if (palya_elemek[y][x].getText() == "B") {
                    if (felfedezo.getKincs_mennyiseg() == 0) {
                        boolean vane = false;
                        kincs_panel.setVisible(true);
                        kincs(arany_amulett);
                        felfedezo.kincsTalal(arany_amulett);
                        palya_elemek[y][x].setText("9");
                        felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                        felfedezo.setViszony(felfedezo.getViszony() - 2);
                    }
                } else if (palya_elemek[y][x].getText() == "Y") {
                    if (felfedezo.getKincs_mennyiseg() == 0) {
                        boolean vane = false;
                        kincs_panel.setVisible(true);
                        kincs(arany_nyaklanc);
                        felfedezo.kincsTalal(arany_nyaklanc);
                        palya_elemek[y][x].setText("9");
                        felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                        felfedezo.setViszony(felfedezo.getViszony() - 2);
                    }
                } else if (palya_elemek[y][x].getText() == "J") {
                    boolean vane = false;
                    if (felfedezo.getKincs_mennyiseg() == 0) {
                        kincs_panel.setVisible(true);
                        kincs(arany_sas);
                        felfedezo.kincsTalal(arany_sas);
                        palya_elemek[y][x].setText("K");
                    }
                    for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
                        if (felfedezo.getSlotok().getTargyak().get(i).getNev() == "Fáklya") {
                            felfedezo.elhasznal("Fáklya");
                            vane = true;
                        }
                    }
                    if (!vane) {
                        felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    }
                } else if (palya_elemek[y][x].getText() == "X") {
                    boolean vane = false;
                    if (felfedezo.getKincs_mennyiseg() == 0) {
                        kincs_panel.setVisible(true);
                        kincs(bronz_tekercs);
                        felfedezo.kincsTalal(bronz_tekercs);
                        palya_elemek[y][x].setText("K");
                    }
                    for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
                        if (felfedezo.getSlotok().getTargyak().get(i).getNev() == "Fáklya") {
                            felfedezo.elhasznal("Fáklya");
                            vane = true;
                        }
                    }
                    if (!vane) {
                        felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    }
                } else if (palya_elemek[y][x].getText() == "K") {
                    boolean vane = false;
                    for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
                        if (felfedezo.getSlotok().getTargyak().get(i).getNev() == "Fáklya") {
                            felfedezo.elhasznal("Fáklya");
                            vane = true;
                        }
                    }
                    if (!vane) {
                        felfedezo.setEnergia(felfedezo.getEnergia() - 1);
                    }
                }
                if (this.kuldetes_mozgas == 1) {
                    vasarole = true;
                    this.falu_vasarole = false;
                    vasarlas(abc);
                    fel_button.setEnabled(false);
                    le_button.setEnabled(false);
                    jobb_button.setEnabled(false);
                    bal_button.setEnabled(false);
                    bolt_button.setEnabled(true);
                    tars_faluban_box.setVisible(false);
                    falvak_tars_vasarlas_button.setVisible(false);
                }
                hajoslot_button.setEnabled(false);
                eladas_panel.setVisible(false);
            }
        } else {
            this.hajos_mozgas = this.hajos_mozgas + 1;
            this.kuldetes_mozgas = 0;
            bolt_button.setEnabled(false);
            felfedezo.setEnergia(100);
            karakter_body_label.setBounds(0, 0, hajo_photo.getIconWidth(), hajo_photo.getIconHeight());
            karakter_body_label.setIcon(hajo_photo);

            if (palya_elemek[y][x].getText() == "T" || palya_elemek[y][x].getText() == "0") {
                this.palya_elemek[y][x].add(karakter_body_label);
            }
            hajoslot_button.setEnabled(true);


            if (this.hajos_mozgas == 1 && this.hanyadik_kuldetes != 6) {
                this.hanyadik_kuldetes = this.hanyadik_kuldetes + 1;
                eladas_panel.setVisible(false);
                eladas();
            } else {
                eladas_panel.setVisible(false);
            }
        }

        palya_elemek[y][x].setVisible(true);
        if (y < 8 && x < 12) {
            palya_elemek[y + 1][x].setVisible(true);
            palya_elemek[y + 1][x + 1].setVisible(true);
            palya_elemek[y][x + 1].setVisible(true);
            if (latokor == 2) {
                if (y < 7 && x < 11) {
                    palya_elemek[y][x + 2].setVisible(true);
                    palya_elemek[y + 1][x + 2].setVisible(true);
                    palya_elemek[y + 2][x + 2].setVisible(true);
                    palya_elemek[y + 2][x + 1].setVisible(true);
                    palya_elemek[y + 2][x].setVisible(true);
                }
                if (y < 7 && x == 11 && y > 1) {
                    palya_elemek[y + 2][x + 1].setVisible(true);
                    palya_elemek[y - 2][x + 1].setVisible(true);
                }
            }
        }
        if (y > 0 && x > 0) {
            palya_elemek[y - 1][x].setVisible(true);
            palya_elemek[y - 1][x - 1].setVisible(true);
            palya_elemek[y][x - 1].setVisible(true);
            if (latokor == 2) {
                if (y > 1 && x > 1) {
                    palya_elemek[y - 2][x].setVisible(true);
                    palya_elemek[y - 2][x - 1].setVisible(true);
                    palya_elemek[y - 2][x - 2].setVisible(true);
                    palya_elemek[y - 1][x - 2].setVisible(true);
                    palya_elemek[y][x - 2].setVisible(true);
                }
                if (y > 1 && x == 1 && y < 7) {
                    palya_elemek[y - 2][x - 1].setVisible(true);
                    palya_elemek[y + 2][x - 1].setVisible(true);
                }
            }
        }
        if (x < 12 && y > 0) {
            palya_elemek[y][x + 1].setVisible(true);
            palya_elemek[y - 1][x + 1].setVisible(true);
            if (latokor == 2) {
                if (x < 11 && y > 1) {
                    palya_elemek[y][x + 2].setVisible(true);
                    palya_elemek[y - 1][x + 2].setVisible(true);
                    palya_elemek[y - 2][x + 2].setVisible(true);
                    palya_elemek[y - 2][x + 1].setVisible(true);
                    palya_elemek[y - 2][x].setVisible(true);
                }
                if (y == 1 && x < 11 && x > 1) {
                    palya_elemek[y - 1][x + 2].setVisible(true);
                    palya_elemek[y - 1][x - 2].setVisible(true);
                }
            }
        }
        if (x > 0 && y < 8) {
            palya_elemek[y][x - 1].setVisible(true);
            palya_elemek[y + 1][x - 1].setVisible(true);
            if (latokor == 2) {
                if (x > 1 && y < 7) {
                    palya_elemek[y][x - 2].setVisible(true);
                    palya_elemek[y + 1][x - 2].setVisible(true);
                    palya_elemek[y + 2][x - 2].setVisible(true);
                    palya_elemek[y + 2][x - 1].setVisible(true);
                    palya_elemek[y + 2][x].setVisible(true);
                }
                if (y == 7 && x > 1 && x < 11) {
                    palya_elemek[y + 1][x - 2].setVisible(true);
                    palya_elemek[y + 1][x + 2].setVisible(true);
                }
            }
        }
    }

    /**
     * Bolt megjelenitese
     *
     * @param bolt A Bolt valtozoja
     */
    public void vasarlas(Bolt bolt) {
        int rand = randi.nextInt(101);
        if (vasarole) {
            if (!falu_vasarole) {
                if (tars_eloszor_vasar == 0) {
                    tars_vasarlas_button.setEnabled(true);
                } else {
                    tars_vasarlas_button.setEnabled(false);
                }
                vasarlas_button.setEnabled(true);
                String hanyadik = "";
                if (this.hanyadik_kuldetes == 1) {
                    hanyadik = "ELSŐ";
                } else if (this.hanyadik_kuldetes == 2) {
                    hanyadik = "MÁSODIK";
                } else if (this.hanyadik_kuldetes == 3) {
                    hanyadik = "HARMADIK";
                } else if (this.hanyadik_kuldetes == 4) {
                    hanyadik = "NEGYEDIK";
                } else if (this.hanyadik_kuldetes == 5) {
                    hanyadik = "UTOLSÓ";
                }
                vasarlista_label.setText("<html><b><h2 style=\"text-align: center\">" + hanyadik + " KÜLDETÉS</h2></b>" +
                        "<p style=\"text-align: center\">Mielőtt elkezded ezt a hatalmas kalandot, ajánlom vásárolj egy két dolgot, ami hasznosnak bizonyul a játék során</p>" +
                        "<table style=\"text-align: center\">\n" +
                        "  <tr>\n" +
                        "    <th>Termék</th>\n" +
                        "    <th>      </th>\n" +
                        "    <th>ÁR</th> \n" +
                        "    <th>      </th>\n" +
                        "    <th>Darab</th>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Kötél</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(kotel).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(kotel).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Bozótvágó</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(bozotvago).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(bozotvago).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Fáklya</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(faklya).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(faklya).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Üveggolyó</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(uveggolyo).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(uveggolyo).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Hús</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(hus).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(hus).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Whiskey</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(whiskey).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(whiskey).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Csokoládé</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(csokolade).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(csokolade).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <th>Csapattárs</th>\n" +
                        "    <th>      </th>\n" +
                        "    <th>ÁR</th> \n" +
                        "    <th>      </th>\n" +
                        "    <th>Típus</th>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>" + kereskedo.getNev() + "</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + kereskedo.getAr() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + kereskedo.getTipus() + "</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>" + katona.getNev() + "</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + katona.getAr() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + katona.getTipus() + "</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>" + szamar.getNev() + "</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + szamar.getAr() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + szamar.getTipus() + "</td>\n" +
                        "  </tr>\n" +
                        "</table>\n</html>");
                vasarlista_label.setFont(betutipus);
                vasar_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
                vasar_panel.setBackground(new Color(0xD2B95F));
                vasar_panel.setBounds(312, 40, 400, 600);
                vasar_panel.setLayout(null);

                vasarlista_label.setBounds(25, 0, 350, 500);
                bolti_lista_box.setBounds(75, 500, 90, 20);
                tars_eloszor_box.setBounds(225, 500, 100, 20);
                falvak_lista_combobox.setVisible(false);
                falvak_vasarlas_button.setVisible(false);
                bolti_lista_box.setVisible(true);
                vasarlas_button.setVisible(true);

                tars_vasarlas_button.setEnabled(felfedezo.getArany() >= kereskedo.getAr() && tars_eloszor_vasar == 0);
                vasar_panel.add(vasarlista_label);
                vasar_panel.add(bolti_lista_box);
                vasar_panel.add(vasarlas_button);
                vasar_panel.add(tars_eloszor_box);
                vasar_panel.add(tars_vasarlas_button);
                vasar_panel.setVisible(true);

            } else {
                String tars_vasarol = "";
                if (felfedezo.getViszony() >= 2 && rand <= 20) {
                    tars_vasarol = "  <tr>\n" +
                            "    <th>Csapattárs</th>\n" +
                            "    <th>      </th>\n" +
                            "    <th>ÁR</th> \n" +
                            "    <th>      </th>\n" +
                            "    <th>Típus</th>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td>" + felderito.getNev() + "</td>\n" +
                            "    <th>      </th>\n" +
                            "    <td>" + felderito.getAr() + " arany</td>\n" +
                            "    <th>      </th>\n" +
                            "    <td>" + felderito.getTipus() + "</td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td>" + saman.getNev() + "</td>\n" +
                            "    <th>      </th>\n" +
                            "    <td>" + saman.getAr() + " arany</td>\n" +
                            "    <th>      </th>\n" +
                            "    <td>" + saman.getTipus() + "</td>\n" +
                            "  </tr>\n" +
                            "  <tr>\n" +
                            "    <td>" + bolcs.getNev() + "</td>\n" +
                            "    <th>      </th>\n" +
                            "    <td>" + bolcs.getAr() + " arany</td>\n" +
                            "    <th>      </th>\n" +
                            "    <td>" + bolcs.getTipus() + "</td>\n" +
                            "  </tr>\n";
                    falvak_tars_vasarlas_button.setEnabled(felfedezo.getArany() >= kereskedo.getAr());
                    tars_faluban_box.setVisible(true);
                    falvak_tars_vasarlas_button.setVisible(true);
                    vasarlista_label.setBounds(40, 0, 300, 400);
                    falvak_lista_combobox.setBounds(70, 400, 90, 20);
                    falvak_vasarlas_button.setBounds(65, 425, 100, 30);
                } else {
                    tars_faluban_box.setVisible(false);
                    falvak_tars_vasarlas_button.setVisible(false);
                    vasarlista_label.setBounds(80, 0, 300, 400);
                    falvak_lista_combobox.setBounds(135, 350, 90, 20);
                    falvak_vasarlas_button.setBounds(130, 375, 100, 30);
                }
                vasarlista_label.setText("<html><b><h2 style=\"text-align: center\">VÁSÁRLÁS</h2></b><br>" +
                        "<table style=\"text-align: center\">\n" +
                        "  <tr>\n" +
                        "    <th>Termék</th>\n" +
                        "    <th>      </th>\n" +
                        "    <th>Ár</th>\n" +
                        "    <th>      </th>\n" +
                        "    <th>Darab</th> \n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Kötél</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(kotel_falu).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(kotel_falu).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Fáklya</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(faklya_falu).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(faklya_falu).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Gyümölcs</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(gyumulcs).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(gyumulcs).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Hús</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(hus_falu).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(hus_falu).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" +
                        "  <tr>\n" +
                        "    <td>Kábítószer</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(kabitoszer).getAra() + " arany</td>\n" +
                        "    <th>      </th>\n" +
                        "    <td>" + bolt.printProducts(kabitoszer).getBoltban_marad() + "db</td>\n" +
                        "  </tr>\n" + tars_vasarol +
                        "</table>\n</html>");
                vasarlista_label.setFont(betutipus);
                vasar_panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));
                vasar_panel.setBackground(new Color(0xD2B95F));
                vasar_panel.setBounds(312, 100, 370, 500);
                vasar_panel.setLayout(null);

                tars_faluban_box.setBounds(200, 400, 100, 20);
                falvak_lista_combobox.setVisible(true);
                falvak_vasarlas_button.setVisible(true);
                bolti_lista_box.setVisible(false);
                vasarlas_button.setVisible(false);

                vasar_panel.add(tars_faluban_box);
                vasar_panel.add(vasarlista_label);
                vasar_panel.add(falvak_lista_combobox);
                vasar_panel.add(falvak_vasarlas_button);
                vasar_panel.add(falvak_tars_vasarlas_button);
                vasar_panel.setVisible(true);
            }
        } else {
            vasar_panel.setVisible(false);
        }
    }

    /**
     * A Hajo slotja tarolojanak megjelenitese
     */
    public void hajoSlot() {
        if (hajoSlotHasznal) {
            String inventory = "";
            for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
                inventory = inventory + "<tr>\n" +
                        "    <td>" + felfedezo.getSlotok().getTargyak().get(i).getNev() + "</td>\n" +
                        "    <td>" + felfedezo.getSlotok().getTargyak().get(i).getDarab() + "</td>\n" +
                        "  </tr>";
                String targy = felfedezo.getSlotok().getTargyak().get(i).getNev();
            }
            hajoraHelyezes_box.setEditable(true);
            String hajoInventory = "";
            for (int j = 0; j < felfedezo.getHajoTarolo().getHajoTargyak().size(); j++) {
                hajoInventory = hajoInventory + "<tr>\n" +
                        "    <td>" + felfedezo.getHajoTarolo().getHajoTargyak().get(j).getNev() + "</td>\n" +
                        "    <td>" + felfedezo.getHajoTarolo().getHajoTargyak().get(j).getHajon_marad() + "</td>\n" +
                        "  </tr>";
            }

            hajoSlot_panel.setBounds(200, 70, 400, 500);
            hajoSlot_panel.setBackground(new Color(0x2B46D5));
            hajoSlot_panel.setBorder(BorderFactory.createLineBorder(new Color(0xA12470AA, true), 10));
            hajoSlot_panel.setLayout(null);

            hajoSlot_label.setText("<html><h2 style=\"text-align: center\">HAJÓ SLOT</h2>" +
                    "<p style=\"text-align: center\">Bármikor elraktározhatod tárgyaidat hogy a következő küldetésekben hasznát vedd őket<br></p></html>");
            hajoSlot_label.setForeground(new Color(0xFFFFFF));
            hajoSlot_label.setBounds(30, 20, 350, 140);

            felfedezoInventHaj_label.setText("<html><p>SAJÁT TÁRGYAID<table style=\"text-align: center\">" + inventory +
                    "</table></p></html>");
            felfedezoInventHaj_label.setForeground(new Color(0xFFFFFF));
            felfedezoInventHaj_label.setBounds(65, 130, 200, 300);

            hajoSlotTargy_label.setText("<html><p>HAJÓBAN LÉVŐTÁRGYAID<table style=\"text-align: center\">" + hajoInventory +
                    "</table></p></html>");
            hajoSlotTargy_label.setForeground(new Color(0xFFFFFF));
            hajoSlotTargy_label.setBounds(210, 130, 200, 300);

            hajoraHelyezes_box.setBounds(70, 400, 90, 20);
            hajoraLevetel_box.setBounds(240, 400, 90, 20);

            hajoSlot_panel.add(hajoSlot_label);
            hajoSlot_panel.add(felfedezoInventHaj_label);
            hajoSlot_panel.add(hajoraHelyezes_box);
            hajoSlot_panel.add(hajoraFel_button);
            hajoSlot_panel.add(hajoSlotTargy_label);
            hajoSlot_panel.add(hajoraLe_button);
            hajoSlot_panel.add(hajoraLevetel_box);
            hajoSlot_panel.add(feladas_button);

            hajoSlot_panel.setVisible(true);
        } else {
            hajoSlot_panel.setVisible(false);
        }
    }

    /**
     * Eladasi felulet megjelenitese
     */
    public void eladas() {
        this.tars_eloszor_vasar = 0;
        String inventory = "";
        for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
            if (!felfedezo.getSlotok().getTargyak().get(i).isKincs()) {
                inventory = inventory + "<tr>\n" +
                        "    <td>" + felfedezo.getSlotok().getTargyak().get(i).getNev() + "</td>\n" +
                        "    <td>" + felfedezo.getSlotok().getTargyak().get(i).getDarab() + "</td>\n" +
                        "  </tr>";
            }
        }

        rivalisok_label.setText("<html><p style=\"text-align: center\"=>FELFEDEZŐK HÍRNEVE<br><br><table style=\"text-align: center\">" +
                "<tr>" +
                "    <td>" + felfedezo.getNev() + "</td>\n" +
                "    <td>" + felfedezo.getHirnev() + "</td>\n" +
                "  </tr>" +
                "<tr>" +
                "    <td>" + rivalis1.getNev() + "</td>\n" +
                "    <td>" + rivalis1.getHirnev() + "</td>\n" +
                "  </tr>" +
                "<tr>" +
                "    <td>" + rivalis2.getNev() + "</td>\n" +
                "    <td>" + rivalis2.getHirnev() + "</td>\n" +
                "  </tr>" +
                "<tr>" +
                "    <td>" + rivalis3.getNev() + "</td>\n" +
                "    <td>" + rivalis3.getHirnev() + "</td>\n" +
                "  </tr>" +
                "</table><br></p></html>");
        rivalisok_label.setBounds(400, 40, 150, 300);
        rivalisok_label.setForeground(new Color(0xFFFFFF));

        eladas_label.setText("<html><h2 style=\"text-align: center\">VÉGE A KÜLDETÉSEDNEK</h2>" +
                " <p style=\"text-align: center\">Itt eldöntheted eladod-e jó pénzért a kincseidet, esetleg a tárgyaidat, " +
                "vagy eladományozod őket a British Museum-nak hírnévért cserébe!! </p></html>");
        eladas_label.setBounds(60, 10, 300, 150);
        eladas_label.setForeground(new Color(0xFFFFFF));

        eladas_termekek_label.setText("<html><p>TÁRGYAID<table style=\"text-align: center\">" + inventory +
                "</table></p></html>");
        eladas_termekek_label.setForeground(new Color(0xFFFFFF));
        eladas_termekek_label.setBounds(90, 130, 200, 200);

        String kincsek = "";
        for (int i = 0; i < felfedezo.getSlotok().getTargyak().size(); i++) {
            if (felfedezo.getSlotok().getTargyak().get(i).isKincs()) {
                kincsek = kincsek + "<br>" + felfedezo.getSlotok().getTargyak().get(i).getNev();
            }
        }

        kincsek_eladasa_label.setText("<html><p>KINCSEID<br>" + kincsek + "</p></html>");
        kincsek_eladasa_label.setForeground(new Color(0xFFFFFF));
        kincsek_eladasa_label.setBounds(250, 130, 200, 200);

        eladasra_kivan_box.setBounds(70, 310, 100, 20);
        kincsek_box.setBounds(230, 290, 100, 20);

        eladas_panel.add(eladas_termekek_label);
        eladas_panel.add(eladas_label);
        eladas_panel.add(eladas_button);
        eladas_panel.add(eladasra_kivan_box);
        eladas_panel.add(kincsek_eladasa_label);
        eladas_panel.add(kincsek_box);
        eladas_panel.add(kincsek_eladasa_button);
        eladas_panel.add(kincsek_eladomany_button);
        eladas_panel.add(rivalisok_label);
        eladas_panel.setVisible(true);
    }

    /**
     * Gombok interakcioinak beallítasa
     *
     * @param e A vart gomb
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (feladas_button.equals(source)) {
            this.sajnos_vege = true;
            this.hajoSlot_panel.setVisible(false);
            vege(true);
        }
        if (nev_button.equals(source)) {
            if (nev_textfield.getText().length() > 0 && nev_textfield.getText().length() <= 25) {
                felfedezo.setNev(nev_textfield.getText());
                nev_panel.setVisible(false);
                fel_button.setEnabled(true);
                le_button.setEnabled(true);
                jobb_button.setEnabled(true);
                bal_button.setEnabled(true);
                hajoslot_button.setEnabled(true);
            } else {
                System.err.println("NEM ÍRTÁL NEVET VAGY TÚL SOK KARAKTERBŐL ÁLL!");
            }
        }
        if (kincsek_eladomany_button.equals(source)) {
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == arany_amulett.getNev()) {
                felfedezo.kincsEladomany(arany_amulett);
                eladas();
                karakter_infok(felfedezo);
            }
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == arany_sas.getNev()) {
                felfedezo.kincsEladomany(arany_sas);
                eladas();
                karakter_infok(felfedezo);
            }
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == bronz_tekercs.getNev()) {
                felfedezo.kincsEladomany(bronz_tekercs);
                eladas();
                karakter_infok(felfedezo);
            }
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == arany_nyaklanc.getNev()) {
                felfedezo.kincsEladomany(arany_nyaklanc);
                eladas();
                karakter_infok(felfedezo);
            }
        }
        if (kincsek_eladasa_button.equals(source)) {
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == arany_amulett.getNev()) {
                felfedezo.kincsEladas(arany_amulett);
                eladas();
                karakter_infok(felfedezo);
            }
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == arany_sas.getNev()) {
                felfedezo.kincsEladas(arany_sas);
                eladas();
                karakter_infok(felfedezo);
            }
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == bronz_tekercs.getNev()) {
                felfedezo.kincsEladas(bronz_tekercs);
                eladas();
                karakter_infok(felfedezo);
            }
            if (kincsek_box.getItemAt(kincsek_box.getSelectedIndex()) == arany_nyaklanc.getNev()) {
                felfedezo.kincsEladas(arany_nyaklanc);
                eladas();
                karakter_infok(felfedezo);
            }
        }
        if (eladas_button.equals(source)) {
            if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == kotel.getNev()) {
                felfedezo.eladas("Kötél");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == bozotvago.getNev()) {
                felfedezo.eladas("Bozótvágó");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == faklya.getNev()) {
                felfedezo.eladas("Fáklya");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == hus.getNev()) {
                felfedezo.eladas("Hús");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == whiskey.getNev()) {
                felfedezo.eladas("Whiskey");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == csokolade.getNev()) {
                felfedezo.eladas("Csokoládé");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == gyumulcs.getNev()) {
                felfedezo.eladas("Gyümölcs");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == kabitoszer.getNev()) {
                felfedezo.eladas("Kábitószer");
                eladas();
                karakter_infok(felfedezo);
            } else if (hajoraHelyezes_box.getItemAt(eladasra_kivan_box.getSelectedIndex()) == uveggolyo.getNev()) {
                felfedezo.eladas("Üveggolyó");
                eladas();
                karakter_infok(felfedezo);
            }
        }
        if (hajoslot_button.equals(source)) {
            if (hajoSlotHasznal) {
                hajoSlotHasznal = false;
                fel_button.setEnabled(true);
                le_button.setEnabled(true);
                jobb_button.setEnabled(true);
                bal_button.setEnabled(true);
                hajoSlot();
            } else {
                hajoSlotHasznal = true;
                fel_button.setEnabled(false);
                le_button.setEnabled(false);
                jobb_button.setEnabled(false);
                bal_button.setEnabled(false);
                hajoSlot();
            }
        }
        if (hajoraFel_button.equals(source)) {
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == kotel.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(kotel, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == bozotvago.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(bozotvago, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == faklya.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(faklya, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == hus.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(hus, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == whiskey.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(whiskey, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == csokolade.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(csokolade, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == gyumulcs.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(gyumulcs, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == kabitoszer.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(kabitoszer, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraHelyezes_box.getItemAt(hajoraHelyezes_box.getSelectedIndex()) == uveggolyo.getNev()) {
                felfedezo.getHajoTarolo().hajoraFel(uveggolyo, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }

        }
        if (hajoraLe_button.equals(source)) {
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == kotel.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(kotel, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == bozotvago.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(bozotvago, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == faklya.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(faklya, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == hus.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(hus, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == whiskey.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(whiskey, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == csokolade.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(csokolade, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == gyumulcs.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(gyumulcs, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == kabitoszer.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(kabitoszer, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }
            if (hajoraLevetel_box.getItemAt(hajoraLevetel_box.getSelectedIndex()) == uveggolyo.getNev()) {
                felfedezo.getHajoTarolo().hajoLe(uveggolyo, felfedezo.getSlotok());
                hajoSlot();
                karakter_infok(felfedezo);
            }

        }
        if (falvak_tars_vasarlas_button.equals(source)) {
            if (tars_faluban_box.getItemAt(tars_faluban_box.getSelectedIndex()) == felderito.getNev()) {
                if (felfedezo.tarsAdd(felderito)) {
                    this.latokor = 2;
                    mozgas(this.x, this.y);
                    karakter_infok(felfedezo);
                    tars_eloszor_vasar = 1;
                    vasarlas(cba);
                }
            } else if (tars_faluban_box.getItemAt(tars_faluban_box.getSelectedIndex()) == saman.getNev()) {
                if (felfedezo.tarsAdd(saman)) {
                    felfedezo.tarsHasznal(saman, cba);
                    karakter_infok(felfedezo);
                    tars_eloszor_vasar = 1;
                    vasarlas(cba);
                }
            } else if (tars_faluban_box.getItemAt(tars_faluban_box.getSelectedIndex()) == bolcs.getNev()) {
                if (felfedezo.tarsAdd(bolcs)) {
                    felfedezo.setViszony(felfedezo.getViszony() + 3);
                    karakter_infok(felfedezo);
                    tars_eloszor_vasar = 1;
                    vasarlas(cba);
                }
            }
        }
        if (tars_vasarlas_button.equals(source)) {
            if (tars_eloszor_box.getItemAt(tars_eloszor_box.getSelectedIndex()) == kereskedo.getNev()) {
                if (felfedezo.tarsAdd(kereskedo)) {
                    felfedezo.tarsHasznal(kereskedo, abc);
                    felfedezo.tarsHasznal(kereskedo, cba);
                    karakter_infok(felfedezo);
                    tars_eloszor_vasar = 1;
                    vasarlas(abc);
                }
            } else if (tars_eloszor_box.getItemAt(tars_eloszor_box.getSelectedIndex()) == katona.getNev()) {
                if (felfedezo.tarsAdd(katona)) {
                    felfedezo.tarsHasznal(katona, abc);
                    felfedezo.tarsHasznal(katona, cba);
                    karakter_infok(felfedezo);
                    tars_eloszor_vasar = 1;
                    vasarlas(abc);
                }
            } else if (tars_eloszor_box.getItemAt(tars_eloszor_box.getSelectedIndex()) == szamar.getNev()) {
                if (felfedezo.tarsAdd(szamar)) {
                    felfedezo.tarsHasznal(szamar, abc);
                    karakter_infok(felfedezo);
                    tars_eloszor_vasar = 1;
                    vasarlas(abc);
                }
            }
        }
        if (kincs_bezaras_button.equals(source)) {
            kincs_panel.remove(kincsleiras_label);
            kincs_panel.setVisible(false);
            fel_button.setEnabled(true);
            le_button.setEnabled(true);
            jobb_button.setEnabled(true);
            bal_button.setEnabled(true);
        }
        if (plusz_energia_button.equals(source)) {
            if (elel_box.getItemAt(elel_box.getSelectedIndex()) == gyumulcs.getNev()) {
                felfedezo.pluszEletero(gyumulcs);
                karakter_infok(felfedezo);
            } else if (elel_box.getItemAt(elel_box.getSelectedIndex()) == hus.getNev()) {
                felfedezo.pluszEletero(hus);
                karakter_infok(felfedezo);
            } else if (elel_box.getItemAt(elel_box.getSelectedIndex()) == csokolade.getNev()) {
                felfedezo.pluszEletero(csokolade);
                karakter_infok(felfedezo);
            } else if (elel_box.getItemAt(elel_box.getSelectedIndex()) == kabitoszer.getNev()) {
                felfedezo.pluszEletero(kabitoszer);
                karakter_infok(felfedezo);
            } else if (elel_box.getItemAt(elel_box.getSelectedIndex()) == whiskey.getNev()) {
                felfedezo.pluszEletero(whiskey);
                karakter_infok(felfedezo);
            }
        }
        if (bolt_button.equals(source)) {
            if (falu_vasarole) {
                if (vasarole) {
                    vasarole = false;
                    fel_button.setEnabled(true);
                    le_button.setEnabled(true);
                    jobb_button.setEnabled(true);
                    bal_button.setEnabled(true);
                    vasarlas(cba);
                } else {
                    fel_button.setEnabled(false);
                    le_button.setEnabled(false);
                    jobb_button.setEnabled(false);
                    bal_button.setEnabled(false);
                    vasarole = true;
                    vasarlas(cba);
                }
            } else {
                if (vasarole) {
                    vasarole = false;
                    fel_button.setEnabled(true);
                    le_button.setEnabled(true);
                    jobb_button.setEnabled(true);
                    bal_button.setEnabled(true);
                    vasarlas(abc);
                } else {
                    fel_button.setEnabled(false);
                    le_button.setEnabled(false);
                    jobb_button.setEnabled(false);
                    bal_button.setEnabled(false);
                    vasarole = true;
                    vasarlas(abc);
                }
            }

        }
        if (falvak_vasarlas_button.equals(source)) {
            if (falvak_lista_combobox.getItemAt(falvak_lista_combobox.getSelectedIndex()) == kotel.getNev()) {
                felfedezo.inventoryVasarlas(kotel_falu, cba);
                karakter_infok(felfedezo);
                vasarlas(cba);
            }
            if (falvak_lista_combobox.getItemAt(falvak_lista_combobox.getSelectedIndex()) == faklya.getNev()) {
                felfedezo.inventoryVasarlas(faklya_falu, cba);
                karakter_infok(felfedezo);
                vasarlas(cba);
            }
            if (falvak_lista_combobox.getItemAt(falvak_lista_combobox.getSelectedIndex()) == hus.getNev()) {
                felfedezo.inventoryVasarlas(hus_falu, cba);
                karakter_infok(felfedezo);
                vasarlas(cba);
            }
            if (falvak_lista_combobox.getItemAt(falvak_lista_combobox.getSelectedIndex()) == gyumulcs.getNev()) {
                felfedezo.inventoryVasarlas(gyumulcs, cba);
                karakter_infok(felfedezo);
                vasarlas(cba);
            }
            if (falvak_lista_combobox.getItemAt(falvak_lista_combobox.getSelectedIndex()) == kabitoszer.getNev()) {
                felfedezo.inventoryVasarlas(kabitoszer, cba);
                karakter_infok(felfedezo);
                vasarlas(cba);
            }
        }
        if (vasarlas_button.equals(source)) {
            if (bolti_lista_box.getItemAt(bolti_lista_box.getSelectedIndex()) == kotel.getNev()) {
                felfedezo.inventoryVasarlas(kotel, abc);
                karakter_infok(felfedezo);
                vasarlas(abc);
            }
            if (bolti_lista_box.getItemAt(bolti_lista_box.getSelectedIndex()) == bozotvago.getNev()) {
                felfedezo.inventoryVasarlas(bozotvago, abc);
                karakter_infok(felfedezo);
                vasarlas(abc);
            }
            if (bolti_lista_box.getItemAt(bolti_lista_box.getSelectedIndex()) == faklya.getNev()) {
                felfedezo.inventoryVasarlas(faklya, abc);
                karakter_infok(felfedezo);
                vasarlas(abc);
            }
            if (bolti_lista_box.getItemAt(bolti_lista_box.getSelectedIndex()) == uveggolyo.getNev()) {
                felfedezo.inventoryVasarlas(uveggolyo, abc);
                karakter_infok(felfedezo);
                vasarlas(abc);
            }
            if (bolti_lista_box.getItemAt(bolti_lista_box.getSelectedIndex()) == hus.getNev()) {
                felfedezo.inventoryVasarlas(hus, abc);
                karakter_infok(felfedezo);
                vasarlas(abc);
            }
            if (bolti_lista_box.getItemAt(bolti_lista_box.getSelectedIndex()) == whiskey.getNev()) {
                felfedezo.inventoryVasarlas(whiskey, abc);
                karakter_infok(felfedezo);
                vasarlas(abc);
            }
            if (bolti_lista_box.getItemAt(bolti_lista_box.getSelectedIndex()) == csokolade.getNev()) {
                felfedezo.inventoryVasarlas(csokolade, abc);
                karakter_infok(felfedezo);
                vasarlas(abc);
            }
        }
        if (fel_button.equals(source)) {
            if (this.y > 0) {
                if (felfedezo.isHajonvane()) {
                    if (palya_elemek[y - 1][x].getText().equals("T") && !palya_elemek[y - 1][x].getText().equals("G")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x, this.y -= 1);
                        karakter_body_label.setVisible(true);
                    } else {
                        if (!palya_elemek[y - 1][x].getText().equals("G")) {
                            karakter_body_label.setVisible(false);
                            felfedezo.setHajonvane(false);
                            felfedezo.mozgas();
                            if (felfedezo.utolsoItalok()) {
                                this.reszeg_lepes++;
                            }
                            mozgas(this.x, this.y -= 1);
                            if (!felfedezo.isHajonvane()) {
                                hajo_y = this.y + 1;
                                hajo_x = this.x;
                                hajo_koordinata(hajo_x, hajo_y);
                                hajo_body_label.setVisible(true);
                            }
                            karakter_body_label.setVisible(true);
                        }
                    }
                } else {
                    if (!palya_elemek[y - 1][x].getText().equals("T") && !palya_elemek[y - 1][x].getText().equals("O") && !palya_elemek[y - 1][x].getText().equals("G")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x, this.y -= 1);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    } else if (x == hajo_x && y - 1 == hajo_y) {
                        karakter_body_label.setVisible(false);
                        felfedezo.setHajonvane(true);
                        felfedezo.mozgas();
                        mozgas(this.x, this.y -= 1);
                        hajo_body_label.setVisible(false);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    }
                }
            }
            karakter_infok(felfedezo);
        }
        if (le_button.equals(source)) {
            if (this.y < 8) {
                if (felfedezo.isHajonvane()) {
                    if (palya_elemek[y + 1][x].getText().equals("T")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x, this.y += 1);
                        karakter_body_label.setVisible(true);
                    } else {
                        if (!palya_elemek[y + 1][x].getText().equals("G")) {
                            karakter_body_label.setVisible(false);
                            felfedezo.setHajonvane(false);
                            felfedezo.mozgas();
                            mozgas(this.x, this.y += 1);
                            if (!felfedezo.isHajonvane()) {
                                hajo_y = this.y - 1;
                                hajo_x = this.x;
                                hajo_koordinata(hajo_x, hajo_y);
                                hajo_body_label.setVisible(true);
                            }
                            karakter_body_label.setVisible(true);
                        }
                    }
                } else {
                    if (!palya_elemek[y + 1][x].getText().equals("T") && !palya_elemek[y + 1][x].getText().equals("O") && !palya_elemek[y + 1][x].getText().equals("G")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x, this.y += 1);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    } else if (x == hajo_x && y + 1 == hajo_y) {
                        karakter_body_label.setVisible(false);
                        felfedezo.setHajonvane(true);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x, this.y += 1);
                        hajo_body_label.setVisible(false);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    }
                }
            }
            karakter_infok(felfedezo);
        }
        if (jobb_button.equals(source)) {
            if (this.x < 12) {
                if (felfedezo.isHajonvane()) {
                    if (palya_elemek[y][x + 1].getText().equals("T")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x += 1, this.y);
                        karakter_body_label.setVisible(true);
                    } else {
                        if (!palya_elemek[y][x + 1].getText().equals("G")) {
                            karakter_body_label.setVisible(false);
                            felfedezo.setHajonvane(false);
                            felfedezo.mozgas();
                            if (felfedezo.utolsoItalok()) {
                                this.reszeg_lepes++;
                            }
                            mozgas(this.x += 1, this.y);
                            if (!felfedezo.isHajonvane()) {
                                hajo_y = this.y;
                                hajo_x = this.x - 1;
                                hajo_koordinata(hajo_x, hajo_y);
                                hajo_body_label.setVisible(true);
                            }
                            karakter_body_label.setVisible(true);
                        }
                    }
                } else {
                    if (!palya_elemek[y][x + 1].getText().equals("T") && !palya_elemek[y][x + 1].getText().equals("O") && !palya_elemek[y][x + 1].getText().equals("G")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x += 1, this.y);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    } else if (x + 1 == hajo_x && y == hajo_y) {
                        karakter_body_label.setVisible(false);
                        felfedezo.setHajonvane(true);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x += 1, this.y);
                        hajo_body_label.setVisible(false);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    }
                }
            }
            karakter_infok(felfedezo);
        }
        if (bal_button.equals(source)) {
            if (this.x > 0) {
                if (felfedezo.isHajonvane()) {
                    if (palya_elemek[y][x - 1].getText().equals("T")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x -= 1, this.y);
                        karakter_body_label.setVisible(true);
                    } else {
                        if (!palya_elemek[y][x - 1].getText().equals("G")) {
                            karakter_body_label.setVisible(false);
                            felfedezo.setHajonvane(false);
                            felfedezo.mozgas();
                            if (felfedezo.utolsoItalok()) {
                                this.reszeg_lepes++;
                            }
                            mozgas(this.x -= 1, this.y);
                            if (!felfedezo.isHajonvane()) {
                                hajo_y = this.y;
                                hajo_x = this.x + 1;
                                hajo_koordinata(hajo_x, hajo_y);
                                hajo_body_label.setVisible(true);
                            }
                            karakter_body_label.setVisible(true);
                        }
                    }
                } else {
                    if (!palya_elemek[y][x - 1].getText().equals("T") && !palya_elemek[y][x - 1].getText().equals("O") && !palya_elemek[y][x - 1].getText().equals("G")) {
                        karakter_body_label.setVisible(false);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x -= 1, this.y);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    } else if (x - 1 == hajo_x && y == hajo_y) {
                        karakter_body_label.setVisible(false);
                        felfedezo.setHajonvane(true);
                        felfedezo.mozgas();
                        if (felfedezo.utolsoItalok()) {
                            this.reszeg_lepes++;
                        }
                        mozgas(this.x -= 1, this.y);
                        hajo_body_label.setVisible(false);
                        karakter_body_label.setVisible(true);
                        elhagyas();
                    }
                }
            }
            karakter_infok(felfedezo);
        }
        if (vissza_button.equals(source)) {
            vege_panel.setVisible(false);
            fel_button.setEnabled(true);
            le_button.setEnabled(true);
            jobb_button.setEnabled(true);
            bal_button.setEnabled(true);
        }
        if (kilepes_button.equals(source)) {
            fel_button.setEnabled(true);
            le_button.setEnabled(true);
            jobb_button.setEnabled(true);
            bal_button.setEnabled(true);
            try {
                frame.getContentPane().removeAll();
                frame.repaint();
                clip.stop();
                new Kezdolap(frame);
            } catch (LineUnavailableException lineUnavailableException) {
                lineUnavailableException.printStackTrace();
            }
        }
    }
}
