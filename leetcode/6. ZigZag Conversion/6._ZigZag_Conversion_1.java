public class Solution {
    public String convert(String s, int numRows) {
        if( numRows == 1 || numRows >= s.length() )
            return s;
        List<List<Character>> matrix = new ArrayList<List<Character>>();
        for(int i=0; i<numRows; i++)
            matrix.add(new ArrayList<Character>() );
        
        int rowIndex = 0, dx = 1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            matrix.get(rowIndex).add(c);
            if( rowIndex == 0)
                dx = 1;
            else if( rowIndex == numRows-1)
                dx = -1;
            rowIndex += dx;
        }
        StringBuilder sb = new StringBuilder();
        for(List<Character> l: matrix) {
            for(char c: l) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}