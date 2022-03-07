public class Spesialist extends Lege implements Godkjenningsfritak{                 //Sub klasse av Lege og implementerer Godkjenningsfritak                    
    
    protected String kontrollId;

    public Spesialist(String navn, String kontrollId){                              //Konstruktør
        super(navn);
        this.kontrollId = kontrollId;
    }

    @Override                                                                       //Henter ut kontrollID nummer
    public String hentKontrollId(){
        return kontrollId;
    }

    @Override                                                                       //Returnerer all informasjon om spesialist klassen
    public String toString(){
        return super.toString() + "\nType Lege: Spesialist\n" + "Kontroll ID: " + hentKontrollId();
    }

}
