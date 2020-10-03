package teamcalypso;

public class Sorter<E extends Storage> {

    private Storage[] data;

    public Sorter(E[] data) {
        // Making a copy of the array, so initial data won't be affected
        this.data = new Storage[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    public Storage[] sort() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < (data.length - i - 1); j++) {
                if ((data[j].size < data[j + 1].size) ||
                        (data[j].size == data[j + 1].size && data[j].type.compareTo(data[j + 1].type) > 0)) {
                    Storage temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
        return data;
    }
}
