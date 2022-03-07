public class Rack {
    private static int maxNoder = 12;                           //Max noder er 12
    private Node[] nodeListe = new Node[maxNoder];              //Setter opp en liste og ikke arrayliste
    
    public void settInn(Node noder){                            //Legger noder til listen
        for(int i = 0; i < maxNoder; i++){
            if (nodeListe[i] == null){
                nodeListe[i] = noder;
                break;
            }
        }
    }

    public int antProsessorer(){                                //Teller totale antall prosessorer 
        int sammenlagtProsessorer = 0;
        for (Node node : nodeListe){
            if (node == null){
                break;
            }
            sammenlagtProsessorer += node.antProsessor();
        }
        return sammenlagtProsessorer;
    }

    public boolean sjekkMaxNode(){                              //Returnerer true dersom liste ikke er full
        for (Node x : nodeListe){
            if (x ==  null){
                return false;
            }
        }
        return true;
    }

    public int noderMedNokMinne(int paakrevdMinne){            //Teller antall noder i klynge
        int nokMinne = 0;
        for (Node node : nodeListe){
            if (node == null){
                break;
            }
            if (node.minne() >= paakrevdMinne){
                nokMinne++;
            }
        }
        return nokMinne;                                        //Returnerer antallet
    }

}