import java.util.Arrays;

public class Main {
    private Integer[] items;
    private int size;

    public Main() {
        items = new Integer[10];
        size = 0;
    }

    public void add(Integer item) {
        if (contains(item)) {
            return;
        }

        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }

        items[size++] = item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean contains(Integer item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return items[index];
    }

    public static void main(String[] args) {
        Main set = new Main();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2);

        System.out.println(set.toString());
        System.out.println(set.get(1));
    }
}