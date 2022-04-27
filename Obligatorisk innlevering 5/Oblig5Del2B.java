//Del 2B, Oppgave 11. Ferdig.

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Oblig5Del2B {
    public static void main(String[] args) {

        try {
            //Path skal endres til der test filene ligger, både filen og metadata.
            File testdatalikeMetadata = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalike/metadata.csv");
            Monitor2 firstMonitor2B = new Monitor2();
            Scanner sc = new Scanner(testdatalikeMetadata);
            ArrayList<Thread> threadR = new ArrayList<>();

            //Itererer gjennom filen og lager thread. 
            for(int i = 0; i < 9; i++) {
                String nL = sc.nextLine();
                String forData = "/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalike/";
                Runnable nyLeseTrad = new LeseTraad(forData + nL, firstMonitor2B);
                Thread newThread = new Thread(nyLeseTrad);
                threadR.add(newThread);
                newThread.start();
            }
            sc.close();
            
            //Gjør samme som forrige fil iterering
            File testdatalitenlikeMetadata = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalitenlike/metadata.csv");
            Monitor2 secondMonitor2B = new Monitor2();
            Scanner sc2 = new Scanner(testdatalitenlikeMetadata);
            for(int i = 0; i < 3; i++) {
                String nL2 = sc2.nextLine();
                String forTestdatalitenlike = "/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalitenlike/";
                Runnable nyLeseTrad2 = new LeseTraad(forTestdatalitenlike + nL2, secondMonitor2B);
                Thread threadB = new Thread(nyLeseTrad2);
                threadR.add(threadB);
                threadB.start();
            }
            sc2.close();
            
            for(int i = 0; i < threadR.size(); i++) {
                try {
                    threadR.get(i).join();
                    //System.out.println("Flettes traad1");
                } 
                catch (Exception e) {}
            } 

            ArrayList<Thread> nyLeseTrader2 = new ArrayList<>();
            for(int i = 0; i < nyLeseTrader2.size(); i++) {
                try {
                    nyLeseTrader2.get(i).join();
                    //System.out.println("Flettes");
                } 
                catch (Exception e) {}
            } 

            ArrayList<Thread> sammenslattTrader = new ArrayList<>();
            for(int i = 0; i < 8 ; i++) {
                Runnable nySammenslattTrad = new FletteTrad(firstMonitor2B);
                Thread newThread = new Thread(nySammenslattTrad);
                sammenslattTrader.add(newThread);
                newThread.start();
            }
            
            for(int i = 0; i < sammenslattTrader.size(); i++) {
                try {
                    sammenslattTrader.get(i).join();
                    //System.out.println("Riktig kjøres");
                }
                catch (Exception e) {}
            }

            ArrayList<Thread> fletteTrader2 = new ArrayList<>();
            for(int i = 0; i < 2 ; i++) {
                Runnable fleteTrad2 = new FletteTrad(secondMonitor2B);
                Thread newThread = new Thread(fleteTrad2);
                fletteTrader2.add(newThread);
                newThread.start();
            }

            for(int i = 0; i< fletteTrader2.size(); i++) {
                try {
                    fletteTrader2.get(i).join();
                    //System.out.println("Riktig");
                }
                catch (Exception e) {}
            }

            HashMap<String, Subsekvens> x = firstMonitor2B.hentBeholder().get(0);
            int storst = 0;
            Subsekvens storstSub = null;
            for (String i : x.keySet()) {
                if(x.get(i).hentForekomster() > storst) {
                    storst = x.get(i).hentForekomster();
                    storstSub = x.get(i);
                }
                else{
                    //System.out.println("Feil, HashMap x");
                }
            }

            HashMap<String, Subsekvens> y = secondMonitor2B.hentBeholder().get(0);
            int storst2 = 0;
            Subsekvens storstSub2 = null;
            for (String i : y.keySet()) {
                if(y.get(i).hentForekomster() > storst2) {
                    storst2 = y.get(i).hentForekomster();
                    storstSub2 = y.get(i);
                }
                else{
                    //System.out.println("Feil, HashMap y");
                }
            }
            System.out.println("\n------Immunrepertoar-----");
            System.out.println("Testdatalike:\n" + storstSub);
            System.out.println("\nTestdatalitenlike:\n" + storstSub2 + "\n");
        }
        catch (FileNotFoundException e) {}
    }
}
