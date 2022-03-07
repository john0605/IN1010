public class Integrasjonstest {                                                     //Hovedprogrammet og testklassen
    public static void main(String[] args){

        Vanedannende tablett = new Vanedannende("Benzodiazepiner", 90, 12, 2);      //Lager en instans av alle variablene og tester dem mot slutten
        Narkotisk flaske = new Narkotisk("Amylnitritt", 199, 31.9, 8);
        Vanlig kapsler = new Vanlig("Ibux", 99, 1.9);
        Vanlig piller = new Vanlig("P-Piller", 135, 0.8);

        Lege lege = new Lege("Marius");
        Spesialist spesialist = new Spesialist("Tharani", "4593");

        BlaaResept blaa = new BlaaResept(tablett, lege, 313, 10);
        HvitResept hvit = new HvitResept(flaske, spesialist, 211, 8);
        MilResept militær = new MilResept(kapsler, lege, 4768);
        PResept prevensjon = new PResept(piller, spesialist, 6352, 15);

        System.out.println(lege.toString() + "\n" + spesialist.toString());         //Skriver ut all informasjon om lege, resept og legemiddel
        
        System.out.println(blaa.toString() + "\n" +hvit.toString() + "\n" +  militær.toString() + "\n" + prevensjon.toString());

        System.out.println(tablett.toString()+ "\n" +flaske.toString() + "\n" + kapsler.toString() + "\n" + piller.toString());
    }

}
