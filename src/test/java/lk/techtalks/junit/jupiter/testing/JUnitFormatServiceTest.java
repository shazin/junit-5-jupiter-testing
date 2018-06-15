package lk.techtalks.junit.jupiter.testing;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class JUnitFormatServiceTest {

    private FormatService formatService = new FormatService();

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Rule
    public Timeout timeout = new Timeout(15, TimeUnit.MILLISECONDS);

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
    public void testRepeat_timeout() {
        formatService.repeat("blah", 100_000);
    }

    @Test
    public void testAppend_IllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        formatService.append(null, null);
    }
}
