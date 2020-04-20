public interface Deque<Item> {
    void addFirst(Item x);
    void addLast(Item y);
    Item removeFirst();
    Item removeLast();
    Item get(int i);
    int size();
    boolean isEmpty();
    void printDeque();
}
