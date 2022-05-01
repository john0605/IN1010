//Ferdig.
import java.io.*;
import java.util.*;

public class Oblig6 {
    public static void main(String[] args) {
        //Forst kompilere Oblig6 filen,
        //Saa "java Oblig6 <navnPaaTestfil>" i teminalen.
        String inputFil = null;
        if (args.length > 0) {
            inputFil = args[0];
        } 
        else {
            System.out.println("Sjekk om parameteren er riktig.");
        }

        File fil = new File(inputFil);
        Labyrinth lab = null;
        try {
            lab = new Labyrinth(fil);
        } 
        catch (Exception e) {
            System.out.println("Feil catch.");       
        }
        //Skriver ut hele labyrinten ut til terminalen. 
        System.out.println(lab);

        //Setter opp en loop som henter data fra bruker
        Scanner input = new Scanner(System.in);
        System.out.println("---Tast inn koordinatene slikt: <Rad> <Mellomrom> <Kolonne>---");
        System.out.println("--------Tast 'A' for aa avslutte programmet :)--------");
        String[] x = input.nextLine().split(" ");
        //Stopper nar bruker taster A
        while (!x[0].equals("A")) {
            try {
                //Finner utveien fra gitt kordinater
                int rad = Integer.parseInt(x[0]); int kolonne = Integer.parseInt(x[1]);
                System.out.println("Mulige aapninger:");
                lab.finnUtveiFra(rad, kolonne);
                System.out.println();
            }
            catch (NumberFormatException e) {
                System.out.println("Forstar ikke. Prov paa nytt.");
            }

            System.out.println("----Skriv inn nye koordinater eller tast inn 'A' for aa avslutte----");
            x = input.nextLine().split(" ");
        }
        input.close();
    }
}