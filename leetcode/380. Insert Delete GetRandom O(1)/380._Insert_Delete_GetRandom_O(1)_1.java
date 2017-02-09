public class RandomizedSet {
    Random random;
    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if( map.containsKey(val) )  return false;
        int index = list.size();
        list.add(val);
        map.put(val, index);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if( !map.containsKey(val) ) return false;
        int index = map.get(val);
        int lastIndex = list.size()-1;
        if( index != lastIndex) {
            int last = list.get(lastIndex);
            list.set(index, last );
            map.put(last, index);
        }
        list.remove(lastIndex);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */