package teamcalypso;

public class Iterator<E extends Storage> {

    private E[] data;
    private int index;

    public Iterator(E[] data) {
        this.data = data;
    }

    public boolean hasNext() {
        return index < data.length;
    }

    public E next() {
        if (hasNext()) {
            return data[index++];
        }
        return null;
    }
}
