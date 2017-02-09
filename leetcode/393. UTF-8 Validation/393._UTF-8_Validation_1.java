public class Solution {
    public boolean validUtf8(int[] data) {
        for(int i=0; i<data.length; i++) {
            data[i] &= 0xff;
            //System.out.println("current:" + Integer.toBinaryString(data[i]));
        }
            
        for(int i=0; i<data.length; ) {
            if( data[i] >>> 7 == 0) {
                i++;
                continue;
            }
            if( i+1 < data.length && (data[i] >>> 5) == 6 && (data[i+1] >>> 6) == 2) {
                i+=2;
                continue;
            }
            if( i+2 < data.length && (data[i] >>> 4) == 14 && (data[i+1] >>> 6) == 2 && (data[i+2] >>> 6) == 2) {
                i+=3;
                continue;
            }
            if( i+3 < data.length && (data[i] >>> 3) == 0x1e && (data[i+1] >>> 6) == 2 && (data[i+2] >>> 6) == 2 && (data[i+3] >>> 6) == 2 ) {
                i+=4;
                continue;
            }
            return false;
        }
        return true;
    }
}