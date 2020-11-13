package com.ss.t1;

public class exp2 {
    class TreeNode {
        int val;
        TreeNode left, right;
    }

    void traverse(TreeNode root) {
        traverse(root.left);
        traverse(root.right);
    }
}
