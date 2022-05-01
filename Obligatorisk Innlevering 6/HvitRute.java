//Ferdig. 
class HvitRute extends Rute {
    protected boolean nei = false;

    public HvitRute(int radNummer, int kolonneNummer, Labyrinth lab) {
        super(radNummer, kolonneNummer, lab);
    }

    //Metode som sjekker om nabo rute har vært innom. 
    public void finn(Rute fra) {
        nei = true;
        if (nord != null) {
            if (!nord.nei) {
                nord.finn(this);
            }
        }

        if (syd != null) {
            if (!syd.nei) {
                syd.finn(this);
            }
        }

        if (oest != null) {
            if (!oest.nei) {
                oest.finn(this);
            }
        }

        if (vest != null) {
            if (!vest.nei) {
                vest.finn(this);
                ;
            }
        }
        nei = false;
    }

    @Override
    public String toString() {
        return ".";
    }
}