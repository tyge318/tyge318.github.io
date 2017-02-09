public class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0, right = num.length()-1;
        while( left <= right) {
            char cl = num.charAt(left);
            char cr = num.charAt(right);
            if( cl == cr && !(cl == '0' || cl == '1' || cl == '8') )    return false;
            if( cl != cr && !((cl == '6' && cr == '9') || (cl == '9' && cr == '6')) )   return false;
            left++;
            right--;
        }
        return true;
    }
}