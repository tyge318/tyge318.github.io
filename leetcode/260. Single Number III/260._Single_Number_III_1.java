public class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Boolean> track = new HashMap<Integer, Boolean>();
        for(int i=0; i<nums.length; i++) {
            Integer temp = new Integer(nums[i]);
            if(track.containsKey(temp)) {
                track.put(temp, !track.get(temp));
            }
            else {
                track.put(temp, true);
            }
        }
        int[] output = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Boolean> entry : track.entrySet()) {
            if(!entry.getValue())
                continue;
            else {
                output[index++] = entry.getKey();
            }
        }
        return output;
    }
}