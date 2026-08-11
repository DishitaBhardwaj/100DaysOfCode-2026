//Need to find the lowest common ancestor, but only if both employees exist

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int x) {
        val = x;
        left = nullptr;
        right = nullptr;
    }
};

TreeNode* buildTree(vector<int>& arr) {
    if (arr.empty() || arr[0] == -1) return nullptr;

    TreeNode* root = new TreeNode(arr[0]);
    queue<TreeNode*> q;
    q.push(root);

    int i = 1;
    while (!q.empty() && i < arr.size()) {
        TreeNode* curr = q.front();
        q.pop();

        if (i < arr.size() && arr[i] != -1) {
            curr->left = new TreeNode(arr[i]);
            q.push(curr->left);
        }
        i++;

        if (i < arr.size() && arr[i] != -1) {
            curr->right = new TreeNode(arr[i]);
            q.push(curr->right);
        }
        i++;
    }

    return root;
}

bool exists(TreeNode* root, int target) {
    if (root == nullptr) return false;
    if (root->val == target) return true;
    return exists(root->left, target) || exists(root->right, target);
}

TreeNode* lca(TreeNode* root, int a, int b) {
    if (root == nullptr || root->val == a || root->val == b) {
        return root;
    }

    TreeNode* left = lca(root->left, a, b);
    TreeNode* right = lca(root->right, a, b);

    if (left != nullptr && right != nullptr) return root;
    return (left != nullptr) ? left : right;
}

int main() {
    vector<int> tree = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
    int a = 5;
    int b = 1;

    TreeNode* root = buildTree(tree);

    if (!exists(root, a) || !exists(root, b)) {
        cout << -1;
        return 0;
    }

    TreeNode* ans = lca(root, a, b);

    if (ans == nullptr) {
        cout << -1;
    } else {
        cout << ans->val;
    }

    return 0;
}