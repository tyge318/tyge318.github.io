public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append("@"+s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        while( !s.isEmpty() ) {
            int atIndex = s.indexOf("@");
            int len = Integer.valueOf(s.substring(0, atIndex) );
            if( len > 0 )
                ans.add(s.substring(atIndex+1, atIndex+len+1) );
            else
                ans.add("");
            s = s.substring(atIndex+len+1);
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));