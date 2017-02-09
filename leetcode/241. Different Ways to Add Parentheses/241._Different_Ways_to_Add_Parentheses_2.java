public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i=0; i<input.length(); i++) {
            char cc = input.charAt(i);
            if( cc == '+' || cc == '-' || cc == '*') {
                List<Integer> subans1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> subans2 = diffWaysToCompute(input.substring(i+1));
                for(int j: subans1) {
                    for(int k: subans2) {
                        switch(cc) {
                            case '+':
                                ans.add(j+k);
                                break;
                            case '-':
                                ans.add(j-k);
                                break;
                            case '*':
                                ans.add(j*k);
                            default:
                        }
                    }
                }
            } 
        }
        if( ans.isEmpty() )
            ans.add(new Integer(input) );
        return ans;
    }
}