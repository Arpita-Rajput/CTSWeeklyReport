package com.arpita.week1.javadsa;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> q = new ArrayDeque<>();
        q.add("a"); q.add("b"); q.add("c");
        System.out.println("Queue poll: " + q.poll());
    }
}
