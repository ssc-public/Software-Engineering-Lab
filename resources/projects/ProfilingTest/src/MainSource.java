import java.io.IOException;

public class MainSource {

    public static void main(String[] args) throws IOException {
        prompt("Start");
        A.getInstance().doJobA();
        B.getInstance().doJobB();
        mainSleep();
        prompt("Finish");
    }

    private static void mainSleep() {
        for (int i = 0; i < 100; i++) {
            Utils.sleepUninterrruptable(0.01);
        }
    }

    private static void prompt(String action) throws IOException {
        System.out.println("Press any key to " + action.toLowerCase() + "...");
        System.in.read();
        System.out.println(action + "ed !");
    }

}
