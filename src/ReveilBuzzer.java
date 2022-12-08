public class ReveilBuzzer implements ModeReveil{
    public static final ReveilBuzzer INSTANCE = new ReveilBuzzer();

    private ReveilBuzzer() {}

    public static ReveilBuzzer getInstance() {
        return INSTANCE;
    }

    @Override
    public ModeReveil next(Reveil r) {
        r.setSonReveil(new SonReveilRadio());
        return ReveilRadio.getInstance();
    }
}
