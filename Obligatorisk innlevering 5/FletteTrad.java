//Del 2, Oppgave 9. Ferdig.

import java.util.HashMap;
import java.util.ArrayList;

public class FletteTrad implements Runnable{
    Monitor2 m2;

    public FletteTrad(Monitor2 monitor2){
        this.m2 = monitor2;  
    }
    
    @Override
    public void run() {
        ArrayList<HashMap<String, Subsekvens>> hashBeholder2 = new ArrayList<>();
        try {
            while(hashBeholder2 != null){
                hashBeholder2 = m2.taUtTo();
                if(hashBeholder2 == null){
                    return;
                }
                HashMap<String, Subsekvens> bothHash2 = Monitor2.flettet2(hashBeholder2.get(0), hashBeholder2.get(1));
                m2.hashMapFlettetrad(bothHash2);
            }
        }
        catch (Exception exception) {}
    }
}

