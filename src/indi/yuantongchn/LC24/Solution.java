package indi.yuantongchn.LC24;

//24. 两两交换链表中的节点

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(0);
        ListNode first = pre;
        pre.next = head;
        ListNode sign = head;
        ListNode start = head;
        ListNode end = head;
        while (sign != null) {
            for (int i = 0; i < 1; i++) {
                end = end.next;
                if (end == null) {
                    return first.next;
                }
            }
            sign = end.next;
            reverse(start, end);
            pre.next = end;
            start.next = sign;
            pre = start;
            start = sign;
            end = sign;
        }
        return first.next;
    }

    private void reverse(ListNode start, ListNode end) {
        end.next = start;
    }
}
