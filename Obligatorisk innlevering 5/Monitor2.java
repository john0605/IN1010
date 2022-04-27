//Del 2, Oppgave 10. Ferdig.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.locks.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class Monitor2{
    Lock laas = new ReentrantLock();
    private ArrayList<HashMap<String, Subsekvens>> Monitor2Beholder;
    private HashMap<String, Subsekvens> nyHash;

    public Monitor2(){
        Monitor2Beholder = new ArrayList<HashMap<String, Subsekvens>>();
    }

    public void settInnHash(HashMap<String, Subsekvens> leggTil) {
        this.laas.lock();
        try {
            Monitor2Beholder.add(leggTil);
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

    public static HashMap<String, Subsekvens> flettet2(HashMap<String, Subsekvens> hashMap1,
        HashMap<String, Subsekvens> Monitor2Beholder) {                                                 // Slår sammen hashmaps.
        HashMap<String, Subsekvens> flettetHash = new HashMap<>();

        for (String i : hashMap1.keySet()) {
            flettetHash.put(i, hashMap1.get(i));
        }
        for (String i : Monitor2Beholder.keySet()) {
            if (flettetHash.containsKey(i)) {
                int x = Monitor2Beholder.get(i).endreForekomster(flettetHash.get(i).hentForekomster());
                Subsekvens y = new Subsekvens(i, x);
                flettetHash.put(i, y);
            }
            else {
                flettetHash.put(i, Monitor2Beholder.get(i));
            }
        }
        return flettetHash;
    }

    public void hashMapFlettetrad(HashMap<String, Subsekvens> inn) {
        Condition hentUt = laas.newCondition();
        this.laas.lock();    
        try {
            Monitor2Beholder.add(inn);
            if(Monitor2Beholder.size() > 0){
                hentUt.signalAll();   
            }
        } 
        finally {
            this.laas.unlock();
        }
    }

    public ArrayList<HashMap<String, Subsekvens>> taUtTo(){
        ArrayList<HashMap<String, Subsekvens>> beholderForTo = new ArrayList<>();
        this.laas.lock();
        try {
            if(Monitor2Beholder.size() < 2){
                return null;
            }
            for(int i = 0; i < 2; i++){
                nyHash = Monitor2Beholder.get(0);
                Monitor2Beholder.remove(0);
                beholderForTo.add(nyHash);
                if(Monitor2Beholder.size() == 0){
                    beholderForTo.add(nyHash);
                    return beholderForTo;
                }
            }
            return beholderForTo;
        } 
        finally{
            this.laas.unlock(); 
        }
    }

    public ArrayList<HashMap<String, Subsekvens>> hentBeholder() {
        return Monitor2Beholder;
    }

    public int hentStr() {
        return Monitor2Beholder.size();
    }
}
