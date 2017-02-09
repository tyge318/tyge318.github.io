public class Solution {
    int[][] digit_count;
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(int i=0; i<s.length(); i++) {
            char cc = s.charAt(i);
            if( cc == 'z') count[0]++;   //'z'ero, 0
            if( cc == 'o') count[1]++;   //'o'ne, 0, 1, 2, 4
            if( cc == 't') count[2]++;   //'t'wo, 2, 3, 8
            if( cc == 'r') count[3]++;   //th'r'ee, 3, 0, 4
            if( cc == 'u') count[4]++;   //fo'u'r, 4
            if( cc == 'v') count[5]++;   //fi'v'e, 5, 7
            if( cc == 'x') count[6]++;   //si'x', 6
            if( cc == 's') count[7]++;   //'s'even, 6, 7
            if( cc == 'h') count[8]++;   //eig'h't, 8, 3 
            if( cc == 'i') count[9]++;   //n'i'ne, 5, 6, 8, 9
        }
        count[7] -= count[6];
        count[5] -= count[7];
        count[3] -= (count[0]+count[4]);
        count[8] -= count[3];
        count[9] -= (count[5]+count[6]+count[8]);
        count[2] -= (count[3]+count[8]);
        count[1] -= (count[0]+count[2]+count[4]);
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<10; i++) {
            for(int j=0; j<count[i]; j++)
                temp.append(i);
        }
        return temp.toString();
    }
}