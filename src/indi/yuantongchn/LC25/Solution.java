package indi.yuantongchn.LC25;


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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode hair = new ListNode(0);
        ListNode pre = hair;
        ListNode start = head;
        ListNode end = start;
        ListNode sign = end;
        while (sign != null) {
            for (int i = 0; i < k - 1; i++) {
                end = end.next;
                if (end == null) {
                    return hair.next;
                }
            }
            sign = end.next;
            end.next = null;
            reverseGroup(start, end);
            pre.next = end;
            start.next = sign;
            pre = start;
            start = sign;
            end = start;
        }
        return hair.next;
    }

    private void reverseGroup(ListNode start, ListNode end) {
        ListNode cur = start;
        ListNode next = cur;
        ListNode prev = null;
        while (cur != null) {
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
}
