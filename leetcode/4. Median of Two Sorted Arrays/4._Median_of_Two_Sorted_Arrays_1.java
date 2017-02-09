public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sum = nums1.length + nums2.length;
        if( sum % 2 == 1)
            return findKth(nums1, nums2, 0, 0, sum/2+1);
        else
            return ((findKth(nums1, nums2, 0, 0, sum/2) + findKth(nums1, nums2, 0, 0, sum/2+1))/2.0);
    }
    public double findKth(int[] a, int[] b, int aBegin, int bBegin, int k) {
        if( aBegin >= a.length)  //run out of a choices, kth is at array b
            return b[bBegin+k-1];
        if( bBegin >= b.length)  //run out of b choices, kth is at array a
            return a[aBegin+k-1];
        if( k == 1) //if k is 1, then choose the min of the two.
            return (double)Math.min(a[aBegin], b[bBegin]);
        
        //Do binary search.
        int midIndexA = aBegin+k/2-1, midIndexB = bBegin+k/2-1;
        
        int midA = (midIndexA < a.length) ? a[midIndexA]: Integer.MAX_VALUE;
        int midB = (midIndexB < b.length) ? b[midIndexB]: Integer.MAX_VALUE;
        
        if( midA < midB)
            return findKth(a, b, midIndexA+1, bBegin, k-k/2);
        else
            return findKth(a, b, aBegin, midIndexB+1, k-k/2);
    }
    
}