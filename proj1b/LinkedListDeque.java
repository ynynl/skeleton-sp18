/** Builds Linked List Deque data structure. */
public class LinkedListDeque<T> implements Deque<T> {

    /*create a nested naked double linked list */
    private static class Node<T>  {
        private T item;
        private Node prev;
        private Node next;


        private Node(T i, Node previous, Node nexter) {
            item = i;
            prev = previous;
            next = nexter;
        }

    }

    private Node sentinel;
    private int size;

    /**
     * Create a new Deque.
     */

    public  LinkedListDeque() {
        size = 0;

        /** Use circular sentinel topology.
         */

        sentinel = new Node<String>("I am a sentinel", null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    @Override
    public void addFirst(T item) {
        /**
         * Prev points to sentinel.
         * Next points to the old first: sentinel.next.
         * Change sentinel.next later.
         */
        Node<T> first = new Node<>(item, sentinel, sentinel.next);

        /**
         * The old first item.prev should point to THIS first,
         * And the old first item is sentinel.next
         */
        sentinel.next.prev = first;

        /**
         * Sentinel.next changes to the first item.
         */
        sentinel.next = first;

        /**
         * If this first is the only item,
         * sentinel.prev should point to this first item.
         */
        if (sentinel.prev == sentinel) {
            sentinel.prev = first;
        }

        size = size + 1;
    }

    @Override
    public void addLast(T item) {
        /**
         the new last item has the prev of the old last item
         which is the sentinel.prev
         and the next points to the sentinel
         ===================================
         sentinel.prev <-> last <-> sentinel
         ===================================
         */
        Node<T> last = new Node<T>(item, sentinel.prev, sentinel);

        /**
         PREVIOUS last item is sentinel.prev
         The next of PREVIOUS last item should points to THIS last.
         */
        sentinel.prev.next = last;

        /**
         Sentinel.prev should pointed to THIS last.
         */
        sentinel.prev = last;

        /** In case this item is the only item of the list,
         *  the first item should be THIS last,
         *  which is sentinel.next.
         */
        if (sentinel.next == sentinel) {
            sentinel.next = last;
        }

        size += 1;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StringBuilder s = new StringBuilder();
        Node ptr = sentinel;
        while (ptr.next != sentinel) {
            s.append(ptr.next.item.toString()).append(" ");
            ptr = ptr.next;
        }
        s.append("\n");
        System.out.println(s);
    }

    @Override
    public T removeFirst() {
        /** Let the sentinel.next point to sentinel.next.next
         * Then let the sentinel.next.prev point to the sentinel
         */
        if (size == 0) {
            return null;
        }
        T f = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return f;
    }

    @Override
    public T removeLast() {
        /** Let the sentinel.prev point to sentinel.prev.prev
         *  Then let the sentinel.prev.next point to sentinel.
         */
        if (size == 0) {
            return null;
        }
        T l = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return l;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > (size - 1)) {
            return null;
        }
        Node ptr = sentinel;
        while (index >= 0) {
            ptr = ptr.next;
            index -= 1;
        }
        return (T) ptr.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > (size - 1)) {
            return null;
        }
        if (index == 0) {
            return (T) sentinel.next.item;
        }
        LinkedListDeque<T> r = new LinkedListDeque();
        r.size = size;
        r.sentinel = new Node("recursive get", sentinel.next, sentinel.next.next);

        return r.getRecursive(index - 1);
    }
}
