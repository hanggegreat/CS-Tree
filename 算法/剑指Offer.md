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


### 1.二维数组中的查找

#### 题目描述

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

#### Solution:

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

#### 题目描述

请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

#### Solution:

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

#### 题目描述

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

#### Solution:

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

#### 题目描述

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

#### Solution:

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
        }
        return node;
    }
}
```

### 5.用两个栈实现队列

#### 题目描述

用两个栈来实现一个队列，完成队列的push和pop操作。 队列中的元素为int类型。

#### Solution:

```java
/**
*  本题解答采用的思路如下：
*  数据插入时，直接push到stack1中
*  当弹出数据时，先将stack1中的元素依次弹出并插入stack2中，此时stack2栈顶即为要弹出的数据
*  在弹出完毕后，再将stack2中的元素一次弹出并插入stack1中即可
*/
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if (stack1.size() == 0) {
            throw new RuntimeException();
        }
        
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int res = stack1.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return res;
    }
}
```

### 6.旋转数组的最小数字

#### 题目描述

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。

#### Solution:

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

#### 题目描述

大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。

n<=39

#### Solution:

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

#### 题目描述

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

#### Solution:

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

#### 题目描述

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

#### Solution:

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

#### 题目描述

我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

#### Solution:

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

#### 题目描述

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

#### Solution:

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

#### 题目描述

给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

#### Solution:

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

#### 题目描述

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

#### Solution:

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

#### 题目描述

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

#### Solution:

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

#### 题目描述

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

#### Solution:

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

#### 题目描述

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

#### Solution:

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

#### 题目描述

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

#### Solution:

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

#### 题目描述

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

#### Solution:

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

#### 题目描述

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

#### Solution:

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

#### 题目描述

定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

#### Solution:

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

