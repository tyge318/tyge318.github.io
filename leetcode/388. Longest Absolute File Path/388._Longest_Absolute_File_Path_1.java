public class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] trace = new int[lines.length+1];
        int ans = 0;
        for(String s: lines) {
            //System.out.printf("Current line = %s\n", s);
            int level = s.lastIndexOf("\t")+1;
            int curLen = trace[level]+s.length()-level+1;
            trace[level+1] = curLen;
            if(s.contains(".") )
                ans = Math.max(ans, curLen-1);
            //System.out.println("trace = " + Arrays.toString(trace));
            //System.out.printf("level = %d, curLen = %d\n", level, curLen);
        }
        return ans;
    }
}