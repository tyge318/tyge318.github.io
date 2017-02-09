public class Solution {
    public int hIndex(int[] citations) {
        for(int i=0; i<citations.length; i++)
            citations[i] *= -1;
        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++) {
            citations[i] *= -1;
            if( citations[i] >= i+1) {
                if( (i+1 < citations.length && -citations[i+1] < i+2) || i+1 == citations.length )
                    return i+1;
            }
        }
        return 0;
    }
}