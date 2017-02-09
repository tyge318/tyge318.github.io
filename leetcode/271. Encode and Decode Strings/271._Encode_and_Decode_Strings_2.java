public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append('@').append(s);
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<String>();
        while( !s.isEmpty() ) {
            int atIndex = s.indexOf("@");
            int len = (atIndex > 0) ? Integer.parseInt(s.substring(0, atIndex)) : 0;
            if( len > 0 )
                ans.add(s.substring(atIndex+1, atIndex+1+len) );
            else
                ans.add("");
            s = s.substring(atIndex+1+len );
        }
        return ans;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));