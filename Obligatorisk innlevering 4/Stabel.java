class Stabel<T> extends Lenkeliste<T> {

     public void leggTil(T x){

          Node nyNode = new Node(x);

          if (sjekkerOmDetFinnesElementerForst()){
               foran = nyNode;
          } else {
               bakerst.neste = nyNode;
               nyNode.forrige = bakerst;
          }
          bakerst = nyNode;
          antallElementer += 1;
     }
     
}
