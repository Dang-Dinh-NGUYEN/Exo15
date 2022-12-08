public class Main {

    public static void main(String[] args) {
        HorlogeReveil horlogeReveil = new HorlogeReveil();
        horlogeReveil.getReveil().regleReveil(7,0);
        Reveil fonction = new Reveil();
        fonction.regleReveil(9,0);
        horlogeReveil.ajouteObservateur(fonction);
    }
}
