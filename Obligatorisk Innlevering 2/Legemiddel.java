abstract class Legemiddel{                                                  //Setter opp den abstrakte klassen Legemiddel
    
    protected String navn;
    protected double pris;
    protected double virkestoff;
    protected int id;
    protected static int idTeller = 1;

    public Legemiddel(String navn, double pris, double virkestoff){         //Kontruktør og innstansvariablene fra oppgaven
        this.navn = navn;
        this.pris = pris;
        this.virkestoff = virkestoff;

        id = idTeller;
        idTeller++;
    }

    public int hentId(){                                                    //Metode som returnerer id nummeret
        return id;
    }

    public String hentNavn(){                                               //Metode som henter ut navnet
        return navn;
    }

    public double hentPris(){                                               //Metode som henter ut prisen 
        return pris;
    }

    public double hentVirkestoff(){                                         //Metode som henter ut mengde virkestoff
        return virkestoff;
    }

    public void settNyPris(int nyPris){                                     //Metode som setter den nye prisen 
        pris = nyPris;
    }

    @Override                                                               //Overskriver tostring metode som skiver ut all informasjon
    public String toString(){
        return "LEGEMIDDEL INFORMASJON: \nID:" + hentId() + "\nNavn: " + hentNavn() + "\nPris: " + hentPris() + "\nVirkestoff: " + hentVirkestoff();
    }

}