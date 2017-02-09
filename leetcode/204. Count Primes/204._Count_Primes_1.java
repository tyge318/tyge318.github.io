public class Solution {
    public int countPrimes(int n) {
        if(n<1)
            return 0;
        boolean[] flag = new boolean[n+1];
        flag[0] = true;
        flag[1] = true;
        for(int i=2; i*i<n; i++) {
            if(flag[i])
                continue;
            int c = i*i;
            while(c < n) {
                flag[c] = true;
                c += i;
            }
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!flag[i])
                count++;
        }
        return count;
    }
}