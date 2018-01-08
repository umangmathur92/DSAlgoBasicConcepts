package LinkedLists;

public class LinkedListExamples {

    static ListNode myLinkedList =
            new ListNode(1,
            new ListNode(5,
            new ListNode(9,
            new ListNode(2,
            new ListNode(8,
            new ListNode(5,
            new ListNode(3, null)))))));

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
        ListNode middleNode = findMiddleNode(myLinkedList);
        System.out.println(middleNode.data);
        myLinkedList = deleteAtPosition(myLinkedList, 4);
        System.out.println(myLinkedList);
        myLinkedList = insertAtPosition(myLinkedList, 5, 99);
        System.out.println(myLinkedList);
    }

    private static ListNode append(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return head;
    }

    private static ListNode prepend(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    private static ListNode deleteAtHead(ListNode head) {
        if (head == null) {
            return null;
        }
        head = head.next;
        return head;
    }

    private static ListNode deleteAtTail(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode currNode = head;
        ListNode prevNode = null;
        while (currNode.next != null) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = null;
        return head;
    }

    private static ListNode insertAtPosition(ListNode head, int position, int data) {
        ListNode newNode = new ListNode(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        ListNode currNode = head;
        ListNode prevNode = null;
        int iterationCount = 0;
        while (currNode.next != null && iterationCount < position) {
            prevNode = currNode;
            currNode = currNode.next;
            iterationCount++;
            System.out.println(iterationCount);
        }
        if (position <= iterationCount) {
            newNode.next = currNode;
            prevNode.next = newNode;
        }
        return head;
    }

    private static ListNode deleteAtPosition(ListNode head, int position) {
        if (position == 0) {
            head = head.next;
            return head;
        }
        ListNode currNode = head;
        ListNode prevNode = null;
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

    private static ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode deleteWithValue(ListNode head, int data) {
        if (head == null) {
            return head;
        }
        if (head.data == data) {
            head = head.next;
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

}