class TestLegemiddel {
    public static void main(String[]args){
        Narkotisk n = new Narkotisk("Narkotika", 99.0, 5, 1);
        Vanedannende v = new Vanedannende("Vane", 199.0, 2.9, 5);
        Vanlig van = new Vanlig("Van", 30, 9.2);

        System.out.println("\nFORVENTET NARKOTISK: \nID: 1 \nNavn: Narkotika \nPris: 99 \nVirkestoff: 5 \nStyrke: 1");
        System.out.println("\nTEST: \nID:" + n.hentId() + "\nNavn: " + n.hentNavn() + "\nPris: " + n.hentPris() + "\nVirkestoff: " + n.hentVirkestoff() + "\nStyrke: " + n.hentNarkotiskStyrke());
        
        System.out.println("\n\nFORVENTET VANEDANNENDE: \nID: 2 \nNavn: Vane \nPris: 199 \nVirkestoff: 2.9 \nStyrke: 5");
        System.out.println("\nTEST: \nID:" + v.hentId() + "\nNavn: " + v.hentNavn() + "\nPris: " + v.hentPris() + "\nVirkestoff: " + v.hentVirkestoff() + "\nStyrke: " + v.hentVanedannendeStyrke());

        System.out.println("\n\nFORVENTET VANLIG: \nID: 3 \nNavn: Van \nPris: 30 \nVirkestoff: 9.2");
        System.out.println("\nTEST: \nID:" + van.hentId() + "\nNavn: " + van.hentNavn() + "\nPris: " + van.hentPris() + "\nVirkestoff: " + van.hentVirkestoff());
    }

    public static boolean testLegemiddelId(Legemiddel legemiddel, int forventetLegemiddelId){
        return legemiddel.hentId() == forventetLegemiddelId;
    }

    public static boolean testLegemiddelNavn(Legemiddel legemiddel, String forventetLegemiddelNavn){
        return legemiddel.hentNavn() == forventetLegemiddelNavn;
    }

    public static boolean testLegemiddelPris(Legemiddel legemiddel, int forventetLegemiddelPris){
        return legemiddel.hentPris() != forventetLegemiddelPris;
    }

    public static boolean testLegemiddelVirkestoff(Legemiddel legemiddel, double forventetLegemiddelVirkestoff){
        return legemiddel.hentVirkestoff() == forventetLegemiddelVirkestoff;
    }

    public static boolean testNarkotiskStyrke(Narkotisk legemiddel, int forventetStyrke) {
        return legemiddel.hentNarkotiskStyrke() == forventetStyrke;
    }

    public static boolean testVanedannendeStyrke(Vanedannende legemiddel, int forventetStyrke) {
        return legemiddel.hentVanedannendeStyrke() == forventetStyrke;
    }
    
}
