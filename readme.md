1.树的子结构
-
>输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

思路：先判断AB树父节点是否值相等，相等的话看AB是否`equals`,不是的话继续对A的左右节点继续进行该判断，`递归`求解<br><br>
该思路有误，在于如果AB父节点相等，不应该仅看AB是否`equals`，而是看B是否是A的`子结构`。例如B的某节点遍历到null了，但是A的该节点的左右孩子都有值，应该也满足B是A的子结构。<br><br>
有了上述想法后，写出代码就不难了<br><br>


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

2.链表环的入口节点
-
>给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

思路：先通过一个快慢指针的相遇，找到环的长度x(如果没有环则返回Null),之后用两个指针，一个从起点出发，一个先走x步，相遇时，从起点出发的指针走了l,l即为起点到入口的长度。<br><br>

思路没问题，这个题目要注意代码的`鲁棒性`，如果链表中没有环，循环调用ListNode的next方法时，可能会发生`NPE`，这点需要注意。<br><br>


	public ListNode entryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        //创建两个指针，一个速度为1，一个速度为2
        ListNode fast = pHead;
        ListNode slow = pHead;
        int lengthOfCircle = 0;
        do {
            if (fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            lengthOfCircle++;
        } while (fast != slow);
        ListNode formal = pHead;
        ListNode letter = pHead;
        for (int i = 0; i < lengthOfCircle; i++) {
            letter = letter.next;
        }
        while (formal != letter) {
            formal = formal.next;
            letter = letter.next;
        }
        return formal;
    }


