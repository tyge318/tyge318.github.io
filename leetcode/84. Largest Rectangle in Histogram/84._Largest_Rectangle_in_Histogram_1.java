public class Solution {
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