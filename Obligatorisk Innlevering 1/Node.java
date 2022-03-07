class Node {
    private int minne;                                  //Deklarerer variablene
    private int prosessor;

    public Node(int nyProsessor, int nyMinne){          //Konstruktør som setter opp en node
        this.minne = nyMinne;
        this.prosessor = nyProsessor;
    }

    public int antProsessor(){                          //Returnerer antall prosessorer
        return prosessor;
    }

    public boolean nokMinne(int paakrevdMinne) {        //Ser om det er nok minne og returnerer boolean verdi
        if (minne >= paakrevdMinne){
            return true;
        }
        return false;
    }

    public int minne(){                                 //Returnerer minne vi har fra før av
        return minne;
    }
}