public class Solution {
    public int numWays(int n, int k) {
        if(n == 0)  return 0;
        if(n == 1)  return k;
        int same = k, diff = k*(k-1);
        for(int i=3; i<=n; i++) {
            int prevSame = same;
            same = diff*1;    //current same has no choice but 1, which makes previous two fences need to be different
            diff = (prevSame+diff)*(k-1); //current different just need to be different with previous, so previous has two choices.
        }   
        return same+diff;
    }
}