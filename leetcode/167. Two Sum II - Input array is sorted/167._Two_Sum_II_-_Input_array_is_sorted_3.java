public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int ans[] = new int[2];
        
        for(int i=0; i<numbers.length; i++) {
            int current = numbers[i];
            int remain = target-current;
            //System.out.println("Target = " + target + "; current = " + current + "; looking for " + remain);
            int temp;
            if( remain < current)
                temp = bsearch(numbers, 0, Math.max(i-1, 0), remain);
            else
                temp = bsearch(numbers, Math.min(i+1, numbers.length-1), numbers.length-1, remain);
            if( temp == -1) continue;
            if( i < temp) {
                ans[0] = i+1;
                ans[1] = temp+1;
            }
            else {
                ans[0] = temp+1;
                ans[1] = i+1;
            }
            break;
        }
        return ans;
    }
    public int bsearch(int[] nums, int begin, int end, int target) {
        while(begin <= end ) {
            int mid = (begin+end)/2;
            if( nums[mid] == target )
                return mid;
            if( nums[mid] < target )
                begin = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}