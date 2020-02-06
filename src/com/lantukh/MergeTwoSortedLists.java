package com.lantukh;

public class MergeTwoSortedLists {

    public static void getSolution() {

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(4);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode solution = mergeTwoLists(node11, node21);
        System.out.println(solution);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        if (l1.val > l2.val) {
            return mergeTwoLists(l2, l1);
        }

        ListNode pointer1 = l1;
        ListNode pointer2 = l2;

        ListNode prew = null;

        while (pointer1 != null && pointer2 != null) {

            if (pointer1.val <= pointer2.val) {
                prew = pointer1;
                pointer1 = pointer1.next;
            } else {
                ListNode tmp = pointer2.next;

                prew.next = pointer2;
                pointer2.next = pointer1;

                prew = pointer2;

                pointer2 = tmp;

            }
        }

        if(pointer2 != null) {
            prew.next = pointer2;
        }

        return l1;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
