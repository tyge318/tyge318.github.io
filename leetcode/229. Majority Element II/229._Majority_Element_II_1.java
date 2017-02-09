public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        Integer a = null, b = null;
        int count_a = 0, count_b = 0;
        for(int i: nums) {
            if( a != null && i == a.intValue() )
                count_a++;
            else if( b != null && i == b.intValue() )
                count_b++;
            else if( count_a == 0) {
                a = i;
                count_a = 1;
            }
            else if( count_b == 0) {
                b = i;
                count_b = 1;   
            }
            else {
                count_a--;
                count_b--;
            }
        }
        count_a = count_b = 0;
        for(int i: nums) {
            if( i == a.intValue() )
                count_a++;
            else if( i == b.intValue() )
                count_b++;
        }
        if( count_a > nums.length/3)
            ans.add(a);
        if( count_b > nums.length/3)
            ans.add(b);
        return ans;
    }
}