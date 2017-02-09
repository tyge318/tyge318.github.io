public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        List<Integer> temp = new ArrayList<Integer>();
        int left = 0, right = nums.length-1;
        if( a == 0) {
            for(int i: nums) {
                temp.add(b*i+c);
            }
            if( b < 0)
                Collections.reverse(temp);
        }
        else {
            //find symmetric axis
            double sx = -((double)b/(2*a));
            while( left <= right) {
                int x1 = nums[left], x2 = nums[right];
                if( Math.abs((double)x1-sx) >= Math.abs((double)x2-sx) ) {
                    temp.add(a*x1*x1+b*x1+c);
                    left++;
                }
                else {
                    temp.add(a*x2*x2+b*x2+c);
                    right--;
                }
            }
            if( a > 0 )
                Collections.reverse(temp);
        }
        int[] ans = new int[nums.length];
        for(int i=0; i<ans.length; i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }
}