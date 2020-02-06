package com.lantukh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwapNodesInKGroup {


    public static void getSolution() {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
//        ListNode node13 = new ListNode(3);
//        ListNode node14 = new ListNode(4);
//        ListNode node15 = new ListNode(5);


        node11.next = node12;
//        node12.next = node13;
//        node13.next = node14;
//        node14.next = node15;


        ListNode solution = reverseKGroup(node11, 3);
        System.out.println(solution);

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        List<ListNode> nodes = new ArrayList();
        ListNode pointer = head;

        while (pointer != null) {
            ListNode tmp = pointer.next;
            pointer.next = null;
            nodes.add(pointer);
            pointer = tmp;
        }

        int size = nodes.size();

        if(size >= k) {
            for (int i = 0; i + k <= size; i += k) {
                Collections.reverse(nodes.subList(i, i + k));
            }
        }

        ListNode newHead = nodes.get(0);
        pointer = newHead;

        for(int i = 1; i < size; i++) {
            pointer.next = nodes.get(i);
            pointer = pointer.next;
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
