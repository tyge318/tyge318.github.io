public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length, col = (row == 0) ? 0 : matrix[0].length;
        int[][] heights = new int[row][col+1];
        
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if( matrix[i][j] == '0')
                    heights[i][j] = 0;
                else
                    heights[i][j] = (i == 0) ? 1 : heights[i-1][j]+1;
            }
        }
        
        //System.out.println(Arrays.deepToString(heights) );
        int max = 0;
        for(int i=0; i<heights.length; i++) 
            max = Math.max(max, largestRectangleArea(heights[i]) );
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        List<Integer> hs = new ArrayList<Integer>();
        for(int i=0; i<heights.length; i++)
            hs.add(heights[i]);
        hs.add(0);
        
        Stack<Integer> st = new Stack<Integer>();   //stores the left boundary pos for undetermined rectangles
        int max = 0, h = 0, w = 0;
        for(int i=0; i<hs.size(); i++) {
            if( st.isEmpty() || hs.get(i) > hs.get(st.peek()) ) //create an undetermined rectangle start with pos i
                st.push(i);
            else { 
                while( !st.isEmpty() && hs.get(i) <= hs.get(st.peek()) ) { //finish all undetermined area calculation and find max.
                    h = hs.get(st.pop());
                    w = (st.isEmpty() ? i : i-1-st.peek());
                    max = Math.max(max, h*w);
                }
                st.push(i); //create an undetermined rectangle start with pos i
            }
        }
        return max;
    }
}