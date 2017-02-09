public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( nums == null || nums.length == 0 || k < 0 || t < 0)
            return false;
        
        TreeSet<Long> visited = new TreeSet<Long>();
        for(int i=0; i<nums.length; i++) {
            long current = (long)nums[i];
            
            long left = current-t;
            long right = current+t+1;
            SortedSet<Long> subset = visited.subSet(left, right);
            
            if( subset.size() > 0)
                return true;
            visited.add(current);
            if( visited.size() > k)
                visited.remove((long)nums[i-k]);
        }
        return false;
    }
}