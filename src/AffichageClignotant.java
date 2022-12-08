public class AffichageClignotant implements AffichageHeure{
    boolean visible = true;
    public AffichageClignotant(HorlogeReveil h){ h.ajouteObservateur(this);}
    @Override
    public void miseAJour(HorlogeReveil h) {
        if(visible) {
            System.out.println( h.getHeures() + " : " + h.getMinutes());
            visible = false;
        }else{
            System.out.println(h.getHeures() + "  " + h.getMinutes());
            visible = true;
        }
    }
}
