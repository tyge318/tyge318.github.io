public class Solution {
    List<String> ans;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<String>();
        if(num.length() == 0)
            return ans;
        findAns(num, (long)-target, "", 0, 0);
        return ans;
    }
    public void findAns(String num, long sum, String path, int n, int pre) {
        if( n == num.length() && sum == 0) {
            ans.add(path);
            return;
        }
        //int value = 0;
        for(int i=n, value = 0; i<num.length(); i++) {
            value = value*10 + (num.charAt(i) - '0');
            if( value > Integer.MAX_VALUE)
                break;
            if( n == 0)
                findAns(num, sum+value, path+String.valueOf(value), i+1, value);
            else{
                findAns(num, sum+value, path+"+"+String.valueOf(value), i+1, value);
                findAns(num, sum-value, path+"-"+String.valueOf(value), i+1, -value);
                findAns(num, sum-pre+pre*value, path+"*"+String.valueOf(value), i+1, pre*value);
            }
            if(num.charAt(n) == '0')
                break;
        }
    }
}