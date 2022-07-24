/**
 * Inventory ososztaly parametereinek letrehozasa
 */
public abstract class Inventory {
    protected String nev;
    protected int ara;
    protected int eladasAr;
    protected int darab = 1;
    protected int energia_noveles;
    protected int boltban_marad;
    protected int hajon_marad;
    protected boolean kincs;
    protected boolean elelmiszer;
    protected boolean fuggoseg;

    public Inventory(String nev, int ara, int energia_noveles, boolean kincs, boolean elelmiszer, boolean fuggo) {
        this.nev = nev;
        this.ara = ara;
        this.energia_noveles = energia_noveles;
        this.kincs = kincs;
        this.elelmiszer = elelmiszer;
        this.eladasAr = ara;
        this.fuggoseg = fuggo;
        this.eladasAr = ara;
    }

    public int getHajon_marad() {
        return hajon_marad;
    }

    public void setHajon_marad(int hajon_marad) {
        this.hajon_marad = hajon_marad;
    }

    public boolean isFuggoseg() {
        return fuggoseg;
    }

    public void setFuggoseg(boolean fuggoseg) {
        this.fuggoseg = fuggoseg;
    }

    public int getEnergia_noveles() {
        return energia_noveles;
    }

    public void setEnergia_noveles(int energia_noveles) {
        this.energia_noveles = energia_noveles;
    }

    public boolean isElelmiszer() {
        return elelmiszer;
    }

    public boolean isKincs() {
        return kincs;
    }

    public int getBoltban_marad() {
        return boltban_marad;
    }

    public void setBoltban_marad(int boltban_marad) {
        this.boltban_marad = boltban_marad;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }

    public String getNev() {
        return nev;
    }

    public int getAra() {
        return ara;
    }

    public void setAra(int ara) {
        this.ara = ara;
    }

    public int getEladasAr() {
        return eladasAr;
    }

    public void setEladasAr(int eladasAr) {
        this.eladasAr = eladasAr;
    }

}
