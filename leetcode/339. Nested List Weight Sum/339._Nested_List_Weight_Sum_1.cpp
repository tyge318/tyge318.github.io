/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class Solution {
public:
    int depthSum(vector<NestedInteger>& nestedList) {
        return helper(1, nestedList);
    }
    int helper(int depth, vector<NestedInteger>& nestedList) {
        int ans = 0;
        for(auto iter=nestedList.begin(), end = nestedList.end(); iter!=end; ++iter) {
            if( iter->isInteger())    ans += (depth*iter->getInteger());   
            else    ans += helper(depth+1, iter->getList());
        }
        return ans;
    }
};