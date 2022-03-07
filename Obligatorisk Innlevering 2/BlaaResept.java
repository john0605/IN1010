class BlaaResept extends Resepter {                                                                 //Sub klasse av parent klasse Resept
    
    private final static double rabattBlaa = 0.75;

    public BlaaResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){        //Kontruktør
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override                                                                                       //Overskriver og returnerer faren på resept
    public String farge(){
        return "Blaa";
    }

    @Override                                                                                       //Returnerer prisen ved å trekke 0.75 fra 1 som tilsvarer 0.25
    public double prisAaBetale(){                                                                   //og gange det med prisen slik at brukeren betaler 20%
        return legemiddel.hentPris() * (1 - rabattBlaa);
    }

    @Override                                                                                       //ToString metode som returnerer all informasjon
    public String toString() {
        return "\n\n" + super.toString() + "\nType resept: " + farge() + " Resept" + "\nPris: " + prisAaBetale() + " kr";
    }

}
