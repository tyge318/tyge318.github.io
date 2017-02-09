public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<String>();
        long[] array = new long[nums.length+2];
        array[0] = (long)lower-1;
        for(int i=0; i<nums.length; i++)
            array[i+1] = nums[i];
        array[array.length-1] = (long)upper+1;
        
        for(int i=1; i<array.length; i++) {
            long diff = array[i] - array[i-1];
            if( diff <= 1 )
                continue;
            else if (diff == 2)
                ans.add(String.valueOf(array[i]-1) );
            else {
                long begin = array[i-1]+1, end = array[i]-1;
                ans.add(String.format("%s->%s", begin, end) );
            }
        }
        return ans;
    }
}