/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return weightDepthSum(1, nestedList);
    }
    public int weightDepthSum(int w, List<NestedInteger> nestedList) {
        int ans = 0;
        for(NestedInteger i: nestedList) {
            if( i.isInteger())
                ans += w*i.getInteger();
            else
                ans += weightDepthSum(w+1, i.getList());
        }
        return ans;
    }
}