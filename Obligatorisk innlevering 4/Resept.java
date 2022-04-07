//------------------------------------------------START-KLASSE-RESEPTER------------------------------------------------
public abstract class Resept {
  
  protected Legemiddel legemiddel;
  protected Lege lege;
  public static int reseptID;
  protected int idd_teller;
  protected int reit;
  protected Pasient pasient;
    
  public Resept(Legemiddel legemiddel, Lege lege, Pasient pasient, int reit){
    this.legemiddel = legemiddel;
    this.lege = lege;
    this.pasient = pasient;
    this.reit = reit;
    reseptID++;
    idd_teller += reseptID;
    //System.out.println("//Klasse Resept Opprettet.");
  }

  protected abstract String farge();
  protected abstract int prisAaBetale();

  public abstract String toString();

  public int hentID(){
    return idd_teller;
  }

  public Legemiddel hentLegemiddel(){
    return legemiddel;
  }

  public Lege hentLege(){
    return lege;
  }

  public Pasient hentPasient(){
    return pasient;
  }

  public int hentReit(){
    return reit;
  }

  public boolean bruk(){
    if (hentReit() > 0){
      reit--;
      return true;
    } else {
      return false;
    }
  }


  public String hentType(){
          if(this instanceof HviteResepter){
              return "Hvit Resept";
          }else if(this instanceof BlaaResepter ){
              return "Blaa Resept";
          }else if(this instanceof MilResept){
              return "Militær Resept";
          }else{
            return "P Resept";
          }
      }
  }

//------------------------------------------------START-KLASSE-HVITE-RESEPTER------------------------------------------------


class HviteResepter extends Resept{
  
  public HviteResepter(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
    //System.out.println("//Klasse Hvit Resept Opprettet.");
  }

  protected String farge(){
    return "Resepten har hvit farge";
  }

  protected int prisAaBetale(){
    int pris = hentLegemiddel().hentPris();
    return pris;
  }

  @Override 
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris: " + prisAaBetale() + "\n" +
           "Legenavn: " + lege + "\n" +
           "Pasient: " + pasient + "\n" +
           "Re-it: " + reit);
  }
  /*@Override 
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris: " + prisAaBetale() + "\n" +
           "\n" + 
           "Info om legemiddel: " + "\n" + 
           legemiddel + "\n" +
           "\n" +
           "Legenavn: " + lege + "\n" +
           "PasientID: " + pasientID + "\n" +
           "Re-it: " + reit);
  }*/
}


//------------------------------------------------START-KLASSE-MILITÆR-RESEPT------------------------------------------------


class MilResept extends HviteResepter{

  protected static int reit = 3;

  public MilResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient){
    super(legemiddel, utskrivendeLege, pasient, reit);
    //System.out.println("//Klasse Militær Resept Opprettet.");
  }

  protected int prisAaBetale(){
    return 0;
  }

  @Override
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris(100% avslag): " + prisAaBetale() + "\n" +
           "Legenavn: " + lege + "\n" +
           "Pasient: " + pasient + "\n" +
           "Re-it: " + reit);
  }
  /*@Override 
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris: " + prisAaBetale() + "\n" +
           "\n" + 
           "Info om legemiddel: " + "\n" + 
           legemiddel + "\n" +
           "\n" +
           "Legenavn: " + lege + "\n" +
           "PasientID: " + pasientID + "\n" +
           "Re-it: " + reit);
  }*/
}


//------------------------------------------------START-KLASSE-P-RESEPT------------------------------------------------


class pResept extends HviteResepter{

  public pResept(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
    //System.out.println("//Klasse P-Resept Opprettet.");
  }

  protected int prisAaBetale(){
    int sum = (hentLegemiddel().hentPris());
    if (sum - 108 > 0){
      return sum-108;
    } else {
      return 0;
    }
  }

  @Override 
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris(-108kr): " + prisAaBetale() + "\n" +
           "Legenavn: " + lege + "\n" +
           "Pasient: " + pasient + "\n" +
           "Re-it: " + reit);
  }
  /*@Override 
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris: " + prisAaBetale() + "\n" +
           "\n" + 
           "Info om legemiddel: " + "\n" + 
           legemiddel + "\n" +
           "\n" +
           "Legenavn: " + lege + "\n" +
           "PasientID: " + pasientID + "\n" +
           "Re-it: " + reit);
  }*/
}


//------------------------------------------------START-KLASSE-BLÅ-RESEPT------------------------------------------------


class BlaaResepter extends Resept{

  public BlaaResepter(Legemiddel legemiddel, Lege utskrivendeLege, Pasient pasient, int reit){
    super(legemiddel, utskrivendeLege, pasient, reit);
    //System.out.println("//Klasse Blå Resept Opprettet.");
  }

  protected String farge(){
    return "Resepten har blå farge";
  }

  protected int prisAaBetale(){
    int sum = hentLegemiddel().hentPris();
    return ((sum/100)*25);
  }


  @Override 
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris(75% avslag): " + prisAaBetale() + "\n" +
           "Legenavn: " + lege + "\n" +
           "Pasient: " + pasient + "\n" +
           "Re-it: " + reit);
  }
  /*@Override 
  public String toString(){
    return ("ReseptID: " + idd_teller + "\n" +
           "Farge på resept: " + farge() + "\n"  +
           "Pris: " + prisAaBetale() + "\n" +
           "\n" + 
           "Info om legemiddel: " + "\n" + 
           legemiddel + "\n" +
           "\n" +
           "Legenavn: " + lege + "\n" +
           "PasientID: " + pasientID + "\n" +
           "Re-it: " + reit);
  }*/
}


//------------------------------------------------END-OF-CODE------------------------------------------------
