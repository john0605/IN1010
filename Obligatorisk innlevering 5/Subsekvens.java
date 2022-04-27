//Del 1, Oppgave 1. Ferdig

public class Subsekvens {
    public final String subsekvens; // Kan ikke endres, etter å ha blitt definert.
    private int forekomster = 1;

    public Subsekvens(String subsekvens, int antSubsekvens) {
        this.subsekvens = subsekvens;
        this.forekomster = antSubsekvens;
    }

    public String hentSubsekvens() { // Henter subsekvens.
        return subsekvens;
    }

    public int hentForekomster() { // Hentet antall forekomster av subsekvens.
        return forekomster;
    }

    public int endreForekomster(int x) { // Endrer antallet av forekomster.
        forekomster += x;
        return forekomster;
    }

    @Override
    public String toString() { // To string metode fra oppgaven. 
        return "(" + subsekvens + "," + forekomster + ")";
    }
}
