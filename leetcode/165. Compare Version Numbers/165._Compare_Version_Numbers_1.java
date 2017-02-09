public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1tokens = version1.split("\\.");
        String[] v2tokens = version2.split("\\.");
        
        if( v1tokens.length == 0 && v2tokens.length == 0) {
            int temp1 = Integer.valueOf(version1);
            int temp2 = Integer.valueOf(version2);
            if(temp1 > temp2)
                return 1;
            else if (temp1 < temp2)
                return -1;
            else
                return 0;
        }
        for(int i=0; i<Math.max(v1tokens.length, v2tokens.length); i++) {
            int subv1 = Integer.valueOf( ((i<v1tokens.length) ? v1tokens[i] : "0" ));
            int subv2 = Integer.valueOf( ((i<v2tokens.length) ? v2tokens[i] : "0" ) );
            if(subv1 > subv2)
                return 1;
            else if (subv1 < subv2)
                return -1;
            else
                continue;
        }
        return 0;
    }
}