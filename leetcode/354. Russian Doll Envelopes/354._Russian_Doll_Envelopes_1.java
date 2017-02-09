public class Solution {
    class Envelope {
        int width, height;
        public Envelope(int w, int h) {
            width = w;
            height = h;
        }
        public String toString() {
            return "["+width+","+height+"]";
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if( n == 0 )
            return 0;
        List<Envelope> envs = new ArrayList<Envelope>();
        for(int i=0; i<n; i++)
            envs.add( new Envelope(envelopes[i][0], envelopes[i][1]) );
        
        Collections.sort(envs, new Comparator<Envelope>() {
            @Override
            public int compare(Envelope e1, Envelope e2) {
                if( e1.width != e2.width )
                    return Integer.compare(e1.width, e2.width);
                else {
                    return -Integer.compare(e1.height, e2.height);
                }
            }
        });
        //System.out.println(envs.toString());
        
        List<Integer> heightSeq = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            int left = 0, right = heightSeq.size();
            int height = envs.get(i).height;
            while( left < right) {
                int mid = (left + right)/2;
                if( heightSeq.get(mid) < height )
                    left = mid+1;
                else
                    right = mid;
            }
            if( right >= heightSeq.size())
                heightSeq.add(height);
            else
                heightSeq.set(right, height);
        }
        return heightSeq.size();
    }
}