public class Solution {
    int[] nums;
    int[] current;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.current = Arrays.copyOf(nums, nums.length);
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.current = Arrays.copyOf(nums, nums.length);
        return this.current;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = current.length;
        for(int i=0; i<len; i++) {
            int j = random.nextInt(len-i);
            int hold = current[i];
            current[i] = current[i+j];
            current[i+j] = hold;
        }
        return current;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */