//Del 2A, Oppgave 8. Ferdig.

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class Oblig5Del2A {

    public static void main(String[] args) {

        try {
            File testdatalike = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalike/metadata.csv");             //Path som går direkte til metadata filen.
            File testdatalitenlike = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalitenlike/metadata.csv");   //Endres ut ifra hvor den er plassert. 

            Monitor1 monitor = new Monitor1();
            ArrayList<Thread> threads = new ArrayList<>();

            Monitor1 monitor2 = new Monitor1();
            ArrayList<Thread> threads2 = new ArrayList<>();

            HashMap<String, Subsekvens> hashMapFil1 = new HashMap<>();
            HashMap<String, Subsekvens> flettetHash = new HashMap<>();
            Scanner sc = new Scanner(testdatalike);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                Thread tradEn = new Thread(new LeseTrad("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalike/" + data, monitor));
                threads.add(tradEn);
                tradEn.start();
                // hashMapFil = SubsekvensRegister.lesFraFil("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalike/" + data);
                // flettetHash = SubsekvensRegister.flettet(hashMapFil, flettetHash);
            }
            sc.close();

            HashMap<String, Subsekvens> hashMapFil2 = new HashMap<>();
            HashMap<String, Subsekvens> flettetHash2 = new HashMap<>();
            Scanner sc2 = new Scanner(testdatalitenlike);
            while (sc2.hasNextLine()) {
                String data = sc2.nextLine();
                Thread t2 = new Thread(new LeseTrad("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalitenlike/" + data, monitor2));
                threads2.add(t2);
                t2.start();
                // hashMapFil2 = 
                // SubsekvensRegister.lesFraFil(""/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalitenlike/" + data);
                // flettetHash2 = 
                // SubsekvensRegister.flettet(hashMapFil2, flettetHash2);
            }
            sc2.close();

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (Exception e) {
                    System.out.println("Thread could not be joined");
                }
            }

            for (Thread thread : threads2) {
                try {
                    thread.join();
                } catch (Exception e) {
                    System.out.println("Thread could not be joined");
                }
            }

            ArrayList<HashMap<String, Subsekvens>> beholder = monitor.hentHashBeholder();
            for (HashMap<String, Subsekvens> hashMap : beholder) {
                hashMapFil1 = hashMap;
                flettetHash = Monitor1.flettet(hashMapFil1, flettetHash);
            }
            
            ArrayList<HashMap<String, Subsekvens>> beholder2 = monitor2.hentHashBeholder();
            for (HashMap<String, Subsekvens> hashMap : beholder2) {
                hashMapFil2 = hashMap;
                flettetHash2 = Monitor1.flettet(hashMapFil2, flettetHash2);
            }

            int x = 0;
            Subsekvens sub = null;
            for (String i : flettetHash.keySet()) {
                if (flettetHash.get(i).hentForekomster() > x) {
                    x = flettetHash.get(i).hentForekomster();
                    sub = flettetHash.get(i);
                }
            }

            int y = 0;
            Subsekvens sub2 = null;
            for (String i : flettetHash2.keySet()) {
                if (flettetHash2.get(i).hentForekomster() > y) {
                    y = flettetHash2.get(i).hentForekomster();
                    sub2 = flettetHash2.get(i);
                }
            }
            System.out.println("\n------Immunrepertoar-----");
            System.out.println("Testdatalike:\n" + sub);
            System.out.println("\nTestdatalitenlike:\n" + sub2 + "\n");
        }
        catch (FileNotFoundException e) {}
    }
}