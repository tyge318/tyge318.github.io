public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=nums.length-1; i>=0; i--) {
            if( map.containsKey(target - nums[i]) )
                return (new int[]{i, map.get(target-nums[i])});
            map.put(nums[i], i);
        }
        return null;
    }
}