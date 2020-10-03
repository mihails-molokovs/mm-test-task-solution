package teamcalypso;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DataFilterTest {

    private DataFilter<Storage> filter;

    @Test
    public void testEmptyData() {
        final Storage[] data = {};
        filter = new DataFilter<>(data);

        assertArrayEquals(data, filter.removeWithCapitalLetters());
    }

    @Test
    public void testSingleDataShouldBeFiltered() {
        final Storage[] data = new Storage[]{new Storage(1, "Test 1", 1)};
        filter = new DataFilter<>(data);

        assertArrayEquals(filter.removeWithCapitalLetters(), new Storage[]{});
    }

    @Test
    public void testSingleDataShouldNotBeFiltered() {
        final Storage[] data = new Storage[]{new Storage(1, "test 1", 1)};
        filter = new DataFilter<>(data);

        assertArrayEquals(filter.removeWithCapitalLetters(), data);
    }

    @Test
    public void testMultipleData() {
        final Storage[] data =
                new Storage[]{new Storage(1, "test 0", 2),
                        new Storage(2, "Test 1", 3),
                        new Storage(3, "test 2", 1),
                        new Storage(4, "Test 3", 1),
                        new Storage(5, "test 4", 3)};
        filter = new DataFilter<>(data);
        final Storage[] expectedResult =
                new Storage[]{data[0], data[2], data[4]};

        assertArrayEquals(filter.removeWithCapitalLetters(), expectedResult);
    }
}
