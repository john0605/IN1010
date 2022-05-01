//Ferdig.
class Aapning extends HvitRute {
    public Aapning(int radNummer, int kolonneNummer, Labyrinth lab) {
        super(radNummer, kolonneNummer, lab);
    }

    @Override
    public void finn(Rute fra) {
        nei = true;
        //Aapning dersom det ikke er en starts punkt. 
        if (fra == null) {
            super.finn(fra);
        } 
        else {
            //Mulige aapninger. 
            System.out.println("Aapning:" + radNummer + "," + kolonneNummer + "");
        }
        nei = false;
    }
}