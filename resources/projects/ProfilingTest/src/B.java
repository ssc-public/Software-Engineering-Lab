
public class B {

    private static B instance;

    public static B getInstance() {
        if (instance == null)
            instance = new B();
        return instance;
    }

    public void doJobB() {
        sleepMethodB();
    }

    private void sleepMethodB() {
        for (int i = 0; i < 1000; i++) {
            Utils.sleepUninterrruptable(0.001);
        }
    }

}
