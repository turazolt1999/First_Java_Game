/**
 * Elelmiszer letrehozasa, ami egy Inventory
 */
public class Elelmiszer extends Inventory {
    public Elelmiszer(String nev, int ara, int energia_noveles, boolean fuggo) {
        super(nev, ara, energia_noveles, false, true, fuggo);
    }
}
