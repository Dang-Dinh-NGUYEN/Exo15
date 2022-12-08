public class ReveilRadio implements ModeReveil{
    public static final ReveilRadio INSTANCE = new ReveilRadio();

    private ReveilRadio() {}

    public static ReveilRadio getInstance() {
        return INSTANCE;
    }

    @Override
    public ModeReveil next(Reveil r) {
        r.setReveil(false);
        return ReveilEteint.getInstance();
    }
}
