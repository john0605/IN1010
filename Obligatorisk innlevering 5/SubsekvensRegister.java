//Del 1, Oppgave 2, Oppgave 3, Oppgave 4. Ferdig

import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SubsekvensRegister {
    ArrayList<HashMap<String, Subsekvens>> hashMapBeholder = new ArrayList<>();                 // Beholder som tar vare på registeret.
    HashMap<String, Subsekvens> hashmapMedSubsekvens;

    public static HashMap<String, Subsekvens> lesFraFil(String fileName) {
        HashMap<String, Subsekvens> mapForFil = new HashMap<String, Subsekvens>();              // Tom hash for subsekvenser.
        File fil = new File(fileName);
        Scanner scanner;
        int counter = 1;

        try {
            scanner = new Scanner(fil);                                                         // Scanner filen linje for linje.
            while (scanner.hasNextLine()) {
                String x = scanner.nextLine();
                String[] y = x.split("");

                for (int i = 0; i < y.length - 2; i++) {                                        // itererer gjennom for å finne mulige 3 sekvenser.
                    String subNavn = y[i] + y[i + 1] + y[i + 2];

                    if (!mapForFil.containsKey(subNavn)) {
                        Subsekvens ny = new Subsekvens(subNavn, counter);
                        mapForFil.put(subNavn, ny);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {                                                       // Stopper programmet.
            scanner = new Scanner("");
        }
        scanner.close();
        return mapForFil;
    }

    public static HashMap<String, Subsekvens> flettSammen(HashMap<String, Subsekvens> hashMap1,
            HashMap<String, Subsekvens> hashMap2) {                                             // Slår sammen hashmaps.
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
}
