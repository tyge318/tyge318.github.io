public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if( matrix.length == 0 )
            return ans;
        int left = -1, right = matrix[0].length, top = -1, bottom = matrix.length;
        int count = 0, i = 0, j = 0;
        int increment = 1;
        boolean horizontal = true;
        while( !((right - left <= 2) && (bottom - top <= 2)) && (j>left && j<right) && (i>top && i<bottom) )  {
            //System.out.println("i = " + i + "; j = "+ j);
            ans.add(matrix[i][j]);
            if( horizontal) {
                j += increment;
                if( j == left || j == right) {
                    horizontal = false;
                    if( j == right ) {
                        top += increment;
                        //System.out.println("top = " + top);
                    }
                    else {
                        bottom += increment;
                        //System.out.println("bottom = " + bottom);
                    }
                    j -= increment;
                    i += increment;

                }
            }
            else {
                i += increment;
                if( i == top || i == bottom) {
                    horizontal = true;
                    if( i == bottom ) {
                        right -= increment;
                        //System.out.println("right = " + right);
                    }
                    else {
                        left -= increment;
                        //System.out.println("left = " + left);
                    }
                    i -= increment;
                    j -= increment;
                    increment *= -1;
                }
                
            }
        }
        if( (j>left && j<right) && (i>top && i<bottom) )
            ans.add(matrix[i][j]);
        return ans;
    }
}