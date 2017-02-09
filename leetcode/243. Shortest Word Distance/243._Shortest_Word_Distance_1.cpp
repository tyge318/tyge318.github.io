class Solution {
public:
    int shortestDistance(vector<string>& words, string word1, string word2) {
        int hold = -1, ans = INT_MAX;
        for(int i=0; i<words.size(); i++) {
            if( words[i] == word1 || words[i] == word2) { //ignore irrelevant words
                if( hold != -1 && words[hold] != words[i])
                    ans = min(ans, i-hold);
                hold = i;
            }
        }
        return ans;
    }
};