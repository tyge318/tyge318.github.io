public class Solution {
    public int jump(int[] nums) {
        int last = 0, current = 0, count = 0, len = nums.length;
        for(int i=0; i<len; i++) {
            if(last < i) {
                last = current;
                count++;
            }
            current = current < i + nums[i] ? i + nums[i] : current;
        }
        return count;
    }
}