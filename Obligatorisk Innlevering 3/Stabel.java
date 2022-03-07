public class Stabel<T> extends Lenkeliste<T>{   //Klasse Stabel<T> som arver fra Lenkeliste<T>
    
    @Override
    public void leggTil(T x){                   //Leggtil() metode som legger til først i listen
        Node nyNode = new Node(x);              //i forhold til samme metode fra Lenkeliste klassen
        if(antNoder == 0){                      //som legger til slutten av listen. 
            start = nyNode;                     //Sjekker om listen er tom og legger til. 
        }

        else{                                   //Dersom den ikke er tom, så legges elementet
            nyNode.neste = start;               //helt foran i listen. 
            start.forrige = nyNode;
            start = nyNode;
        }
        antNoder++;
    }
}