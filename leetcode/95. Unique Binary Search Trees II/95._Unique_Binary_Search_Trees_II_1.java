/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        int[] vals = new int[n];
        for(int i=1; i<=n; i++)
            vals[i-1] = i;
        return getTree(vals, 0, n);
    }
    
    public List<TreeNode> getTree(int[] vals, int begin , int end) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if( begin == end )
            return ans;
        if( end - begin == 1) {
            ans.add(new TreeNode(vals[begin]) );
            return ans;
        }
        for(int i=begin; i<end; i++) {
            int current = vals[i];
            
            List<TreeNode> leftsubs = getTree(vals, begin, i);
            List<TreeNode> rightsubs = getTree(vals, Math.min(i+1, end), end);
            if( leftsubs.size() == 0) {
                for(int j=0; j<rightsubs.size(); j++) {
                    TreeNode rootNode = new TreeNode(current);
                    rootNode.right = rightsubs.get(j);
                    ans.add(rootNode);
                }
            }
            else if (rightsubs.size() == 0) {
                for(int j=0; j<leftsubs.size(); j++) {
                    TreeNode rootNode = new TreeNode(current);
                    rootNode.left = leftsubs.get(j);
                    ans.add(rootNode);
                }
            }
            else {
                for(int j=0; j<leftsubs.size(); j++) {
                    for(int k=0; k<rightsubs.size(); k++) {
                        TreeNode rootNode = new TreeNode(current);
                        rootNode.left = leftsubs.get(j);
                        rootNode.right = rightsubs.get(k);
                        ans.add(rootNode);
                    }
                }
            }
        }
        return ans;
    }
}