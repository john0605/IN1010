public class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {     //Prioritert kø klasse.
    @Override
    public void leggTil(T x){                                                   //Metode som legger til sortert liste. 
        if (start == null){                                                     //Sjekker om listen er tom og legger til element
            super.leggTil(x);
            return;
        } 
        else{
            for(int i =0; i<antNoder; i++){
                if(hent(i).compareTo(x) > 0){                                   //Ittererer gjennom informasjon i listen og legger til
                    super.leggTil(null);                                        //ved å bruke innebygget compare funksjon. 
                    for(int nyNode = antNoder -2; i <= nyNode; nyNode --){
                        sett(nyNode + 1, hent(nyNode));
                    }
                    sett(i, x);                                                 //Etter å ha funet posisjon til nye element settes det inn. 
                    return;
                }
            }
            super.leggTil(x);
        }
    }
    
    public T hent(int pos){                                                     //Metode som henter ut element fra gitt posisjon.
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

    public void sett(int pos, T x){                                             //Metode som setter inn i gitt posisjon. 
        Node nyNode = new Node(x);
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
}
