public class RandomizedSet {
    Random random;
    Map<Integer, Integer> valueToIndex;
    Map<Integer, Integer> indexToValue;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new Random();
        valueToIndex = new HashMap<Integer, Integer>();
        indexToValue = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = !valueToIndex.containsKey(val);
        if( ans ) { //new value
            valueToIndex.put(val, valueToIndex.size());
            indexToValue.put(indexToValue.size(), val);
        }
        return ans;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean ans = valueToIndex.containsKey(val);
        if( ans ) { //existing value
            int targetIndex = valueToIndex.get(val);
            
            valueToIndex.remove(val);
            indexToValue.remove(targetIndex);
            
            if( valueToIndex.size() == 0 || targetIndex == valueToIndex.size())
                return true;
            
            //fix the hole: targetIndex = some value < valueToIndex.size()
            //=> move the last element to targetIndex
            int lastValue = indexToValue.get(valueToIndex.size());
            valueToIndex.put(lastValue, targetIndex);
            indexToValue.remove(indexToValue.size());
            indexToValue.put(targetIndex, lastValue);
        }
        return ans;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if( valueToIndex.isEmpty())
            return -1;
        
        int randomIndex = random.nextInt(indexToValue.size());
        return indexToValue.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */