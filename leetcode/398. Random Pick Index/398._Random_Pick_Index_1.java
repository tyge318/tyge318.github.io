public class Solution {
    //Map<Integer, List<Integer>> map;
    int[] nums;
    int cachedId;
    List<Integer> candidates;
    Random random = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        this.cachedId = Integer.MIN_VALUE;
        candidates = new ArrayList<Integer>();
    }
    
    public int pick(int target) {
        if( cachedId != target ) {
            cachedId = target;
            candidates.clear();
            for(int i=0; i<nums.length; i++) {
                if( nums[i] == target) {
                    candidates.add(i);
                }
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