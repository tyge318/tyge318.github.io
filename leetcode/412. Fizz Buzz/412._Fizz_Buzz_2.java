public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        for(int i=1; i<=n; i++)
            ans.add(getStr(i));
        return ans;
    }
    public String getStr(int n) {
        if( n % 15 == 0)
            return "FizzBuzz";
        if( n % 5 == 0)
            return "Buzz";
        if( n % 3 == 0)
            return "Fizz";
        return String.valueOf(n);
    }
}