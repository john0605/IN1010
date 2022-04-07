public class Pasient {

     private String navn;
     private String fodeselsnummer;
     private static int teller;
     private int pasientID;
     // Vi skal IKKE ha en metode som legger til resept.
     // Det er leger som kan legge til resepter,
     // pasienter kan jo ikke legge til det selv? it makes sense.
     private IndeksertListe<Resept> utskrevneResepter;

     public Pasient(String navn, String fodselsnummer){
          this.navn = navn;
          this.fodeselsnummer = fodselsnummer;
          pasientID = teller++;
          // Hver pasient har en liste som viser hvilke resepter de skal ha
          utskrevneResepter = new IndeksertListe<Resept>();

     }

     public String hentNavn(){
          return navn;
     }

     public String hentFodselsnummer(){
          return fodeselsnummer;
     }

     public int hentID(){
          return pasientID;
     }

     public IndeksertListe<Resept> hentReseptListeTilPasienten(){
          return utskrevneResepter;
     }

     // Denne metoden trengs for E4()
     public void leggTil(Resept r){
          utskrevneResepter.leggTil(r);
     }


     public String toString(){
          return ("Navn: " + navn  + "\n" +
                 "Fødselsnummer: " + fodeselsnummer + "\n" + 
                 "ID: " + pasientID);
     }
     
}
