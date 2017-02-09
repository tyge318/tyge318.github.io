class Solution {
public:
    vector<string> generatePossibleNextMoves(string s) {
        vector<string> ans;
        if( s.empty() ) return ans;
        for(int i=0; i<s.length()-1; i++) {
            if( s[i] == '+' && s[i+1] == '+') {
                s[i] = s[i+1] = '-';
                ans.push_back(s);
                s[i] = s[i+1] = '+';
            }
        }
        return ans;
    }
};