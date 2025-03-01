import java.util.ArrayList;
import java.util.List;

/**
 * A jatakos slotjanak parameterei
 */
public class Slot {
    public List<Inventory> targyak;
    public int slotMax;
    public Bolt bolt;

    public Slot(int slotMax) {
        this.targyak = new ArrayList<>();
        this.slotMax = slotMax;
    }

    public List<Inventory> getTargyak() {
        return targyak;
    }

    public void setTargyak(List<Inventory> targyak) {
        this.targyak = targyak;
    }

    public int getSlotMax() {
        return slotMax;
    }

    public void setSlotMax(int slotMax) {
        this.slotMax = slotMax;
    }

    /**
     * Slotba helyezi a targyat
     *
     * @param felfedezo A Jatakos
     * @param mit       Targy parametere
     * @param bolt      Bolt parametere
     */
    public void hozzaAd(Felfedezo felfedezo, Inventory mit, Bolt bolt) {
        boolean vane = false;
        for (int i = 0; i < bolt.targyak.size(); i++) {
            if (bolt.targyak.get(i).getNev() == mit.getNev()) {
                System.out.println("Megvan a termék!");
                for (int j = 0; j < targyak.size(); j++) {
                    if (mit.getNev() == this.targyak.get(j).getNev()) {
                        vane = true;
                        System.out.println("Van ilyen terméked");
                        int db = this.targyak.get(j).getDarab();
                        if (db > 6) {
                            System.err.println("Nem vehetsz többet");
                            break;
                        } else if (felfedezo.arany < mit.getAra()) {
                            System.out.println("Nincs rá pénzed");
                            break;
                        } else if (this.targyak.get(j).getBoltban_marad() == 0) {
                            System.out.println("Elfogyott");
                            break;
                        } else {
                            this.targyak.get(j).setDarab(db + 1);
                            felfedezo.arany = felfedezo.arany - bolt.targyak.get(i).getAra();
                            bolt.termekElad(mit);
                            System.out.println("Sikerült megvásárolni: " + this.targyak.get(j).getNev() + " Ennyi maradt a boltban: " + bolt.targyak.get(i).getBoltban_marad() + " Ennyi van nálad " + this.targyak.get(j).getDarab());
                            break;
                        }
                    }
                }
                if (!vane) {
                    if (felfedezo.arany < bolt.targyak.get(i).getAra()) {
                        System.out.println("Nincs rá pénzed");
                        break;
                    } else if (bolt.targyak.get(i).getBoltban_marad() == 0) {
                        System.out.println("Elfogyott");
                        break;
                    } else {
                        if (this.targyak.size() > this.slotMax - 1) {
                            felfedezo.setMozgas_energia(felfedezo.getMozgas_energia() * 120 / 100);
                        }
                        this.targyak.add(mit);
                        felfedezo.arany = felfedezo.arany - bolt.targyak.get(i).getAra();
                        bolt.termekElad(mit);
                        if (this.targyak.get(targyak.size() - 1).getDarab() == 0) {
                            this.targyak.get(targyak.size() - 1).setDarab(1);
                        }
                        System.out.println("Sikerült megvásárolni: " + this.targyak.get(targyak.size() - 1).getNev() + " Ennyi maradt a boltban: " + bolt.targyak.get(i).getBoltban_marad() + " Ennyi van nálad " + this.targyak.get(targyak.size() - 1).getDarab());
                        break;
                    }
                } else {
                    break;
                }
            } else {
                System.err.println("Nem ez a termék kell");
            }
        }
    }

    /**
     * Slotbol kiveszi a targyat
     *
     * @param felfedezo A Jatakos
     * @param mit       Targy parametere
     * @return          Hozzáadja vagy nem
     */
    public boolean kincsAdd(Felfedezo felfedezo, Inventory mit) {
        boolean vane = false;
        for (int i = 0; i < this.targyak.size(); i++) {
            if (this.targyak.get(i).isKincs()) {
                vane = true;
            }
        }
        if (!vane) {
            targyak.add(mit);
            if (this.targyak.size() > this.slotMax - 1) {
                double jelenlegi = felfedezo.getMozgas_energia();
                felfedezo.setMozgas_energia(jelenlegi * 120 / 100);
            }
            return true;
        } else {
            System.err.println("Nem teheted el!");
            return false;
        }
    }

    /**
     * Slotban levo targyat elhasznalja
     *
     * @param felfedezo A Jatekos
     * @param mit       Targy neve
     * @return Az adott termekkel ter vissza
     */
    public Inventory elhasznal(Felfedezo felfedezo, String mit) {
        Inventory uj;
        for (int i = 0; i < this.targyak.size(); i++) {
            if (this.targyak.get(i).getNev() == mit) {
                uj = this.targyak.get(i);
                if (this.targyak.get(i).getDarab() == 1) {
                    this.targyak.remove(i);
                } else {
                    this.targyak.get(i).setDarab(this.targyak.get(i).getDarab() - 1);
                }
                return uj;
            }
        }
        return null;
    }
}
