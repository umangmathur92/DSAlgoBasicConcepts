package linkedLists;

public class LinkedListNew {

    static Node myLinkedList2 = new Node(5, null);

    static Node myLinkedList =
            new Node(1,
                    new Node(5,
                            new Node(9,
                                    new Node(2,
                                            new Node(8,
                                                    new Node(5,
                                                            new Node(3,
                                                                    null)))))));

    public static void main(String[] args) {
        System.out.println(myLinkedList);
        myLinkedList = deleteAtPosition(myLinkedList, 3);
        System.out.println(myLinkedList);
    }

    private static Node append(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
        return head;
    }

    private static Node prepend(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    private static Node deleteAtHead(Node head) {
        if (head == null) {
            return head;
        }
        head = head.next;
        return head;
    }

    private static Node deleteAtTail(Node head) {
        if (head == null || head.next == null) {
            head = null;
            return head;
        }
        Node currNode = head;
        Node prevNode = null;
        while (currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = null;
        return head;
    }

    private static Node insertAtPosition(Node head, int position, int data) {
        Node newNode = new Node(data);
        Node currNode = head;
        Node prevNode = null;
        int count = 0;
        while (currNode.next != null && count < position) {
            prevNode = currNode;
            currNode = currNode.next;
            count++;
        }
        prevNode.next = newNode;
        prevNode.next.next = currNode;
        return head;
    }

    private static Node deleteAtPosition(Node head, int position) {
        Node currNode = head;
        Node prevNode = null;
        int count = 0;
        while (currNode.next != null && count < position) {
            prevNode = currNode;
            currNode = currNode.next;
            count++;
        }
        prevNode.next = currNode.next;
        return head;
    }

    private static Node findMiddleNode(Node head) {

        return head;
    }

    static class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "=>" + next;
        }
    }

}
