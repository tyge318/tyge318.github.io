class Solution {
    public boolean isReflected(int[][] points) {
        Map<String, Integer> ps = new HashMap<String, Integer>();
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE;
        for(int[] p: points) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            String pString = Arrays.toString(p);
            if( ps.containsKey(pString) )
                ps.put(pString, ps.get(pString)+1);
            else
                ps.put(pString, 1);
        }
        double reflectionX = (maxX+minX)/2.0;
        for(int[] p: points) {
            String pString = Arrays.toString(p);
            if( !ps.containsKey(pString) || (double)p[0] == reflectionX )
                continue;
            ps.put(pString, ps.get(pString)-1);
            if( ps.get(pString) == 0)
                ps.remove(pString);
            int[] pRef = Arrays.copyOf(p, 2);
            pRef[0] = (int)(2*reflectionX - p[0]);
            String pRefString = Arrays.toString(pRef);
            //System.out.println("pString = " + pString + "; pRefString = " + pRefString);
            if( !ps.containsKey(pRefString) )
                return false;
            ps.put(pString, ps.get(pRefString)-1);
            if( ps.get(pRefString) == 0)
                ps.remove(pRefString);
        }
        return true;
    }
}