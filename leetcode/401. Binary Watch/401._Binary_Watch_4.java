public class Solution {
    Map<Integer, List<Integer>> dict;
    public List<String> readBinaryWatch(int num) {
        dict = new HashMap<Integer, List<Integer>>();
        
        //count bits
        for(int i=0; i<60; i++) {
            int key = countBits(i);
            List<Integer> values;
            if( dict.containsKey(key) )
                values = dict.get(key);
            else
                values = new ArrayList<Integer>();
            values.add(i);
            dict.put(key, values);
        }
        
        List<String> ans = new ArrayList<String>();
        for(int i=0; i<=num; i++) {
            int j=num-i;
            if( i < 0 || i > 5 || j < 0 || j > 5)
                continue;
            List<Integer> hours = dict.get(i);
            List<Integer> minutes = dict.get(j);
            for(Integer hr: hours) {
                if( hr > 11)
                    continue;
                for(Integer mn: minutes) {
                    ans.add(hr+":"+String.format("%02d", mn));
                }
            }
        }
        return ans;
    }
    public int countBits(int num) {
        int ans = 0;
        while( num > 0) {
            ans += (num & 1);
            num >>= 1;
        }
        return ans;
    }
}