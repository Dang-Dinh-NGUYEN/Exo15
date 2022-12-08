public class SonReveilRadio extends Radio implements SonReveil{
    @Override
    public void on() {
        allume();
    }

    @Override
    public void off() {
        eteint();
    }
}
