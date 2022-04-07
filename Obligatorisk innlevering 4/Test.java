/*
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class Test{


  private IndeksertListe<Pasient> listeAvPasienter;
  private IndeksertListe<Legemiddel> listeAvLegemidler;
  private IndeksertListe<Lege> listeAvLeger;

  public Test(){

    listeAvPasienter = new IndeksertListe<Pasient>();
    listeAvLegemidler = new IndeksertListe<Legemiddel>();
    listeAvLeger = new IndeksertListe<Lege>();

  }

  //sett koden i main her inne
  public void LesFil(String filnavn){

     try {
            
          //storing the file with name myFile
        File myFile = new File(filnavn);
    
          //Scanning the file and storing it in myReader
        Scanner myReader = new Scanner(myFile);
    
        String objektet = "null";
          //My reader will now read
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          
          
    
          
          if(data.contains("#")){
         
            
            String[] biter = data.split(" ");
             objektet = biter[1];
             
    
             
          }else{
    
            String[] biter1 = data.split(",");
    
            //Hvis det skal bli pasient objekter
            if(objektet.equals("Pasienter")){
              Pasient newPasient = new Pasient(biter1[0],biter1[1]);
              //rød strek?
              listeAvPasienter.leggTil(newPasient);
              
              
             }
    
             //Hvis det skal bli legemiddel objekter
            if(objektet.equals("Legemidler")) {
    
                  if(biter1[1].equals("narkotisk")){
                    Narkotisk newNarkotisk = new Narkotisk(biter1[0],Integer.parseInt(biter1[2]),Double.parseDouble(biter1[3]),Integer.parseInt(biter1[4]));
                     //rød strek?
                     listeAvLegemidler.leggTil(newNarkotisk);
                  }
    
                  if(biter1[1].equals("vanedannende")){
                    Vanedannende newVanedannende = new Vanedannende(biter1[0],Integer.parseInt(biter1[2]),Double.parseDouble(biter1[3]),Integer.parseInt(biter1[4]));
                     //rød strek?
                     listeAvLegemidler.leggTil(newVanedannende);
                  }
    
                  if(biter1[1].equals("vanlig")){
                    VanligLegemiddel newVanligLegemiddel = new VanligLegemiddel( biter1[0],Integer.parseInt(biter1[2]),Double.parseDouble(biter1[3]));
                     //rød strek?
                     listeAvLegemidler.leggTil(newVanligLegemiddel);
                  }
            }
              //Hvis det skal bli lege objekter
            if(objektet.equals("Leger")) {
                //Skjønner ikke hvordan dr.cox kommer gjennom 
                //if kondisjonen når biter1[1] er 0
                if(!biter1[1].equals("0")){
                  Spesialist nySpesialist = new Spesialist(biter1[0],biter1[1]);
                   //rød strek?
                  listeAvLeger.leggTil(nySpesialist);
                }else{
                Lege nyLege = new Lege(biter1[0]);
                 //rød strek?
                listeAvLeger.leggTil(nyLege);
                }
              
    
             //Hvis det skal bli resept objekter
            }
            if(objektet.equals("Resepter")) {
    
              int legemiddelNummer = Integer.parseInt(biter1[0]);
              int legeNavn= biter1[1];
              int pasientId = Integer.parseInt(biter1[2]);
              String type = biter1[3];
              int reit = Integer.parseInt(biter1[4]);
    
              
              for(Lege legen : listeAvLeger ){
                try{
                if(legen.equals(legeNavn)){
                  
                  if(type.equals("hvit")){
                    
                    legen.skrivHvitResept(listeAvLeger.hent(legemiddelNummer),listeAvPasienter.hent(pasientId),reit);
                  }
                  if(type.equals("blaa")){
                    legen.skrivBlaaResept(listeAvLeger.hent(legemiddelNummer),listeAvPasienter.hent(pasientId), reit);
                  }
                  if(type.equals("militaer")){
                    legen.skrivMilResept( listeAvLeger.hent(legemiddelNummer),listeAvPasienter.hent(pasientId));
                  }
                  if(type.equals("p")){
                    legen.skrivpResept( listeAvLeger.hent(legemiddelNummer),listeAvPasienter.hent(pasientId),reit);
                  }
    
    
                }
    
              }catch(UlovligUtskrift l){
                System.out.println("Noe feil");
              }
            }
    
            }
         
             
    
        }
        
      }
    
      myReader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    
    
        
      }

    public static void main(String[] args) {

     */