class IndeksertListe<T> extends Lenkeliste<T> {

     public void leggTil (int pos, T x) {
          Node midlertidig = new Node(x);

          if (pos < 0 || pos > antallElementer){
               // Kaster unntak fordi forespurt index ikke er gyldig. 
               // Enten mindre enn 0, eller høyere enn antall elementer i "lista"
               throw new UgyldigListeindeks(pos);
               // Index 0
          } else if (pos == 0){
               leggTilStart(x);
          } else if (pos == antallElementer){
               leggTil(x);
          } else {
               Node n = foran;

               for (int i = 0; i < pos; i++){
                    n = n.neste;
               }

               Node y = n.forrige;
               y.neste = midlertidig;
               midlertidig.forrige = y;
               midlertidig.neste = n;
               n.forrige = midlertidig;
               antallElementer++;
          }
     }  

     // Hjelpemtode for å putte inn elementer foran i "lista"
     public void leggTilStart(T x){
          Node nyNode = new Node(x);

          if (sjekkerOmDetFinnesElementerForst()){
               bakerst = nyNode;
          } else {
               foran.forrige = nyNode;
          }
          nyNode.neste = foran;
          foran = nyNode;
          antallElementer++;
     }

     public void sett (int pos, T x) {
          Node midlertidig = getNode(pos);
          midlertidig.informasjon = x;
     }
     
     // Hjelpemetode for å hente hente en spesifikk Node - hører til sett(int, T) og hent(int)
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
     
     // Henter forespurt element fra "lista", men den slettes ikke.
     public T hent (int pos) {
          Node nodeSomSkalHentes = getNode(pos);
          return nodeSomSkalHentes.informasjon;
     }

     public T fjern (int pos) {
          Node midlertidig = foran;

          if (pos < 0 || pos >= antallElementer || sjekkerOmDetFinnesElementerForst()){
               throw new UgyldigListeindeks(pos);
          } else if (pos == 0){
               foran = foran.neste;
               if (foran != null){
                    foran.forrige = null;
               }
               antallElementer -= 1;
          } else if (pos == antallElementer -1){
               midlertidig = bakerst;
               bakerst = bakerst.forrige;
               bakerst.neste = null;
               antallElementer -= 1;
          } else {
               for (int i = 0; i < pos; i++){
                    midlertidig = midlertidig.neste;
               }

               Node y = midlertidig.forrige;
               Node etter = midlertidig.neste;
               y.neste = midlertidig.neste;
               etter.forrige = y;
          }
          return midlertidig.informasjon;
     }

     // Denne metoden må endres på. IKKE LIK FRA LENKELISTE<T>
     // Denne metoden fungerer for testfila
     public T fjern(){
          Node midlertidig = foran;

          if (sjekkerOmDetFinnesElementerForst()){
               throw new UgyldigListeindeks(0);
          }
          foran = foran.neste;
          if (foran != null){
               foran.forrige = null;
          }
          antallElementer -= 1;
          return midlertidig.informasjon;
     }
     
}
