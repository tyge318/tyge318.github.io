public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<String>();
        List<String> line = new ArrayList<String>();
        int lineWidth = 0;
        for(int i=0; i<words.length; i++) {
            String current = words[i];
            if( lineWidth == 0 ) {
                line.add(current);
                lineWidth += current.length();
            }
            else if ( lineWidth + current.length()+1 <= maxWidth) {
                line.add(current);
                lineWidth += (1+current.length());
            }
            else {
                ans.add(adjustLine(line, lineWidth, maxWidth, false) );
                line = new ArrayList<String>();
                lineWidth = 0;
                i--;
            }
        }
        if(lineWidth > 0 || !line.isEmpty() ) {
            System.out.println("~"+lineWidth+";"+maxWidth);
            ans.add(adjustLine(line, lineWidth, maxWidth, true) );
        }
        return ans;
    }
    public String adjustLine(List<String> line, int lineWidth, int maxWidth, boolean lastLine) {
        int sep = line.size()-1;
        StringBuilder temp = new StringBuilder();
        if( sep > 0 ) {
            if(!lastLine) {
                int spaceCount = (maxWidth - lineWidth) + sep;
                System.out.println("space count=" + spaceCount);
                int spaceEach = spaceCount / sep;
                int remainder = spaceCount % sep;
                for(int i=0; i<line.size(); i++) {
                    temp.append(line.get(i) );
                    if( i == line.size()-1 )
                        break;
                    for(int j=0; j<spaceEach; j++)
                        temp.append(' ');
                    if( remainder > 0) {
                        temp.append(' ');
                        remainder--;
                    }
                }
            }
            else {
                for(int i=0; i<line.size(); i++) {
                    temp.append(line.get(i) );
                    if( i == line.size()-1 )
                        break;
                    temp.append(' ');
                }
            }
        }
        else {
            temp.append(line.get(0));
        }
        
        while( temp.length() < maxWidth) {
            temp.append(' ');
        }
        return temp.toString();
    }
}