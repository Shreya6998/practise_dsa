package LinkedList;

import LinkedList.LinkedList.Node;

public class Intersection {

    public static void main(String[] args) {
        // Shared part
        Node intersect = new Node(7);
        intersect.next = new Node(8);

        // List A: 1 -> 2 -> 3 -> 7 -> 8
        Node headA = new Node(1);
        headA.next = new Node(2);
        headA.next.next = new Node(3);
        headA.next.next.next = intersect;

        // List B: 4 -> 5 -> 7 -> 8
        Node headB = new Node(4);
        headB.next = new Node(5);
        headB.next.next = intersect;

        Node result = getIntersectionNode(headA, headB);

        if (result != null) {
            System.out.println("Intersection at node with value: " + result.data);
        } else {
            System.out.println("No intersection");
        }
    }

    private static Node getIntersectionNode(Node headA, Node headB) {
        Node pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB:pA.next;
            pB = pB == null ? headA:pB.next;
        }
        return pA;
    }
}

