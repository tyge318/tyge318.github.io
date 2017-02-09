public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] opt = new int[nums.length];
        int size = 0;
        for(int i: nums) {
            int j = Arrays.binarySearch(opt, 0, size, i);
            if( j < 0 )
                j = -(j+1);
            //System.out.printf("j = %d, opt(before) = %s; ", j, Arrays.toString(opt));
            opt[j] = i;
            if( j == size) {
                size++;
                //System.out.printf("size = %d; ", size);
            }
            //System.out.printf("opt(after) = %s\n", Arrays.toString(opt));
        }
        return size;
    }
}