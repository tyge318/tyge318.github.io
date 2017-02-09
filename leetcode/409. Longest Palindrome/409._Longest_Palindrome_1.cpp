class Solution {
public:
    int longestPalindrome(string s) {
        int ans = 0;
        unordered_set<char> trace;
        for(char c: s) {
            if( trace.find(c) == trace.end())   trace.insert(c);
            else {
                trace.erase(c);
                ans += 2;
            }
        }
        ans += (trace.empty() ? 0: 1);
        return ans;
    }
};