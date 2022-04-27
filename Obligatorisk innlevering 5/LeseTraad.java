//Del 2, Oppgave 10. Ferdig

import java.util.HashMap;

public class LeseTraad implements Runnable {
    private String fileName;
    private Monitor2 monitor;

    public LeseTraad(String fileName, Monitor2 monitor) {
        this.fileName = fileName;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        HashMap<String, Subsekvens> nyHash = Monitor2.lesFraFil(this.fileName);
        this.monitor.settInnHash(nyHash);
    }
}