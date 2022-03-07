public class Lege {                                         //Parent klasse Lege

    protected String navn;

    public Lege(String navn){                               //Konstruktør
        this.navn = navn;
    }

    public String hentNavn(){                               //Metode som returnerer navnet til legen
        return navn;
    }

    @Override                                               //Metode som returnerer all informasjon om legen
    public String toString(){
        return "\nLEGE INFORMASJON\nNavn:" + hentNavn();
    }
}
