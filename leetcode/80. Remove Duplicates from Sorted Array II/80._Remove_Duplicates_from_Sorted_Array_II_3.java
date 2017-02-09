public class Solution {
    public int removeDuplicates(int[] nums) {
        if( nums.length <= 2)
            return nums.length;
        TreeMap<Integer, Integer> counts = new TreeMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if( !counts.containsKey(nums[i]) )
                counts.put(nums[i], 1);
            else
                counts.put(nums[i], counts.get(nums[i])+1);
        }
        int index = 0;
        for(Integer key: counts.keySet()) {
            if( counts.get(key) == 1)
                nums[index++] = key;
            else {
                nums[index++] = key;
                nums[index++] = key;
            }
        }
        return index;
    }
}