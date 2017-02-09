public class Solution {
    //Map<Integer, List<Integer>> map;
    int[] nums;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        List<Integer> candidates = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            if( nums[i] == target) {
                candidates.add(i);
            }
        }
        return candidates.get(random.nextInt(candidates.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */