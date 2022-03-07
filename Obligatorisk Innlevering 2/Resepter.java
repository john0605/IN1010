abstract class Resepter {                                                                       //Super klassen Resepter

    protected Legemiddel legemiddel;
    protected Lege utskrivendeLege;
    protected int pasientId;
    protected int reit;
    protected int id;
    protected static int idTeller = 1;

    public Resepter(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){      //Konstruktør med alle paramentere
        this.legemiddel = legemiddel;
        this.utskrivendeLege = utskrivendeLege;
        this.pasientId = pasientId;
        this.reit = reit;

        id = idTeller;                                                                          //Legger til telleren med en hver gang det blir opprettet ny objekt
        idTeller++;
    }

    public int hentId(){                                                                        //Metodene returnerer verdi på samme måte som legemiddel klassen
        return id;
    }

    public Legemiddel legemiddel(){
        return legemiddel;
    }

    public Lege hentLege(){
        return utskrivendeLege;
    }

    public int hentPasientId(){
        return pasientId;
    }

    public int hentReit(){
        return reit;
    }

    public boolean bruk(){                                                                      //Metode som tester dersom reit verdi går ned etter hver bruk
        if (reit > 0) {
            reit --;
            return true;
        }
        else{
            return false;
        }
    }

    abstract public String farge();                                                             //Metode som henter ut fargen på resept

    abstract public double prisAaBetale();                                                      //Metode som henter ut prisen på legemiddelet

    @Override                                                                                   //Metode som skriver ut all informasjon om reseptet
    public String toString(){
        return ("RESEPT INFORMASJON\nID: " + hentId() + "\nLegemiddel: " + legemiddel.hentNavn() + "\nUtskrivende lege: " + utskrivendeLege.hentNavn() + "\nPasient ID: " + hentPasientId() + "\nReit: " + hentReit());
    }

}
