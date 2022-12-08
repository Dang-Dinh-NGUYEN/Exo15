public class Reveil implements Observateur {
    private int heureReveil ;
    private int minuteReveil ;
    private boolean reveil ;
    private SonReveil son ;
    private ModeReveil mode = ReveilEteint.INSTANCE ;

    void setReveil(boolean b){reveil = b;}

    void setSonReveil(SonReveil choix){son = choix;}

    void regleReveil(int h, int m){
        heureReveil = h ;
        minuteReveil = m ;
    }

    ModeReveil getMode(){
        return this.mode;
    }

    void basculeReveil(){
     mode = mode.next(this) ;
    }

    void sonOff(){son.off();}

    void sonOn(){son.on();}

    public void miseAJour(HorlogeReveil h) {
        if ( reveil && h.getHeures () == heureReveil &&
                h.getMinutes () == minuteReveil && h.getSecondes() == 0)
            son.on();
    }
}
