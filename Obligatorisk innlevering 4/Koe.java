class Koe<T> extends Lenkeliste<T> {

     public T hent(){
          // Kø system -->  FIFO. Ifølge vår lenkeliste blir nye elementer 
          // lagt inn bakerst. Det vil si vi må starte med å hente de 
          // som ligger foran i "lista".
          Node forsteMannUt = foran;
          return forsteMannUt.informasjon;
     }

     // Se kommentar fra metoden over. Første element skal nå ut av 
     // "lista" først, ellers så vil ikke FIFO prinsippet fungere
     public T fjern(){
          Node midlertidig = foran;
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
          return midlertidig.informasjon;
     }
     
}
