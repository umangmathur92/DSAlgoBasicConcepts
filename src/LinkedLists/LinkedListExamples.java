package LinkedLists;

public class LinkedListExamples {

    static ListNode myLinkedList =
            new ListNode(1,
            new ListNode(5,
            new ListNode(9,
            new ListNode(2,
            new ListNode(8,
            new ListNode(5, null))))));

    public static void main(String[] args) {
        myLinkedList = append(myLinkedList, 25);
        myLinkedList = prepend(myLinkedList, 11);
        myLinkedList = deleteWithValue(myLinkedList, 2);
        myLinkedList = append(myLinkedList, 30);
        ListNode middleNode = findMiddleNode(myLinkedList);
        System.out.println(middleNode.data);
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

    private static ListNode findMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode deleteAtHead(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tempNode = head.next;
        head.next = null;
        head = tempNode;
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

}
