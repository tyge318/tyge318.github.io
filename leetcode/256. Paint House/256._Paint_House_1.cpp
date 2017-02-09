class Solution {
public:
    int minCost(vector<vector<int>>& costs) {
        int n = costs.size();
        if( n == 0) return 0;
        vector<vector<int>> opt;
        opt.push_back(costs[0]);
        for(int i=1; i<n; i++) {
            vector<int> current;
            for(int j=0; j<3; j++) {
                current.push_back(costs[i][j] + min(opt[i-1][(j+1)%3], opt[i-1][(j+2)%3]) );
            }
            opt.push_back(current);
        }
        return min(opt[n-1][0], min(opt[n-1][1], opt[n-1][2]));
    }
};