package indi.yuantongchn.LC103;

//103. 二叉树的锯齿形层序遍历

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean isOrderLeft = true;
        LinkedList<TreeNode> nodeList = new LinkedList<TreeNode>();
        nodeList.addLast(root);
        nodeList.addLast(null);
        LinkedList<Integer> levelValues = new LinkedList<Integer>();
        while(!nodeList.isEmpty()){
            TreeNode curNode = nodeList.pollFirst();
            if(curNode != null){
                if(isOrderLeft){
                    levelValues.addLast(curNode.val);
                }else{
                    levelValues.addFirst(curNode.val);
                }
                if(curNode.left != null){
                    nodeList.addLast(curNode.left);
                }
                if(curNode.right != null){
                    nodeList.addLast(curNode.right);
                }
            }else{
                res.add(levelValues);
                levelValues = new LinkedList<Integer>();
                if(!nodeList.isEmpty()){
                    nodeList.addLast(null);
                }
                isOrderLeft = !isOrderLeft;
            }
        }
        return res;
    }
}
