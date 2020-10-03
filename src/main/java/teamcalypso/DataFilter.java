package teamcalypso;

public class DataFilter<E extends Storage> {

    private E[] data;

    public DataFilter(E[] data) {
        this.data = data;
    }

    public Storage[] removeWithCapitalLetters() {
        Storage[] arrayWithoutCapitalLetters = new Storage[data.length];
        System.arraycopy(data, 0, arrayWithoutCapitalLetters, 0, data.length);
        int indexOffset = 0;

        for (int i = 0; i < data.length; i++) {
            if (!data[i].type.equals(data[i].type.toLowerCase())) {
                arrayWithoutCapitalLetters = removeElement(arrayWithoutCapitalLetters, i, indexOffset);
                indexOffset++;
            }
        }
        return arrayWithoutCapitalLetters;
    }

    private Storage[] removeElement(Storage[] array, int index, int indexOffset) {
        Storage[] resultingArray = new Storage[array.length - 1];

        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != (index - indexOffset)) {
                resultingArray[j++] = array[i];
            }
        }

        return resultingArray;
    }
}
