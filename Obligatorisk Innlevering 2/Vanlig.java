class Vanlig extends Legemiddel{                                    //Subklasse av parent klasse Legemiddel

    public Vanlig(String navn, double pris, double virkestoff){     //Konstruktør
        super(navn, pris, virkestoff);
    }
    
    @Override                                                       //Overskriver parent toString metoden sammen med den nye metoden
    public String toString(){
        return "\n" + super.toString();
    }

}
