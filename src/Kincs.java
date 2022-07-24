/**
 * Kincs letrehozasa, ami egy Inventory
 */
public class Kincs extends Inventory {
    public int erteke;
    public int hirnev;

    public Kincs(String mit, int erteke, int hirnev) {
        super(mit, 0, 0, true, false, false);
        this.erteke = erteke;
        this.hirnev = hirnev;
    }

    public int getErteke() {
        return erteke;
    }

    public int getHirnev() {
        return hirnev;
    }
}
