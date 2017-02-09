public class Solution {
    public String countAndSay(int n) {
        ArrayList<String> seq = new ArrayList<String>();
        seq.add("1");
        while( seq.size() != n) {
            String toRead = seq.get(seq.size()-1);
            String readOut = read(toRead);
            seq.add(readOut);
        }
        return seq.get(seq.size()-1);
    }
    public String read(String s) {
        StringBuilder temp = new StringBuilder();
        int counter = 1;
        char lastChar = s.charAt(0);
        for(int i=1; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == lastChar)
                counter++;
            else {
                temp.append(counter);
                temp.append(lastChar);
                lastChar = cc;
                counter = 1;
            }
        }
        temp.append(counter);
        temp.append(lastChar);
        return temp.toString();
    }
}