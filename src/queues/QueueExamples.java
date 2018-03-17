package queues;

public class QueueExamples {

    private static Node head;
    private static Node tail;

    public static void main(String[] args) {
        head = new Node(10);
        tail = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = tail;
        System.out.println(head);
        System.out.println(peek());
        System.out.println(isEmpty());
        add(99);
        System.out.println(head);
        System.out.println(remove());
        System.out.println(head);
    }

    private static int peek() {
        return head.data;
    }

    private static boolean isEmpty() {
        return head == null;
    }

    private static void add(int data) {
        Node newNode = new Node(data);
        if (tail != null) {
            tail.next = newNode;
        }
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }

    private static int remove() {
        int val = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return val;
    }

    private static class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + "=>" + next;
        }
    }
}
