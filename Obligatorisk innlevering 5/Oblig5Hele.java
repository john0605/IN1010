//Del 2C, Oppgave 12. Ferdig.

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Oblig5Hele {
    public static void main(String[] args) {

        try {
            //Endre path. Kjører også testdataliten samt testdata.
            File metaData = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/data/metadata.csv");
            File testdataliten = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/data/metadata.csv");     
            Monitor2 firstMonitor = new Monitor2(); Monitor2 secondMonitor = new Monitor2();
            Scanner sc = new Scanner(testdataliten); Scanner sc2 = new Scanner(metaData);

            ArrayList<Thread> threadR = new ArrayList<>();
            while(sc.hasNextLine()) {
                String nL = sc.nextLine(); String nL2 = sc2.nextLine();
                String[] x = nL.split(","); String[] y = nL2.split(",");
                if(y[1].equals("True")) {
                    Runnable nyLeseTrad2 = new LeseTraad("/Users/john_0605/Desktop/ObligatoriskInnlevering5/data/" + x[0], secondMonitor);
                    Thread threadB = new Thread(nyLeseTrad2);
                    threadR.add(threadB);
                    threadB.start();
                }
                else {
                    Runnable leseTrad = new LeseTraad("/Users/john_0605/Desktop/ObligatoriskInnlevering5/data/" + x[0], firstMonitor);
                    Thread t1 = new Thread(leseTrad);
                    threadR.add(t1);
                    t1.start();      
                }
            }
            sc.close(); sc2.close();
            
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
            
            ArrayList<Thread> sammenslaattTrader = new ArrayList<>();
            for(int i = 0; i < 8 ; i++) {
                Runnable nySammenslattTrad2 = new FletteTrad(secondMonitor);
                    Thread newThread = new Thread(nySammenslattTrad2);
                    sammenslaattTrader.add(newThread);
                    newThread.start();
                }

            for(int i = 0; i < 8 ; i++) {
                Runnable nySammenslattTrad = new FletteTrad(firstMonitor);
                    Thread newThread = new Thread(nySammenslattTrad);
                    sammenslaattTrader.add(newThread);
                    newThread.start();
                }

            for(int i = 0; i < sammenslaattTrader.size(); i++) {
                try {
                    sammenslaattTrader.get(i).join();
                    //System.out.println("Riktig");
                }
                catch (Exception e) {}
            }

            System.out.println("\n------Immunrepertoar-----\nData:");
            for(String sub : secondMonitor.hentBeholder().get(0).keySet()) {
                int storstDiff = 0;
                if(firstMonitor.hentBeholder().get(0).get(sub) == null) {
                    if(secondMonitor.hentBeholder().get(0).get(sub).hentForekomster() >= storstDiff) {
                        storstDiff = secondMonitor.hentBeholder().get(0).get(sub).hentForekomster();
                        String storstDiffSub = null;
                        storstDiffSub = sub;
                    }
                }
                if(firstMonitor.hentBeholder().get(0).get(sub) != null) {
                    int diff = secondMonitor.hentBeholder().get(0).get(sub).hentForekomster()-firstMonitor.hentBeholder().get(0).get(sub).hentForekomster();
                    if(diff > storstDiff) {
                        storstDiff = secondMonitor.hentBeholder().get(0).get(sub).hentForekomster();
                        String storstDiffSub = null;
                        storstDiffSub = sub;
                    }
                    if(diff >= 7) {
                        System.out.println(secondMonitor.hentBeholder().get(0).get(sub));
                    }
                }
            }
            System.out.println("");
        }
        catch (FileNotFoundException e) {}   
    }
}

