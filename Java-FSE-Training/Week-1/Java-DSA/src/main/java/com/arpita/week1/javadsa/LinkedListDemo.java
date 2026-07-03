package com.arpita.week1.javadsa;

public class LinkedListDemo {
    static class Node { int val; Node next; Node(int v){val=v;} }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node cur = head;
        System.out.print("LinkedList: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
