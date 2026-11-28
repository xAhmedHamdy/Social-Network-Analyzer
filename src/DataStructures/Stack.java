package DataStructures;

public class Stack<T> {
    private T[] s;
    private int size;

    public Stack() {
        s = (T[]) new Object[2];
        size = 0;
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
            copy[i] = s[i];
        }
        s = copy;
    }

    public void push(T item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException();

        if (size == s.length)
            resize(2 * s.length);

        s[size++] = item;
    }

    public T pop() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        T item = s[--size];
        s[size] = null;

        if (size > 0 && size == s.length / 4)
            resize(s.length / 2);

        return item;
    }

    public T peek() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();
        return s[size - 1];
    }
}
