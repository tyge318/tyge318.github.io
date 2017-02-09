public class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes = 0;
        for(int i=0; i<nums.length; i++) {
            twos |= ones & nums[i]; //if nums[i] has appeared once and appears again, then this records it.
            ones ^= nums[i]; //if it's nums[i]'s first appearance, then this records it.
            threes = ones & twos; //if nums[i] appear twice and once, then it appears total of three times.
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}