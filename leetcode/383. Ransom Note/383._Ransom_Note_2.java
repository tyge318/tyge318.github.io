public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder temp = new StringBuilder(magazine);
        for(int i=0; i<ransomNote.length(); i++) {
            String cc = ransomNote.substring(i, i+1);
            int pos = 0;
            if( (pos = temp.indexOf(cc)) != -1)
                temp.deleteCharAt(pos);
            else
                return false;
        }
        return true;
    }
}