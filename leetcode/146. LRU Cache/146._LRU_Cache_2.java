public class LRUCache {
    Map<Integer, Integer> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity) {
            @Override 
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        if( cache.containsKey(key) ) {
            Integer ans = cache.get(key);
            cache.remove(key);
            cache.put(key, ans);
            //System.out.println("Operation: get key = " + key);
            //System.out.println(cache.toString() );
            return ans;
        }
        else {
            //System.out.println(cache.toString() );
            return -1;
        }
    }
    
    public void set(int key, int value) {
        //System.out.println("Operation: set (key, value) = (" + key + "," + value +")");
        if( cache.containsKey(key) )
            cache.remove(key);
        cache.put(key, value);
        //System.out.println(cache.toString() );
    }
}