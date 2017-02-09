class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> counts;
        for(char c: s) {
            if( counts.find(c) == counts.end() )
                counts[c] = 1;
            else
                counts[c]++;
        }
        for(char c: t) {
            if( counts.find(c) == counts.end() )
                return false;
            else
                counts[c]--;
            if( counts[c] == 0) counts.erase(c);
        }
        return counts.empty();
    }
};