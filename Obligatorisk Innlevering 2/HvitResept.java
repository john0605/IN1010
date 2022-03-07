class HvitResept extends Resepter {                                                             //Sub klasse av parent klasse Resepter
    
    public HvitResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){    //Kontruktør
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override                                                                                   //Overskriver metoden og returnerer fargen
    public String farge(){
        return "Hvit";
    }

    @Override                                                                                   //Henter ut prisen direkte, ettersom oppgaven tilsier ikke noe annet
    public double prisAaBetale(){
        return legemiddel.hentPris();
    }

    @Override                                                                                   //ToString metode som returnerer all informasjon
    public String toString(){
        return "\n\n" + super.toString() + "\nType resept: " + farge() + " resept" + "\nPris: " + prisAaBetale() + " kr";
    }

}
