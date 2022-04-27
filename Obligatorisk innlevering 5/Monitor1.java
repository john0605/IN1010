//Del 2, Oppgave 6. Ferdig

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.locks.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Monitor1 {
    Lock laas = new ReentrantLock();
    SubsekvensRegister register = new SubsekvensRegister();
    private ArrayList<HashMap<String, Subsekvens>> hashBeholder;

    public Monitor1() {
        hashBeholder = new ArrayList<HashMap<String, Subsekvens>>();
    }

    public void settInnHash(HashMap<String, Subsekvens> leggTil) {
        this.laas.lock();
        try {
            hashBeholder.add(leggTil);
            // System.out.println("Legger til hashmap i monitor");
        }
        finally {
            this.laas.unlock();
            // System.out.println("Ferdig med å legge til hashmap i monitor");
        }
    }

    public static HashMap<String, Subsekvens> lesFraFil(String fileName) {
        HashMap<String, Subsekvens> nyHash = new HashMap<String, Subsekvens>();
        File fil = new File(fileName);
        Scanner scanner;
        int counter = 1;
        try {
            scanner = new Scanner(fil);
            while (scanner.hasNextLine()) {
                String x = scanner.nextLine();
                String[] y = x.split("");

                for (int i = 0; i < y.length - 2; i++) {
                    String subNavn = y[i] + y[i + 1] + y[i + 2];

                    if (!nyHash.containsKey(subNavn)) {
                        Subsekvens ny = new Subsekvens(subNavn, counter);
                        nyHash.put(subNavn, ny);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            scanner = new Scanner("");
        }
        scanner.close();
        return nyHash;
    }

    public static HashMap<String, Subsekvens> flettet(HashMap<String, Subsekvens> hashMap1, 
        HashMap<String, Subsekvens> hashMap2) {
        HashMap<String, Subsekvens> flettetHash = new HashMap<>();

        for (String i : hashMap1.keySet()) {
            flettetHash.put(i, hashMap1.get(i));
        }
        for (String i : hashMap2.keySet()) {
            if (flettetHash.containsKey(i)) {
                int x = hashMap2.get(i).endreForekomster(1);
                Subsekvens y = new Subsekvens(i, x);
                flettetHash.put(i, y);
            }
            else {
                flettetHash.put(i, hashMap2.get(i));
            }
        }
        return flettetHash;
    }

    public ArrayList<HashMap<String, Subsekvens>> hentHashBeholder() {
        return hashBeholder;
    }
}

