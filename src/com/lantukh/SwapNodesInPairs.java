package com.lantukh;

import java.util.Collections;

public class SwapNodesInPairs {


    public static void getSolution() {

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        ListNode solution = swapPairs(node11);
        System.out.println(solution);

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode newHead = null;
        ListNode prev = null;

        while(first != null && first.next != null) {
            ListNode second = first.next;
            ListNode threed = second.next;

            if(prev != null) {
                prev.next = second;
            }

            if(newHead == null) {
                newHead = second;
            }


            second.next = first;
            first.next = threed;

            prev = second.next;
            first = threed;

        }
        return newHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return
                    " " + val + (next == null ? "" : next.toString());
        }
    }
}
