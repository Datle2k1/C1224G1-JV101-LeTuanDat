import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    void add(int index, E o) {
        elements = Arrays.copyOf(elements, DEFAULT_CAPACITY + 1);
        elements[DEFAULT_CAPACITY] = o;
        size ++;
    }

    E remove(int index) {
        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }


    int size() {
        return size;
    }

    public E clone() {
        MyList<E> cloned = new MyList<>();
        cloned.elements = Arrays.copyOf(elements, DEFAULT_CAPACITY);
        cloned.size = size;
        return (E) cloned;
    }

    boolean contains(E o) {
        for (Object obj : elements) {
            if (o.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    int indexOf(E o) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == o) {
                index = i;
                break;
            }
        }
        return index;
    }

    boolean add(E o) {
        ensureCapacity(size + 1);
        elements[size++] = o;
        return true;
    }

    void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            elements = Arrays.copyOf(elements, minCapacity);
        }
    }


    E get(int index) {
        return (E) elements[index];
    }

    void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
