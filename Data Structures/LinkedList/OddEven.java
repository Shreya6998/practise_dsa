package LinkedList;

import LinkedList.LinkedList.Node;

public class OddEven {

    public static void main(String[] args) {
        // Create list: 1 → 2 → 3 → 4 → 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head = oddEvenList(head);

        printList(head);
    }

    private static Node oddEvenList(Node head) {
        if (head == null) return null;
        Node pO = head, pE = head.next;
        Node headE = head.next;
        while(pE != null && pE.next != null) {
            //rewire pointers
            pO.next = pE.next;
            pE.next = pE.next.next;

            // move 2 steps
            pO = pO.next;
            pE = pE.next;
        }
        pO.next = headE;
        return head;
    }

    private static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
