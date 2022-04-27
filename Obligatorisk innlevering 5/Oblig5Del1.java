//Del 1, Oppgave 5. Ferdig

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class Oblig5Del1 {
    public static void main(String[] args) {

        try {
            File testdatalike = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalike/metadata.csv");           //Path som går direkte til metadata filen. 
            File testdatalitenlike = new File("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalitenlike/metadata.csv"); //Endres ut ifra hvor den er plassert.

            HashMap<String, Subsekvens> hashMapFil = new HashMap<>();
            HashMap<String, Subsekvens> flettetHash = new HashMap<>();
            Scanner sc = new Scanner(testdatalike);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                hashMapFil = SubsekvensRegister.lesFraFil("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalike/" + data);        //Endre path.
                flettetHash = SubsekvensRegister.flettSammen(hashMapFil, flettetHash);
            }
            sc.close();

            HashMap<String, Subsekvens> hashMapFil2 = new HashMap<>();
            HashMap<String, Subsekvens> flettetHash2 = new HashMap<>();
            Scanner sc2 = new Scanner(testdatalitenlike);
            while (sc2.hasNextLine()) {
                String data = sc2.nextLine();
                hashMapFil2 = SubsekvensRegister.lesFraFil("/Users/john_0605/Desktop/ObligatoriskInnlevering5/testdatalitenlike/" + data);  //Endre path.
                flettetHash2 = SubsekvensRegister.flettSammen(hashMapFil2, flettetHash2);
            }
            sc2.close();

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

        catch (FileNotFoundException exception) {}
    }
}