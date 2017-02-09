public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int[] array = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        
        HashSet<String> vertices = new HashSet<String>();
        
        long areaSum = 0;
        for(int i=0; i<rectangles.length; i++) {
            array[0] = Math.min(array[0], rectangles[i][0]);
            array[1] = Math.min(array[1], rectangles[i][1]);
            array[2] = Math.max(array[2], rectangles[i][2]);
            array[3] = Math.max(array[3], rectangles[i][3]);
            areaSum += calculateArea(rectangles[i]);
            String[] fourVertices = getVertices(rectangles[i]);
            for(String vertex: fourVertices) {
                if( vertices.contains(vertex) ) 
                    vertices.remove(vertex);
                else
                    vertices.add(vertex);
            }
        }
        for(String vertex: getVertices(array)) {
            if( vertices.contains(vertex) )
                vertices.remove(vertex);
            else
                return false;
        }
        return (vertices.isEmpty() && areaSum == calculateArea(array));
        
    }
    public String[] getVertices(int[] rect) {
        String[] ans = new String[4];
        ans[0] = String.valueOf(rect[0])+","+String.valueOf(rect[1]);
        ans[1] = String.valueOf(rect[2])+","+String.valueOf(rect[1]);
        ans[2] = String.valueOf(rect[2])+","+String.valueOf(rect[3]);
        ans[3] = String.valueOf(rect[0])+","+String.valueOf(rect[3]);
        return ans;
    }
    public long calculateArea(int[] rect) {
        long xSide = (long)rect[2] - (long)rect[0];
        long ySide = (long)rect[3] - (long)rect[1];
        return (xSide*ySide);
    }
}