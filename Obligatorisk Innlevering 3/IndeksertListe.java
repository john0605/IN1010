public class IndeksertListe<T> extends Lenkeliste<T> {

    public void leggTil(int pos, T x){                  //Ny metode som vil kunne legge til egnet posisjon
        if(pos > stoerrelse() || pos < 0){
            throw new UgyldigListeindeks(pos);
        }
        else if(start == null && pos == 0){             //Resterende elementer i listen vil bli skyvet bak
            Node nyNode = new Node(x);                  //Går ut fra om listen er tom
            start = nyNode;
            antNoder++;
        }
        else{
            if(slutt == null && pos == 0){
                Node NyNode = new Node(x);
                NyNode.neste = start;
                start.forrige = NyNode;
                slutt = start;
                start = NyNode;
            }
            else if(pos == 0){
                Node node = new Node(x);
                node.neste = start;
                start.forrige = node;
                start = node;
            }
            else if(slutt == null && pos == 1){
                Node Node = new Node(x);
                start.neste = Node;
                Node.forrige = start;
                slutt = Node;
            }
            else if (pos == stoerrelse()){
                Node nodeTo = new Node(x);
                nodeTo.forrige = slutt;
                slutt.neste = nodeTo;
                slutt = nodeTo;
            }
            else{
                Node naavaerende = new Node(x);
                naavaerende = start;
                for(int i = 0; i < pos; i++){
                    naavaerende = naavaerende.neste;
                }
                Node nodeTre = new Node(x);
                naavaerende.forrige.neste = nodeTre;
                naavaerende.forrige = nodeTre;
                nodeTre.forrige = naavaerende.forrige;
                nodeTre.neste = naavaerende;
            }
            antNoder++;
        }
    }

    public void sett(int pos, T x){                     //Setter inn ut i fra gitt posisjon.
        Node nyNode = new Node(x);                      //Endrer det elementet. 
        if(pos >= antNoder || pos < 0){
          throw new UgyldigListeindeks(pos);
        }
        else{
            if(pos == 0){
                nyNode = start;
                nyNode.data = x;
            }
            else {
                nyNode = start;
                for(int i = 0; i < pos; i++) {
                    nyNode = nyNode.neste;
                }
                nyNode.data = x;
            }
        }
    }    

    public T hent(int pos){                             //Sender tilbake element fra gitt posisjon. 
        Node nyNode = start;
        if(pos < 0 || pos > (antNoder - 1)){
            throw new UgyldigListeindeks(pos);
        }
        else{
            for(int i = 0; i < pos; i++){
                nyNode = nyNode.neste;
            }
        }    
        return nyNode.data;
    }

    public T fjern(int pos){                            //Metode som vil fjerne element fra gitt posisjon. 
        Node nyNode = start;
        if(pos < 0 || pos > (antNoder - 1)){
            throw new UgyldigListeindeks(pos);
        }
        for(int i = 0; i < pos; i++){
            nyNode = nyNode.neste;
        }
        if(pos == 0){
            start = start.neste;
        }
        else{
            if(pos == antNoder-1){
            nyNode.forrige.neste = null;
            }
        }
        antNoder--;
        return nyNode.data;
    }
}