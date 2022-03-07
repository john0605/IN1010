class MilResept extends HvitResept {                                                //Sub klasse av parent klassen HvitResept

    final private static int gratisLegemiddel = 0;

    public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, int pasientId){   //Konstruktør
        super(legemiddel, utskrivendeLege, pasientId, 3);
    }
    
    @Override                                                                       //Ettersom legemiddel for verneplikte er gratis så returnerer metoden 0
    public double prisAaBetale(){
        return gratisLegemiddel;
    }

    @Override                                                                       //Metode som returnerer all informasjon
    public String toString() {
        return super.toString();
    }

}
