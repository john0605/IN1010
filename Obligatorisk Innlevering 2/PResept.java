class PResept extends HvitResept{                                                           //Sub klasse av parent klassen HvitResept

    final private static int rabatt = 108;

    public PResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId, int reit){   //Konstruktør
        super(legemiddel, utskrivendeLege, pasientId, reit);
    }

    @Override                                                                               //Henter ut prisen av varen
    public double prisAaBetale(){                                                           //Setter variabelen rabatt lik 108 for så trekke det fra prisen
        if (legemiddel.hentPris() >= rabatt){                                               //dersom den er lik 108 eller større hvis ikke returnere 0
            return legemiddel.hentPris() - rabatt; 
        }
        else{
            return 0;
        }
    }

    @Override                                                                               //ToSting metode som skriver ut all informasjon
    public String toString() {
        return  super.toString();
    }

}
