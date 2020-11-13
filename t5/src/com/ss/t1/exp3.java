package com.ss.t1;

public class exp3 {

    class TreeNode {
        int val;
        TreeNode[] children;
    }

    void traverse(TreeNode root) {
        for (TreeNode child : root.children) {
            traverse(child);
        }
    }
}
