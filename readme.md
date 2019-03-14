1.树的子结构
-
>输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

思路：先判断AB树父节点是否值相等，相等的话看AB是否`equals`,不是的话继续对A的左右节点继续进行该判断，`递归`求解<br><br>
该思路有误，在于如果AB父节点相等，不应该仅看AB是否`equals`，而是看B是否是A的`子结构`。例如B的某节点遍历到null了，但是A的该节点的左右孩子都有值，应该也满足B是A的子结构。<br><br>
代码如下:



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
代码如下:

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

3.斐波拉契数列
-
>大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0)n<=39

思路：斐波拉契数列用递归求解，有递归方法和非递归方法。<br><br>
在牛客网上试了下两种解法的时间和内存使用，如下 <br>
非递归方法 运行时间：14ms 占用内存：8948k<br>
递归方法 运行时间：1142ms 占用内存：9320k<br>
可以看出，非递归方法不仅速度比较快，而且占用内存小，递归申请的栈的深度比较深，内存占用大，对执行速度也有影响。<br><br>
代码如下:

	public int FibonacciInRecursion(int n) {
	        if (n == 0) return 0;
	        if (n == 1) return 1;
	        return FibonacciInRecursion(n - 1) + FibonacciInRecursion(n - 2);
    }
	    
    public int FinonacciInLoop(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int formal = 0;
        int letter = 1;
        for (int i = 1; i < n; i++) {
            int tmp = formal + letter;
            formal = letter;
            letter = tmp;
        }
        return letter;
    }
    
4.链表中倒数第k个节点
-
>输入一个链表，输出该链表中倒数第k个结点。

思路一：直观的方法是先遍历一遍链表求出总长度l,然后用一个指针根结点走l-k步，即为倒数第k个结点。这种方法有个弊端是等于遍历两遍链表，会浪费一些时间。<br>
思路二：用一个A指针走k步，另一个指针B在起点，两个指针同时向后走，当A指针走到末尾的时候，B指针即在倒数第k的位置。<br><br>
思路一 运行时间：34ms 占用内存：9392k <br>
思路二 运行时间：24ms 占用内存：9636k <br><br>
代码如下:
	
	public ListNode findKthToTail(ListNode head, int k) {
        if (k <= 0) return null;
        if (head == null) return null;
        ListNode formal = head;
        ListNode letter = head;
        //formal走k步
        for (int i = 0; i < k - 1; i++) {
            if (formal.next == null) return null;
            formal = formal.next;
        }
        while (formal.next != null) {
            formal = formal.next;
            letter = letter.next;
        }
        return letter;
    }