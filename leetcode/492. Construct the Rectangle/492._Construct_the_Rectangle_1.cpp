class Solution {
public:
    vector<int> constructRectangle(int area) {
        vector<int> ans;
        int L = ceil(sqrt(area)), W;
        while( area % L != 0 )
            L++;
        W = area / L;
        ans.push_back(L);
        ans.push_back(W);
        return ans;
    }
};