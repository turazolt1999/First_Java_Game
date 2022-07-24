/**
 * Szamár tars letrehozasa
 */
public class Szamar extends Tars {
    public Szamar(String nev) {
        super(nev, "Szamár");
    }

    /**
     * Slot meretenek novelese
     *
     * @param slot Slot parametere
     * @param bolt Bolt parametere
     */
    @Override
    public void kepesseg(Slot slot, Bolt bolt) {
        slot.setSlotMax(slot.getSlotMax() + 2);
    }
}
