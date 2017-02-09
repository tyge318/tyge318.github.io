public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<int[]> ans = new ArrayList<int[]>();
        k = Math.min(k, m*n);
        if( k == 0 )
            return ans;
        int[] indices = new int[nums1.length];
        
        while( k > 0 ) {
            int min = Integer.MAX_VALUE;
            int ptr = 0;
            for(int i=0; i<m; i++) {
                if( indices[i]<n && nums1[i]+nums2[indices[i]]<min ) {
                    ptr = i;
                    min = nums1[i] + nums2[indices[i]];
                }
            }
            int[] current = {nums1[ptr], nums2[indices[ptr]] };
            ans.add(current);
            indices[ptr]++;
            k--;
        }
        
        return ans;
    }
}