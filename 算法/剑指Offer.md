## 以下摘自牛客网剑指Offer

- [1.二维数组中的查找](#1二维数组中的查找)
- [2.替换空格](#2替换空格)
- [3.从尾到头打印链表](#3从尾到头打印链表)
- [4.重建二叉树](#4重建二叉树)
- [5.用两个栈实现队列](#5用两个栈实现队列)
- [6.旋转数组的最小数字](#6旋转数组的最小数字)
- [7.斐波那切数列](#7斐波那切数列)
- [8.跳台阶](#8跳台阶)
- [9.变态跳台阶](#9变态跳台阶)
- [10.矩阵覆盖](#10矩阵覆盖)
- [11.二进制中1的个数](#11二进制中1的个数)
- [12.数值的整数次方](#12数值的整数次方)
- [13.调整数组顺序使奇数位于偶数前面](#13调整数组顺序使奇数位于偶数前面)
- [14.链表中倒数第k个结点](#14链表中倒数第k个结点)
- [15.反转链表](#15反转链表)
- [16.合并两个排序链表](#16合并两个排序链表)
- [17.树的子结构](#17树的子结构)
- [18.二叉树的镜像](#18二叉树的镜像)
- [19.顺时针打印矩阵](#19顺时针打印矩阵)
- [20.包含min函数的栈](#20包含min函数的栈)
- [21.栈的压入、弹出序列](#21栈的压入、弹出序列)
- [22.从上往下打印二叉树](#22从上往下打印二叉树)
- [23.二叉搜索树的后序遍历序列](#23二叉搜索树的后序遍历序列)
- [24.二叉树中和为某一值的路径](#24二叉树中和为某一值的路径)
- [25.复杂链表的复制](#25复杂链表的复制)
- [26.二叉搜索树与双向链表](#26二叉搜索树与双向链表)
- [27.字符串的排列](#27字符串的排列)
- [28.数组中出现次数超过一半的数字](#28数组中出现次数超过一半的数字)
- [29.最小的K个数](#29最小的K个数)
- [30.连续子数组的最大和](#30连续子数组的最大和)
- [31.整数中1出现的次数](#31整数中1出现的次数)
- [32.把数组排成最小的数](#32把数组排成最小的数)
- [33.丑数](#33丑数)
- [34.第一个只出现一次的字符](#34第一个只出现一次的字符)
- [35.数组中的逆序对](#35数组中的逆序对)
- [36.两个链表的第一个公共结点](#36两个链表的第一个公共结点)
- [37.数字在排序数组中出现的次数](#37数字在排序数组中出现的次数)
- [38.二叉树的深度](#38二叉树的深度)
- [39.平衡二叉树](#39平衡二叉树)
- [40.数组中只出现一次的数字](#40数组中只出现一次的数字)
- [41.和为S的连续正数序列](#41和为S的连续正数序列)
- [42.和为S的两个数字](#42和为S的两个数字)
- [43.左旋转字符串](#43左旋转字符串)
- [44.翻转单词顺序](#44翻转单词顺序)
- [45.扑克牌顺子](#45扑克牌顺子)
- [46.孩子们的游戏](#46孩子们的游戏)
- [47.求1+2+3+\.\.\.+n](#47求1+2+3+\.\.\.+n)
- [48.不用加减乘除做加法](#48不用加减乘除做加法)
- [49.把字符串转换成整数](#49把字符串转换成整数)
- [50.数组中重复的数字](#50数组中重复的数字)
- [51.构建乘积数组](#51构建乘积数组)
- [52.正则表达式匹配](#52正则表达式匹配)
- [53.表示数值的字符串](#53表示数值的字符串)
- [54.字符流中第一个不重复的字符](#54字符流中第一个不重复的字符)
- [55.链表中环的入口结点](#55链表中环的入口结点)
- [56.删除链表中重复的结点](#56删除链表中重复的结点)
- [57.二叉树的下一个结点](#57二叉树的下一个结点)
- [58.对称的二叉树](#58对称的二叉树)
- [59.按之字形顺序打印二叉树](#59按之字形顺序打印二叉树)
- [60.把二叉树打印成多行](#60把二叉树打印成多行)
- [61.序列化二叉树](#61序列化二叉树)
- [62.二叉搜索树的第k个结点](#62二叉搜索树的第k个结点)
- [63.数据流中的中位数](#63数据流中的中位数)
- [64.滑动窗口的最大值](#64滑动窗口的最大值)
- [65.矩阵中的路径](#65矩阵中的路径)
- [66.机器人的运动范围](#66机器人的运动范围)

### 1.二维数组中的查找

**题目描述**

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
·
**Solution**

```java
/**
* 从左上角开始搜索
* 若小于target值，则向下搜索
* 若大于target值，则向左搜索
*/
public class Solution {
    public boolean Find(int target, int [][] array) {
        if (array == null || array.length < 1) {
            return false;
        }

        int col = array[0].length - 1;
        int row = 0;
        while (col >= 0 && row < array.length) {
            if (array[row][col] == target) {
                return true;
            }
            if (array[row][col] < target) { // 向下移动，寻找更大的元素
                row++;
            } else { // 向左移动，寻找更小的元素
                col--;
            }
        }
        return false;
    }
}
```

### 2.替换空格

**题目描述**

请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

**Solution**

```java
/**
* 遍历字符串，用StringBuilder拼接出新的字符串
*/
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	if (str == null || str.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == ' ' ? "%20" : str.charAt(i));
        }
        return sb.toString();
    }
}
```

### 3.从尾到头打印链表

**题目描述**

输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

结点定义如下：

```java
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
import java.util.*;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }
}
```

### 4.重建二叉树

**题目描述**

输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

结点定义如下：

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

**Solution**

```java
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length != in.length || pre.length == 0) {
            return null;
        }
        for(int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return rebuild(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode rebuild(int[] pre, int[] in, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(pre[ps]);
        int index = map.get(pre[ps]);
        root.left = rebuild(pre, in, ps + 1, index - is + ps, is, index);
        root.right = rebuild(pre, in, index - is + ps + 1, pe, index + 1, ie);
        return root;
    }
}
```

### 5.用两个栈实现队列

**题目描述**

用两个栈来实现一个队列，完成队列的push和pop操作。 队列中的元素为int类型。

**Solution**

```java
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
}
```

### 6.旋转数组的最小数字

**题目描述**

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

**Solution**

```java
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (array[m] < array[array.length - 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return array[l];
    }
}
```

### 7.斐波那切数列

**题目描述**

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。

n<=39

**Solution**

```java
/**
* 用递归当n很大时容易StackOverflowError
* 这里采用迭代法：
* F(n) = F(n - 1) + F(n - 2);
*/
public class Solution {
    public int Fibonacci(int n) {
        if (n < 1) {
            return n;
        }
        int pre = 0, cur = 1;
        for (int i = 1; i < n; i++) {
            int temp = cur;
            cur += pre;
            pre = temp;
        }
        return cur;
    }
}
```

### 8.跳台阶

**题目描述**

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

**Solution**

```java
/**
* 仔细分析可以发现本题能转化为斐波那契数列第n项值的问题
*/
public class Solution {
    public int JumpFloor(int target) {
        int pre = 0;
        int res = 1;
        
        for (int i = 0; i < target; i++) {
            int temp = res;
            res += pre;
            pre = temp;
        }
        
        return res;
    }
}
```

### 9.变态跳台阶

**题目描述**

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

**Solution**

```java
/**
* 每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)中情况
*/
public class Solution {
    public int JumpFloorII(int target) {
        return 1 << (target - 1);
    }
}
```

### 10.矩阵覆盖

**题目描述**

我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

**Solution**

```java
/**
* 通过分析发现其依旧是斐波那契问题
*/
public class Solution {
    public int RectCover(int target) {
        if (target < 4) {
            return target;
        }
        
        int pre = 2;
        int res = 3;
        
        for (int i = 3; i < target; i++) {
            int temp = res;
            res += pre;
            pre = temp;
        }
        
        return res;
    }
}
```

### 11.二进制中1的个数

**题目描述**

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

**Solution**

```java
public class Solution {
    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= (n - 1);
        }
        return res;
    }
}
```

### 12.数值的整数次方

**题目描述**

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

**Solution**

```java
public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = exponent < 0;
        exponent = Math.abs(exponent);
        double res = Power(base * base, exponent >>> 1);
        if ((exponent & 1) != 0) {
            res *= base;
        }
        return isNegative ? 1 / res : res;
    }
}
```

### 13. 调整数组顺序使奇数位于偶数前面

**题目描述**

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

**Solution**

```java
public class Solution {
    public void reOrderArray(int [] array) {
        int[] temp = array.clone();
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                evenIndex++;
            }
        }
        
        for (int i = 0; i < temp.length; i++) {
            if ((temp[i] & 1) == 1) {
                array[oddIndex++] = temp[i];
            } else {
                array[evenIndex++] = temp[i];
            }
        }
    }
}
```

### 14.链表中倒数第k个结点

**题目描述**

输入一个链表，输出该链表中倒数第k个结点。

结点定义如下：

```java
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
```

### 15.反转链表

**题目描述**

输入一个链表，反转链表后，输出新链表的表头。

结点定义如下：

```java
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
/**
* 头插法
*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
```

### 16.合并两个排序链表

**题目描述**

输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

结点定义如下：

```java
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        pre.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
```

### 17.树的子结构

**题目描述**

输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtree(root1, root2) 
            || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    
    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        return root1.val == root2.val 
            && isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}
```

### 18.二叉树的镜像

**题目描述**

操作给定的二叉树，将其变换为源二叉树的镜像。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}
```

### 19.顺时针打印矩阵

**题目描述**

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

**Solution**

```java
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new  ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (l <= r && t <= b) {
            for (int i = l; i <= r; i++) {
                res.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            if (l > r || t > b) {
                return res;
            }
            for (int i = r; i >= l; i--) {
                res.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i >= t; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}
```

### 20.包含min函数的栈

**题目描述**

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    
    public void push(int node) {
        stack.push(node);
        minStack.push((minStack.isEmpty() || node < minStack.peek()) ? node : minStack.peek());
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}
```

### 21.栈的压入、弹出序列

**题目描述**

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

**Solution**

```java
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length != popA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && popA[popIndex] == stack.peek()) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
```

### 22.从上往下打印二叉树

**题目描述**

从上往下打印出二叉树的每个节点，同层节点从左至右打印。

**Solution**

```java
import java.util.*;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
```

### 23.二叉搜索树的后序遍历序列

**题目描述**

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。

**Solution**

```java
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }
    
    private boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        
        int i = end - 1;
        // 寻找左子树最后一个节点位置
        while (i >= start && sequence[i] > sequence[end]) {
            i--;
        }
        
        // 左子树节点不能大于跟节点
        for (int j = i; j >= start; j--) {
            if (sequence[j] > sequence[end]) {
                return false;
            }
        }
        return verify(sequence, start, i) && verify(sequence, i + 1, end - 1);
    }
}
```

### 24.二叉树中和为某一值的路径

**题目描述**

输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
import java.util.ArrayList;

public class Solution {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);

        return res;
    }
}
```

### 25.复杂链表的复制

**题目描述**

输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

结点定义如下：

```java
结点定义如下：

public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
```

**Solution**

```java
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return pHead;
        }
        
        // 复制每个结点并插入到其后面
        RandomListNode node = pHead;
        while (node != null) {
            RandomListNode next = node.next;
            node.next = new RandomListNode(node.label);
            node.next.next = next;
            node = next;
        }
        
        // 将random指针值赋予新节点
        node = pHead;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        
        // 分离新旧结点
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        node = pHead;
        while (node != null) {
            pre.next = node.next;
            pre = pre.next;
            node.next = node.next.next;
            node = node.next;
        }
        return dummy.next;
    }
}
```

### 26.二叉搜索树与双向链表

**题目描述**

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
import java.util.*;

public class Solution {

    // 解法一：非递归中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRootOfTree;
        TreeNode root = null;
        TreeNode pre = null;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre == null) {
                root = node;
                node.left = null;
            } else {
                node.left = pre;
                pre.right = node;
            }
            pre = node;
            node = node.right;
        }
        return root;
    }

    // 解法二：递归中序遍历
    private TreeNode pre;
    private TreeNode root;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }

        Convert(pRootOfTree.left);
        pRootOfTree.left = pre;
        if (pre == null) {
            root = pRootOfTree;
        } else {
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return root;
    }
}
```

### 27.字符串的排列

**题目描述**

输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。

**输入描述**

```
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
```

**Solution**

```java
public class Solution {
    private ArrayList<String> list = new ArrayList<>();
    private boolean[] visited;
    
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return list;
        }
        char[] chs = str.toCharArray();
        Arrays.sort(chs);
        visited = new boolean[str.length()];
        permute(chs, new StringBuilder(), visited);
        return list;
    }
    
    private void permute(char[] chs, StringBuilder sb, boolean[] visited) {
        if (sb.length() == chs.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < chs.length; i++) {
            if (i > 0 && chs[i] == chs[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                sb.append(chs[i]);
                permute(chs, sb, visited);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
}
```

### 28.数组中出现次数超过一半的数字

**题目描述**

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。

**Solution**

```java
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int res = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (res == array[i]) {
                count++;
            } else if (--count == 0) {
                res = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int a : array) {
            if (a == res) {
                count++;
            }
        }
        return count * 2 > array.length ? res : 0;
    }
}
```

### 29.最小的K个数

**题目描述**

输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

**Solution**

```java
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k-- > input.length) {
            return res;
        }
        int l = 0, r = input.length - 1;
        while (l < r) {
            int p = partition(input, l, r);
            if (p == k) {
                break;
            }
            if (p < k) {
                l = p + 1;
            } else {
                r = p - 1;
            }
        }
        for (int i = 0; i <= k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private int partition(int[] input, int start, int end) {
        int temp = input[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && input[j] > temp) {
                j--;
            }
            while (i < j && input[i] <= temp) {
                i++;
            }
            if (i < j) {
                swap(input, i, j);
            }
        }
        swap(input, start, i);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
```

### 30.连续子数组的最大和

**题目描述**

HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

**Solution**

```java
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
```

### 31.整数中1出现的次数

**题目描述**

求出1-13的整数中1出现的次数,并算出100-1300的整数中1出现的次数？为此他特别数了一下1-13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

**Solution**

```java
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 1; i <= n && i > 0; i *= 10) {
            int a = n / i; // 表示i位置及前面的数
            int b = n % i; // 表示i位置后面的数
            if (a % 10 == 0) {// i位置为0，则i位置为1有(a / 10) * i种可能
                count += (a / 10) * i;
            } else if (a % 10 == 1) {// i位置为1，则i位置为1有(a / 10) * i + b + 1种可能
                count += (a / 10) * i + b + 1;
            } else {// i位置为2 - 9，则i位置为1有(a /10 + 1) * i种可能
                count += (a /10 + 1) * i;
            }
        }
        
        return count;
    }
}
```

### 32.把数组排成最小的数

**题目描述**

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

**Solution**

```java
public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : nums) {
            sb.append(str);
        }
        return sb.toString();
    }
}
```

### 33.丑数

**题目描述**

把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

**Solution**

```java
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) {
            return index;
        }
        int[] array = new int[index];
        array[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < index; i++) {
            array[i] = Math.min(Math.min(array[i2] * 2, array[i3] * 3), array[i5] * 5);
            if (array[i] == array[i2] * 2) {
                i2++;
            }
            if (array[i] == array[i3] * 3) {
                i3++;
            }
            if (array[i] == array[i5] * 5) {
                i5++;
            }
        }
        return array[index - 1];
    }
}
```

### 34.第一个只出现一次的字符

**题目描述**

在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

**Solution**

```java
import java.util.BitSet;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        BitSet bitSet1 = new BitSet(256);
        BitSet bitSet2 = new BitSet(256);
        for (int i = 0; i < str.length(); i++) {
            if (!bitSet1.get(str.charAt(i)) && !bitSet2.get(str.charAt(i))) {
                bitSet1.set(str.charAt(i));
            } else {
                bitSet2.set(str.charAt(i));
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (bitSet1.get(str.charAt(i)) && !bitSet2.get(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
```

### 35.数组中的逆序对

**题目描述**

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

**输入描述**

```html
题目保证输入的数组中没有的相同的数字
数据范围：
	对于50%的数据,size<=10^4
	对于75%的数据,size<=10^5
	对于100%的数据,size<=2*10^5
```

示例1

**输入**

复制

```html
1,2,3,4,5,6,7,0
```

**输出**

复制

```html
7
```

**Solution**

```java
public class Solution {
    private long cnt = 0;
    private int[] temp;

    public int InversePairs(int [] array) {
        temp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + end >> 1;
        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private void merge(int[] array, int start, int mid, int end) {
        int k = 0;
        int i = start, j = mid + 1;
        while (i <= mid || j <= end) {
            if (i > mid) {
                temp[k++] = array[j++];
            } else if (j > end) {
                temp[k++] = array[i++];
            } else if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                cnt += mid - i + 1;
            }
        }
        for (i = 0; i < k; i++) {
            array[start + i] = temp[i];
        }
    }
}
```

### 36.两个链表的第一个公共结点

**题目描述**

输入两个链表，找出它们的第一个公共结点。

**Solution**

```java
import java.util.*;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
```

### 37.数字在排序数组中出现的次数

**题目描述**

统计一个数字在排序数组中出现的次数。

**Solution**

```java
public class Solution {
    public int GetNumberOfK(int[] array , int k) {
        int first = searchFirst(array, k);
        int last = searchLast(array, k);
        return (first >= array.length || array[first] != k) ? 0 : (last - first + 1);
    }
    
    private int searchFirst(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (array[m] >= k) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    private int searchLast(int[] array, int k) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (array[m] <= k) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
```

### 38.二叉树的深度

**题目描述**

输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public int TreeDepth(TreeNode root) {
        return root == null ? 0
            : 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
```

### 39.平衡二叉树

**题目描述**

输入一棵二叉树，判断该二叉树是否是平衡二叉树。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    private boolean flag = true;
    
    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return flag;
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
```

### 40.数组中只出现一次的数字

**题目描述**

一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。

**Solution**

```java
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp = 0;
        for (int a : array) {
            temp ^= a;
        }
        temp &= -temp;
        
        for (int a : array) {
            if ((a & temp) == 0) {
                num1[0] ^= a;
            } else {
                num2[0] ^= a;
            }
        }
    }
}
```

### 41.和为S的连续正数序列

**题目描述**

小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

**输出描述**:

```html
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
```

**Solution**

```java
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int l = 1, r = 2, curr = 3;
        
        while (l < r && r < sum) {
            if (curr < sum) {
                curr += ++r;
            } else if (curr > sum) {
                curr -= l++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    list.add(i);
                }
                res.add(list);
                curr -= l++;
            }
        }
        
        return res;
    }
}
```

### 42.和为S的两个数字

**题目描述**

输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

**输出描述**:

```html
对应每个测试案例，输出两个数，小的先输出。
```

**Solution**

```java
import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int l = 0, r = array.length - 1;
        while (l <= r) {
            if (array[l] + array[r] < sum) {
                l++;
            } else if (array[l] + array[r] > sum) {
                r--;
            } else {
                if (res.size() == 0 || array[l] * array[r] < res.get(0) * res.get(1)) {
                    res.clear();
                    res.add(array[l]);
                    res.add(array[r]);
                }
                l++;
                r--;
            }
        }
        
        return res;
    }
}
```

### 43.左旋转字符串

**题目描述**

汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！

**Solution**

```java
public class Solution {
    public String LeftRotateString(String str,int n) {
        n = str.length() == 0 ? 0 : n % str.length();
        char[] chs = str.toCharArray();
        reverse(chs, 0, n - 1);
        reverse(chs, n, str.length() - 1);
        reverse(chs, 0, str.length() - 1);
        return new String(chs);
    }
    
    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            swap(chs, i++, j--);
        }
    }
    
    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
```

### 44.翻转单词顺序

**题目描述**

牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？

**Solution**

```java
public class Solution {
    public String ReverseSentence(String str) {
        char[] chs = str.toCharArray();
        int j = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == ' ') {
                reverse(chs, j, i - 1);
                j = i + 1;
            }
        }
        reverse(chs, 0, str.length() - 1);
        return new String(chs);
    }

    private void reverse(char[] chs, int i, int j) {
        while (i < j) {
            swap(chs, i++, j--);
        }
    }

    private void swap(char[] chs, int i, int j) {
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
```

### 45.扑克牌顺子

**题目描述**

LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

**Solution**

```java
import java.util.Arrays;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        
        Arrays.sort(numbers);
        int count = 0;// 癞子个数
        for (int number : numbers) {
            if (number == 0) {
                count++;
            }
        }
        // 非0
        for (int i = count; i < numbers.length - 1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }
            count -= numbers[i + 1] - numbers[i] - 1;
        }
        return count >= 0;
    }
}
```

### 46.孩子们的游戏

**题目描述**

每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

**Solution**

```java
/**
* 约瑟夫环问题
*/
public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }
}
```

### 47.求1+2+3+\.\.\.+n

**题目描述**

求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

**Solution**

```java
/**
* 递归吧
*/
public class Solution {
    public int Sum_Solution(int n) {
        int res = n;
        boolean a = (n > 0) && (res += Sum_Solution(n - 1)) > 0;
        return res;
    }
}
```

### 48.不用加减乘除做加法

**题目描述**

写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。

**Solution**

```java
public class Solution {
    public int Add(int a,int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }
}
```

### 49.把字符串转换成整数

**题目描述**

将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。

**输入描述**

```html
输入一个字符串,包括数字字母符号,可以为空
```

**输出描述**:

```html
如果是合法的数值表达则返回该数字，否则返回0
```

示例1

**输入**

```html
+2147483647
    1a33
```

**输出**

```html
2147483647
    0
```

**Solution**

```java
public class Solution {
    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int isNegative = str.charAt(0) == '-' ? -1 : 1;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
            res = res * 10 + str.charAt(i) - '0';
        }
        return isNegative * res;
    }
}
```

### 50.数组中重复的数字

**题目描述**

在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

**Solution**

```java
public class Solution {
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[numbers[i]] == numbers[i]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

### 51.构建乘积数组

**题目描述**

给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

**Solution**

```java
import java.util.ArrayList;

public class Solution {
    public int[] multiply(int[] A) {
        if (A == null) {
            return A;
        }
        
        int[] B = new int[A.length];
        
        // 从前往后遍历，每次product = A[0] * A[1] * ... * A[i - 1];
        for (int i = 0, product = 1; i < A.length; product *= A[i], i++) {
            B[i] = product;
        }
        
        // 从后往前遍历，每次product = A[n - 1] * A[n - 2] * ... * A[i + 1]
        for (int i = A.length - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        
        return B;
    }
}
```

### 52.正则表达式匹配

**题目描述**

请实现一个函数用来匹配包括'.'和'\*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab\*ac\*a"匹配，但是与"aa.a"和"ab\*a"均不匹配

**Solution**

```java
class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, pattern, 0, 0);
    }

    /**
     * 匹配正则表达式
     * @param str 要匹配的字符串
     * @param pattern 正则表达式
     * @param s str索引
     * @param p patter索引
     * @return
     */
    private boolean match(char[] str, char[] pattern, int s, int p) {
        // 到底了
        if (p == pattern.length) {
            return s == str.length;
        }
        // 正则表达式下一位为*，此时考虑两种情况
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            // 若正则表达式当前位字符与字符串当前位置相匹配，则匹配1位或者0位
            if (str.length > s && (pattern[p] == str[s] || pattern[p] == '.')) {
                return match(str, pattern, s, p + 2)
                        || match(str, pattern, s + 1, p);
            }
            // 若正则表达式当前位字符与字符串当前位置不匹配，则匹配0位
            return match(str, pattern, s, p + 2);
        }

        // 匹配1位
        if (str.length > s && (pattern[p] == '.' || pattern[p] == str[s])) {
            return match(str, pattern, s + 1, p + 1);
        }

        return false;
    }
}
```

### 53.表示数值的字符串

**题目描述**

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

**Solution**

```java
/**
* 利用正则表达式求解，字符串格式应为正负号（非必须）+ 整数（必须）+ 小数点和整数（非必须）+（E或e和正负号（非必须）和整数）（非必须）
*/
public class Solution {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length < 1) {
            return false;
        }
        
        return String.valueOf(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([Ee][\\+\\-]?\\d+)?");
    }
}
```

### 54.字符流中第一个不重复的字符

**题目描述**

请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。

**输出描述**:

```html
如果当前字符流没有存在出现一次的字符，返回#字符。
```

**Solution**

```java
public class Solution {
    private Queue<Character> queue = new LinkedList<>();
    private int[] map = new int[256];
    
    public void Insert(char ch) {
        queue.offer(ch);
        map[ch]++;
        while (!queue.isEmpty() && map[queue.peek()] > 1) {
            queue.poll();
        }
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }
}
```

### 55.链表中环的入口结点

**题目描述**

给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。

结点定义如下：

```java
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
/**
 * 先说个定理：两个指针一个fast、一个slow同时从一个链表的头部出发
 * fast一次走2步，slow一次走一步，如果该链表有环，两个指针必然在环内相遇
 * 此时只需要把其中的一个指针重新指向链表头部，另一个不变（还在环内），
 * 这次两个指针一次走一步，相遇的地方就是入口节点。
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        
        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
```

### 56.删除链表中重复的结点

**题目描述**

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

结点定义如下：

```java
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                int temp = cur.val;
                while (pre.next != null && pre.next.val == temp) {
                    pre.next = pre.next.next;
                }
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
```

### 57.二叉树的下一个结点

**题目描述**

给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。

结点定义如下：

```java
public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode.next != null) {
            TreeLinkNode next = pNode.next;
            if (next.left == pNode) {
                return next;
            }
            pNode = next;
        }
        return null;
    }
}
```

### 58.对称的二叉树

**题目描述**

请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    
    private boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetrical(left.left, right.right) 
            && isSymmetrical(left.right, right.left);
}
}
```

### 59.按之字形顺序打印二叉树

**题目描述**

请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(pRoot);
        int level = 1;
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                if ((level & 1) == 1) {
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                } else {
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
            }
            res.add(list);
            level++;
        }
        return res;
    }
}
```

### 60.把二叉树打印成多行

**题目描述**

从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        
        while (queue.size() > 0) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
```

### 61.序列化二叉树

**题目描述**

请实现两个函数，分别用来序列化和反序列化二叉树

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    private int index = -1;

    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append('!');
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        String[] splits = str.split("!");
        return helper(splits);
    }

    private TreeNode helper(String[] splits) {
        index++;
        if ("#".equals(splits[index])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(splits[index]));
        root.left = helper(splits);
        root.right = helper(splits);
        return root;
    }
}
```

### 62.二叉搜索树的第k个结点

**题目描述**

给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。

结点定义如下：

```java
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
```

**Solution**

```java
public class Solution {
    public TreeNode KthNode(TreeNode pRoot, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = pRoot;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (++count == k) {
                return node;
            }
            node = node.right;
        }
        return null;
    }
}
```

### 63.数据流中的中位数

**题目描述**

如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。

```java
public class Solution {
    private Queue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
    private Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private int n;
    
    public void Insert(Integer num) {
        if ((n++ & 1) == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double GetMedian() {
        return ((n & 1) == 1) ? 
            (double) minHeap.peek() : ((minHeap.peek() + maxHeap.peek()) / 2.0);
    }
}
```

### 64.滑动窗口的最大值

**题目描述**

给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

```java
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size > num.length || size < 1) {
            return res;
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < size; i++) {
            maxHeap.offer(num[i]);
        }
        res.add(maxHeap.peek());
        for (int i = size; i < num.length; i++) {
            maxHeap.remove(num[i - size]);
            maxHeap.offer(num[i]);
            res.add(maxHeap.peek());
        }
        return res;
    }
}
```

### 65.矩阵中的路径

**题目描述**：

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

**Solution**

```java
public class Solution {
    private boolean[] visited;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(matrix, str, rows, cols, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[] matrix, char[] str, int rows, int cols, int r, int c, int index) {
        if (index == str.length) {
            return true;
        }
        int idx = r * cols + c;
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[idx] || matrix[idx] != str[index]) {
            return false;
        }
        boolean res = false;
        visited[idx] = true;
        for (int[] d : directions) {
            if (dfs(matrix, str, rows, cols, r + d[0], c + d[1], index + 1)) {
                res = true;
                break;
            }
        }
        visited[idx] = false;
        return res;
    }
}
```

### 66.机器人的运动范围：

**题目描述**

地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？

**Solution**

```java
public class Solution {
    private int res = 0;
    private boolean[][] visited;
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows][cols];
        dfs(threshold, rows, cols, 0, 0);
        return res;
    }
    
    private void dfs(int threshold, int rows, int cols, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols 
            || visited[r][c] || (sum(r) + sum(c)) > threshold) {
            return;
        }
        res++;
        visited[r][c] = true;
        for (int[] d : directions) {
            dfs(threshold, rows, cols, r + d[0], c + d[1]);
        }
    }
    
    private int sum(int a) {
        int res = 0;
        while (a > 0) {
            res += a % 10;
            a /= 10;
        }
        return res;
    }
}
```