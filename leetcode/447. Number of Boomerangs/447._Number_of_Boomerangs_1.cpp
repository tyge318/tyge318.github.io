class Solution {
public:
    int numberOfBoomerangs(vector<pair<int, int>>& points) {
        int ans = 0;
        for(auto a: points) {
            unordered_map<double, int> dis(points.size());
            for(auto b: points) {
                ans += 2*dis[hypot(a.first-b.first, a.second-b.second)]++;
            }
        }
        return ans;
    }
};