import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class A {

    private static A instance;

    public static A getInstance() {
        if (instance == null)
            instance = new A();
        return instance;
    }

    private String randomHash() {
        CRC32 crc32 = new CRC32();
        crc32.reset();
        crc32.update((int) (Math.random() * 255));
        return String.format("%08X", crc32.getValue()); // e.g. AABBCCDD
    }

    public void doJobA() {
        produceGarbage();
        sleepMethodA();
    }

    private void sleepMethodA() {
        Utils.sleepUninterrruptable(1);
    }

    private void produceGarbage() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(randomHash());
        }
    }

}
