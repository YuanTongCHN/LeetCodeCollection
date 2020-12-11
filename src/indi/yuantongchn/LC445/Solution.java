package indi.yuantongchn.LC445;

//445. 两数相加 II

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        ListNode res = new ListNode(0);
        int jump = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + jump;
            int num = sum % 10;
            jump = sum / 10;
            res.val = num;
            ListNode pre = new ListNode(0);
            pre.next = res;
            res = pre;
        }
        while (!s2.isEmpty()) {
            int sum = s2.pop() + jump;
            int num = sum % 10;
            jump = sum / 10;
            res.val = num;
            ListNode pre = new ListNode(0);
            pre.next = res;
            res = pre;
        }
        while (!s1.isEmpty()) {
            int sum = s1.pop() + jump;
            int num = sum % 10;
            jump = sum / 10;
            res.val = num;
            ListNode pre = new ListNode(0);
            pre.next = res;
            res = pre;
        }
        if (jump != 0) {
            res.val = jump;
            ListNode pre = new ListNode(0);
            pre.next = res;
            res = pre;
        }
        return res.next;
    }
}
