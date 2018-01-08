package LinkedLists;

public class ListNode {
    Integer data;
    ListNode next = null;

    ListNode(Integer val) {
        this.data = val;
    }

    ListNode(Integer val, ListNode nxt) {
        this.data = val;
        this.next = nxt;
    }

    @Override
    public String toString() {
        return data + "=>" + next;
    }
}
