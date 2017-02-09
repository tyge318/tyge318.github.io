public class AllOne {
    class Box{
        int val;
        Set<String> keys;
        Box pre, next;
        public Box(int val) {
            this.val = val;
            keys = new HashSet<>();
        }
    }
    Box head, tail;
    Map<Integer, Box> indexToBox;
    Map<String, Integer> keyToIndex;
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Box(Integer.MIN_VALUE);
        tail = new Box(Integer.MAX_VALUE);
        head.next = tail;
        tail.pre = head;
        indexToBox = new HashMap<>();
        keyToIndex = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if( keyToIndex.containsKey(key) )
            changeKey(key, 1);
        else {
            keyToIndex.put(key, 1);
            if( head.next.val != 1) 
                addNextBox(head, new Box(1) );
            head.next.keys.add(key);
            indexToBox.put(1, head.next);
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if( !keyToIndex.containsKey(key) )  return;
        int index = keyToIndex.get(key);
        if( index == 1) {
            keyToIndex.remove(key);
            boxRemoveKey(indexToBox.get(index), key);
        }
        else
            changeKey(key, -1);
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return tail.pre == head ? "": (String)tail.pre.keys.iterator().next();
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail? "": (String)head.next.keys.iterator().next();
    }
    
    public void changeKey(String key, int d) {
        int index = keyToIndex.get(key);
        keyToIndex.put(key, index+d);
        Box current = indexToBox.get(index);
        Box addBox;
        if( indexToBox.containsKey(index+d) )
            addBox = indexToBox.get(index+d);
        else {
            addBox = new Box(index+d);
            indexToBox.put(index+d, addBox);
            addNextBox( (d == 1 ? current: current.pre), addBox);
        }
        addBox.keys.add(key);
        boxRemoveKey(current, key);
        
    }
    public void boxRemoveKey(Box target, String key) {
        target.keys.remove(key);
        if( target.keys.isEmpty() ) {
            listRemoveBox(target);
            indexToBox.remove(target.val);
        }
    }
    public void listRemoveBox(Box target) {
        target.pre.next = target.next;
        target.next.pre = target.pre;
        target.next = null;
        target.pre = null;
    }
    public void addNextBox(Box a, Box b) {  //set a->b relation
        b.pre = a;
        b.next = a.next;
        a.next.pre = b;
        a.next = b;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */