public class Solution {

    static void enqueue(int key, Queue queue) {
        Node newNode = new Node(key);
        if (queue.rear == null) {
            queue.front = queue.rear = newNode;
            queue.rear.link = queue.front;
        } else {
            queue.rear.link = newNode;
            newNode.link = queue.front;
            queue.rear = newNode;
        }
    }

    static void dequeue(Queue queue) {
        if (queue.front == null) return;

        if (queue.front == queue.rear) {
            queue.front = queue.rear = null;
        } else {
            queue.rear.link = queue.front.link;
            queue.front = queue.front.link;
        }
    }

    static void displayQueue(Queue queue) {
        if (queue.front == null) {
            System.out.println("Queue is empty");
            return;
        }

        StringBuilder result = new StringBuilder();
        Node current = queue.front;

        while (true) {
            result.append(current.key).append(" ");
            if (current == queue.rear) break;
            current = current.link;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        enqueue(1, queue);
        displayQueue(queue);

        enqueue(2, queue);
        displayQueue(queue);

        enqueue(3, queue);
        displayQueue(queue);

        for (int i = 0; i < 4; i++) {
            dequeue(queue);
            displayQueue(queue);
        }
    }
}
