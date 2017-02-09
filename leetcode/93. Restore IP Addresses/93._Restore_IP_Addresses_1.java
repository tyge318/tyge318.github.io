public class Solution {
    public List<String> restoreIpAddresses(String s) {
        return generate(s, 1, 0, s.length()-1);
    }
    public List<String> generate(String s, int part, int begin, int end) {
        List<String> ans = new ArrayList<String>();
        if( part <= 3) {
            for(int i=1; i<=3; i++) {
                if( begin+i >= s.length() )
                    break;
                String head = s.substring(begin, begin+i);
                List<String> subans = generate(s, part+1, begin+i, end);
                if( subans.size() == 0 )
                    continue;
                if( head.length() >=2 && head.length() <= 3 && head.charAt(0) == '0')
                    continue;
                if( (new Integer(head)) > 255 )
                    continue;
                for(int j=0; j<subans.size(); j++)
                    ans.add(head+"."+subans.get(j) );
            }
        }
        else{ //part == 4
            if( end-begin+1 > 3 || begin > end)
                return ans;
            String current = s.substring(begin, end+1);
            if( current.length() >= 2 && current.length() <= 3 && current.charAt(0) == '0')
                return ans;
            if( (new Integer(current)) > 255 )
                return ans;
            ans.add(current);
        }
        return ans;
    }
}