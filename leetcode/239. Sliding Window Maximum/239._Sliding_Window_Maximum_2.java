public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int qindex = 0;
        ArrayList<Integer> queue = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(nums.length == 0)
            return (new int[0]);
        for(int i=0; i+k <= nums.length; i++) {
            System.out.println("i = " + i);
            if(i == 0) {
                for(qindex = 0; qindex < k; qindex++) {
                    queue.add(nums[qindex]);
                }
                temp.add(Collections.max(queue));
            }
            else {
                //System.out.println("Before (qindex = " + qindex +"):"+getString(queue));
                qindex = qindex % k;
                queue.set(qindex, nums[i+k-1]);
                //System.out.println("After (qindex = " + qindex +"):"+getString(queue));
                qindex++;
                temp.add(Collections.max(queue));
            }
        }
        
        int[] output = new int[temp.size()];
        for(int i=0; i<output.length; i++)
            output[i] = temp.get(i).intValue();
        return output;
    }

}