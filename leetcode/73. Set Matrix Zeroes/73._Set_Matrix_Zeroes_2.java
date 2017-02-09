public class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rowID = new ArrayList<Integer>();
        List<Integer> colID = new ArrayList<Integer>();
        
        int row = matrix.length, col = matrix[0].length;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if( matrix[i][j] == 0) {
                    rowID.add(i);
                    colID.add(j);
                }
            }
        }
        
        for(int i=0; i<rowID.size(); i++) {
            int current = rowID.get(i);
            for(int j=0; j<col; j++)
                matrix[current][j] = 0;
            current = colID.get(i);
            for(int j=0; j<row; j++)
                matrix[j][current] = 0;
        }
    }
}