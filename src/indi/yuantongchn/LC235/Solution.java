package indi.yuantongchn.LC235;

//235. 二叉搜索树的最近公共祖先

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    //注意利用二叉搜索树的特性
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        return findNode(root, p, q);
    }

    private TreeNode findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val >= p.val && root.val <= q.val || root.val >= q.val && root.val <= p.val) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return findNode(root.left, p, q);
        } else {
            return findNode(root.right, p, q);
        }
    }
}
