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

5.平衡二叉树
-
>输入一棵二叉树，判断该二叉树是否是平衡二叉树。

附上`平衡二叉树`的性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。这个方案很好的解决了二叉查找树退化成`链表`的问题，把插入，查找，删除的时间复杂度最好情况和最坏情况都维持在O(logN)。但是频繁旋转会使插入和删除牺牲掉O(logN)左右的时间，不过相对二叉查找树来说，时间上稳定了很多。
 
思路一`[自上而下]`：判断根节点左右子树的高度，确定该节点是平衡的，再递归判断左右子树是否为平衡二叉树<br>
这种思路有个弊端，在递归的判断子树是否为平衡树的过程中，多次求了每个子树的高度，相当于底层的节点被遍历了很多遍<br><br>
代码如下:

	public boolean IsBalanced_Solution(TreeNode root) {
	        if (root == null) return true;
	        return (Math.abs(getHeightOfTree(root.left) - getHeightOfTree(root.right)) <= 1)
	                && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getHeightOfTree(TreeNode treeNode) {
        if (treeNode == null) return 0;
        if (treeNode.left == null && treeNode.right == null) return 1;
        int leftLength = getHeightOfTree(treeNode.left);
        int rightLength = getHeightOfTree(treeNode.right);
        return 1+Math.max(leftLength,rightLength);
    }

思路二`[自下而上]`：自底向上求高度，如果存在一个节点不是平衡树，则返回-1<br><br>
代码如下:
	
	public boolean isBalancedSolution(TreeNode root) {
	        if (root == null) return true;
	        return getDepth(root) != -1;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        if (getDepth(node.left) == -1 || getDepth(node.right) == -1) return -1;
        return Math.abs(getDepth(node.left) - getDepth(node.right)) > 1 ? -1 : Math.max(getDepth(node.left), getDepth(node.right));
    }

6.对称二叉树
-
>请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

思路：递归求解的时候应该注意的是，不是所有节点都完全对称，这个和题意还是有区别的<br><br>
代码如下:

    private static boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null) return true;
        return isMirrorNode(pRoot.left,pRoot.right);
    }

    private static boolean isMirrorNode(TreeNode left, TreeNode right) {
        if(left==null&&right==null) return true;
        if((left==null&&right!=null)||(left!=null&&right==null)||left.val!=right.val) return false;
        return isMirrorNode(left.left, right.right)&&isMirrorNode(left.right,right.left);
    }
    
7.跳台阶
-
>一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

思路：这个问题其实是一个动态规划的问题，动态规划的问题可以参考下<<算法导论>>，可以做一个简单的思考，当青蛙处于N层台阶的时候，它的选择是N-1台阶走一步+N-2台阶走两步，
这两种情况，这样既可得到关系式:f(N)=f(N-1)+f(N-2)，关于性能和优化的问题可以参考斐波拉契那道题目。<br><br>
代码如下：

    public int jump(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return jump(target - 1) + jump(target - 2);
        }
    }
    
8.旋转数组的最小数字
-
>把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

思路：初次思考，阅读题目之后，发现只要找到了节点N<N+1，则N+1节点即为最小元素。不过这个方法等于遍历了整个数组，更加高效的方法是用二分法，可以将时间复杂度从O(n)减小到O(logn)。除此之外，数组为单调非递减数组，可能会出现{1,1,1,1,0,1}这样的数组，这种情况只能遍历数组。最后，应该注意程序的鲁棒性。<br><br>
代码如下：

    public int minNumberInRotateArray(int[] array) {
            if (array.length == 0) {
                return 0;
            }
            int left = 0;
            int right = array.length - 1;
            while (left != right) {
                int mid = (left + right) / 2;
                if (array[left] > array[mid]) {
                    right = mid;
                } else if (array[left] < array[mid]) {
                    left = mid;
                } else {
                    left = left + 1;
                    if (array[left-1] > array[left]) {
                        return array[left];
                    }
                }
            }
            return array[left];
    }
    
9.二叉树的镜像
-
>操作给定的二叉树，将其变换为源二叉树的镜像。

思路：这题的思路是先将节点的左右子节点交换，对每个子节点，继续递归交换节点。<br><br>
代码如下：

    public void Mirror(TreeNode root) {
        if (root != null) {
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

10.最小的K个数
-
>输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。

思路：topk问题，不需要去重，求最大topK用最小堆，求最小topK用最大堆。堆排序建堆时间复杂度O(NlogN)。<br><br>
代码如下:

    public ArrayList<Integer> GetLeastNumbersSolution(int[] input, int k) {
        if (input.length <= 0 || k <= 0 || k > input.length) {
            return new ArrayList();
        }
        PriorityQueue<Integer> leastQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : input) {
            if (leastQueue.size() < k) {
                leastQueue.add(num);
            } else if (leastQueue.peek() > num) {
                leastQueue.poll();
                leastQueue.add(num);
            }
        }
        ArrayList result = new ArrayList();
        while (leastQueue.size() > 0) {
            result.add(leastQueue.poll());
        }
        return result;
    }

11.最大子矩阵
-
>已知矩阵的大小定义为矩阵中所有元素的和。
 给定一个矩阵，你的任务是找到最大的非空(大小至少是1 * 1)子矩阵。
 比如，如下4 * 4的矩阵<br>
 0 -2 -7 0<br>
 9 2 -6 2<br>
 -4 1 -4 1<br>
 -1 8 0 -2<br>
 的最大子矩阵是<br>
 9 2<br>
 -4 1<br>
 -1 8<br>
 这个子矩阵的大小是15。
 
总体思路：先简化为一维数组如何求最大子数组的问题，再讲二维数组压缩，转化为一维数组求最大子数组的问题。

步骤一：求一维数组的最大子数组
思路：首先是选择什么解法，最慢的是遍历，然后对遍历的结果求最大值。其次慢的是带记忆的遍历，即遍历的时候给最大值存在一个max变量中，时间复杂度会小一点，但是这两种方法都不太好。<br>
最优解的思路是动态规划，设i长度数组num[]的最大子矩阵值为f(i),第m个元素的值为num[i],可以得到公式:<br>
```
    f(i) = Math.max(f(i-1)+num[i],num[i])
```
这个公式是指从index为1的数开始向前累加，并且记录max，如果求和的值大于max则替换，一旦连续数组的和小于0，从i+1开始新建一个新的子数组，继续向前遍历。

步骤二：将二维数组遍历所有的行组成的矩阵，i(0<i<n)行,j(i<j<n),i,j行之间的矩阵按列求和，即转换为一维数组的求最大子数组的问题。<br>
代码参考 MaxSubMatrix

12.打印二叉树(同层从左往右)
-
>从上往下打印出二叉树的每个节点，同层节点从左至右打印。

思路：注意代码健壮性。首先需要建立一个先入先出的队列，然后遍历树的每一层，可以用start,end两个数字当做坐标，当上层遍历结束时，上层节点的孩子都加入了队列，队列中剩余节点数量为end.

代码如下：<br>
```
public static ArrayList<ArrayList<Integer>> printFromTopToBottom(TreeNode root) {
    ArrayList<ArrayList<Integer>> resultList = new ArrayList();
    if (root == null) {
        return resultList;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int start = 0;
    int end = 1;
    ArrayList<Integer> rowList = new ArrayList<>();
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        rowList.add(node.val);
        start++;
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
        if (start == end) {
            start = 0;
            end = queue.size();
            resultList.add(rowList);
            rowList = new ArrayList<>();
        }
    }
    return resultList;
}
```

13.打印二叉树(之字行)
---
>请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

思路：注意代码健壮性。之字型打印参考按层数打印，区别在于如果直接reverse，时间复杂度会比较高，利用Linkedlist双向链表的特性，遍历head的时候，从尾部add,遍历tail的时候，从头部add,依然采用index来划分层数。

代码如下:<br>

```
public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();
    LinkedList<TreeNode> nodes = new LinkedList<>();
    if (pRoot == null) return resultList;
    nodes.add(pRoot);
    int i = 0;
    int start = 0;
    int end = 1;
    ArrayList<Integer> rowList = new ArrayList<>();
    while (!nodes.isEmpty()) {
        TreeNode node;
        if ((i & 1) == 0) {
            node = nodes.removeLast();
            if (node.left != null) {
                nodes.addFirst(node.left);
            }
            if (node.right != null) {
                nodes.addFirst(node.right);
            }
        } else {
            node = nodes.removeFirst();
            if (node.right != null) {
                nodes.addLast(node.right);
            }
            if (node.left != null) {
                nodes.addLast(node.left);
            }
        }
        rowList.add(node.val);
        start++;

        if (start == end) {
            i++;
            start = 0;
            end = nodes.size();
            resultList.add(rowList);
            rowList = new ArrayList<>();
        }
    }
    return resultList;
}

```

14.两个栈实现队列
---
>用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

思路:栈的特点是先入后出，队列的特点是先入先出(FIFO),用stack1用来存新的元素，stack2用来pop，如果stack2为空，一次性将stack1中的元素导入到stack2中。

代码如下:<br>

```
public void push(int node) {
    stack1.push(node);
}

public int pop() {
    if (stack1.isEmpty() && stack2.isEmpty()) {
        return -1;
    }
    if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    return stack2.pop();
}

```

15.重建二叉树
---
>  task 15
   输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
   假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
   例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
   则重建二叉树并返回
   
思路：前序遍历的第一个数为a,在中序遍历中找到a的index，可以获得a的左右两个孩子对应的前序和中序的数组。递归求解。

代码如下:
 ```
public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    if (pre.length == 0 || in.length == 0) {
        return null;
    }
    TreeNode node = new TreeNode(pre[0]);
    int index = 0;
    for (int i = 0; i < pre.length; i++) {
        if (pre[0] == in[i]) {
            break;
        }
        index++;
    }
    int[] leftleft = new int[index];
    int[] leftright = new int[index];
    System.arraycopy(pre,1,leftleft,0,index);
    System.arraycopy(in,0,leftright,0,index);
    node.left = reConstructBinaryTree(leftleft, leftright);
    int[] rightleft = new int[pre.length - index-1];
    int[] rightright = new int[pre.length - index-1];
    System.arraycopy(pre,index+1,rightleft,0,pre.length - index-1);
    System.arraycopy(in,index+1,rightright,0,pre.length - index-1);
    node.right = reConstructBinaryTree(rightleft, rightright);
    return node;
}
```

16.替换字符串空格
---
>请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy

思路:首先需要知道有多少空格，遍历一遍求解，其次，需要新建一个新的char数组，然后一次按照顺序，copy字符，并且在遇到空字符的时候，进行替换。
用java操作的话有一个技巧，即StringBuffer的setLength()方法，也是进行一次替换，但是延长了char数组的元素数，然后从后向前进行填充。

代码如下:
```
public static String replaceSpace(StringBuffer str) {
    int oldLength = str.length();
    int countOfBlank = 0;
    for(int i =0;i<str.length();i++){
        if(str.charAt(i)==' '){
            countOfBlank++;
        }
    }
    int numberOfBlank=0;
    int newLength = oldLength+countOfBlank*2;
    str.setLength(newLength);
    for(int i=0;i<oldLength;i++){
        if(str.charAt(oldLength-i-1)==' '){
            str.setCharAt(newLength-i-1-numberOfBlank*2,'0');
            str.setCharAt(newLength-i-2-numberOfBlank*2,'2');
            str.setCharAt(newLength-i-3-numberOfBlank*2,'%');
            numberOfBlank++;
        }else{
            str.setCharAt(newLength-i-1-numberOfBlank*2,str.charAt(oldLength-i-1));
        }
    }
    return str.toString();
}
```

17.反转链表
---
>输入一个链表，反转链表后，输出新链表的表头。

思路：通过两个指针的移动操作来实现，pre指针指向head,cur指针指向head.next。循环每执行一次，cur成为后面链表的head,pre成为前面链表的head，知道最后,cur为null停止。

代码如下:
```
public static ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode pre = head;
    ListNode cur = head.next;
    head.next = null;
    while (cur != null) {
        ListNode tmp = cur;
        cur = cur.next;
        tmp.next = pre;
        pre = tmp;
    }
    return pre;
}
```

18.逆序打印链表
---
>输入一个链表，按链表值从尾到头的顺序返回一个ArrayList

思路:采用递归的方法，没次递归时，将该节点加入一个静态的list中。

代码如下:
```
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    if (listNode != null) {
        printListFromTailToHead(listNode.next);
        list.add(listNode.val);
    }
    return list;
}
```

19.有序二维数组中的查找
---
>在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

思路:从该二维数组的左下角开始搜索，如果数字比当前节点大，则向右走一步，如果比当前节点小，则向上走一步。

代码如下:
```
public static boolean find(int target, int[][] array) {
    int row = array.length - 1;
    int col = 0;
    while (row >= 0 && col <= array[0].length - 1) {
        if (array[row][col] == target) {
            return true;
        } else if (array[row][col] < target) {
            col++;
            continue;
        } else {
            row--;
            continue;
        }
    }
    return false;
}
```

20.N*N矩阵逆时针旋转90度
---
>讲一个N*N的矩阵顺时针旋转90度，并打印出来

思路:逆时针旋转分两步操作1.沿45度对角线交换2.沿垂直方向的中等分线交换。

代码如下:

```
private int[][] rotate(int[][] source) {
    //先沿对角线旋转 source[i][j]->source[j][i]
    for (int i = 0; i < source.length; i++) {
        for (int j = 0; j < i; j++) {
            swap(source,i,j);
        }
    }
    //在沿中心线替换
    for (int i = 0; i < source.length / 2; i++) {
        for (int j = 0; j < source[0].length; j++) {
            swapVerticle(source,i,j);
        }
    }
    return source;
}
```

21.TwoSum
---
>给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
示例:<br>
给定 nums = [2, 7, 11, 15], target = 9<br>
因为 nums[0] + nums[1] = 2 + 7 = 9<br>
所以返回 [0, 1]<br>

思路:遍历数组+哈希比较，哈希的时间复杂度是O(1)，所以整体的时间复杂度是O(1)+O(n),空间复杂度为哈希表的空间复杂度。

代码如下:
```
private int[] getTarget(int[] nums, int target) {
    HashMap map = new HashMap();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(target - nums[i])) {
            int[] result = new int[2];
            result[0] = (int) map.get(target - nums[i]);
            result[1] = i;
            return result;
        } else {
            map.put(nums[i], i);
        }
    }
    throw new RuntimeException("未找到结果");
}
```
