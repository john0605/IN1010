//Ferdig.
class SvartRute extends Rute {
    public SvartRute(int radNummer, int kolonneNummer, Labyrinth lab) {
        super(radNummer, kolonneNummer, lab);
    }

    //Metoden vil ikke la oss starte fra svart rute.
    @Override
    public void finn(Rute fra) {
        if (fra == null) {
            System.out.println("Svart rute, prov paa nytt. ");
        }
    }

    //Symbolet til svart rute, toString metoden. 
    @Override
    public String toString() {
        return "#";
    }
}