import java.util.LinkedList;

public class HorlogeReveil {
    private int heures ;
    private int minutes ;
    private int secondes ;
    private Reveil fonctionReveil ;
    private LinkedList <Observateur> observateurs = new LinkedList<Observateur>() ;
    int getHeures () { return heures ; }
    int getMinutes () { return minutes ; }
    int getSecondes () { return secondes ; }
    Reveil getReveil () { return fonctionReveil ; }
    HorlogeReveil () {
        fonctionReveil = new Reveil () ;
        ajouteObservateur(fonctionReveil);

    }
    void regleHeure ( int h , int m , int s ) {
        heures = h ;
        minutes = m ;
        secondes = s ;
    }
    void tictac () {
        secondes = ( secondes + 1) % 60;
        if ( secondes == 0) {
            minutes = ( minutes + 1) % 60;
            if ( minutes == 0)
                heures = ( heures + 1) % 24;
        }
        previentToutLeMonde() ;
    }
    void ajouteObservateur(Observateur x ) {
        observateurs.add(x) ;
    }
    void previentToutLeMonde() {
        for ( Observateur x : observateurs )
            x.miseAJour(this);
    }
}

