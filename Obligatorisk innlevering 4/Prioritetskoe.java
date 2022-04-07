class Prioritetskoe<T extends Comparable<T>> extends Lenkeliste<T> {
     
     public void leggTil(T x){
          leggTiliPrioritertRekkefolge(x);
     }

     public void leggTiliPrioritertRekkefolge(T x){
          Node nyNode = new Node(x);
          Node midlertidig = foran;

          if (sjekkerOmDetFinnesElementerForst()){
               foran = nyNode;
               bakerst = nyNode;
               antallElementer += 1;
               return;
          }
          if (midlertidig.informasjon.compareTo(nyNode.informasjon) >= 0){
               nyNode.neste = midlertidig;
               midlertidig.forrige = nyNode;
               foran = nyNode;
               antallElementer += 1;
               return;
          }

          while (midlertidig != null){
               if (midlertidig.neste == null){
                    midlertidig.neste = nyNode;
                    nyNode.forrige = midlertidig;
                    bakerst = nyNode;
                    antallElementer += 1;
                    return;

               } else if (midlertidig.neste.informasjon.compareTo(nyNode.informasjon) > 0){
                    nyNode.forrige = midlertidig;
                    nyNode.neste = midlertidig.neste;
                    midlertidig.neste.forrige = nyNode;
                    midlertidig.neste = nyNode;
                    antallElementer += 1;
                    return;
               } else {
                    midlertidig = midlertidig.neste;
               }
          }
     }

     public T hent(){
          Node n = foran;
          return n.informasjon;
     }

     public T fjern(){
          Node n = foran;
          if (sjekkerOmDetFinnesElementerForst()){
               throw new UgyldigListeindeks(0);
          } else if (foran == bakerst){
               foran = null;
               bakerst = null;
          } else {
               foran = foran.neste;
               foran.forrige = null;
          }
          antallElementer -= 1;
          return n.informasjon;
     }

     public void leggTil(int pos, T x){
          throw new UnsupportedOperationException();
     }

     public void sett(int pos, T x){
          throw new UnsupportedOperationException();
     }



}
