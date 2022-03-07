import java.util.Scanner;
import java.io.File;

public class Hovedprogram {
    public static void main(String[] args){
        String fileName = "dataklynge.txt";                                            //Henter ut info fra txt filene
        Dataklynge x = new Dataklynge();
        Hovedprogram.lesFraFil(fileName, x);
        System.out.println(" ");                                                        //Printer ut info om de ulike dataklyngene
        System.out.println("Navn paa fil: " + fileName);
        System.out.println("Noder med minst 128 GB: " + x.noderMedNokMinne(128));
        System.out.println("Noder med minst 512 GB: " + x.noderMedNokMinne(512));
        System.out.println("Noder med minst 1024 GB: " + x.noderMedNokMinne(1024));
        System.out.println("Antall prosessorer: " + x.antProsessorer());
        System.out.println("Antall rack: " + x.getAntRack());
    }

    static void lesFraFil(String filNavn, Dataklynge y){                                //Metode som leser fra fil
        Scanner file = null;                                                            //Denne metoden skal ligge i hovedprogrammet
        try{                                                                            //og ikke i Dataklynge klassen
            file = new Scanner(new File(filNavn));                                      //Henter ut node, prosessor
            while (file.hasNextLine()) {                                                //ut ifra plasseringen i filen
                String linje = file.nextLine();
                String[] space = linje.split(" ");
                int n = Integer.parseInt(space[0]);
                int p = Integer.parseInt(space[1]);
                int m = Integer.parseInt(space[2]);
    
                if (p > 16 || m > 4096) {                                               //Oppgaven tilsier 16 prosessor
                    throw new Exception(filNavn);                                       //Og 4096 minne
                }
                for (int i = 0; i < n; i++) {
                    Node node = new Node(p, m);
                    y.settInnNode(node);
                }
            }
        }
         
        catch (Exception exception){
            System.out.println();
            System.out.println(exception.getMessage());
            System.exit(1);
        }
        file.close();
    }
}

//Dataklynge saga = new Dataklynge();                                                   //Denne delen tilhører del D
    //Node x = new Node(4,512);
    //Node y = new Node(8,1024);
    //for (int i = 0; i<16;i++  ) {
      //saga.settInnNode(y);
    //}
    //for (int i = 0; i<450;i++  ) {
      //saga.settInnNode(x);
    //}