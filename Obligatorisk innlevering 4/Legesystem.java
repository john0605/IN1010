import java.util.*;
import java.io.*;

public class Legesystem {

     // Listene måtte gjøres static ellers vil vi ikke kunne hente objekter fra E() metodene
     static IndeksertListe<Lege> listeAvLeger; 
     static IndeksertListe<Legemiddel> listeAvLegemidler; 
     static IndeksertListe<Pasient> listeAvPasienter; 
     static IndeksertListe<Resept> utskrevneResepter; 

     public Legesystem(){
         listeAvLeger = new IndeksertListe<Lege>();
         listeAvLegemidler = new IndeksertListe<Legemiddel>();
         listeAvPasienter = new IndeksertListe<Pasient>();
         utskrevneResepter = new IndeksertListe<Resept>();
     }

     public static void main (String[] args){
          E2();
     }

     // Dette er E1, altså lese info fra fil. Må kopiere data fra Legessystem.java til Legesystem2.java
     public static void E1(String filnavn){
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
                          listeAvLegemidler.leggTil(newNarkotisk);
                       }
         
                       if(biter1[1].equals("vanedannende")){
                         Vanedannende newVanedannende = new Vanedannende(biter1[0],Integer.parseInt(biter1[2]),Double.parseDouble(biter1[3]),Integer.parseInt(biter1[4]));                          listeAvLegemidler.leggTil(newVanedannende);
                       }
         
                       if(biter1[1].equals("vanlig")){
                         VanligLegemiddel newVanligLegemiddel = new VanligLegemiddel( biter1[0],Integer.parseInt(biter1[2]),Double.parseDouble(biter1[3]));
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
                   String legeNavn = biter1[1];
                   int pasientId = Integer.parseInt(biter1[2]);
                   String type = biter1[3];
                   int reit = Integer.parseInt(biter1[4]);
         
                   
                   for(Lege legen : listeAvLeger ){
                     try{
                     if(legen.hentNavn().equals(legeNavn)){
                       
                       if(type.equals("hvit")){
                         
                         legen.skrivHvitResept(listeAvLegemidler.hent(legemiddelNummer),listeAvPasienter.hent(pasientId),reit);
                       }
                       if(type.equals("blaa")){
                         legen.skrivBlaaResept(listeAvLegemidler.hent(legemiddelNummer),listeAvPasienter.hent(pasientId), reit);
                       }
                       if(type.equals("militaer")){
                         legen.skrivMilResept( listeAvLegemidler.hent(legemiddelNummer),listeAvPasienter.hent(pasientId));
                       }
                       if(type.equals("p")){
                         legen.skrivpResept( listeAvLegemidler.hent(legemiddelNummer),listeAvPasienter.hent(pasientId),reit);
                       }
                     }
         
                   }catch(UlovligUtskrift l){
                     System.out.println("Noe feil");
                   }
                 }}}}
         
           myReader.close();
         } catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
           }  
           }

     public static void E2(){
          Scanner sc = new Scanner(System.in);
          int tall = 0;

          // Grunnen til at disse 2 linjene er utafor, er for at samme hilsen ikke skal
          // repeteres hver gang løkken kjører. Holder med å si "hei" en gang.
          System.out.println("Hei og velkommen skal du være til vårt legesystem!");
          System.out.println("Du får nå 5 valg. Tast inn: 1/2/3/4/5:");

          while (tall != -1){
               System.out.println("1: Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter");
               System.out.println("2: Opprette og legge til nye elementer i systemet");
               System.out.println("3: Bruke en gitt resept fra listen til en pasient (reit -1)");
               System.out.println("4: Skrive ut forskjellige former for statistikk");
               System.out.println("5: Skrive all data til en ny fil");
               System.out.println("-1: Avslutte program");
               // Dette repeteres på nytt etter å ha skrevet 1 2 3 4 5 etc..
               System.out.println();
               // Skriv inn inputten din her.
               tall = sc.nextInt();

               switch(tall){
                    case 1:
                         E3();
                         break;
                         // 1: Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter 
     
                    case 2:
                         E4();
                         break;
                         // 2: Opprette og legge til nye elementer i systemet
     
                    case 3:
                         E5();
                         break;
                         // 3: Bruke en gitt resept fra listen til en pasient (reit -1)
     
                    case 4:
                         E6();
                         break;
                         // 4: Skrive ut forskjellige former for statistikk
     
                    case 5:
                         E7();
                         break;
                         // 5: Skrive all data til en ny fil

                    case -1:
                         System.out.println("Hadebra, på gjensyn!");
                         break;
               }
          }
     } // E2() metoden avsluttes

     public static void E3(){
          System.out.println("Du valgte 1 - skrive ut fullstendig oversikt.");
          System.out.println("Leger:");

          // Printer ut om alle leger
          if (listeAvLeger.sjekkerOmDetFinnesElementerForst()){
               // Sjekker om den er tom først
               System.out.println("FINNES INGEN LEGER!!!");
          } else {
               for (Lege l : listeAvLeger){
                    System.out.println(l.toString());
                    System.out.println("Reseptlisten til samme legen:");
                    // Sjekker om den er tom først
                    if (l.hentReseptListeTilLegen().sjekkerOmDetFinnesElementerForst()){
                         System.out.println("TOMxxxx");
                    } else{
                         for (Resept r : l.hentReseptListeTilLegen()){
                              System.out.println(r.toString());
                         }
                    }
                    // Mellomrom mellom hver Lege printings
                    System.out.println();
               }
          }

          // PRINTER UT ALLE PASIENTER
          System.out.println("Pasienter");
          // Sjekker om den er tom først
          if (listeAvPasienter.sjekkerOmDetFinnesElementerForst()){
               System.out.println("FINNES INGEN PAASIENTER....");

               for (Pasient p : listeAvPasienter){
                    System.out.println(p.toString());
                    System.out.println("Pasientens reseptliste:");
                    // Sjekker om den er tom først
                    if (p.hentReseptListeTilPasienten().sjekkerOmDetFinnesElementerForst()){
                         System.out.println("TOMxxxx");
                    } else {
                         for (Resept r : p.hentReseptListeTilPasienten()){
                              System.out.println(r.toString());
                         }
                    }
                    // Mellomrom mellom hver pasient printings
                    System.out.println();
               }
          }

          // PRINTER UT ALLE LEGEMIDLER
          System.out.println("Legemidler");
          if (listeAvLegemidler.sjekkerOmDetFinnesElementerForst()){
               System.out.println("FINNES INGEN LEDGEMIDLER");
          } else {
               for (Legemiddel lm : listeAvLegemidler){
                    System.out.println(lm.toString());
               }
               // Mellomrom mellom hver legemiddel printings
               System.out.println();
          }
     } // E3() metoden avsluttes


     public static void E4(){
          System.out.println("Du valgte 2 - opprette og legge til nye elementer i systemet");
          System.out.println("Start med å velge hvilket objekt du vil opprette først:");
          System.out.println("1 = Legemiddel");
          System.out.println("2 = Pasient");
          System.out.println("3 = Resept");
          System.out.println("4 = Lege");
          Scanner sc = new Scanner(System.in);
          int tall = 0;
          tall = sc.nextInt();
          sc.close();

          // OPPRETT NYTT LEGE/SPESIALIST
          if (tall == 1){
               Scanner scanner = new Scanner(System.in);
               System.out.println("Legen sitt navn er:");
               String navnPaaLege = scanner.nextLine();
               System.out.println("Spesifiser dypere.");
               System.out.println("Tast 0 for lege, eller tast 1 for spesialist:");

               int spesifiser = scanner.nextInt();

               if (spesifiser == 0){
                    Lege nyLege = new Lege(navnPaaLege);
                    listeAvLeger.leggTil(nyLege);

               } else if (spesifiser == 1){
                    System.out.println("Legen sin kontrollID er:");
                    String kontrollID = scanner.nextLine();
                    Spesialist nySpesialist = new Spesialist(navnPaaLege, kontrollID);
                    listeAvLeger.leggTil(nySpesialist);

               } else {
                    System.out.println("Tast inn enten 0 eller 1!");
               }
          }

          // OPPRETT NY PASIENT
          if (tall == 2){
               Scanner scanner = new Scanner(System.in);
               System.out.println("Pasienten sitt navn er:");
               String navnPaaPasient = scanner.nextLine();
               System.out.println("Pasienten sin fødselsnummer er:");
               String fodselsnummer = scanner.nextLine();
               Pasient ny = new Pasient(navnPaaPasient, fodselsnummer);
               listeAvPasienter.leggTil(ny);
          }

          // OPPRETT NY RESEPT
          if (tall == 3){
               Scanner scanner = new Scanner(System.in);

               // Må sjekke om det finnes pasienter til å begynne med
               // Respeter kan kun opprettes om det finnes pasienter til å begynne med!
               if (listeAvPasienter.sjekkerOmDetFinnesElementerForst()){
                    System.out.println("Det finnes ingen pasienter, dermed kan ikke en ny resept opprettes.");
                    System.out.println("Start med å opprette en ny pasient først.");
                    // Løkken avsluttes her
                    return;
               }
               System.out.println("Start med å velge hvilken pasient:");
               for (Pasient p : listeAvPasienter){
                    System.out.println(p.hentID() + ": " + p.hentNavn() + " " + p.hentFodselsnummer());
               }
               Pasient dennePasienten = null;
               int pasientID = scanner.nextInt();
               scanner.nextLine();
               
               for (Pasient p : listeAvPasienter){
                    if (p.hentID() == pasientID){
                         dennePasienten = p;
                    } else {
                         System.out.println("Beklager men du skrev noe feil. Denne pasienten finnes ikke");
                    }
               }

               if (listeAvLeger.sjekkerOmDetFinnesElementerForst()){
                    System.out.println("Det finnes ingen leger. Start med å opprette en ny lege først");
               }
               System.out.println("Denne legen skal utskrive resepten til meg:");
               for (Lege l : listeAvLeger){
                    System.out.println(l.hentNavn());
               }
               Lege denneLegen = null;
               String navnPaaLege = scanner.nextLine();

               for (Lege l : listeAvLeger){
                    if (l.hentNavn().equals(navnPaaLege)){
                         denneLegen = l;
                    } else {
                         System.out.println("Legen finnes ikke, skriv på nytt");
                    }
               }

               if (listeAvLegemidler.sjekkerOmDetFinnesElementerForst()){
                    System.out.println("Finnes ingen legemidler, start med å opprette legemidler først.");
               }
               System.out.println("Hvilket legemiddel fra listen vil du bruke?");
               for (Legemiddel l : listeAvLegemidler){
                    System.out.println(l.hentNavn());
               }

               Legemiddel denneLegemiddel = null;
               String navnPaaLegemiddel = scanner.nextLine();
               for (Legemiddel l : listeAvLegemidler){
                    if (l.hentNavn().equals(navnPaaLegemiddel)){
                         denneLegemiddel = l;
                    } else {
                         System.out.println("Legemiddelet du skrev inn finnes ikke.");
                    }
               }

               System.out.println("Velg antall reit:");
               int reit = scanner.nextInt();
               scanner.nextLine();
               System.out.println("Nå skal du velge type resept");
               System.out.println("Tast inn følgende tall for type:");
               System.out.println("1 - Militær, 2 - P, 3 - Blå");
               int type = scanner.nextInt();

               if (type == 1){
                    MilResept nyMR = new MilResept(denneLegemiddel, denneLegen, dennePasienten);
                    utskrevneResepter.leggTil(nyMR);
                    dennePasienten.leggTil(nyMR);
                    denneLegen.leggTil(nyMR);
               }

               if (type == 2){
                    pResept nyPR = new pResept(denneLegemiddel, denneLegen, dennePasienten, reit);
                    utskrevneResepter.leggTil(nyPR);
                    dennePasienten.leggTil(nyPR);
                    denneLegen.leggTil(nyPR);
               }

               if (type == 3){
                    BlaaResepter nyBL = new BlaaResepter(denneLegemiddel, denneLegen, dennePasienten, reit);
                    utskrevneResepter.leggTil(nyBL);
                    dennePasienten.leggTil(nyBL);
                    denneLegen.leggTil(nyBL);
               }
          }

          // OPPRETT NY LEGEMIDDEL
          if (tall == 4){
               Scanner scanner = new Scanner(System.in);
               System.out.println("Tast en av følgende tall for legemiddeltype:");
               System.out.println("1 - Narkotisk, 2 - Vanedannende, 3 - Vanlig legemiddel");
               int type = scanner.nextInt();

               if (type == 1){
                    System.out.println("Du valgte type: narkotisk");
                    System.out.println("Navn på legemiddel:");
                    String navn = scanner.nextLine();

                    System.out.println("Pris på legemiddel:");
                    int pris = scanner.nextInt();

                    System.out.println("Virkestoff på legemiddel:");
                    double virkestoff = scanner.nextDouble();

                    System.out.println("Legemiddel styrke:");
                    int styrke = scanner.nextInt();

                    Narkotisk nyNarkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
                    listeAvLegemidler.leggTil(nyNarkotisk);
               }

               if (type == 2){
                    System.out.println("Du valgte type: vanedannende");
                    System.out.println("Navn på legemiddel:");
                    String navn = scanner.nextLine();

                    System.out.println("Pris på legemiddel:");
                    int pris = scanner.nextInt();

                    System.out.println("Virkestoff på legemiddel:");
                    double virkestoff = scanner.nextDouble();

                    System.out.println("Legemiddel styrke:");
                    int styrke = scanner.nextInt();

                    Vanedannende nyVanedannende = new Vanedannende(navn, pris, virkestoff, styrke);
                    listeAvLegemidler.leggTil(nyVanedannende);
               }

               if (type == 3){
                    System.out.println("Du valgte type: vanlig");
                    System.out.println("Navn på legemiddel:");
                    String navn = scanner.nextLine();

                    System.out.println("Pris på legemiddel:");
                    int pris = scanner.nextInt();

                    System.out.println("Virkestoff på legemiddel:");
                    double virkestoff = scanner.nextDouble();

                    VanligLegemiddel nyVanlig = new VanligLegemiddel(navn, pris, virkestoff);
                    listeAvLegemidler.leggTil(nyVanlig);               
               }
          }    
     } // E4() metoden avsluttes

     public static void E5(){
          Scanner scanner = new Scanner(System.in);

          if (listeAvPasienter.sjekkerOmDetFinnesElementerForst()){
               System.out.println("Ingen pasienter finnes.");
          } else {
               for (Pasient p : listeAvPasienter){
                    System.out.println(p.hentID() + ": " + p.hentNavn() + " " + ("fnr " + p.hentFodselsnummer()));
               }
               System.out.println("Velg en pasient(id) du vil hente resepten til.");
               int pasientID = scanner.nextInt();
               scanner.nextLine();

               Pasient dennePasienten = null;
               for (Pasient p : listeAvPasienter){
                    if (p.hentID() == pasientID){
                         dennePasienten = p;
                         for (Resept r : dennePasienten.hentReseptListeTilPasienten()){
                              System.out.println(r);
                         }
                    }
               }
               // Hvis pasienten har en resept:
               if (dennePasienten != null || !dennePasienten.hentReseptListeTilPasienten().sjekkerOmDetFinnesElementerForst()){
                    System.out.println("Skriv inn reseptens ID:");
                    int reseptID = scanner.nextInt();
                    scanner.nextLine();

                    for (Resept r : dennePasienten.hentReseptListeTilPasienten()){
                         // Sjekker om resepten har flere reit
                         if (r.hentID() == reseptID){
                              if (r.hentReit() > 0){
                                   // reit -1
                                   r.bruk();
                                   System.out.println("Du har " + r.hentReit() + " antall reit igjen.");
                              } else {
                                   System.out.println("Du har ikke flere reit igjen");
                              }
                         } else {
                              System.out.println("Respten du tastet inn finnes dessverre ikke i lista");
                         }
                    }
               } else {
                    System.out.println("Pasienten du tasten inn finnes dessverre ikke i lista");
               }
          }
     } // E5() metoden avsluttes 


     public static void E6(){
          if (utskrevneResepter.sjekkerOmDetFinnesElementerForst()){
               System.out.println("Det finnes ingen resepter desverre.");
          }

          // øker med hver gang (+1) for hver iterasjon av løkka
          int totalNarkotiskLegemiddel = 0;
          int totalVanedannendeLegemiddel = 0;
          int totalVanligLegemiddel = 0;

          // NARKOTISK
          for (Resept r : utskrevneResepter){
               if (r.hentLegemiddel() instanceof Narkotisk){
                    totalNarkotiskLegemiddel += 1;
               }
          }
          if (totalNarkotiskLegemiddel == 0){
               System.out.println("Det er ingen narkotiske resepter");
          } else {
               System.out.println("Det fantes " + totalNarkotiskLegemiddel + " narkotiske resepter");
          }

          // VANEDANNENDE
          for (Resept r : utskrevneResepter){
               if (r.hentLegemiddel() instanceof Vanedannende){
                    totalVanedannendeLegemiddel += 1;
               }
          }
          if (totalVanedannendeLegemiddel == 0){
               System.out.println("Det er ingen vanedannende resepter");
          } else {
               System.out.println("Det fantes " + totalVanedannendeLegemiddel + " vanedannende resepter");
          }

          for (Resept r : utskrevneResepter){
               if (r.hentLegemiddel() instanceof VanligLegemiddel){
                    totalVanligLegemiddel += 1;
               }
          }
          if (totalVanligLegemiddel == 0){
               System.out.println("Det er ingen vanlige resepter");
          } else {
               System.out.println("Det fantes " + totalVanligLegemiddel + " vanlige resepter");
          }

//STAT DELEN

          for(Lege n : listeAvLeger){
               int count = 0;

               if(!(n instanceof Spesialist)){
                    continue;
                    //Hvis legen ikke er spesialist så bryr vi oss ikke
               }

               for(Resept k : n.utskrevneResepter()){
                    if(k.hentLegemiddel() instanceof Narkotisk){
                         count++;
                    }}

               if(count != 0 ){
                   System.out.println(n.hentNavn() + " antall resepter: "+ count);
               }


          }




     } // E6() metoden avsluttes 

     public static void E7(){
          try{
               //We get the file
               String navn = "fNav.txt";
               File minFil = new File(navn);
               

               //Create a new file if minFil does not exists
               if( minFil.createNewFile() ){
               FileWriter myW = new FileWriter(navn);
                    System.out.println("Vi har laget en ny fil med navn: " + minFil.getName() );    

               myW.write("Pasient informasjon (navn, fnr) ");
               for(Pasient n : listeAvPasienter){
                    myW.write(n.hentNavn() + "," + n.hentFodselsnummer());
               }
               

               myW.write("Legemidler informasjon (navn,type,pris,virkestoff,evt.styrke)");
               for(Legemiddel n : listeAvLegemidler){
                    myW.write(n.hentNavn() + "," + n.henttype() + "," + n.hentPris() + 
                    "," + n.hentVirkestoff() + "," + n.hentStyrke());
               }

          
               
               myW.write("Lege informasjon (navn,kontrollID,(1 hvis spessialist, 0 hvis ikke))");
              for (Lege n : listeAvLeger){
               if (n instanceof Spesialist){

                      Spesialist k = (Spesialist) n;
                      myW.write(k.hentNavn() + "," +k.hentKontrollID());

                }else{
                      myW.write(n.hentNavn() + ", 0");}}

               
               myW.write("Resept informasjon (legemiddelnummer,legenavn,pasientId,type,evt.reit)");

               for (Resept n : utskrevneResepter){
                    Legemiddel legemiddel = n.hentLegemiddel();
                    int legemiddelID = legemiddel.hentID();
                    Lege lege = n.hentLege();
                    String legenavn = lege.hentNavn();
                    Pasient pasient = n.hentPasient();
                    int pasID = pasient.hentID();
                    String type = n.hentType();

                    if(type.equals("MilResept")){
                    
                    myW.write(legemiddelID+","+legenavn+","+pasID+","+type);

                    }else{
                         int reit = n.hentReit();
                         myW.write(legemiddelID+","+lege+","+pasID+","+type+","+reit);

                    }
               }
               myW.close();
          }else{
               System.out.println("Du har en fil med navn: "+ navn);
          }
          }catch(IOException e){
               System.out.println("Error");
               e.printStackTrace();       }
     }

}
