package com.jia.leetCode;

public class Pro0606 {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        if(t.left == null && t.right == null) return String.valueOf(t.val);
        if(t.left == null && t.right != null)
	        return t.val+ "()"  + "(" + tree2str(t.right) +")";
        if(t.left!=null && t.right==null) 
            return t.val + "(" + tree2str(t.left) +")";
        return t.val + "(" + tree2str(t.left) +")"+ "(" + tree2str(t.right) +")";   
    }
}
