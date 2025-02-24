public class MyLinkedListQueue {
    private Node head;
    private Node tail;

    MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    void enqueue(int key) {
        Node temp = new Node(key);
        if (this.tail == null) {
            this.head = this.tail = temp;
            return;
        }
        this.tail.next = temp;
        this.tail = temp;
    }

    Node dequeue() {
        if (this.head == null) return null;
        Node temp = this.head;
        this.head = this.head.next;
        if (this.head == null) this.tail = null;
        return temp;
    }
}
