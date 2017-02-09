public class Solution {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> track = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
            Integer temp = new Integer(nums[i]);
            if( track.contains(temp) )
                track.remove(temp);
            else
                track.add(temp);
        }
        int[] output = new int[track.size()];
        for(int i=0; i<output.length; i++)
            output[i] = track.get(i).intValue();
        return output;
    }
}