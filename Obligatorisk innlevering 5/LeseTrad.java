//Del 2, Oppgave 7. Ferdig

import java.util.HashMap;

public class LeseTrad implements Runnable {
    private String fileName;
    private Monitor1 monitor;

    public LeseTrad(String fileName, Monitor1 monitor) {
        this.fileName = fileName;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        HashMap<String, Subsekvens> nyHash = SubsekvensRegister.lesFraFil(this.fileName);
        this.monitor.settInnHash(nyHash);
    }
}
