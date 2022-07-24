import java.util.ArrayList;
import java.util.List;

/**
 * Hajo Slot parameteri
 */
public class HajoTarolo {
    public List<Inventory> hajoTargyak;

    public HajoTarolo() {
        this.hajoTargyak = new ArrayList<>();
    }

    public List<Inventory> getHajoTargyak() {
        return hajoTargyak;
    }

    /**
     * Hajo slotjaba valo behelyezes
     *
     * @param inventory Targy parametere
     * @param slot      A Jatekos slotja
     */
    public void hajoraFel(Inventory inventory, Slot slot) {
        boolean vane = false;
        for (int i = 0; i < slot.getTargyak().size(); i++) {
            if (slot.getTargyak().get(i).getNev() == inventory.getNev()) {
                for (int j = 0; j < hajoTargyak.size(); j++) {
                    if (inventory.getNev() == this.hajoTargyak.get(j).getNev()) {
                        vane = true;
                        int db = this.hajoTargyak.get(j).getHajon_marad() + 1;
                        int ujdb = slot.getTargyak().get(i).getDarab();
                        this.hajoTargyak.get(j).setHajon_marad(db);
                        slot.getTargyak().get(i).setDarab(ujdb - 1);
                        if (slot.getTargyak().get(i).getDarab() <= 0) {
                            slot.getTargyak().remove(i);
                        } else {
                            System.out.println("Fel Termék neve: " + slot.getTargyak().get(i).getNev() + " és ebből " + slot.getTargyak().get(i).getDarab());
                        }
                        System.out.println("Hajon Termék neve: " + this.hajoTargyak.get(j).getNev() + " és ebből " + this.hajoTargyak.get(j).getHajon_marad());

                    }
                }
                if (!vane) {
                    this.hajoTargyak.add(inventory);
                    this.hajoTargyak.get(this.hajoTargyak.size() - 1).setHajon_marad(1);
                    int ujdb = slot.getTargyak().get(i).getDarab();
                    slot.getTargyak().get(i).setDarab(ujdb - 1);
                    if (slot.getTargyak().get(i).getDarab() == 0) {
                        slot.getTargyak().remove(i);
                    } else {
                        System.out.println("Fel Termék neve: " + slot.getTargyak().get(i).getNev() + " és ebből " + slot.getTargyak().get(i).getDarab());
                    }
                    System.out.println("Hajon Termék neve: " + this.hajoTargyak.get(this.hajoTargyak.size() - 1).getNev() + " és ebből " + this.hajoTargyak.get(this.hajoTargyak.size() - 1).getHajon_marad());
                }
            }
        }
    }

    /**
     * Hajo slotjabol valo kivetel
     *
     * @param inventory Targy parametere
     * @param slot      A Jatekos slotja
     */
    public void hajoLe(Inventory inventory, Slot slot) {
        boolean vane = false;
        for (int i = 0; i < hajoTargyak.size(); i++) {
            if (hajoTargyak.get(i).getNev() == inventory.getNev()) {
                for (int j = 0; j < slot.getTargyak().size(); j++) {
                    if (inventory.getNev() == slot.getTargyak().get(j).getNev()) {
                        vane = true;
                        int db = slot.getTargyak().get(j).getDarab() + 1;
                        int ujdb = hajoTargyak.get(i).getHajon_marad() - 1;
                        if (db <= 7) {
                            slot.getTargyak().get(j).setDarab(db);
                            hajoTargyak.get(i).setHajon_marad(ujdb);
                            if (hajoTargyak.get(i).getHajon_marad() <= 0) {
                                hajoTargyak.remove(i);
                            } else {
                                System.out.println("Hajon Termék neve: " + this.hajoTargyak.get(i).getNev() + " és ebből " + this.hajoTargyak.get(i).getHajon_marad());
                            }
                            System.out.println("Fel Termék neve: " + slot.getTargyak().get(j).getNev() + " és ebből " + slot.getTargyak().get(j).getDarab());
                        }
                    }
                }
                if (!vane) {
                    slot.getTargyak().add(inventory);
                    slot.getTargyak().get(slot.getTargyak().size() - 1).setDarab(1);
                    int ujdb = this.hajoTargyak.get(i).getHajon_marad() - 1;
                    hajoTargyak.get(i).setHajon_marad(ujdb);
                    if (hajoTargyak.get(i).getHajon_marad() <= 0) {
                        hajoTargyak.remove(i);
                    } else {
                        System.out.println("Hajon Termék neve: " + this.hajoTargyak.get(i).getNev() + " és ebből " + this.hajoTargyak.get(i).getHajon_marad());
                    }
                    System.out.println("Fel Termék neve: " + slot.getTargyak().get(slot.getTargyak().size() - 1).getNev() + " és ebből " + slot.getTargyak().get(slot.getTargyak().size() - 1).getDarab());
                }
            }
        }
    }

}
