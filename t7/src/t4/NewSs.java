package t4;


public class NewSs {
    private static NewSs ss;

    private NewSs() {

    }

    public synchronized static NewSs getSs() {
        if (ss == null) {
            ss = new NewSs();
        }
        return ss;
    }
}
