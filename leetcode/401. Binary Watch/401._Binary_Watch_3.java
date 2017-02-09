public class Solution {
    public List<String> readBinaryWatch(int num) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<60; i++) {
            int key = countOne(i);
            if(!map.containsKey(key) )
                map.put(key, new ArrayList<>() );
            map.get(key).add(i);
        }
        List<String> ans = new ArrayList<>();
        for(int hr = 0; hr<=num; hr++) {
            int mn = num - hr;
            if( hr > 4 || mn > 5)   continue;
            //System.out.printf("num = %d, hr = %d, mn = %d\n", num, hr, mn);
            List<Integer> hrs = map.get(hr);
            List<Integer> mns = map.get(mn);
            for(int i: hrs) {
                if( i > 11) continue;
                for(int j: mns) {
                    String temp = String.format("%d:%02d", i, j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    public int countOne(int num) {
        int ans = 0;
        while( num > 0 ) {
            ans += (num & 0x1);
            num >>>= 1;
        } 
        return ans;
    }
}