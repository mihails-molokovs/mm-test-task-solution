package teamcalypso;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class IteratorTest {

    private Iterator<Storage> iterator;

    @Test
    public void testEmptyData() {
        final Storage[] data = {};
        iterator = new Iterator<>(data);

        assertFalse(iterator.hasNext());
        assertNull(iterator.next());
    }

    @Test
    public void testSingleData() {
        final Storage[] data = new Storage[]{new Storage(1, "Test 1", 1)};
        iterator = new Iterator<>(data);

        assertTrue(iterator.hasNext());
        assertSame(iterator.next(), data[0]);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testMultipleData() {
        final Storage[] data =
                new Storage[]{new Storage(1, "Test 1", 1), new Storage(2, "Test 2", 2)};
        iterator = new Iterator<>(data);

        assertTrue(iterator.hasNext());
        assertSame(iterator.next(), data[0]);
        assertTrue(iterator.hasNext());
        assertSame(iterator.next(), data[1]);
        assertFalse(iterator.hasNext());
    }
}
