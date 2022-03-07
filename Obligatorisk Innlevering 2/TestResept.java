class TestResept {

    public static void main(String[] args){

        Vanedannende tablett = new Vanedannende("Benzodiazepiner", 90, 12, 2);
        Narkotisk flaske = new Narkotisk("Amylnitritt", 199, 31.9, 8);
        Vanlig kapsler = new Vanlig("Ibux", 99, 1.9);
        Vanlig piller = new Vanlig("P-Piller", 135, 0.8);


        Lege lege = new Lege("Marius");
        Lege lege2 = new Lege("Ole");

        BlaaResept a = new BlaaResept(tablett, lege, 313, 10);
        HvitResept b = new HvitResept(flaske, lege2, 211, 8);
        MilResept c = new MilResept(kapsler, lege, 4768);
        PResept d = new PResept(piller, lege2, 6352, 15);
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        
    }

}