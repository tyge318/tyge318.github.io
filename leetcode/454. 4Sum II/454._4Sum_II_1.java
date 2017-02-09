public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> ABsums = new HashMap<>();
        Map<Integer, Integer> CDsums = new HashMap<>();
        
        int n = A.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if( ABsums.containsKey(A[i]+B[j]) )
                    ABsums.put(A[i]+B[j], ABsums.get(A[i]+B[j])+1 );
                else
                    ABsums.put(A[i]+B[j], 1);
                if( CDsums.containsKey(C[i]+D[j]) )
                    CDsums.put(C[i]+D[j], CDsums.get(C[i]+D[j])+1 );
                else
                    CDsums.put(C[i]+D[j], 1);
            }
        }
        int ans = 0;
        for(int i: ABsums.keySet()) {
            if( CDsums.containsKey(-i) )
                ans += ABsums.get(i)*CDsums.get(-i);
        }
        return ans;
    }
}