class Solution {
public:
    bool canPermutePalindrome(string s) {
        unordered_set<char> trace;
        for(char& c: s) {
            if( trace.find(c) == trace.end())   //not contain
                trace.insert(c);
            else
                trace.erase(c);
        }
        return (trace.size() < 2);
    }
};