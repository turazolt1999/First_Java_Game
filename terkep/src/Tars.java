/**
 * Tars ososztaly parametereinek letrehozasa
 */
public abstract class Tars implements Kepesseg {
    public String nev;
    public String tipus;
    public int ar;

    public Tars(String nev, String tipus) {
        this.nev = nev;
        this.ar = 150;
        this.tipus = tipus;
    }

    public String getNev() {
        return nev;
    }

    public int getAr() {
        return ar;
    }

    public String getTipus() {
        return tipus;
    }
}
