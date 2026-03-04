package LinkedList;

import LinkedList.LinkedList.Node;

public class RemoveNthNode {

    public static void main(String[] args) {
        // Create list: 1 → 2 → 3 → 4 → 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int n = 2;

        head = removeNthFromEnd(head, n);

        printList(head);
    }

    private static Node removeNthFromEnd(Node head, int n) {
        if (head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;

        Node slow = dummy, fast = head;
        int i = 1;
        while( fast != null && i <= n ) {
            fast = fast.next;
            i++;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
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

