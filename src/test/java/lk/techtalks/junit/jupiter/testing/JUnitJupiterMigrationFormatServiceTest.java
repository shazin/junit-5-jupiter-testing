package lk.techtalks.junit.jupiter.testing;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.migrationsupport.rules.EnableRuleMigrationSupport;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@EnableRuleMigrationSupport
public class JUnitJupiterMigrationFormatServiceTest {

    private FormatService formatService = new FormatService();

    @Test
    public void testAppend() {
        assertEquals("abcdef", formatService.append("abc", "def"));
    }

    @Test
    public void testPrepend() {
        assertEquals("uvwxyz", formatService.prepend("xyz", "uvw"));
    }

    @Test
    public void testRepeat() {
        assertEquals("blahblahblah", formatService.repeat("blah", 3));
    }

    @Test
    @DisplayName("The Test Didn't finish within the specified time")
    public void testRepeat_timeout() {
        assertTimeout(Duration.ofMillis(10), () -> formatService.repeat("blah", 100_000));
    }

    @Test
    public void testAppend_IllegalArgumentException() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> formatService.append(null, null));
        assertNotNull(iae);
        assertEquals("Both Arguments are required", iae.getMessage());
    }
}
