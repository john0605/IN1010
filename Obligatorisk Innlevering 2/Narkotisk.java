class Narkotisk extends Legemiddel{                                                 //Subklasse av klassen Legemiddel
    
    int styrke;

    public Narkotisk(String navn, double pris, double virkestoff, int styrke){      //Konstruktør med super paramenterne og en som tilhører bare denne klassen
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentNarkotiskStyrke(){                                               //Henter ut mengde styrke som gjelder for bare narkotike stoffer
        return styrke;
    }

    @Override                                                                       //Overskriver parent toString metoden sammen med den nye metoden
    public String toString(){
        return "\n" + super.toString() + "\nStyrke:" + hentNarkotiskStyrke();
    }
}
