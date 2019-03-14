1.树的子结构
-
>输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

思路：先判断AB树父节点是否值相等，相等的话看AB是否`equals`,不是的话继续对A的左右节点继续进行该判断，`递归`求解<br>
该思路有误，在于如果AB父节点相等，不应该仅看AB是否`equals`，而是看B是否是A的`子结构`。例如B的某节点遍历到null了，但是A的该节点的左右孩子都有值，应该也满足B是A的子结构。<br>
有了上述想法后，写出代码就不难了<br>


    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        if (doesTree1HavaTree2(root1, root2)) return true;
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private static boolean doesTree1HavaTree2(TreeNode node1, TreeNode node2) {
        if(node2==null) return true;
        if(node1==null||node1.val!=node2.val) return false;
        return doesTree1HavaTree2(node1.left, node2.left) && doesTree1HavaTree2(node1.right, node2.right);
    }

