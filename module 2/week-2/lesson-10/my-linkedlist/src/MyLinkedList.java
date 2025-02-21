public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    MyLinkedList() {
        head = new Node(null);
        numNodes++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) addFirst(element);
        else if (index == numNodes) addLast(element);
        else {
            Node current = head;
            Node temp = null;
            for (int i = 0; i < index; i++) {
                if (i == index - 1) temp = current.next;
                else current = current.next;
            }

            current.next = new Node(element);
            current.next.next = temp;

            numNodes++;
        }
    }

    public void addFirst(E e) {
        Node current = head;
        Node newNode = new Node(e);
        newNode.next = current;
        head = newNode;
        numNodes++;
    }

    public void addLast(E e) {
        Node current = head;
        for (int i = 0; i < numNodes - 1; i++) {
            current = current.next;
        }
        current.next = new Node(e);
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node removed = null;
        Node current = head;

        if (index == 0) {
            removed = head;
            head = current.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
                removed = current;
            }
            current.next = current.next.next;
        }

        numNodes--;

        return (E) removed.data;
    }

    public boolean remove(Object e) {
        boolean check = false;
        Node current = head;
        if (head.data.equals(e)) {
            head = current.next;
            check = true;
        } else {
            for (int i = 0; i < numNodes - 1; i++) {
                Node nextNode = current.next;
                if (nextNode.data == e) {
                    current.next = nextNode.next;
                    check = true;
                    break;
                } else {
                    current = nextNode;
                }
            }
        }

        if (check) numNodes--;

        return check;
    }

    public int size() {
        return numNodes;
    }

    public E clone() {
        MyLinkedList<E> cloned = new MyLinkedList<>();
        cloned.head = new Node(this.head.data);
        Node current = this.head;
        Node currentCloned = cloned.head;

        for (int i = 1; i < numNodes; i++) {
            current = current.next;
            currentCloned.next = new Node(current.data);
        }

        cloned.numNodes = this.numNodes;

        return (E) cloned;
    }

    public boolean contains(E o) {
        boolean check = false;
        Node current = head;
        for (int i = 0; i < numNodes; i++) {
            if (current.data == o) {
                check = true;
                break;
            }
            current = current.next;
        }

        return check;
    }

    public int indexOf(E o) {
        int index = -1;
        Node current = head;
        for (int i = 0; i < numNodes; i++) {
            if (current.data.equals(o)) {
                index = i;
                break;
            }
            current = current.next;
        }

        return index;
    }

    public boolean add(E e) {
        addLast(e);
        return contains(e);
    }

    E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }

        return (E) current.data;
    }

    E getFirst() {
        return (E) head.data;
    }

    E getLast() {
        Node current = head;
        for (int i = 0; i < numNodes - 1; i++) {
            current = current.next;
        }

        return (E) current.data;
    }

    void clear() {
        head = null;
        numNodes = 0;
    }

    public void getAll() {
        StringBuilder result = new StringBuilder("" + head.data);
        Node current = head;
        for (int i = 0; i < numNodes - 1; i++) {
            current = current.next;
            result.append(" , ").append(current.data);
        }

        System.out.println(result);
    }
}
