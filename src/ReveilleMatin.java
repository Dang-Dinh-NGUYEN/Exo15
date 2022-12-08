public class ReveilleMatin {
    private int heures ;
    private int minutes ;
    private int secondes ;
    private int heureReveil ;
    private int minuteReveil ;
    private boolean reveil = false ;
    private int sonReveil = 1;
    private int heureFinSieste ;
    private int minuteFinSieste ;
    private boolean sieste = false ;
    private Radio radio = new Radio () ;
    private Buzzer buzzer = new Buzzer () ;

    void regleHeure ( int h , int m , int s ) {
        heures = h ;
        minutes = m ;
        secondes = s ;
    }
    void regleReveil ( int h , int m ) {
        heureReveil = h ;
        minuteReveil = m ;
    }
    void tictac () {
        secondes = ( secondes + 1) % 60;
        if ( secondes == 0) {
            minutes = ( minutes + 1) % 60;
            if ( minutes == 0)
                heures = ( heures + 1) % 24;
        }
        System . out . println ( heures + " : " + minutes ) ;
        if ( reveil && heures == heureReveil && minutes == minuteReveil && secondes == 0)
            sonOn () ;
        if ( sieste && heures == heureFinSieste && minutes == minuteFinSieste) {
            sonOn () ;
            sieste = false ;
        }
    }
    void basculeReveil () {
        if (! reveil ) {
            reveil = true ;
            sonReveil = 1;
        }
        else if ( sonReveil == 1)
            sonReveil = 2;
        else
            reveil = false ;
    }
    void sonOn () {
        if ( sonReveil == 1)
            buzzer . demarre () ;
        else
            radio . allume () ;
    }
    void sonOff () {
        if ( sonReveil == 1)
            buzzer . stoppe () ;
        else
            radio . eteint () ;
    }
    void sleep ( int m ) {
        sieste = true ;
        minuteFinSieste = ( minutes + m ) % 60;
        heureFinSieste = ( heures + m / 60) % 24;
    }
    void snooze () {
        sonOff () ;
        sleep (9) ;
    }

    /* 1.1) supposons qu'on veut définir une classe modélisant des réveille-matins qui n’ont plus de fonction ”sieste”,
    donc on doit modifier plusieurs méthode dans cette classe (initiale) . C-a-d le OCP est violé. */

    /*1.2) si nous voulions définir une classe modélisant des réveille-matins dont le son du buzzer est
    remplacé par un chant d’oiseau grâce à une classe ChantOiseau, on doit modifier la classe ReveilleMatin aussi en
    ajoutant un attribut de type ChantOiseau par exemple. Donc le OCP est violé. */

    /*1.3) Imaginons que nous voulions définir une classe modélisant des réveille-matins qui affichent l’heure
    différemment, par exemple en faisant clignoter le ” :” se trouvant entre les heures et les minutes. On doit modifier
    la classe ReveilleMatin. Le OCP est violé, en plus, on obtient que cette classe se serve à plusieurs responsabilités
    différentes (calculer er afficher l'heure, régler les sons, etc) donc le SRP est violé aussi.*/

    /*1.4) La méthode void basculeReveil() permet de basculer d’un des trois états possibles du réveil à un
    autre.Alors, si on décide d’ajouter, de modifier ou d’enlever un état, on doit modifier cette méthode -> OCP violé */

    /*1.5) - le SRP est violé car cette classe se serve à plusieurs responsabilités différentes
    (calculer er afficher l'heure, régler les sons, etc)
      - le OCP est violé car si on veut ajouter/modifier/enlever quelque chose (attribut/ méthode/ fonctionnement/ etc),
       on doit entrer et travailler directement dans cette classe complète*/

}
