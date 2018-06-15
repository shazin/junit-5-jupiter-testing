package lk.techtalks.junit.jupiter.testing;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class JUnitJupiterFormatServiceTests {

    private FormatService formatService = new FormatService();

    @Test
    @DisabledOnOs(OS.WINDOWS)
    @DisplayName("Not supposed to run on Windows OS")
    void testAppend() {
        assertEquals("abcdef", formatService.append("abc", "def"));
    }

    @Nested
    @DisplayName("Happy Cases")
    public class HappyCases {
        @Test
        @Tag("happy")
        void testAppend() {
            assertEquals("abcdef", formatService.append("abc", "def"));
        }

        @Test
        @Tag("happy")
        void testPrepend() {
            assertEquals("uvwxyz", formatService.prepend("xyz", "uvw"));
        }

        @Test
        @Tag("happy")
        void testRepeat() {
            assertEquals("blahblahblah", formatService.repeat("blah", 3));
        }

    }

    @RepeatedTest(value = 5, name = "පරීක්ෂණ {totalRepetitions} න් {currentRepetition} වන පරීක්ෂණය")
    void repeatingTest(RepetitionInfo repetitionInfo) {
        assertEquals(String.join("", Collections.nCopies(repetitionInfo.getCurrentRepetition(), "clap")), formatService.repeat("clap", repetitionInfo.getCurrentRepetition()));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        " World!",
        " John",
        " Tom"
    })
    void parameterizedTest(String input) {
        assertEquals("Hello"+input, formatService.append("Hello", input));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        final String FILE_NAME = "abc";
        return Stream.of(".jpg", ".png", "tif").map(s -> dynamicTest("Test for "+s, () -> assertEquals(FILE_NAME+s, formatService.append(FILE_NAME, s))));
    }

}
