public class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        public Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
        public Node() {
            this.key = 0;
            this.value = 0;
        }
    }
    int capacity, count;
    Map<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if( !map.containsKey(key) ) return -1;
        Node target = map.get(key);
        update(target);
        return target.value;
    }
    
    public void set(int key, int value) {
        Node n;
        if( !map.containsKey(key) ) {
            n = new Node(key, value);
            map.put(key, n);
            add(n);
        }
        else {
            n = map.get(key);
            n.value = value;
            update(n);
        }
        if( count > capacity) {
            Node oldest = tail.prev;
            remove(oldest);
            map.remove(oldest.key);
        }
    }
    public void update(Node n) {
        remove(n);
        add(n);
    }
    public void remove(Node n) {
        Node before = n.prev, after = n.next;
        before.next = after;
        after.prev = before;
        count--;
    }
    public void add(Node n) {
        Node after = head.next;
        head.next = n;
        n.next = after;
        after.prev = n;
        n.prev = head;
        count++;
    }
}