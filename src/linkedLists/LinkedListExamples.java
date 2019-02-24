package linkedLists;

public class LinkedListExamples {

    static Node myLinkedList =
            new Node(1,
                    new Node(5,
                            new Node(9,
                                    new Node(2,
                                            new Node(8,
                                                    new Node(5,
                                                            new Node(3, null)))))));

    public static void main(String[] args) {
        System.out.println(myLinkedList);
        myLinkedList = append(myLinkedList, 25);
        System.out.println(myLinkedList);
        myLinkedList = prepend(myLinkedList, 11);
        System.out.println(myLinkedList);
        myLinkedList = deleteWithValue(myLinkedList, 2);
        System.out.println(myLinkedList);
        myLinkedList = append(myLinkedList, 30);
        System.out.println(myLinkedList);
        myLinkedList = deleteAtHead(myLinkedList);
        System.out.println(myLinkedList);
        myLinkedList = deleteAtTail(myLinkedList);
        System.out.println(myLinkedList);
        Node middleNode = findMiddleNode(myLinkedList);
        System.out.println(middleNode.data);
        myLinkedList = deleteAtPosition(myLinkedList, 4);
        System.out.println(myLinkedList);
        myLinkedList = insertAtPosition(myLinkedList, 5, 99);
        System.out.println(myLinkedList);
        myLinkedList = reverseLinkedList(myLinkedList);
        System.out.println(myLinkedList);
    }

    private static Node append(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
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
            return null;
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
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node currNode = head;
        Node prevNode = null;
        int iterationCount = 0;
        while (currNode.next != null && iterationCount < position) {
            prevNode = currNode;
            currNode = currNode.next;
            iterationCount++;
        }
        if (position <= iterationCount) {
            newNode.next = currNode;
            prevNode.next = newNode;
        }
        return head;
    }

    private static Node deleteAtPosition(Node head, int position) {
        if (position == 0) {
            head = head.next;
            return head;
        }
        Node currNode = head;
        Node prevNode = null;
        int iterationCount = 0;
        while (currNode.next != null && iterationCount < position) {
            prevNode = currNode;
            currNode = currNode.next;
            iterationCount++;
        }
        if (position <= iterationCount) {
            prevNode.next = currNode.next;
        }
        return head;
    }

    private static Node findMiddleNode(Node head) {
        if (head == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node deleteWithValue(Node head, int data) {
        if (head == null) {
            return head;
        }
        if (head.data == data) {
            head = head.next;
            return head;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    public static Node reverseLinkedList(Node head) {
        Node prevNode = null;
        Node currNode = head;
        while (currNode != null) {
            Node temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
        }
        head = prevNode;
        return head;
    }

    private static class Node {
        Integer data;
        Node next = null;

        Node(Integer val) {
            this.data = val;
        }

        Node(Integer val, Node nxt) {
            this.data = val;
            this.next = nxt;
        }

        @Override
        public String toString() {
            return data + "=>" + next;
        }
    }
}
