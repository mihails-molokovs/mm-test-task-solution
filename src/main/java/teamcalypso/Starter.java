package teamcalypso;

public class Starter {

    private static Storage[] data = new Storage[]{
            new Storage(1, "int", 10),
            new Storage(2, "float", 4),
            new Storage(3, "double", 6),
            new Storage(4, "String", 12),
            new Storage(5, "BigDecimal", 13),
            new Storage(6, "Integer", 12),
            new Storage(7, "Double", 15),
            new Storage(8, "Object", 4),
    };

    public static void main(String[] args) {
        final Sorter<Storage> sorter = new Sorter<>(data);

        Iterator<Storage> iterator = new Iterator<>(sorter.sort());

        System.out.println("Printing sorted storage! Sort is done by size descending and type ascending");

        print(iterator);

        final DataFilter<Storage> filter = new DataFilter<>(data);

        iterator = new Iterator<>(filter.removeWithCapitalLetters());

        System.out.println("\nPrinting filtered storage! Filtering is done by removing elements, " +
                "which have capital letters in their type fields");

        print(iterator);
    }

    private static void print(Iterator<Storage> iterator) {
        while (iterator.hasNext()) {
            final Storage storage = iterator.next();
            System.out.println("| id " + storage.getId() + " | type " + storage.getType() + " | " + storage.getSize());
        }
    }
}
