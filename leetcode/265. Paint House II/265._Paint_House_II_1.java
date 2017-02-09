public class Solution {
    public int minCostII(int[][] costs) {
        if( costs == null || costs.length == 0)
            return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        List<Integer> min1Indices = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int tempMin1 = Integer.MAX_VALUE, tempMin2 = Integer.MAX_VALUE;
            List<Integer> tempIndices = new ArrayList<>();
            //System.out.println("i = " + i + "; min1Indices = " + min1Indices.toString());
            for(int j=0; j<k; j++) {
                int current;
                if( i == 0 ) 
                    current = costs[0][j];
                else {
                    if( min1Indices.size() == 1 && min1Indices.get(0) == j)
                        current = costs[i][j] + min2;
                    else
                        current = costs[i][j] + min1;
                }
                int temp = Math.min(tempMin1, current);
                if( tempMin1 == current) {
                    tempIndices.add(j);
                }
                else if( temp == current) {  //current is the minimum => previous tempMin1 becomes current tempMin2
                    tempMin2 = tempMin1;
                    tempMin1 = temp;
                    tempIndices.clear();
                    tempIndices.add(j);
                }
                else {  //tempMin1 is still the minimum => current might be current tempMin2
                    tempMin2 = Math.min(current, tempMin2);
                }
            }
            min1 = tempMin1;
            min2 = tempMin2;
            min1Indices = new ArrayList<Integer>(tempIndices);
            //System.out.printf("min1 = %d, min2 = %d\n", min1, min2);
        }
        return min1;
    }
}