package DataStructures;

public class Queue<T> {

    private T[] q;
    private int head;
    private int tail;
    private int size;

    public Queue() {
        q = (T[]) new Object[2];
        head = tail = size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int newCapacity) {
        T[] copy = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            copy[i] = q[(head + i) % q.length];
        }
        q = copy;
        head = 0;
        tail = size;
    }

    public void enqueue(T item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException();
        if (size == q.length)
            resize(2 * q.length);

        q[tail] = item;
        tail = (tail + 1) % q.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();

        T item = q[head];
        q[head] = null;
        head = (head + 1) % q.length;
        size--;

        if (size > 0 && size == q.length / 4)
            resize(q.length / 2);

        return item;
    }

}
