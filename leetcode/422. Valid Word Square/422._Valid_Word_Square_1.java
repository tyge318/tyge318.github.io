public class Solution {
    public boolean validWordSquare(List<String> words) {
        if( words == null)
            return false;
        if( words.size() <= 1)
            return true;
        for(int i = 0; i<words.size(); i++) {
            for(int j = 0; j<words.get(i).length(); j++) {
                try {
                    if( words.get(i).charAt(j) != words.get(j).charAt(i) )
                        return false;
                }
                catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }
}