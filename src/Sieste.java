public class Sieste implements Observateur {
    private int heureFinSieste;
    private int minuteFinSieste;

    private HorlogeReveil h;
    private boolean sieste ;

    public Sieste(HorlogeReveil h) {
        this.h = h;
        h.ajouteObservateur(this);
    }

    void setSieste(boolean b){sieste = b;}


    public void sleep(int m) {
        sieste = true;
        minuteFinSieste = (h.getMinutes() + m) % 60;
        heureFinSieste = (h.getHeures() + m / 60) % 24;
    }

    public void snooze() {
        h.getReveil().sonOff();
        sleep(9);
    }

    @Override
    public void miseAJour(HorlogeReveil h) {
        if (sieste && h.getHeures() == heureFinSieste && h.getMinutes() == minuteFinSieste) {
            h.getReveil().sonOn();
            sieste = false;
        }
    }
}
