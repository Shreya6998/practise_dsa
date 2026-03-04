package LinkedList;

class LinkedList {
    private Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public LinkedList(int[] arr) {
        Node current = null;
//        Node tail = null; // circular
        for (int i = arr.length - 1; i >= 0; i--) {
            Node node = new Node(arr[i]);
//            if (current == null) {tail = node;} // circular
            node.next = current;
            current = node;
        }
        head = current;
//        tail.next = head; //circular
    }

    public int findMiddle() {
        if (head == null) throw new RuntimeException("List is empty");
        Node slow = head, fast = head;
        while (fast != null  && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public boolean detectCycle() {
        if (head == null) { return false; }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(new int[]{10, 6, 38, 25, 67, 89, 48, 100, 37, 49});
        if (!list.detectCycle()) {
            System.out.println(list.findMiddle());
            list.reverse();
            list.printList();
            list.reverse();
            list.printList();
        } else {
            System.out.println("List is cyclic");
        }
    }
}
