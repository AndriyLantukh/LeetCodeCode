package com.lantukh;

import java.util.*;
import java.util.stream.Collectors;

public class MergeKSortedLists {


    public static void getSolution() {

        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;

        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;

        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        node31.next = node32;

        ListNode[] arr = {node11, node21, node31};

        ListNode solution = mergeKLists(arr);
        System.out.println(solution);

        String s = Integer.toBinaryString(4);
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        sortMin(lists);

        ListNode result = lists[0];
        ListNode resultPointer = null;

        while (lists[0] != null) {

            if (resultPointer != null) {
                resultPointer.next = lists[0];
            }
            resultPointer = lists[0];
            lists[0] = lists[0].next;
            sortMin(lists);
        }
        return result;
    }

    public static void sortMin(ListNode[] lists) {
        for (int i = lists.length - 1; i > 0; i--) {
            if (lists[i] != null && lists[i - 1] == null) {
                lists[i - 1] = lists[i];
                lists[i] = null;
            } else if (lists[i] != null && lists[i].val < lists[i - 1].val) {
                ListNode temp = lists[i - 1];
                lists[i - 1] = lists[i];
                lists[i] = temp;
            }
        }
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
