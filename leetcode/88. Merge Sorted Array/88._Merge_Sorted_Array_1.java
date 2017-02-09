public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1, p1 = m-1, p2 = n-1;
        while(p2>=0) {
            nums1[k--] = (p1 >= 0 && nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
    }
}