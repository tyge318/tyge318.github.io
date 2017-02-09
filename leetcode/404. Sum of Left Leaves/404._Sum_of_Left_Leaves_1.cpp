/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int sumOfLeftLeaves(TreeNode* root) {
        int ans = 0;
        if( !root ) return ans;
        if( root->left && isLeaf(root->left))
            ans += root->left->val;
        else
            ans += sumOfLeftLeaves(root->left);
        ans += sumOfLeftLeaves(root->right);
        return ans;
    }
    bool isLeaf(TreeNode* root) {
        return (!root->left && !root->right);
    }
};