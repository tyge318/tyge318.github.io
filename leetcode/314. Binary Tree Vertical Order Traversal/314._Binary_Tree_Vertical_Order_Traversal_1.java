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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if( root == null )
            return ans;
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        
        q.add(root);
        cols.add(0);
        
        int min = 0, max = 0;
        while( !q.isEmpty() ) {
            TreeNode current = q.poll();
            int col = cols.poll();
            if( !map.containsKey(col) )
                map.put(col, new ArrayList<Integer>());
            map.get(col).add(current.val);
            
            if( current.left != null ) {
                q.add(current.left);
                cols.add(col-1);
                min = Math.min(min, col-1);
            }
            if( current.right != null ) {
                q.add(current.right);
                cols.add(col+1);
                max = Math.max(max, col+1);
            } 
        }
        
        for(int i=min; i<=max; i++)
            ans.add(map.get(i) );
        return ans;
    }
}