class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        inorder(root, target, true, st2);
        inorder(root, target, false, st1);
        
        List<Integer> ans = new ArrayList<>();
        while( k-- > 0) {
            if( st1.isEmpty() )
                ans.add(st2.pop());
            else if( st2.isEmpty() )
                ans.add(st1.pop() );
            else if( Math.abs(st1.peek()-target) < Math.abs(st2.peek()-target) )
                ans.add(st1.pop());
            else
                ans.add(st2.pop());
        }
        return ans;
    }
    
    public void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
        if( root == null)   return;
        
        inorder( reverse ? root.right: root.left, target, reverse, stack);
        //if reverse => already done root.right, and root.left is guaranteed to be less than root.val => prune it
        //if !reverse => already done root.left, and root.right is guaranteed to be greater than root.val => prune it
        if( (reverse && root.val <= target) || (!reverse && root.val > target) )    return;
        stack.push(root.val);
        inorder( reverse? root.left: root.right, target, reverse, stack);
        
    }
}