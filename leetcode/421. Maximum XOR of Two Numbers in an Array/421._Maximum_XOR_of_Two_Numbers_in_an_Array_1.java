public class Solution {
    public int findMaximumXOR(int[] nums) {
        int ans = 0, mask = 0;
        for(int i=31; i>=0; i--) {
            mask = mask | (1 << i);
            Set<Integer> candidates = new HashSet<Integer>();
            for(int j: nums)
                candidates.add(j & mask);
            int temp = ans | (1 << i);
            for(int pre: candidates) {
                if( candidates.contains(temp ^ pre) ) {
                    ans = temp;
                    break;
                }
            }
        }
        return ans;
    }
}