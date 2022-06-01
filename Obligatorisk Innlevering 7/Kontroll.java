//Ferdig.
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Kontroll extends JPanel implements ActionListener {
    static final int lengde = 800; static final int bredde = 800;
    static final int rute = 35; static final int nett = (lengde * bredde) / (rute * rute);
    static final int slangeFart = 475;

    int skattSpist;
    int slange = 1;
    int skattX; int skattXX; int skattXXX; int skattXXXX; int skattXXXXX;
    int skattY; int skattYY; int skattYYY; int skattYYYY; int skattYYYYY;
    Character retning = 'R'; boolean slangeKjører = false; Timer tidTeller; Random tilfeldig;

    final int xCord[] = new int[nett];
    final int yCord[] = new int[nett];

    //JPanel styreKnapper;
    //JButton knapper;
    
    /*class Knapp implements ActionListener {
        int retning;

        Knapp(int retning) {
            this.retning = retning;
        }

        @Override
        public void actionPerformed (ActionEvent Exception) {
        }
    }*/

    Kontroll() {
        tilfeldig = new Random();
        this.setPreferredSize(new Dimension(lengde, bredde));
        this.setBackground(Color.white);
        this.setFocusable(true);
        //Bruker keylistener fra java bibliteket for å kunne gjøre GUI mer strukturert,
        //Slipper da unødvendige JButtons. 
        this.addKeyListener(new MyKeyAdapter());
        //Starter spillet
        startSpillet();
    }

    //Metode som starter spillet, setter fart på slangen og oppretter skatt.
    public void startSpillet() {
        settInnSkatt();
        slangeKjører = true;
        tidTeller = new Timer(slangeFart, this);
        tidTeller.start();
    }

    //Bruker metodene paintComponent og draw for å sette opp panelet.
    public void paintComponent(Graphics modell) {
        super.paintComponent(modell);
        draw(modell);
    }

    //Modellen som blir satt opp blir slikt. 
    public void draw(Graphics modell) {
        if (slangeKjører) {
            //Alle skatte objektene som blir flyttet på hver gang de blir "Spist" opp. 
            modell.setColor(Color.red);
            modell.fillOval(skattX, skattY, rute, rute);
            modell.fillOval(skattXX,skattYY, rute, rute);
            modell.fillOval(skattXXX,skattYYY, rute, rute);
            modell.fillOval(skattXXXX,skattYYYY, rute, rute);
            modell.fillOval(skattXXXXX,skattYYYYY, rute, rute);

            //Kroppen til slangen.
            for (int i = 0; i < slange; i++) {
                if (i == 0) {
                    modell.setColor(Color.green);
                    modell.fillRect(xCord[i], yCord[i], rute, rute);
                } else {
                    modell.setColor(new Color(50, 180, 0));
                    modell.fillRect(xCord[i], yCord[i], rute, rute);
                }
            }

            //Info teksten som står øverst. 
            modell.setColor(Color.black);
            modell.setFont(new Font("", Font.BOLD, 10));
            FontMetrics y = getFontMetrics(modell.getFont());
            String Info = "--Bruk piltastene for å bevege slangen opp, ned, hoyre eller venstre Skattene beveger seg frivillig. Poeng: " + skattSpist + "--";
            modell.drawString(Info, (lengde - y.stringWidth(Info)) / 2,
                    modell.getFont().getSize());
        } 
        else{
            avluttSpill(modell);
        }
    }

    //Setter opp alle de skatte objektene. 
    public void settInnSkatt() {
        skattX = tilfeldig.nextInt((int) (lengde / rute)) * rute;
        skattY = tilfeldig.nextInt((int) (bredde / rute)) * rute;

        skattXX = tilfeldig.nextInt((int) (bredde / rute)) * rute;
        skattYY = tilfeldig.nextInt((int) (bredde / rute)) * rute;

        skattXXX = tilfeldig.nextInt((int) (bredde / rute)) * rute;
        skattYYY = tilfeldig.nextInt((int) (bredde / rute)) * rute;

        skattXXXX = tilfeldig.nextInt((int) (bredde / rute)) * rute;
        skattYYYY = tilfeldig.nextInt((int) (bredde / rute)) * rute;

        skattXXXXX = tilfeldig.nextInt((int) (bredde / rute)) * rute;
        skattYYYYY = tilfeldig.nextInt((int) (bredde / rute)) * rute;
    }

    //Metode som flytter slangen 
    public void slangeBevegelse() {
        for (int i = slange; i > 0; i--) {
            xCord[i] = xCord[i - 1];
            yCord[i] = yCord[i - 1];
        }

        //Opp, ned, venstre og høyre. 
        switch (retning){
            case 'U':
                yCord[0] -= rute;
                break;
            case 'D':
                yCord[0] += rute;
                break;
            case 'L':
                xCord[0] -= rute;
                break;
            case 'R':
                xCord[0] += rute;
                break;
        }
    }

    //Metode som flytter på skatten dersom den blir spist opp. Velger å flytte alle skattene, 
    //for å gjøre spillet litt bedre. 
    public void sjekkSkatt() {
        if ((xCord[0] == skattX) && (yCord[0] == skattY)) {
            slange++;
            skattSpist++;
            settInnSkatt();
        }
        if ((xCord[0] == skattXX) && (yCord[0] == skattYY)) {
            slange++;
            skattSpist++;
            settInnSkatt();
        }
        if ((xCord[0] == skattXXX) && (yCord[0] == skattYYY)) {
            slange++;
            skattSpist++;
            settInnSkatt();
        }
        if ((xCord[0] == skattXXXX) && (yCord[0] == skattYYYY)) {
            slange++;
            skattSpist++;
            settInnSkatt();
        }
        if ((xCord[0] == skattXXXXX) && (yCord[0] == skattYYYYY)) {
            slange++;
            skattSpist++;
            settInnSkatt();
        }
    }

    //Metode som sjekker om slanger kommer seg bort til kantene og evt avslutter spillet. 
    public void testKant() {
        for (int i = slange; i > 0; i--) {
            if ((xCord[0] == xCord[i]) && (yCord[0] == yCord[i])) {
                slangeKjører = false;
            }
        }
        if (xCord[0] < 0) {
            slangeKjører = false;
        }
        if (xCord[0] > lengde) {
            slangeKjører = false;
        }
        if (yCord[0] < 0) {
            slangeKjører = false;
        }
        if (yCord[0] > bredde) {
            slangeKjører = false;
        }
        if (!slangeKjører) {
            tidTeller.stop();
        }
    }

    //Metode som skriver ut at brukern har tapt, og lar brukeren bli ferdig. 
    public void avluttSpill(Graphics x) {
        x.setColor(Color.red);
        x.setFont(new Font("", Font.BOLD, 25));
        FontMetrics metrics2 = getFontMetrics(x.getFont());
        String tap = "Du tapte :( Prøv igjen ";
        x.drawString(tap, (lengde - metrics2.stringWidth(tap)) / 2, bredde / 2);
    }

    //Sjekker at køen har blitt gjennnført. 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (slangeKjører) {
            slangeBevegelse();
            sjekkSkatt();
            testKant();
        }
        repaint();
    }

    //Metode som vil kunne la bruker ta i bruk piltastene. 
    //Smooth måte å spille spillet på, krever også mindre koding. 
    //Oppgaven lar seg gjøre dette. 
    public class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (retning != 'R') {
                        retning = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (retning != 'L') {
                        retning = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (retning != 'D') {
                        retning = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (retning != 'U') {
                        retning = 'D';
                    }
                    break;
            }
        }
    }
}


