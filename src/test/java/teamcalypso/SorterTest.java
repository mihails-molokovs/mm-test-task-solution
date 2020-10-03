package teamcalypso;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;

public class SorterTest {

    private Sorter<Storage> sorter;

    @Test
    public void testEmptyData() {
        final Storage[] data = {};
        sorter = new Sorter<>(data);

        assertArrayEquals(sorter.sort(), new Storage[]{});
    }

    @Test
    public void testInitialDataNotAffected() {
        final Storage[] data =
                new Storage[]{new Storage(1, "Test 1", 1), new Storage(2, "Test 2", 2)};

        sorter = new Sorter<>(data);
        final Storage[] sortedData = sorter.sort();

        assertFalse(Arrays.equals(data, sortedData));
    }

    @Test
    public void testSortedData() {
        final Storage[] data =
                new Storage[]{new Storage(1, "Test 1", 2), new Storage(2, "Test 2", 1)};

        sorter = new Sorter<>(data);

        assertArrayEquals(sorter.sort(), data);
    }

    @Test
    public void testUnsortedData() {
        final Storage[] data =
                new Storage[]{new Storage(1, "Test 1", 2),
                        new Storage(2, "Test 2", 3),
                        new Storage(3, "Test 4", 1),
                        new Storage(4, "Test 3", 1),
                        new Storage(5, "Test 0", 3)};
        sorter = new Sorter<>(data);
        final Storage[] expectedResult =
                new Storage[]{data[4], data[1], data[0], data[3], data[2]};

        assertArrayEquals(sorter.sort(), expectedResult);
    }
}
