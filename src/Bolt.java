import java.util.ArrayList;
import java.util.List;

/**
 * Bolt osztalya, adatai
 */
public class Bolt {
    public List<Inventory> targyak;

    public Bolt() {
        this.targyak = new ArrayList<>();
    }

    /**
     * Bolt targy feltoltese
     *
     * @param inventory Tárgy paramétere
     * @param mennyit   Tárgy mennyisége
     */
    public void termekHozzaad(Inventory inventory, int mennyit) {
        this.targyak.add(inventory);
        for (int i = 0; i < this.targyak.size(); i++) {
            if (this.targyak.get(i) == inventory) {
                this.targyak.get(i).setBoltban_marad(mennyit);
            }
        }
    }

    /**
     * Bolti targy eladasa
     *
     * @param inventory Tárgy paramétere
     */
    public void termekElad(Inventory inventory) {
        for (int i = 0; i < this.targyak.size(); i++) {
            if (this.targyak.get(i).getNev() == inventory.getNev()) {
                int db = this.targyak.get(i).getBoltban_marad();
                if (db <= 1) {
                    this.targyak.get(i).setBoltban_marad(0);
                } else {
                    this.targyak.get(i).setBoltban_marad(db - 1);
                }
            }
        }
    }

    /**
     * Adott bolti targy leirasa
     *
     * @param melyik Tárgy paramétere
     * @return       Az adott tárgyat
     */
    public Inventory printProducts(Inventory melyik) {
        for (int i = 0; i < this.targyak.size(); i++) {
            if (this.targyak.get(i) == melyik) {
                return this.targyak.get(i);
            }
        }
        return null;
    }

}
