//------------------------------------------------START-KLASSE-LEGE------------------------------------------------
public class Lege implements Comparable<Lege> {

    public String navn;
    protected IndeksertListe<Resept> utskrevneResepter;

    public Lege(String navn){
        this.navn = navn;
        utskrevneResepter = new IndeksertListe<Resept>();
        //System.out.println("//Klasse Lege Opprettet.");
    }

    public String hentNavn(){
        return navn;
    }

    public String toString(){
        return navn;
    }

    public IndeksertListe<Resept> hentReseptListeTilLegen(){
        return utskrevneResepter;
   }

    // Denne metoden trengs for E4()
    public void leggTil(Resept r){
    utskrevneResepter.leggTil(r);
    }

    @Override
    public int compareTo(Lege etAnnetLegeObjekt){
        return this.navn.compareTo(etAnnetLegeObjekt.hentNavn());
        // return hentNavn().compareTo(etAnnetLegeObjekt.hentnavn());???
    }

    // Skriv ut hvitt resept. DETTE ER SKRIVRESEPT() METODEN SOM TRENGS I E1
    public HviteResepter skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) 
        throws UlovligUtskrift {
        if( !(this instanceof Spesialist) && legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            //
            HviteResepter nyHvit = new HviteResepter(legemiddel, this, pasient, reit);
                utskrevneResepter.leggTil(nyHvit);
                return nyHvit;
        }
    }

    // Skriv ut miltær resept. DETTE ER SKRIVRESEPT() METODEN SOM TRENGS I E1
    public MilResept skrivMilResept(Legemiddel legemiddel, Pasient pasient) 
        throws UlovligUtskrift {
        if( !(this instanceof Spesialist) && legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            //
            MilResept nyMil = new MilResept(legemiddel, this, pasient);
                utskrevneResepter.leggTil(nyMil);
                return nyMil;
        }
    }

    // Skriv ut p resept. DETTE ER SKRIVRESEPT() METODEN SOM TRENGS I E1
    public pResept skrivpResept(Legemiddel legemiddel, Pasient pasient, int reit) 
        throws UlovligUtskrift {
        if( !(this instanceof Spesialist) && legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            //
            pResept nyP = new pResept(legemiddel, this, pasient, reit);
                utskrevneResepter.leggTil(nyP);
                return nyP;
        }
    }

    // Skriv ut blått resept. DETTE ER SKRIVRESEPT() METODEN SOM TRENGS I E1
    public BlaaResepter skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) 
        throws UlovligUtskrift {
        if( !(this instanceof Spesialist) && legemiddel instanceof Narkotisk){
            throw new UlovligUtskrift(this, legemiddel);
        } else {
            //
            BlaaResepter nyB = new BlaaResepter(legemiddel, this, pasient, reit);
                utskrevneResepter.leggTil(nyB);
                return nyB;
        }
    }
}


//------------------------------------------------START-KLASSE-SPESIALIST------------------------------------------------


class Spesialist extends Lege implements Godkjenningsfritak{

    protected String kontrollID;

    public Spesialist(String navn, String kontrollID){
        super(navn);
        this.kontrollID = kontrollID;
        utskrevneResepter = new IndeksertListe<Resept>();
        //System.out.println("//Klasse spesialist opprettet.");
    }

    public String hentNavn(){
        return navn;
    }

    public String hentKontrollID(){
        return kontrollID;
    }

    public String toString(){
        return (navn + "\n" +
                "KontrollID: " + kontrollID);
    }
}


//------------------------------------------------END-OF-CODE------------------------------------------------