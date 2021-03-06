package synthesizer;
// package <package name>;
import java.util.Iterator;

//Make sure to make this class and all of its methods public
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //  Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from synthesizer.AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.

        this.rb = (T[]) new Object[capacity];
        this.first = capacity / 2;
        this.last = first - 1;
        this.fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        //  Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount + 1 > capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }

        fillCount += 1;
        if (last + 1 > capacity - 1) {
            last = 0;
        } else {
            last += 1;
        }
        rb[last] = x;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        T temp = rb[first];
        fillCount -= 1;
        if (first + 1 > capacity - 1) {
            first = 0;
        } else {
            first += 1;
        }

        return temp;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        int ptr;

        ArrayRingBufferIterator() {
            this.ptr = first;
        }

        @Override
        public boolean hasNext() {
            return !(ptr == last);
        }

        @Override
        public T next() {
            T item = rb[ptr];

            if (ptr + 1 > capacity - 1) {
                ptr = 0;
            } else {
                ptr += 1;
            }

            return item;
        }
    }

    //  When you get to part 5, implement the needed code to support iteration.
}
