
public class Utils {

    public static void sleepUninterrruptable(double seconds) {
        try {
            Thread.sleep((long)(seconds * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException("Sleep thread interrupted !");
        }
    }

}
