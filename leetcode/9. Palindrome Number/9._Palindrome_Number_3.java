class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 )
            return false;
        ArrayList<Integer> digits = new ArrayList<Integer>();
        while( x > 0 ) {
            digits.add( x % 10 );
            x /= 10;
        }
        int length = digits.size();
        int left = 0, right = length-1;
        while( left < right ) {
            if( digits.get(left) != digits.get(right) )
                return false;
            left++;
            right--;
        }
        return true;
    }
}