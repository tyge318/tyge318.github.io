class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> f = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        int ans = f[s[s.length()-1]];
        for(int i=s.length()-2; i>=0; i--) {
            if( f[s[i]] < f[s[i+1]] )   ans -= f[s[i]];
            else    ans += f[s[i]];
        } 
        return ans;
    }
};