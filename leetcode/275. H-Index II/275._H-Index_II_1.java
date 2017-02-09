public class Solution {
    public int hIndex(int[] citations) {
        int size = citations.length;
        
        for(int i=size-1; i>=0; i--) {
            if( citations[i] >= size-i) {
                if( (i-1 >= 0 && citations[i-1] < size-i+1) || i == 0 )
                    return size-i;
            }
        }
        return 0;
    }
}
/*  citations: [0,1,4,5,6] 
    index:     [0,1,2,3,4]
               [5,4,3,2,1]
*/