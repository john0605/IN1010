import java.util.ArrayList;

public class Dataklynge {
    ArrayList<Rack> racksListe = new ArrayList<Rack>();
    public void settInnNode(Node node){                         //Setter inn info dersom det er ledig plass i listen
        int i = racksListe.size();
        if (i == 0){
            Rack nyRack = new Rack();
            nyRack.settInn(node);
            racksListe.add(nyRack);;
            return;
        }         
        Rack nyRack = racksListe.get(i-1);                      //Dersom det ikke er tilstrekkelig plass
        if (nyRack.sjekkMaxNode()){                             //Settes det opp et nytt rack med info
            nyRack.settInn(node);
        }
        else {
            Rack rack = new Rack();
            rack.settInn(node);
            racksListe.add(rack);
        }
    }

    public int antProsessorer(){                                //Henter ut antall prosessor
        int antallprosessor = 0;
        for (Rack i : racksListe){
            antallprosessor += i.antProsessorer();
        }
        return antallprosessor;
    }

    public int noderMedNokMinne(int paakrevdMinne){             //Fra del C i Dataklynge som returnerer
        int antall = 0;                                         //Antall noder med minst paakrevdMinne antall GByte minne.
        for (Rack i : racksListe){
            antall += i.noderMedNokMinne(paakrevdMinne);
        }
        return antall;
    }

    public int getAntRack(){                                    //Henter ut antall racks
        return racksListe.size();
    }
}