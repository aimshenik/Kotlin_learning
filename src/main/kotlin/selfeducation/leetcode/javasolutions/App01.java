package selfeducation.leetcode.javasolutions;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

//https://leetcode.com/problems/add-two-numbers/
public class App01 {
    static ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    static ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
    static ListNode l3 = new ListNode(7, new ListNode(0, new ListNode(8)));

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(l1, l2).equals(l3) ?
                "CORRECT" : "INCORRECT");

        ListNode j1 = ListNode.of(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1);
        ListNode j2 = ListNode.of(5, 6, 4);
        System.out.println(j1.toString());
        System.out.println(j2.toString());

        System.out.println(addTwoNumbers2(j1, j2));
        System.out.println(addTwoNumbers3(j1, j2));
    }

    private static void ptintListNode(ListNode l) {
        StringBuilder accumulator = new StringBuilder();
        do {
            accumulator.append(l.val + " -> ");
            l = l.next;
        } while (l != null);
        System.out.println(accumulator);
    }

    private static String addTwoNumbers2(ListNode l1, ListNode l2) {
        return Stream.of(Stream.of(l1, l2)
                .map(ListNode::toStringBuilder)
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO, BigInteger::add).toString())
                .map(StringBuilder::new)
                .map(StringBuilder::reverse).reduce(new StringBuilder(), StringBuilder::append).toString();

//        return null;
    }

    private static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        return Stream.of(Stream.of(l1, l2)
                .map(it -> {
                    StringBuilder accumulator = new StringBuilder();
                    do {
                        accumulator.append(it.val);
                        it = it.next;
                    } while (it != null);
                    return accumulator;
                })
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .map(BigInteger::new)
                .reduce(BigInteger.ZERO,BigInteger::add).toString())
                .map(StringBuilder::new)
                .map(StringBuilder::reverse).map(it -> Arrays.stream(it
                        .toString()
                        .split(""))
                        .map(Integer::valueOf)
                        .map(ListNode::new)
                        .reduce(null, (a, b) -> {
                                    if (a == null) return b;
                                    ListNode tail = a;
                                    while (a.next != null) {
                                        a = a.next;
                                    }
                                    a.next = b;
                                    return tail;
                                }
                        ))
                .findFirst().get();
    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return Arrays.stream(new StringBuilder(Stream.of(l1, l2)
                .map(it -> {
                    int i = 0;
                    BigInteger accumulator = BigInteger.ZERO;
                    do {
                        accumulator = BigInteger.valueOf((long) (it.val * Math.pow(10, i++))).add(accumulator);
                        it = it.next;
                    } while (it != null);
                    return accumulator;
                })
                .reduce(BigInteger.ZERO, BigInteger::add).toString())
                .reverse().toString().split(""))
                .map(Integer::valueOf)
                .map(ListNode::new)
                .reduce(null, (a, b) -> {
                    if (a == null) return b;
                    ListNode tail = a;
                    while (a.next != null) {
                        a = a.next;
                    }
                    a.next = b;
                    return tail;
                });
    }
}


// * Definition for singly-linked list.
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

    @Override
    public String toString() {
        StringBuilder accumulator = new StringBuilder();
        ListNode tail = this;
        do {
            accumulator.append(tail.val);
            tail = tail.next;
        } while (tail != null);
        return accumulator.toString();

    }

    public StringBuilder toStringBuilder() {
        StringBuilder accumulator = new StringBuilder();
        ListNode tail = this;
        do {
            accumulator.append(tail.val);
            tail = tail.next;
        } while (tail != null);
        return accumulator;

    }

    public static ListNode of(int... vars) {
        return Arrays.stream(vars)
                .mapToObj(ListNode::new)
                .reduce(null, (a, b) -> {
                    if (a == null) return b;
                    ListNode tail = a;
                    while (a.next != null) {
                        a = a.next;
                    }
                    a.next = b;
                    return tail;
                });
    }
}