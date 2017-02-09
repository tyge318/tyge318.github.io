public class Solution {
    class BSTNode {
        BSTNode left, right;
        int val, leftCount, dup = 1;
        public BSTNode(int v, int c) {
            val = v;
            c = leftCount;  //count the number of elements smaller after self
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        BSTNode root = null;
        for(int i=nums.length-1; i>=0; i--)
            root = insert(nums[i], root, ans, i, 0);
        return Arrays.asList(ans);
    }
    public BSTNode insert(int val, BSTNode node, Integer[] ans, int i, int count) {
        if( node == null ) {
            node = new BSTNode(val, 0);
            ans[i] = count;
        }
        else if( node.val == val) {
            node.dup++;
            ans[i] = count + node.leftCount;
        }
        else if( node.val > val) {  //node with val is on the left, increment leftCount
            node.leftCount++;
            node.left = insert(val, node.left, ans, i, count);
        }
        else {  //node with val is on the right, it gets the leftCount and dup attribute from current node
            node.right = insert(val, node.right, ans, i, count+node.leftCount+node.dup);
        }
        return node;
    }
}