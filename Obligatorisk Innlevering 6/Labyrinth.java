//Ferdig. 
import java.io.*;
import java.util.*;

public class Labyrinth {
    Rute[][] toDimensjonArray;
    int rad;
    int kolonne;
    File filNavn; 

    //Hjelpe metode for aa finne nabo.
    public int hentRad() {
        return rad;
    }

    //Brukes ogsaa i Rute klassen. 
    public int hentKolonne() {
        return kolonne;
    }

    //Brukes ogsaa i Rute klassen. 
    public Rute[][] hentArray() {
        return toDimensjonArray;
    }


    public Labyrinth(File labFil){
        try {
            //Setter opp en parameter for labFil.
            filNavn = labFil;
            Scanner scanner = new Scanner(labFil);
            Scanner nyScanner = new Scanner(labFil);

            //Splitter den forste linjen som forteller om hvordan rad og kolonne til dataen er. 
            String[] data = nyScanner.nextLine().split(" ");
            rad = Integer.parseInt(data[0]); kolonne = Integer.parseInt(data[1]);

            //Leser resten av filen og setter det inne i arrayen.
            int counter = 0;
            toDimensjonArray = new Rute[rad][kolonne];
            while (nyScanner.hasNextLine()) {
                String[] linje = nyScanner.nextLine().split("");
                //For loop som itterer gjennom filen og sjekker hva slags tegn som finnes, og definerer det. 
                for (int peker = 0; peker < kolonne; peker++) {
                    if (linje[peker].equals("#")) {
                        toDimensjonArray[counter][peker] = new SvartRute(counter, peker, this);
                        //System.out.println("SvarRute");
                    }
                    else if (linje[peker].equals(".") && peker == 0 ||
                            counter == 0 || peker == kolonne - 1 || counter == rad - 1) {
                        toDimensjonArray[counter][peker] = new Aapning(counter, peker, this);
                        //System.out.println("aapning");
                    }
                    else{
                        toDimensjonArray[counter][peker] = new HvitRute(counter, peker, this);
                        //System.out.println("HvitRute");
                    }
                }
                counter++;
            }

            for (int nabo = 0; nabo < rad; nabo++) {
                for (int type = 0; type < kolonne; type++) {
                    toDimensjonArray[nabo][type].finnNaboer();
                    //System.out.println("Feil - ruter rundt peker objekt.");
                }
            }
            scanner.close();
            nyScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Finner ikke riktig fil.");
        }
    }

    //Kaller paa finn metoden som viser punktene for veien ut. 
    public void finnUtveiFra(int rad, int kol) {
        toDimensjonArray[rad][kol].finn(null);
    }

    //Skriver labyrinten ut til terminalen. 
    @Override
    public String toString () {
        System.out.println("\n---------Antall rader:"+rad+"."+" Antall kolonner:"+kolonne+".---------\n");
        String labyrint = "";
        for (Rute[] x : toDimensjonArray) {
            for (Rute y : x) {
                labyrint += y;
            }
            labyrint += "\n";
        }
        return labyrint;
    }
}