public final class ReveilEteint implements ModeReveil{
    public static final ReveilEteint INSTANCE = new ReveilEteint();

    private ReveilEteint() {}

    public static ReveilEteint getInstance() {
        return INSTANCE;
    }

    @Override
    public ModeReveil next(Reveil r) {
         r.setReveil(true);
         r.setSonReveil(new SonReveilBuzzer());
         return ReveilBuzzer.getInstance();
    }
}
