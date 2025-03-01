import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A jatekos Adatai, interakcionak megvalositasa
 */
public class Felfedezo {
    public String nev;
    public double energia;
    public int arany;
    public double mozgas_energia;
    public Slot slotok;
    public List<Inventory> elHasznal;
    public List<Tars> tarsak;
    public HajoTarolo hajoTarolo;
    public int hirnev = 0;
    public boolean hajonvane = true;
    public boolean fuggo;
    public Random randi = new Random();
    public int viszony = 3;
    public int kincs_mennyiseg;
    public int fugg_mennyiseg;
    public boolean sikeres_nev_valtoztats=false;

    public Felfedezo(String nev) {
        this.nev = nev;
        this.hajoTarolo = new HajoTarolo();
        this.tarsak = new ArrayList<>();
        this.energia = 100;
        this.arany = 250;
        this.mozgas_energia = 1;
        this.slotok = new Slot(8);
        this.elHasznal = new ArrayList<>();
        this.fuggo = false;
        this.kincs_mennyiseg = 0;
    }

    public String getNev() {
        return nev;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public int getArany() {
        return arany;
    }

    public int getViszony() {
        return viszony;
    }

    public void setViszony(int viszony) {
        if (viszony <= 0) {
            this.viszony = 0;
        } else {
            this.viszony = viszony;
        }
    }

    public int getKincs_mennyiseg() {
        return kincs_mennyiseg;
    }

    public void setKincs_mennyiseg(int kincs_mennyiseg) {
        this.kincs_mennyiseg = kincs_mennyiseg;
    }

    public int getHirnev() {
        return hirnev;
    }

    public void setNev(String nev) {
        this.nev = nev;
        this.sikeres_nev_valtoztats = true;
    }

    public boolean isSikeres_nev_valtoztats() {
        return sikeres_nev_valtoztats;
    }

    public void setHirnev(int hirnev) {
        this.hirnev = hirnev;
    }

    public Slot getSlotok() {
        return slotok;
    }

    public void setSlotok(Slot slotok) {
        this.slotok = slotok;
    }

    public HajoTarolo getHajoTarolo() {
        return hajoTarolo;
    }

    public double getMozgas_energia() {
        return mozgas_energia;
    }

    public void setMozgas_energia(double mozgas_energia) {
        this.mozgas_energia = mozgas_energia;
    }

    public boolean isFuggo() {
        return fuggo;
    }

    public boolean isHajonvane() {
        return hajonvane;
    }

    public void setHajonvane(boolean hajonvane) {
        this.hajonvane = hajonvane;
    }

    /**
     * Csokkenti a mozgas energiajat
     */
    public void mozgas() {
        this.energia = this.energia - this.mozgas_energia;
        if (this.energia < 0) {
            this.energia = 0;
        }
    }

    /**
     * Egy targy levetele, vagy darabjanak csokkenese
     *
     * @param mit Melyik targyat
     */
    public void elhasznal(String mit) {
        Inventory uj = this.slotok.elhasznal(this, mit);
        if (uj != null) {
            this.elHasznal.add(uj);
        } else {
            System.err.println("Nincs ilyen termék");
        }
    }

    /**
     * Utolsó ket ital Fuggoseget okoz-e
     *
     * @return Függőseget okoz van nem
     */
    public boolean utolsoItalok() {
        int darab = this.elHasznal.size() - 1;
        if (darab >= 1) {
            if (elHasznal.get(darab).getNev() == "Whiskey" && elHasznal.get(darab - 1).getNev() == "Whiskey") {
                this.fugg_mennyiseg=this.fugg_mennyiseg+1;
                return true;
            }
            if (elHasznal.get(darab).getNev() == "Kábítószer" && elHasznal.get(darab - 1).getNev() == "Kábítószer") {
                this.fugg_mennyiseg=this.fugg_mennyiseg+1;
                return true;
            }
        }
        this.fugg_mennyiseg=0;
        return false;
    }

    /**
     * A Boltbol valo vasarlast es slothoz valo hozzaadast
     *
     * @param mit    Termek parametere
     * @param honnan Bolt parametere
     */
    public void inventoryVasarlas(Inventory mit, Bolt honnan) {
        this.slotok.hozzaAd(this, mit, honnan);
    }

    /**
     * Kincs slotba helyezese
     *
     * @param mit Kincs neve
     */
    public void kincsTalal(Inventory mit) {
        this.slotok.kincsAdd(this, mit);
        this.kincs_mennyiseg = 1;
    }

    /**
     * Egy Elelmiszer elfogyasztasanak kovetoen noveli az energiajat, es aztan levegye, vagy darabjat csokkentse a slotban
     *
     * @param mit Elelmiszer neve
     */
    public void pluszEletero(Inventory mit) {
        int rand = randi.nextInt(101);
        for (int i = 0; i < slotok.getTargyak().size(); i++) {
            if (this.slotok.getTargyak().get(i).getNev() == mit.getNev()) {
                if (this.slotok.getTargyak().get(i).getNev() == "Gyümölcs") {
                    this.elHasznal.add(mit);
                    if (!mit.isFuggoseg()) {
                        this.fuggo = false;
                    }
                    if (this.slotok.getTargyak().get(i).getDarab() == 0) {
                        energia = energia + this.slotok.getTargyak().get(i).getEnergia_noveles();
                        this.slotok.getTargyak().remove(i);
                        break;
                    } else {
                        this.slotok.getTargyak().get(i).setDarab(this.slotok.getTargyak().get(i).getDarab() - 1);
                        energia = energia + this.slotok.getTargyak().get(i).getEnergia_noveles();
                        if (this.slotok.getTargyak().get(i).getDarab() == 0) {
                            this.slotok.getTargyak().remove(i);
                        }
                        break;
                    }
                } else if (this.slotok.getTargyak().get(i).getNev() == "Hús") {
                    this.elHasznal.add(mit);
                    if (!mit.isFuggoseg()) {
                        this.fuggo = false;
                    }
                    if (this.slotok.getTargyak().get(i).getDarab() == 0) {
                        energia = energia + this.slotok.getTargyak().get(i).getEnergia_noveles();
                        this.slotok.getTargyak().remove(i);
                        break;
                    } else {
                        this.slotok.getTargyak().get(i).setDarab(slotok.getTargyak().get(i).getDarab() - 1);
                        energia = energia + this.slotok.getTargyak().get(i).getEnergia_noveles();
                        if (this.slotok.getTargyak().get(i).getDarab() == 0) {
                            this.slotok.getTargyak().remove(i);
                        }
                        break;
                    }
                } else if (this.slotok.getTargyak().get(i).getNev() == "Csokoládé" || this.slotok.getTargyak().get(i).getNev() == "Kábítószer" || this.slotok.getTargyak().get(i).getNev() == "Whiskey") {
                    this.elHasznal.add(mit);
                    if (utolsoItalok()) {
                        int szazelek = this.fugg_mennyiseg*15;
                        if (rand <= szazelek && (mit.getNev() == "Whiskey" || mit.getNev() == "Kábítószer")) {
                            this.fuggo = true;
                        }
                        if (!mit.isFuggoseg()) {
                            this.fuggo = false;
                        }
                    }
                    if (this.slotok.getTargyak().get(i).getDarab() == 0) {
                        energia = energia + this.slotok.getTargyak().get(i).getEnergia_noveles();
                        this.slotok.getTargyak().remove(i);
                        break;
                    } else {
                        this.slotok.getTargyak().get(i).setDarab(this.slotok.getTargyak().get(i).getDarab() - 1);
                        energia = energia + this.slotok.getTargyak().get(i).getEnergia_noveles();
                        if (this.slotok.getTargyak().get(i).getDarab() == 0) {
                            this.slotok.getTargyak().remove(i);
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * Tarsad hozzaad
     *
     * @param tars Tars parametere
     * @return     Hozzaadja vagy nem
     */
    public boolean tarsAdd(Tars tars) {
        this.arany = this.arany - tars.getAr();
        for (int i = 0; i < tarsak.size(); i++) {
            if (tarsak.get(i).getNev() == tars.getNev()) {
                this.arany = this.arany + tars.getAr();
                System.err.println("Már van ilyen társad!");
                return false;
            }
        }
        if (this.arany >= 0 && tarsak.size() < 3) {
            tarsak.add(tars);
            this.mozgas_energia = this.mozgas_energia * 115 / 100;
            return true;
        } else {
            this.arany = this.arany + tars.getAr();
            return false;
        }
    }

    /**
     * Tars Kepessegenek hasznalata
     *
     * @param tars Targy parametere
     * @param bolt Bolt parametere
     */
    public void tarsHasznal(Tars tars, Bolt bolt) {
        tars.kepesseg(this.slotok, bolt);
    }

    /**
     * Tars elhagyasa
     */
    public void tarsElhagy() {
        if (tarsak.size() > 0) {
            tarsak.remove(0);
        } else {
            System.out.println("Nincsen társad!");
        }

    }

    /**
     * Hajo slotjaba valo behelyezes
     *
     * @param inventory Targy parametere
     */
    public void hajoFel(Inventory inventory) {
        this.hajoTarolo.hajoraFel(inventory, this.slotok);
    }

    /**
     * Hajo slotjabol valo kivetel
     *
     * @param inventory Targy parametere
     */
    public void hajoLel(Inventory inventory) {
        this.hajoTarolo.hajoLe(inventory, this.slotok);
    }

    /**
     * Targy eladasa penzert
     *
     * @param inventory Targy neve
     */
    public void eladas(String inventory) {
        Inventory uj = this.slotok.elhasznal(this, inventory);
        if (uj != null) {
            this.arany = this.arany + uj.getEladasAr();
        }
    }

    /**
     * Kincs eladasa penzert
     *
     * @param kincs Kincs parametere
     */
    public void kincsEladas(Kincs kincs) {
        for (int i = 0; i < this.slotok.getTargyak().size(); i++) {
            if (this.slotok.getTargyak().get(i).getNev() == kincs.getNev()) {
                this.arany = this.arany + kincs.getErteke();
                this.slotok.getTargyak().remove(i);
                this.kincs_mennyiseg = 0;
            }
        }
    }

    /**
     * Kincs eladomanyozasa hirnevert
     *
     * @param kincs Kincs parametere
     */
    public void kincsEladomany(Kincs kincs) {
        for (int i = 0; i < this.slotok.getTargyak().size(); i++) {
            if (this.slotok.getTargyak().get(i).getNev() == kincs.getNev()) {
                this.hirnev = this.hirnev + kincs.getHirnev();
                this.slotok.getTargyak().remove(i);
                if (this.tarsak.size() == 0) {
                    this.mozgas_energia = 1;
                }
                this.kincs_mennyiseg = 0;
            }
        }
    }

}
