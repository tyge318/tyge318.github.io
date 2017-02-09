public class Solution {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int sum = 0, carry = 0;
        for(int i=digits.length-1; i>=0; i--) {
            sum = (carry + digits[i]);
            if( i == digits.length-1)
                sum += 1;
            temp.add( sum % 10);
            carry = sum / 10;
        }
        if( carry == 1)
            temp.add(carry);
        int[] ans = new int[temp.size()];
        int index = 0;
        for(int i=temp.size()-1; i>=0; i--) {
            ans[index] = temp.get(i);
            index++;
        }
        return ans;
    }
}