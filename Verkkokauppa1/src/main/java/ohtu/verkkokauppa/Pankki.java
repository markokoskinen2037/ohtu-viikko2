package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements PankkiIO,KirjanpitoIO {

    private Kirjanpito kirjanpito;

    @Autowired
    public Pankki(Kirjanpito kirjanpito) {
        this.kirjanpito = kirjanpito;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }

    @Override
    public ArrayList<String> getTapahtumat() {
        return kirjanpito.getTapahtumat();
    }

    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        kirjanpito.lisaaTapahtuma(tapahtuma);
    }
}
