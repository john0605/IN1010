import java.util.Iterator;

abstract class Lenkeliste<T> implements Liste<T>  {

     Node foran;
     Node bakerst;
     public int antallElementer = 0;

     // Den er protected fordi andre subklasser av Lenkeliste<T> skal kunne bruke klasse Node
     protected class Node{
          T informasjon;
          Node neste = null;
          Node forrige = null;

          protected Node(T informasjon){
               this.informasjon = informasjon;
          }
     }

     public Lenkeliste(){
          Node foran = null;
          Node bakerst = null;
          int antallElementer = 0;
     }

     // Hjelpemetode for å sjekke om det finnes elementer i lista, spesifikt index 0. 
     // Hvis index 0 = null, så betyr det rett og slett at lista er tom
     public boolean sjekkerOmDetFinnesElementerForst(){
          if (foran == null){
               return true;
          } else {
               return false;
          }
     }

     public int stoerrelse(){
          return antallElementer;
     }

     // Nye elementer blit lagt inn bakerst
     public void leggTil(T x){
          Node nyNode = new Node(x);

          // Om "lista" er tom, så blir første elementet = ny node
          if (sjekkerOmDetFinnesElementerForst()){
               foran = nyNode;
          // Om "lista" har elementer fra før av, sett den nå bakerst i "lista"
          } else {
               bakerst.neste = nyNode;
               nyNode.forrige = bakerst;
          }
          bakerst = nyNode;
          antallElementer += 1;
     }

     public T hent(){
          // Setter x som en referanse til den bakerste noden i "lista", deretter returnerer jeg den
          Node x = bakerst;
          return bakerst.informasjon;
     }

     public T fjern(){
          Node midlertidig = bakerst;
          // Må sjekke om det finnes elementer i "lista" til å begynne med
          if (sjekkerOmDetFinnesElementerForst()){
               // Kaster unntak, "lista" er tom, index 0 = null
               throw new UgyldigListeindeks(0);
          } else if (foran == bakerst){
               foran = null;
               bakerst = null;
          // Fjerner første elementet i lista, lista minkes med 1 
          } else {
               bakerst = bakerst.forrige;
               // Siste index skal settes lik null, fordi den skal slettes
               bakerst.neste = null;
          }
          antallElementer -= 1;
          return midlertidig.informasjon;
     }    

     // Hjelpemetode for å printe ut lista underveis
     public void printUtAlleElementer(){
          Node f = foran;
          System.out.println("-------------");
           
          while (f != null){
               System.out.println(f.informasjon);
          }
          System.out.println();
     }

     public Iterator<T> iterator(){
          return new ListeIterator();
     }

//---------------------------------------KLASSE-ITERATOR-SOM-IMPLEMENTERER-ITERATOR<T>----------------------------------------------------------------

     class ListeIterator implements Iterator<T>{
          Node node = foran;
          protected int antallElementer;
          private int posisjon = 0;

          // Metode fra Lenkeliste,java, trengs her også
          public int stoerrelse(){
               return antallElementer;
          }

          // Sjekke om vi har kommet til slutten av lista
          public boolean hasNext(){
               return posisjon < stoerrelse(); 
          }
     
          public T next(){
               posisjon++;
               return getNode(posisjon-1).informasjon;
               // foreleser: return get(posisjon-1)
          }
     }

     // Hjelpemetode som er kopiert fra IndeksertListe, denne trengs for Iterator-klassen
     public Node getNode(int pos){
          if (pos < 0 || pos >= antallElementer || sjekkerOmDetFinnesElementerForst()){
               throw new UgyldigListeindeks(pos);
          } else {
               Node midlertidig = foran;
               for (int i = 0; i < pos; i++){
                    midlertidig = midlertidig.neste;
               }
               return midlertidig;
          }
     }




}