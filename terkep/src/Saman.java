/**
 * Saman tars letrehozasa
 */
public class Saman extends Tars {
    public Saman(String nev) {
        super(nev, "Sámán");
    }

    /**
     * A Boltban es a Slotban levo Kabitoszer energia novelesenek erteket noveli 120%
     *
     * @param slot Slot parametere
     * @param bolt Bolt parametere
     */
    @Override
    public void kepesseg(Slot slot, Bolt bolt) {
        for (int i = 0; i < slot.getTargyak().size(); i++) {
            if (slot.getTargyak().get(i).getNev() == "Kábítószer") {
                slot.getTargyak().get(i).setEnergia_noveles(slot.getTargyak().get(i).getEnergia_noveles() * 120 / 100);
                break;
            }
        }
        for (int i = 0; i < bolt.targyak.size(); i++) {
            if (bolt.targyak.get(i).getNev() == "Kábítószer") {
                bolt.targyak.get(i).setEnergia_noveles(bolt.targyak.get(i).getEnergia_noveles() * 120 / 100);
                break;
            }
        }
    }
}
