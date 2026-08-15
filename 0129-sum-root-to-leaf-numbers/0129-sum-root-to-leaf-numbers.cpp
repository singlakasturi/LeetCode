/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    void traversel(TreeNode* root, vector<int> &ans, int num)
    {
        if(root->left == NULL && root->right == NULL)
        {
            num = num*10 + root->val;
            ans.push_back(num);
            return ;
        }

        num = num*10 + root->val;
        if(root->left)
            traversel(root->left, ans, num);
        if(root->right)
            traversel(root->right, ans, num);
    }
    int sumNumbers(TreeNode* root) {
        vector<int> ans;
        traversel(root, ans, 0);
        int sum = accumulate(ans.begin(), ans.end(), 0);
        return sum;
    }
};