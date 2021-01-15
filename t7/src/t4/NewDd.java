package t4;

public class NewDd {

    private static NewDd newDd = new NewDd();

    private NewDd() {

    }

    private static NewDd getInstance() {
        return newDd;
    }
}
