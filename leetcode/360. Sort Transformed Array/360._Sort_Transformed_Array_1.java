public class Solution {
    int a, b, c;
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length;
        int[] ans = new int[n];
        this.a = a;
        this.b = b;
        this.c = c;
        
        int left = 0, right = n-1;
        int index = (a >= 0) ? n-1: 0;
        while( left <= right) {
            if( a >= 0 )
                ans[index--] = f(nums[left]) >= f(nums[right]) ? f(nums[left++]) : f(nums[right--]);
            else
                ans[index++] = f(nums[left]) >= f(nums[right]) ? f(nums[right--]) : f(nums[left++]);
        }
        return ans;
    }
    public int f(int x) {
        return a*x*x+b*x+c;
    }
}