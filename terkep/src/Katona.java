/**
 * Katona tars letrehozasa
 */
public class Katona extends Tars {
    public Katona(String nev) {
        super(nev, "Katona");
    }

    /**
     * A Boltban es a Slotban levo Whiskey energia novelesenek erteket noveli 120%
     *
     * @param slot Slot paramétere
     * @param bolt Bolt paramétere
     */
    @Override
    public void kepesseg(Slot slot, Bolt bolt) {
        for (int i = 0; i < slot.getTargyak().size(); i++) {
            if (slot.getTargyak().get(i).getNev() == "Whiskey") {
                slot.getTargyak().get(i).setEnergia_noveles(slot.getTargyak().get(i).getEnergia_noveles() * 120 / 100);
                break;
            }
        }
        for (int i = 0; i < bolt.targyak.size(); i++) {
            if (bolt.targyak.get(i).getNev() == "Whiskey") {
                bolt.targyak.get(i).setEnergia_noveles(bolt.targyak.get(i).getEnergia_noveles() * 120 / 100);
                break;
            }
        }
    }
}
