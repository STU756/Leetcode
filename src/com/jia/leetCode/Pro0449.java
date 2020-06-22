package com.jia.leetCode;

/**
 *449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 *
 * 设计一个算法来序列化和反序列化二叉搜索树。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 *
 * 编码的字符串应尽可能紧凑。
 *
 * 注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Pro0449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) { return "#"; }
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }
    private String deserializeStr;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        this.deserializeStr = data;
        return deserialize();
    }
    private TreeNode deserialize() {
        if(deserializeStr.length() == 0) return null;
        int index = deserializeStr.indexOf(" ");
        String node = index == -1? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1? "" : deserializeStr.substring(index + 1);
        if(node.equals("#")) {
            return null;
        }
        int val = Integer.parseInt(node);
        TreeNode t = new TreeNode(val);
        t.left = deserialize();
        t.right = deserialize();
        return t;
    }
}
