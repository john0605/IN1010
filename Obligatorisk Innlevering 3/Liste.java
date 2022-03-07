public interface Liste <T> {    //Interface oppgitt i oppgaveteksten. 
    int stoerrelse ();
    void leggTil (T x);
    T hent ();
    T fjern ();
}