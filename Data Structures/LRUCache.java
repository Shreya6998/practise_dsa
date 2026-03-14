import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class Node {
        Integer key;
        Integer value;
        Node prev;
        Node next;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    int maxCapacity;
    int currCapacity;
    Node head, tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.maxCapacity = capacity;
        this.currCapacity = 0;
        head = new Node(null,null);
        tail = new Node(null,null);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            //Remove node
            removeNode(node);

            //Move node after head
            moveNodeAfterHead(node);

            //Return value
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            //Update value
            Node node = cache.get(key);
            node.value = value;

            //Remove node
            removeNode(node);

            //Move node after head
            moveNodeAfterHead(node);

        } else {
            if (cache.size() == maxCapacity) {
                Node toRemove = tail.prev;

                //Remove node
                removeNode(toRemove);

                //Remove entry from cache
                cache.remove(toRemove.key);
            }

            //Create new node
            Node node = new Node(key, value);

            //Move node after head
            moveNodeAfterHead(node);

            //Add to cache
            cache.put(key, node);
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveNodeAfterHead(Node node) {
        node.next = head.next;
        node.prev = head;
        node.next.prev = node;
        node.prev.next = node;
    }

    public static void main(String[] args) {
        System.out.println("Test 1");
        LRUCache cache1 = new LRUCache(2);

        cache1.put(1,1);
        cache1.put(2,2);

        System.out.println(cache1.get(1)); // expected 1

        cache1.put(3,3); // evicts 2

        System.out.println(cache1.get(2)); // expected -1

        cache1.put(4,4); // evicts 1

        System.out.println(cache1.get(1)); // expected -1
        System.out.println(cache1.get(3)); // expected 3
        System.out.println(cache1.get(4)); // expected 4


        System.out.println("\nTest 2");

        LRUCache cache2 = new LRUCache(1);

        cache2.put(1,10);
        System.out.println(cache2.get(1)); // 10

        cache2.put(2,20); // evicts 1

        System.out.println(cache2.get(1)); // -1
        System.out.println(cache2.get(2)); // 20


        System.out.println("\nTest 3");

        LRUCache cache3 = new LRUCache(2);

        cache3.put(1,100);
        cache3.put(2,200);

        cache3.put(1,300); // update existing

        System.out.println(cache3.get(1)); // 300
        System.out.println(cache3.get(2)); // 200


        System.out.println("\nTest 4");

        LRUCache cache4 = new LRUCache(2);

        cache4.put(2,1);
        cache4.put(1,1);

        cache4.put(2,3); // update

        cache4.put(4,1); // evict 1

        System.out.println(cache4.get(1)); // -1
        System.out.println(cache4.get(2)); // 3
    }
}
