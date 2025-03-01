/**
 * Kereskedo tars letrehozasa
 */
public class Kereskedo extends Tars {
    public Kereskedo(String nev) {
        super(nev, "Kereskedő");
    }

    /**
     * A termekek ertekeit noveli es arat csokkenti
     *
     * @param slot Slot parametere
     * @param bolt Bolt parametere
     */
    @Override
    public void kepesseg(Slot slot, Bolt bolt) {
        for (int i = 0; i < bolt.targyak.size(); i++) {
            bolt.targyak.get(i).setAra(bolt.targyak.get(i).getAra() - 7);
            bolt.targyak.get(i).setEladasAr(bolt.targyak.get(i).getEladasAr() + 10);
            if (bolt.targyak.get(i).getAra() < 0) {
                bolt.targyak.get(i).setAra(0);
            }
        }
    }
}
