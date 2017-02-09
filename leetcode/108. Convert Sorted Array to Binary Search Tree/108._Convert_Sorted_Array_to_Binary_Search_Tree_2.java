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
    public TreeNode sortedArrayToBST(int[] nums) {
        if( nums.length == 0 )
            return null;
        return buildBST(nums, 0, nums.length-1);
    }
    public TreeNode buildBST(int[] nums, int begin, int end) {
        if( begin > end)
            return null;
        if( begin == end)
            return (new TreeNode(nums[begin]) );
        int mid = (begin+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, begin, mid-1);
        root.right = buildBST(nums, mid+1, end);
        return root;
    }
}