/** builds data structure Array Deque.
 *
 * @param <T>
 */

public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int first;

    public ArrayDeque() {
        items = (T[]) new Object[5];
        size = 0;
        first = 2;
    }

    @Override
    public T get(int index) {
        if (index > (size - 1) || index < 0) {
            return null;
        }
        return items[first + index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity + 1];
        System.arraycopy(items, first, a, ((capacity - size) / 2), size);
        items = a;
        first =  ((capacity - size) / 2);
    }

    @Override
    public void addFirst(T item) {
        if (first == 0) {
            resize((size + 1) * 2);
        }

        items[first - 1] = item;
        first = first - 1;
        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        if (size + first == items.length) {
            resize((size + 1) * 2);
        }
        size = size + 1;
        items[first + size - 1] = item;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T x = items[first];
        items[first] = null;
        size = size - 1;
        first = first + 1;

        /** Resize when there is 75% empty space before the array. */
        if (first > (0.75 * items.length)) {
            resize(items.length / 2);
        }
        return x;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T x = items[first + size - 1];
        items[first + size - 1] = null;
        size -= 1;
        /** Resize when there are 25% empty space after the array. */
        if ((first + size) < (0.25 * items.length)) {
            resize(items.length / 2);
        }
        return x;
    }

    @Override
    public void printDeque() {
        StringBuilder s = new StringBuilder();
        for (int i = first; i < (size + first); i++) {
            s.append(items[i].toString()).append(" ");
        }
        s.append("\n");
        System.out.println(s);
    }

//    public T ArrayDeque(ArrayDeque other) {
//        //TODO
//        return null;
//    }

}
