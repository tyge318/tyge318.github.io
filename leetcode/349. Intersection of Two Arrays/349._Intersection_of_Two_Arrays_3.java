public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set1, set2;
        set1 = getIntegerTreeSet(nums1);
        set2 = getIntegerTreeSet(nums2);
        if(set2.size() < set1.size() ) {
            set1.retainAll(set2);
            return getIntArray(set1);
        }
        else {
            set2.retainAll(set1);
            return getIntArray(set2);
        }
    }
    public TreeSet<Integer> getIntegerTreeSet(int[] nums) {
        TreeSet<Integer> output = new TreeSet<Integer>();
        for(int i: nums)
            output.add(new Integer(i));
        return output;
    }
    public int[] getIntArray(TreeSet<Integer> set) {
        int i=0;
        int[] output = new int[set.size()];
        for(Integer item: set)
            output[i++] = item;
        return output;
    }
}