import java.math.BigInteger;
public class Solution {
    public int firstMissingPositive(int[] nums) {
        BigInteger trace = BigInteger.ONE;
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
            if( nums[i] <= 0 )
                continue;
            BigInteger temp = BigInteger.ONE;
            temp = temp.shiftLeft(nums[i]);
            trace = trace.or(temp);
        }
        while( trace.testBit(0) ) {
            trace = trace.shiftRight(1);
            ans++;
        }
        return ans;
    }

}