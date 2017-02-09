class Solution {
public:
    bool canPermutePalindrome(string s) {
        bitset<256> bs;
        for(char& c: s) {
            bs.flip(c);
        }
        return (bs.count() < 2);
    }
};