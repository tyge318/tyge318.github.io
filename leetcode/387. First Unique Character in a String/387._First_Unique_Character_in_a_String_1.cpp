class Solution {
public:
    int firstUniqChar(string s) {
        for(int i=0; i<s.length(); i++) {
            char c = s[i];
            if( s.find_first_of(c) == s.find_last_of(c))
                return i;
        }
        return -1;
    }
};