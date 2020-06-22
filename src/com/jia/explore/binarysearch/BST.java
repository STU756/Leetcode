package com.jia.explore.binarysearch;

/**
 * 二叉搜索树
 */
public class BST {

    private TreeNode root; //the root treeNode of BST
    private int size; //the size of BST
    private class TreeNode {
        private int key;
        private int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    /**
     * 二分搜索树的rank
     * 目标值value在二分搜索树中排名第几
     * @param  key  目标值
     * @return  返回排名
     */
    public int rank(int key){
        if(this.size == 0 || !contain(key)) { return 0; }
        return rank(this.root, key);
    }
    private int rank(TreeNode node, int key) {
        if(node == null) {
            return 0;
        }
        if(node.key == key) {
            return size(root.left) + 1;
        }else if(node.key > key) {
            return rank(node.left, key);
        }else {
            return 1 + size(root.left) + rank(node.right, key);
        }
    }

    /**
     * 计算node二分搜索树节点的个数
     * @param node 二分搜索树的根节点
     * @return 返回节点数
     */
    private int size(TreeNode node) {
        if(node == null) { return 0; }
        return 1 + size(node.left) + size(node.right);
    }

    /**
     * 查询排名第num的节点
     * @param k  排名数
     * @return 排名第k名的节点
     *
     */
    public TreeNode select(int k) {
        if(k < 1 || this.size < k) { return null; }
        return select(this.root, k);
    }
    private TreeNode select(TreeNode node, int k) {
        if(root == null) {
            return null;
        }
        int com = k - size(root.left);
        if(com == 1) {
            return node;
        }else if(com > 1){
            return select(node.right, com - 1);
        }else {
            return select(node.left, k);
        }
    }



    /**
     * 寻找floor或ceil的逻辑主要分为三步：
     * 1.如果node的key值和需要寻找的key值相等的时候，那么该key的floor就为该node的值
     * 2.如果node的key值比要寻找的key值要打，那么要寻找的floor值在左子树，递归
     * 3.如果node的key值比要寻找的key值小：则node可以是key的floor节点，也可能在右子树上，需要尝试向node的
     *  右子树寻找一下
     * @param key
     * @return
     */
    public TreeNode floor(int key){
        if(this.size == 0 || key < min().key) { return null; }
        return floor(this.root, key);
    }
    private TreeNode floor(TreeNode node, int key) {
        if(node == null) { return null; }
        if(node.key == key) {
            return node;
        }
        if(node.key > key) {
            return floor(node.left, key);
        }
        //尝试在右子树上寻找一下
        TreeNode tempNode = floor(node.right, key);
        //如果需找到
        return tempNode == null? node : tempNode;
    }
    //同理，ceil和floor类似
    public TreeNode ceil(int key) {
        if(this.size == 0 || key > max().key) { return null; }
        return ceil(this.root, key);
    }
    private TreeNode ceil(TreeNode node, int key) {
        if(node == null) { return null; }
        if(node.key == key) {
            return node;
        }
        if(node.key < key) {
            return ceil(node.right, key);
        }
        //尝试在左子树查找是否比key大的node
        TreeNode tempNode = ceil(node.left, key);
        return tempNode == null? node : tempNode;
    }

    //如果删除的节点有左右子树的话，那么删除的节点应该由右子树的最小节点进行代替即可
    //即删除节点的后继节点

    /**
     * 删除左右都有孩子的节点
     * 1.找到s = min(d.right)
     * 2.s是d的后继
     * s.right = delMin(d.right);
     *
     * @param key
     */
    public TreeNode remove(int key) {
        return remove(this.root, key);
    }
    //删除掉以node为根的二分搜索树中的键值为key的的节点
    //返回删除节点后新的二分搜索树的跟
    private TreeNode remove(TreeNode node, int key) {
        if(node == null) { return null; }
        if(key < node.key) {
            node.left = remove(node.left, key);
        }else if(key > node.key) {
            node.right = remove(node.right, key);
        }else {
            //key == node.key 删除node节点
            --size;
            if(node.left == null) {
                return node.right;
            }else if(node.right == null) {
                return node.left;
            }else {
                //左右孩子都不为null
                TreeNode successor = min(node.right); //找到node的右子树的最小节点
                successor.left = node.left;
                successor.right = deleteMin(node.right);//删除右子树的最小节点，并且返回右子树
                ++this.size;  //注意陷阱  deleteMin会删除一个节点
                return successor;
            }
        }
        return node;
    }

    //返回本二叉树的最小节点
    public TreeNode min(){
        return min(this.root);
    }

    //返回二叉搜索树的node的最小节点
    private TreeNode min(TreeNode node) {
        if(node == null) { return null; }
        if(node.left == null) {
            return node;
        }
        return min(node.left);
    }

    //查找二叉搜索树的最大节点
    public TreeNode max(){
        return max(this.root);
    }
    //查找二叉搜索树node的最大节点
    private TreeNode max(TreeNode node) {
        if(node == null) { return null; }
        if(node.right == null) {
            return node;
        }
        return max(node.right);
    }




    //删除最小节点
    public void deleteMin(){
        if(isEmpty()) { return ; }
        this.root = deleteMin(this.root);
    }

    private TreeNode deleteMin(TreeNode node) {
        if(node.left == null) {
            --this.size;
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    //删除最大节点
    public void deleteMax(){
        if(isEmpty()) { return; }
        this.root = deleteMax(this.root);
    }

    private TreeNode deleteMax(TreeNode node) {
        if(node.right == null) {
            --size;
            return node.left;
        }
        node.right = deleteMax(node.right);
        return node;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int key, int value) {
        root = insert(this.root, key, value);
    }

    //向一root为根的二叉搜索树中，插入节点（key, value)
    //返回插入新节点后的二叉树搜索树的跟
    private TreeNode insert(TreeNode root, int key, int value) {
        if(root == null) {
            ++size;
            return new TreeNode(key, value);
        }
        if( key == root.key) {
            root.value = value;
        }else if(key > root.key) {
            root.right = insert(root.right, key, value);
        }else {
            root.left = insert(root.left, key, value);
        }
        return root;
    }
    //TODO  插入二叉查找树非递归实现


    /**
     * 查找二叉搜索树是否存在key节点
     * @param key
     * @return
     */
    public boolean contain(int key) {
        return contain(root, key);
    }

    private boolean contain(TreeNode node, int key) {
        if(node == null) {
            return false;
        }
        if(key == node.key) {
            return true;
        }else if(key < node.key) {
            return contain(node.left, key);
        }else {
            return contain(node.right, key);
        }
    }

    /**
     * 查找key对应的value
     * @param key
     * @return
     */
    public int search(int key) {
        assert contain(key) == true;
        return search(root, key);
    }

    private int search(TreeNode node, int key) {
        if( node == null) {
            return -1;
        }
        if(key == node.key) {
            return node.value;
        }else if(key < node.key) {
            return search(node.left, key);
        }else {
            return search(node.right, key);
        }
    }
}
