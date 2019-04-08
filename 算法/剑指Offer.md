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
/**
* 先序遍历第一个位置肯定是根节点node，
* 中序遍历的根节点位置在中间i，在i左边的肯定是node的左子树的中序数组，i右边的肯定是node的右子树的中序数组
* 另一方面，先序遍历的第二个位置到i，也是node左子树的先序子数组，剩下i右边的就是node的右子树的先序子数组
* 把四个段找出来，分左右递归调用即可
*/
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null || pre.length != in.length || pre.length == 0) {
            return null;
        }
        
        return reBuildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }
    
    private TreeNode reBuildTree(int[] pre, int[] in, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        
        TreeNode node = new TreeNode(pre[ps]);
        for (int i = is; i <= ie; i++) {
            if (in[i] == pre[ps]) {
                node.left = reBuildTree(pre, in, ps + 1, ps + i - is, is, i - 1);
                node.right = reBuildTree(pre, in, ps + i - is + 1, pe, i + 1, ie);
            }
            break;
        }
        return node;
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
/**
* 二分查找的变形
*/
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else if (array[mid] == array[right]) {
                right--;
            } else {
                right = mid;
            }
        }
        return array[left];
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
        if (n < 2) {
            return n;
        }
        
        int a = 1;
        int b = 1;
        for (int i = 2; i < n; i++) {
            int temp = a;
            a = b;
            b += temp;
        }
        return b;
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
        if (target < 2) {
            return 1;
        }
        
        int a = 1;
        int b = 1;
        for (int i = 2; i <= target; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b;
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
        if (target < 2) {
            return 1;
        }
        return (int) Math.pow(2, target - 1);
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
        if (target < 2) {
            return target;
        }
        int a = 1;
        int b = 1;
        for (int i = 2; i <= target; i++) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b;
    }
}
```

### 11.二进制中1的个数

**题目描述**

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

**Solution**

```java
/**
* 循环右移，直至n == 0，每次判断最后一位二进制是否为1，若为1，则计数器加1
*/
public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        
        return count;
    }
}
```

### 12.数值的整数次方

**题目描述**

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

**Solution**

```java
/**
* 指数取绝对值，然后求 base ^ Math.abs(exponent)
* 若exponent为负，则在求倒数
*/
public class Solution {
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1.0;
        }
        
        return (exponent >>> 31 == 1) ? (1.0 / myPower(base, Math.abs(exponent))) : myPower(base, Math.abs(exponent));
    }
    
    private double myPower(double base, int exponent) {
        double res = 1.0;
        for (int i = 0; i < exponent; i++) {
            res *= base;
        }
        return res;
    }
}
```

### 13. 调整数组顺序使奇数位于偶数前面

**题目描述**

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

**Solution**

```java
/**
*  插入法
*/
public class Solution {
    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int m = -1; // 记录排好序的最后一个奇数位置
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) { // 奇数
                int temp = array[i];
                for (int j = i; j > m + 1; j--) {
                    array[j] = array[j - 1];
                }
                array[m + 1] = temp;
                m++;
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
/**
* 快慢指针法，快指针先移动k - 1位
*/
import java.util.Stack;
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
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
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = temp;
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
        ListNode curr = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
            }
        }
        curr.next = list1 != null ? list1 : list2;
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
        if (root1 == null || root2 == null) { //如果A，B有一个为null，则直接返回false
            return false;
        }
        // B树为A树当前结点的子结构，或者B树为A树当前结点的左子树的子结构，或者B树为A树当前结点的右子树的子结构
        return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }
    
    private boolean isSubtree(TreeNode rootA, TreeNode rootB) {
        if (rootB == null) {// B树为空，说明其已经完成遍历并且能够对应上
            return true;
        }
        if (rootA == null) {// A树为空，说明其不能完全包含B树
            return false;
        }
        // 要使得B树为A树的子结构，需要保证A树当前结点的值等于B树根结点的值，且B树的左右子树也为A树当前结点的左右子树的子结构
        return (rootA.val == rootB.val) && isSubtree(rootA.left, rootB.left) && isSubtree(rootA.right, rootB.right);
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
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {// 打印上面一行
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {// 打印右边一列
                res.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) {// 已打印完毕
                return res;
            }
            for (int i = right; i >= left; i--){// 打印底部一行
                res.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--){// 打印左边一列
                res.add(matrix[i][left]);
            }
            left++;
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
/**
* 开辟两个栈，一个保存当前每次插入后的最小值，一个保存数据
*/
import java.util.Stack;

public class Solution {
    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            minStack.push(Math.min(node, minStack.peek()));
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
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
/**
* 本题题意为：给定两个数组，将第一个数组按照某种顺序全部压入并弹出栈，第二个数组为其弹出顺序
* 思路：开辟一个栈，然后模拟数组压入顺序，
* 若栈顶元素与第二个数组当前位置元素相同，则要弹出，并向后移动第二数组位置
*/

import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        
        Stack<Integer> stack = new Stack<>();
        int popPosition = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() &&  stack.peek() == popA[popPosition]) {
                stack.pop();
                popPosition++;
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
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        
        // 将random指针值赋予新节点
        node = pHead;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        
        // 分离新旧结点
        RandomListNode newHead = pHead.next;
        node = pHead;
        while (node != null) {
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            newNode.next = node.next == null ? null : node.next.next;
            node = node.next;
        }
        
        return newHead;
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
        TreeNode head = null;
        TreeNode node = pRootOfTree;
        TreeNode pre = null;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre == null) {
                pre = node;
                head = node;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;
            }
            node = node.right;
        }

        return head;
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
import java.util.*;

public class Solution {
    private ArrayList<String> res = new ArrayList<>();
    private boolean[] visited;
    
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return res;
        }
        
        visited = new boolean[str.length()];
        permutation(str, 0, "");
        return res;
    }
    
    private void permutation(String str, int index, String curr) {
        if (index == str.length()) {
            res.add(curr);
            return;
        }
        
        // 去重
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if (!visited[i] && !set.contains(str.charAt(i))) {
                visited[i] = true;
                set.add(str.charAt(i));
                permutation(str, index + 1, curr + str.charAt(i));
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
/*
* 用Map记录元素个数
*/

import java.util.*;

public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int capacity = array.length >> 1;
        for (int num : array) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > capacity) {
                return num;
            }
        }
        return 0;
    }
}
```

### 29.最小的K个数

**题目描述**

输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。

**Solution**

```java
/**
* 使用优先队列，即小顶堆，将全部元素保存到优先队列中，弹出的前K个元素即为最小的K个元素
*/

import java.util.*;

public class Solution {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || k > input.length || k <= 0) {
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int num : input) {
            queue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            res.add(queue.poll());
        }
        return res;
    }
}
```

### 30.连续子数组的最大和

**题目描述**

HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)

**Solution**

```java
/*
* 动态规划
* max保存当前最大值，res保存全局最大值
*/
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        
        int res = array[0];// 保存全局最大值
        int max = array[0];// 保存当前最大值
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
/**
* 转化为流处理，将数字转化为字符串，然后比较s1 + s2 与 s2 + s1的大小，进行排序，再拼接为字符串即可
*/
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s1 + s2).compareTo(s2 + s1))
                .collect(Collectors.joining());
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
        if (index < 7) { // 前6个丑数为其自身
            return index;
        }

        int[] array = new int[index + 1];
        array[0] = 1;
        //i2，i3，i5分别为三个队列的指针
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for (int i = 1; i < array.length; i++) {
            //选出三个队列头最小的数
            array[i] = Math.min(Math.min(array[i2] * 2, array[i3] * 3), array[i5] * 5);
            //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
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
import java.util.*;

public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
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
    private int res = 0;
    private int[] temp;
    
    public int InversePairs(int [] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        
        temp = new int[array.length];
        mergeSortAndCalc(array, 0, array.length - 1);
        return res;
    }
    
    // 归并排序
    private void mergeSortAndCalc(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int mid = start + ((end - start) >> 1);
        mergeSortAndCalc(array, start, mid);
        mergeSortAndCalc(array, mid + 1, end);
        
        merge(array, start, mid, end);
    }
    
    // 将一个数组中的两个相邻有序区间合并成一个
    private void merge(int array[], int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
                res += mid - i + 1;
                res %= 1000000007;
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= end) {
            temp[k++] = array[j++];
        }
        for(int m = 0; m < k; m++) {
            array[m + start] = temp[m];
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
        Set<ListNode> set = new HashSet<>();
        
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != null) {
            set.add(node1);
            node1 = node1.next;
        }
        while (node2 != null) {
            if (set.contains(node2)) {
                return node2;
            }
            
            node2 = node2.next;
        }
        return null;
    }
}
```

### 37.数字在排序数组中出现的次数

**题目描述**

统计一个数字在排序数组中出现的次数。

**Solution**

```java
// 因为data中都是整数，所以可以稍微变一下，不是搜索k的两个位置，而是搜索k-0.5和k+0.5这两个数应该插入的位置，然后相减即可。

public class Solution {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return binarySearch(array, k + 0.5) - binarySearch(array, k - 0.5);
    }
    
    private int binarySearch(int[] array, double k) {
        int left = 0;
        int right = array.length - 1;
        
        while (right >= left) {
            int mid = left + ((right - left) >> 1);
            if (array[mid] > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
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
import java.util.*;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        Object[] elements = set.toArray();
        num1[0] = (Integer) elements[0];
        num2[0] = (Integer) elements[1];
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
import java.util.ArrayList;
    
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 2;
        int curSum = 3;
        
        while (right < sum) {
            if (curSum < sum) {
                right++;
                curSum += right;
            } else if (curSum > sum) {
                curSum -= left;
                left++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                res.add(list);
                curSum -= left;
                left++;
                right++;
                curSum += right;
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
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] + array[right] < sum) {
                left++;
            } else if (array[left] + array[right] > sum) {
                right--;
            } else {
                if (res.isEmpty()
                        || res.get(0) * res.get(1) > array[left] * array[right]) {
                    res.clear();
                    res.add(array[left]);
                    res.add(array[right]);
                }
                left++;
                right--;
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
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() < 2) {
            return str;
        }
        
        int k = n % str.length();
        return str.substring(k) + str.substring(0, k);
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
        // str = " "的情况容易忽略
        if (str == null || str.trim().isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        String[] temp = str.split(" ");
        for (int i = temp.length - 1; i > 0; i--) {
            sb.append(temp[i]).append(" ");
        }
        return sb.append(temp[0]).toString();
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
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            // 异或相当于求和
            int sum = (num1 ^ num2);
            // 与再左移一位相当于进位
            num2 = (num1 & num2) << 1;
            num1 = sum;
        }
        return num1;
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
        if (str == null || "".equals(str)) {
            return 0;
        }
        
        int index = 0;
        int flag = 1;
        int res = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            flag = -1;
        }
        
        while (index < str.length()) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                return 0;
            }
            res = res * 10 + str.charAt(index++) - '0';
        }
        return flag * res;
    }
}
```

### 50.数组中重复的数字

**题目描述**

在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

**Solution**

```java
import java.util.*;

public class Solution {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }
        // 保存元素，判断是否存在
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                duplication[0] = number;
                return true;
            }
            set.add(number);
        }
        return false;
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
import java.util.LinkedHashMap;

/**
 * LinkedHashMap利用双向链表保存了键的插入顺序
 */
public class Solution {
    private LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Character character : map.keySet()) {
            if (map.get(character) == 1) {
                return character;
            }
        }
        return '#';
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
        ListNode slow = pHead;
        ListNode fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != null && fast.next == null) {
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
        ListNode curr = pHead;
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                int temp = curr.val;
                curr = curr.next.next;
                while (curr != null && curr.val == temp) {
                    curr = curr.next;
                }
                pre.next = curr;
            } else {
                pre = curr;
                curr = curr.next;
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
        // 右节点不为空，说明下一个结点在右子树，只需在右子树往左下沉
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        // 右节点为空，说明向下一个结点是所在左子树的父节点或所在右子树的父节点的父节点
        // 但是不管怎样，只要向上回溯，找到第一个父节点的左节点为当前节点的节点即可，其父节点就是要找的中序遍历下一个节点
        while (pNode.next != null) {
            if (pNode.next.left == pNode) {
                return pNode.next;
            }
            pNode = pNode.next;
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
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
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
/**
 * 使用双向队列保存每一层的节点
 * 奇数层从头部取节点，采用尾插法保存，
 * 偶数层从尾部取节点，采用头插法保存
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode node = pRoot;
        int count = 1;
        int level = 1;
        queue.offerFirst(node);
        while (!queue.isEmpty()) {
            int size = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (count-- > 0) {
                if ((level & 1) == 1) { // 奇数层，从左到右打印
                    node = queue.pollFirst();
                    if (node.left != null) {
                        queue.offerLast(node.left);
                        size++;
                    }
                    if (node.right != null) {
                        queue.offerLast(node.right);
                        size++;
                    }
                    list.add(node.val);
                } else { // 偶数层，从右往左打印
                    node = queue.pollLast();
                    if (node.right != null) {
                        queue.offerFirst(node.right);
                        size++;
                    }
                    if (node.left != null) {
                        queue.offerFirst(node.left);
                        size++;
                    }
                    list.add(node.val);
                }
            }
            res.add(list);
            level++;
            count = size;
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
        int count = 1;// 记录当前层多少结点
        while (count > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            int nextCount = 0;
            while (count-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                    nextCount++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextCount++;
                }
            }
            if (list.size() > 0) {
                res.add(list);
            }
            count = nextCount;
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
            return "#,";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        if (str == null) {
            return null;
        }
        
        String[] values = str.split(",");
        return helper(values);
    }
    
    private TreeNode helper(String[] values) {
        index++;
        if ("#".equals(values[index])) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(values[index]));
        node.left = helper(values);
        node.right = helper(values);
        return node;
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
/**
* 中序遍历
*/
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
            count++;
            if (count == k) {
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
import java.util.*;

/**
 * 使用一个小顶堆和一个大顶堆，可以保证小顶堆的数都大于大顶堆，并且二者元素个数只差为0或1
 */
public class Solution {
    private int count = 0;
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public void Insert(Integer num) {
        if (count++ % 2 == 1) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public Double GetMedian() {
        return count % 2 == 1 ? maxHeap.peek() * 1.0 : ((minHeap.peek() + maxHeap.peek()) / 2.0);
    }
}
```

### 64.滑动窗口的最大值

**题目描述**

给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。

```java
import java.util.*;

public class Solution {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return res;
        }
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < size - 1; i++) {
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while(!queue.isEmpty() && num[queue.peekLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i - queue.peekFirst() + 1 > size) {
                queue.pollFirst();
            }
            res.add(num[queue.peekFirst()]);
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
    private int index = 0;
    private boolean[] visited;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || str == null) {
            return false;
        }

        visited = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, str, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, char[] str, int row, int col) {
        if (index == str.length) {
            return true;
        }

        boolean flag = false;
        if (col < cols && col >= 0
                && row < rows && row >= 0
                && str[index] == matrix[row * cols + col]
                && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            index++;
            flag = helper(matrix, rows, cols, str, row + 1, col)
                    || helper(matrix, rows, cols, str, row - 1, col)
                    || helper(matrix, rows, cols, str, row, col - 1)
                    || helper(matrix, rows, cols, str, row, col + 1);
            if (!flag) {
                index--;
                visited[row * cols + col] = false;
            }
        }
        return flag;
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
    
    public int movingCount(int threshold, int rows, int cols) {
        visited = new boolean[rows][cols];
        dfs(threshold, rows, cols, 0, 0);
        return res;
    }
    
    private void dfs(int threshold, int rows, int cols, int row, int col) {
        if (row < rows && col < cols && bitSum(row, col) <= threshold && !visited[row][col]) {
            visited[row][col] = true;
            res++;
            dfs(threshold, rows, cols, row + 1, col);
            dfs(threshold, rows, cols, row, col + 1);
        }
    }
    
    private int bitSum(int row, int col) {
        int sum = 0;
        while (row > 0) {
            sum += row % 10;
            row /= 10;
        }
        while (col > 0) {
            sum += col % 10;
            col /= 10;
        }
        return sum;
    }
}
```