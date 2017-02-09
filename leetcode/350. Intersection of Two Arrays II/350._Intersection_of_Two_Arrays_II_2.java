import java.util.Arrays;
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if(nums1.length < nums2.length)
            return process(nums1, nums2);
        else
            return process(nums2, nums1);
    }
    public int[] process(int[] nums1, int[] nums2) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=0, j=0; i<nums2.length; i++) {
            while(j < nums1.length && nums1[j] < nums2[i]) {
                j++;
            }
            if(j >= nums1.length)
                break;
            if(nums1[j] == nums2[i]) {
                temp.add(nums1[j]);
                j++;
            }
            else
                continue;
        }
        int i=0;
        int[] output = new int[temp.size()];
        for(Integer item: temp)
            output[i++] = item;
        return output;
    }
}