package lk.techtalks.junit.jupiter.testing;

import java.util.Collections;
import java.util.List;

public class FormatService {

    public String append(String main, String suffix) {
        if (main == null || suffix == null) {
            throw new IllegalArgumentException("Both Arguments are required");
        }
        return main + suffix;
    }

    public String prepend(String main, String prefix) {
        if (main == null || prefix == null) {
            throw new IllegalArgumentException("Both Arguments are required");
        }
        return prefix + main;
    }

    public String repeat(String main, int numberOfTimes) {
        if (main == null || numberOfTimes == 0) {
            throw new IllegalArgumentException("Both Arguments are required");
        }
        List<String> items = Collections.nCopies(numberOfTimes, main);
        return String.join("", items);
    }

}
