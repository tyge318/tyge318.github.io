class Solution {
    int m, n;
    public int minArea(char[][] image, int x, int y) {
        m = image.length;
        n = (m == 0) ? 0: image[0].length;
        int[] bounds = {m-1, 0, n-1, 0};
        dfs(image, x, y, bounds);
        //System.out.println(Arrays.toString(bounds));
        return (bounds[1]-bounds[0]+1)*(bounds[3]-bounds[2]+1);
    }
    public void dfs(char[][] image, int x, int y, int[] bounds) {
        if( x < 0 || x >= m || y < 0 || y >= n) return; 
        if( image[x][y] == '0') return;
        image[x][y] = '0';
        
        if( x < bounds[0])  bounds[0] = x;
        if( x > bounds[1])  bounds[1] = x;
        if( y < bounds[2])  bounds[2] = y;
        if( y > bounds[3])  bounds[3] = y;
        
        dfs(image, x+1, y, bounds);
        dfs(image, x-1, y, bounds);
        dfs(image, x, y-1, bounds);
        dfs(image, x, y+1, bounds);
    }
}