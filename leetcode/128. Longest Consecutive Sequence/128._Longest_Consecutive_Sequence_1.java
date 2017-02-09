public class Solution {
    public int longestConsecutive(int[] nums) {
        if( nums.length == 0)
            return 0;
        
        HashSet<Integer> keep = new HashSet<Integer>();
        for(int i: nums)
            keep.add(i);
        
        int max = 1;
        for(int i: nums) {
            int left = i-1;
            int right = i+1;
            int count = 1;
            
            while( keep.contains(left) ) {
                keep.remove(left);
                left--;
                count++;
            }
            while( keep.contains(right) ) {
                keep.remove(right);
                right++;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}