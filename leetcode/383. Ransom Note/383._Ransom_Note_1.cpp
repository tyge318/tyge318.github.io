class Solution {
public:
    bool canConstruct(string ransomNote, string magazine) {
        unordered_map<char, int> letters;
        for(char c: magazine) {
            if( letters.find(c) == letters.end())
                letters[c] = 1;
            else
                letters[c]++;
        }
        for(char c: ransomNote) {
            if( letters.find(c) == letters.end() || letters[c] == 0)
                return false;
            letters[c]--;
        }
        return true;
    }
};