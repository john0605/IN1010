abstract class Lenkeliste<T> implements Liste<T>{
    class Node{                                     //Klasse node i Lenkelisten for å hjelpe
        Node neste = null;                          //oss med å referere til ulike objekter. 
        Node forrige = null;
        T data;
        Node (T x){
            data = x;
        }
    }

    protected int antNoder = 0;
    protected Node start = null;
    protected Node slutt = null;

    public int stoerrelse(){                        //Returerner antall elementer som er i listen.
        return antNoder;
    }

    @Override
    public void leggTil(T x){                       //Metode som setter inn data på slutten av lenkelisten.
        Node nyNode = new Node(x);
        if(start == null){                          //Legger til dersom listen er tom. 
            start = nyNode;
            antNoder++;
        }
        else{
            if(slutt == null){                      //Legger til den nye noden til slutt
                slutt = nyNode;                     //ut i fra om det er elementer i lister eller ikke
                slutt.forrige = start;
                start.neste = slutt;
                antNoder++;
            }
            else{
                Node NyNode = start;
                while(NyNode.neste != null){
                    NyNode = NyNode.neste;
                }
                NyNode.neste = new Node(x);
                antNoder++;
            }
        }
    }
    
    @Override
    public T hent(){                                //Returnerer første element uten å fjerne det fra listen. 
        if(start.neste == null){
            throw new UgyldigListeindeks(-1);
        }
        return start.data;
    }

    @Override
    public T fjern(){                               //Metode som fjerner det første elementet og returnerer
        T nyData;                                   //det fra lista. 
        if(start == null){
            throw new UgyldigListeindeks(-1);
        }
        else{
            if(start.neste == null){                //Sjekker først om listen er tom, dersom den er det endres
                nyData = start.data;                //ikke antallet. 
                start = null;
                slutt = null;
                antNoder--;
            }
            else{
                nyData = start.data;                //Fjerner det første elementet og returnerer den
                start = start.neste;                //og oppdaterer så antallet. 
                start.forrige = null;
                antNoder--;
            }
        }
        return nyData;
    }

    @Override
    public String toString(){                       //Metode som starter tomt, så legges til elementene. 
        String tekst = "";                          //Som skriver ut en streng med info
        Node naavaerende = start.neste;
        for (;1 < antNoder;){
            tekst = tekst + naavaerende.data;
            naavaerende = naavaerende.neste;
        }
        return tekst;
    }
}