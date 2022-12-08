public class AffichageSimple implements AffichageHeure{

    public AffichageSimple(HorlogeReveil h){
        h.ajouteObservateur(this);
    }
    @Override
    public void miseAJour(HorlogeReveil h) {
        System.out.println( h.getHeures() + " : " + h.getMinutes());
    }
}
