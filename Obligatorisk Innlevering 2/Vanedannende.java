class Vanedannende extends Legemiddel{                                              //Subklasse av parent klasse Legemiddel
    
    int styrke;

    public Vanedannende(String navn, double pris, double virkestoff, int styrke){   //Konstruktør
        super(navn, pris, virkestoff);
        this.styrke = styrke;
    }

    public int hentVanedannendeStyrke(){                                            //Henter ut mengde styrke som gjelder for bare vanedannende stoffer
        return styrke;
    }

    @Override                                                                       //Overskriver parent toString metoden sammen med den nye metoden
    public String toString(){
        return "\n" + super.toString() + "\nStyrke:" + hentVanedannendeStyrke();
    }
    
}
