public class SonReveilBuzzer extends Buzzer implements SonReveil{
    @Override
    public void on() {
        demarre();
    }

    @Override
    public void off() {
        stoppe();
    }
}
