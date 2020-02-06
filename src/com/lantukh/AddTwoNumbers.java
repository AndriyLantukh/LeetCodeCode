package com.lantukh;

import java.util.LinkedList;

public class AddTwoNumbers {


    public static void getSolution() {

        ListNode l1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);

        l1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(5);
        node2 = new ListNode(6);
        node3 = new ListNode(4);

        l2.next = node2;
        node2.next = node3;

        ListNode solution = solution(l1, l2);


    }

    private static ListNode solution(ListNode l1, ListNode l2) {

        ListNode resultList = null;
        ListNode lastNode = null;

        int sum = 0;
        do {

            if (l1 != null) {
                sum = sum + l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum = sum + l2.val;
                l2 = l2.next;
            }

            ListNode newNode;
            if (sum > 9) {
                newNode = new ListNode(sum % 10);
                sum = 1;
            } else {
                newNode = new ListNode(sum);
                sum = 0;
            }

            if(resultList == null) {
                resultList = newNode;
                lastNode = newNode;
            } else  {
               lastNode.next = newNode;
                lastNode = newNode;
            }

        } while (l1 != null || l2 != null);

        if(sum > 0) {
            lastNode.next = new ListNode(sum);
        }

        return resultList;
    }

    public static class ListNode {
        public int val;

        public ListNode next;

        ListNode(int x) {
            this.val = x;
        }

    }
}
