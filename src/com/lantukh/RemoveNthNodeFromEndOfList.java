package com.lantukh;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void getSolution() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;

        int number = 1;

        ListNode solution = removeNthFromEnd(node1, number);
        System.out.println(solution);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null && n == 1) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();

        ListNode listNode = head;
        nodes.add(listNode);
        while (listNode.next != null) {
            listNode = listNode.next;
            nodes.add(listNode);
        }

        int size = nodes.size();

        int indexPrew = size - n - 1;
        int indexNext = size - n + 1;

        if (indexPrew < 0) {
            head = head.next;
        } else if (indexNext == size) {
            nodes.get(indexPrew).next = null;
        } else {
            nodes.get(indexPrew).next = nodes.get(indexNext);
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
