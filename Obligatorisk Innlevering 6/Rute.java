//Ferdig.
public abstract class Rute {
    protected Labyrinth lab;

    //Referanser til naborutene.
    protected Rute nord;
    protected Rute oest;
    protected Rute syd;
    protected Rute vest;

    //Rute sine kordinater.
    protected int radNummer;
    protected int kolonneNummer;

    //Hjelp for metode.  
    protected boolean nei = false;

    //Konstruktoren her er kordinatene. 
    public Rute(int radNummer, int kolonneNummer, Labyrinth lab) {
        this.radNummer = radNummer;
        this.kolonneNummer = kolonneNummer;
        this.lab = lab;
    }

    public void finn(Rute fra) {
    }

    public void finnNaboer() {
        Rute[][] toDimArray = lab.hentArray();
        //Finner posisjoneringen av rutene rundt ruten som har blitt valgt.

        if (0 < radNummer) {
            nord = toDimArray[radNummer - 1][kolonneNummer];
        }

        if (radNummer < lab.hentRad() - 1) {
            syd = toDimArray[radNummer + 1][kolonneNummer] ;
        }

        if (kolonneNummer < lab.hentKolonne() - 1) {
            oest = toDimArray[radNummer][kolonneNummer + 1];
        }

        if (0 < kolonneNummer) {
            vest = toDimArray[radNummer][kolonneNummer - 1];
        }
    }
}