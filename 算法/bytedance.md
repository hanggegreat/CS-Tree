### leetcode上的字节跳动面试题库

#### [1. 两数之和](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

``` java
给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
```



``` java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(nums[i])) {
            return new int[]{map.get(nums[i]), i};
        }
        map.put(target - nums[i], i);
    }
    return new int[]{-1, -1};
}
```



#### [3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

``` java
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
```

``` java
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
```

``` java
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
```



``` java
public int lengthOfLongestSubstring(String s) {
  int res = 0;
  int l = 0, r = 0;
  int[] map = new int[256];
  while (l < s.length()) {
    if (r < s.length() && map[s.charAt(r)] == 0) {
      map[s.charAt(r++)]++;
      res = Math.max(res, r - l);
    } else {
      map[s.charAt(l++)]--;
    }
  }
  return res;
}
```



#### [2. 两数相加](https://leetcode-cn.com/problems/add-two-numbers/)

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

``` java
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
```



``` java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    int carry = 0;
    while (l1 != null || l2 != null || carry > 0) {
        pre.next = new ListNode(carry);
        if (l1 != null) {
            pre.next.val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            pre.next.val += l2.val;
            l2 = l2.next;
        }
        carry = pre.next.val / 10;
        pre.next.val %= 10;
        pre = pre.next;
    }
    return dummy.next;
}
```



#### [206. 反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)

反转一个单链表。

``` java
示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```



``` java
public class Solution {
    public ListNode reverseList(ListNode head) {
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



#### [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

![image-20190717151630534](assets/image-20190717151630534.png)

上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:

``` java
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6
```



``` java
public int trap(int[] height) {
    int res = 0;
    int lMax = 0, rMax = 0;
    int l = 0, r = height.length - 1;
    while (l < r) {
        lMax = Math.max(lMax, height[l]);
        rMax = Math.max(rMax, height[r]);

        if (lMax < rMax) {
            res += lMax - height[l++];
        } else {
            res += rMax - height[r--];
        }
    }
    return res;
}
```



#### [53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

``` java
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
```



``` java
public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    int res = nums[0], max = nums[0];
    for (int i = 1; i < nums.length; i++) {
        max = Math.max(max + nums[i], nums[i]);
        res = Math.max(max, res);
    }
    return res;
}
```



#### [15. 三数之和](https://leetcode-cn.com/problems/3sum/)

给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

``` java
满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```



``` java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int l = i + 1, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r] + nums[i];
            if (sum == 0) {
                res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                while (l < r && nums[l] == nums[++l]) ;
                while (l < r && nums[r] == nums[--r]) ;
            } else if (sum < 0) {
                l++;
            } else {
                r--;
            }
        }
    }
    return res;
}
```



#### [4. 寻找两个有序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/)

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

``` java
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0
```

示例 2:

``` java
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
```



``` java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l = nums1.length + nums2.length + 1 >> 1;
    int r = nums1.length + nums2.length + 2 >> 1;
    return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
}

private int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
    if (start1 >= nums1.length) {
        return nums2[start2 + k - 1];
    }
    if (start2 >= nums2.length) {
        return nums1[start1 + k - 1];
    }
    if (k == 1) {
        return Math.min(nums1[start1], nums2[start2]);
    }

    int mid1 = start1 + k / 2 - 1 >= nums1.length
            ? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];
    int mid2 = start2 + k / 2 - 1 >= nums2.length
            ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];
    return mid1 > mid2 ? getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2) :
            getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
}
```



#### [135. 分发糖果](https://leetcode-cn.com/problems/candy/)

老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。

你需要按照以下要求，帮助老师给这些孩子分发糖果：

每个孩子至少分配到 1 个糖果。
相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:

``` java
输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
```
示例 2:

``` java
输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
```



``` java
public int candy(int[] ratings) {
    int sum = 0;
    int[] arrays = new int[ratings.length];
    Arrays.fill(arrays, 1);
    for (int i = 1; i < ratings.length; i++) {
        if (ratings[i] > ratings[i - 1]) {
            arrays[i] = arrays[i - 1] + 1;
        }
    }
    for (int i = ratings.length - 1; i > 0; i--) {
        if (ratings[i - 1] > ratings[i]) {
            arrays[i - 1] = Math.max(arrays[i - 1], arrays[i] + 1);
        }
    }
    for (int array : arrays) {
        sum += array;
    }
    return sum;
}
```



#### [146. LRU缓存机制](https://leetcode-cn.com/problems/lru-cache/)

运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

``` java
LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
```



``` java
public class LRUCache {
    private Map<Integer, Integer> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer, Integer>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
```



#### [11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)

给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

![image-20190719101645305](assets/image-20190719101645305.png)

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。

示例:

``` java
输入: [1,8,6,2,5,4,8,3,7]
输出: 49
```



``` java
public int maxArea(int[] height) {
    int res = 0;
    int l = 0, r = height.length - 1;
    while (l < r) {
        res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
        if (height[l] < height[r]) {
            l++;
        } else {
            r--;
        }
    }
    return res;
}
```



#### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

``` java
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
```



``` java
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;

    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            pre.next = l1;
            l1 = l1.next;
        } else {
            pre.next = l2;
            l2 = l2.next;
        }
        pre = pre.next;
    }
    if (l1 != null) {
        pre.next = l1;
    }
    if (l2 != null) {
        pre.next = l2;
    }
    return dummy.next;
}
```



#### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

示例 1:

``` java
输入:
11110
11010
11000
00000

输出: 1
```

示例 2:

``` java
输入:
11000
11000
00100
00011

输出: 3
```



``` java
private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
private int rows, cols;

public int numIslands(char[][] grid) {
    if (grid.length == 0 || grid[0].length == 0) {
        return 0;
    }

    int res = 0;
    rows = grid.length;
    cols = grid[0].length;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == '1') {
                res++;
                dfs(grid, i, j);
            }
        }
    }
    return res;
}

private void dfs(char[][] grid, int i, int j) {
    if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0') {
        return;
    }
    grid[i][j] = '0';
    for (int[] d : directions) {
        dfs(grid, i + d[0], j + d[1]);
    }
}
```



#### [93. 复原IP地址](https://leetcode-cn.com/problems/restore-ip-addresses/)

给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

``` java
输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
```



``` java
public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    StringBuilder curr = new StringBuilder();
    restore(s, res, curr, 0);
    return res;
}

private void restore(String s, List<String> res, StringBuilder curr, int k) {
    if (k == 4 || s.length() == 0) {
        if (k == 4 && s.length() == 0) {
            res.add(curr.toString());
        }
        return;
    }

    for (int i = 0; i <= 2 && i < s.length(); i++) {
        if (i > 0 && s.charAt(0) == '0') {
            break;
        }
        String part = s.substring(0, i + 1);
        if (Integer.valueOf(part) <= 255) {
            if (k > 0) {
                part = "." + part;
            }
            curr.append(part);
            restore(s.substring(i + 1), res, curr, k + 1);
            curr.delete(curr.length() - part.length(), curr.length());
        }
    }
}
```



#### [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/)

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

``` java
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
```

示例 2:

``` java
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
```



``` java
public int search(int[] nums, int target) {
    if (nums.length < 1) {
        return -1;
    }
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int m = l + r >> 1;
        if (nums[m] <= nums[nums.length - 1]) {
            r = m;
        } else {
            l = m + 1;
        }
    }

    if (target <= nums[nums.length - 1]) {
        r = nums.length - 1;
    } else {
        l = 0;
        r--;
    }

    while (l < r) {
        int m = l + r + 1 >> 1;
        if (nums[m] <= target) {
            l = m;
        } else {
            r = m - 1;
        }
    }
    return nums[l] == target ? l : -1;
}
```



#### [56. 合并区间](https://leetcode-cn.com/problems/merge-intervals/)

给出一个区间的集合，请合并所有重叠的区间。

示例 1:

``` java
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
```



示例 2:

``` java
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
```



``` java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        List<Interval> list = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        Interval pre = null;
        for (Interval interval : intervals) {
            if (pre == null || pre.end < interval.start) {
                list.add(interval);
                pre = interval;
            } else {
                pre.end = Math.max(pre.end, interval.end);
            }
        }
        return list;
    }
}
```



#### [23. 合并K个排序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)

合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

``` java
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
```



``` java
public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null) {
        return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;

    Queue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
    for (ListNode list : lists) {
        if (list != null) {
            minHeap.offer(list);
        }
    }

    while (!minHeap.isEmpty()) {
        pre.next = minHeap.poll();
        pre = pre.next;
        if (pre.next != null) {
            minHeap.offer(pre.next);
        }
    }
    return dummy.next;
}
```



#### [121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

``` java
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
```

示例 2:

``` java
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```



``` java
public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int res = 0;
    for (int price : prices) {
        min = Math.min(min, price);
        res = Math.max(res, price - min);
    }
    return res;
}
```



#### [25. K 个一组翻转链表](https://leetcode-cn.com/problems/reverse-nodes-in-k-group/)

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

示例 :

``` java
给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5
```

说明 :

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

``` java
public ListNode reverseKGroup(ListNode head, int k) {
    ListNode end = head;
    int n = k;
    while (end != null && n > 1) {
        n--;
        end = end.next;
    }
    if (n != 1 || end == null) {
        return head;
    }
    end.next = reverseKGroup(end.next, k);
    while (head != end) {
        ListNode nextHead = head.next;
        head.next = end.next;
        end.next = head;
        head = nextHead;
    }
    return end;
}
```



#### [9. 回文数](https://leetcode-cn.com/problems/palindrome-number/)

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

``` java
输入: 121
输出: true
```

示例 2:

``` java
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
```

示例 3:

``` java
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
```


进阶:

你能不将整数转为字符串来解决这个问题吗？

``` java
public boolean isPalindrome(int x) {
    if (x < 0 || (x != 0 && x % 10 == 0)) {
        return false;
    }
    int y = 0;
    while (x > y) {
        y = y * 10 + x % 10;
        x /= 10;
    }
    return x == y || x == y / 10;
}
```



#### [199. 二叉树的右视图](https://leetcode-cn.com/problems/binary-tree-right-side-view/)

给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

``` java
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```



``` java
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
        return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (queue.size() > 0) {
        int size = queue.size();
        while(size-- > 0) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (size == 0) {
                list.add(node.val);
            }
        }
    }
    return list;
}
```



#### [695. 岛屿的最大面积](https://leetcode-cn.com/problems/max-area-of-island/)

给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

示例 1:

``` java
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
```

示例 2:

``` java
[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。
```

注意: 给定的矩阵grid 的长度和宽度都不超过 50。



``` java
public class Solution {
    private int res;
    private int area;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = 0;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            res = Math.max(res, area);
            return;
        }
        
        area++;
        grid[i][j] = 0;
        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
```



#### [10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)

给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。

示例 1:

``` java
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
```

示例 2:

``` java
输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
```

示例 3:

``` java
输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
```


示例 4:

``` java
输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
```


示例 5:

``` java
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
```



``` java
public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    for (int i = 1; i < p.length(); i++) {
        dp[0][i + 1] = dp[0][i - 1] && p.charAt(i) == '*';
    }

    for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                dp[i + 1][j + 1] = dp[i][j];
            } else if (j > 0 && p.charAt(j) == '*') {
                dp[i + 1][j + 1] = dp[i + 1][j - 1];
                if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}
```



#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

``` java
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
```

示例 2：

``` java
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
```



``` java
public int climbStairs(int n) {
    int a = 1;
    int b = 1;
    for (int i = 2; i <= n; i++) {
        int temp = b;
        b += a;
        a = temp;
    }
    return b;
}
```



#### [45. 跳跃游戏 II](https://leetcode-cn.com/problems/jump-game-ii/)

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

``` java
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
```
说明:

假设你总是可以到达数组的最后一个位置。



``` java
public int jump(int[] nums) {
    int res = 0;
    int max = 0;
    int end = 0;
    for (int i = 0; i < nums.length - 1; i++) {
        max = Math.max(max, nums[i] + i);
        if (i == end) {
            res++;
            end = max;
        }
    }
    return res;
}
```



#### [102. 二叉树的层次遍历](https://leetcode-cn.com/problems/binary-tree-level-order-traversal/)

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

```java
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

``` java
[
  [3],
  [9,20],
  [15,7]
]
```



``` java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
        return res;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (queue.size() > 0) {
        int size = queue.size();
        List<Integer> list = new ArrayList(size);
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
```



#### [176. 第二高的薪水](https://leetcode-cn.com/problems/second-highest-salary/)

编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。

``` mysql
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
```


例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。

``` mysql
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
```



``` mysql
SELECT (
    SELECT DISTINCT Salary
    FROM Employee
    ORDER BY Salary DESC
    LIMIT 1, 1
) AS SecondHighestSalary;
```



#### [215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

``` java
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:
```



``` java
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:
```

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。



``` java
public int findKthLargest(int[] nums, int k) {
    k = nums.length - k;
    int l = 0, r = nums.length - 1;
    while (l < r) {
        int p = partition(nums, l, r);
        if (p >= k) {
            r = p;
        } else {
            l = p + 1;
        }
    }
    return nums[l];
}

private int partition(int[] nums, int start, int end) {
    int temp = nums[start];
    int i = start, j = end;
    while (i < j) {
        while (j > i && nums[j] >= temp) {
            j--;
        }
        while (j > i && nums[i] < temp) {
            i++;
        }
        swap(nums, i, j);
    }
    swap(nums, start, i);
    return i;
}

private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
```



#### [393. UTF-8 编码验证](https://leetcode-cn.com/problems/utf-8-validation/)

UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：

对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
这是 UTF-8 编码的工作方式：

``` java
Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
```



给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。

注意:
输入是整数数组。只有每个整数的最低 8 个有效位用来存储数据。这意味着每个整数只表示 1 字节的数据。

示例 1:

``` java
data = [197, 130, 1], 表示 8 位的序列: 11000101 10000010 00000001.

返回 true 。
这是有效的 utf-8 编码，为一个2字节字符，跟着一个1字节字符。
```



示例 2:

``` java
data = [235, 140, 4], 表示 8 位的序列: 11101011 10001100 00000100.

返回 false 。
前 3 位都是 1 ，第 4 位为 0 表示它是一个3字节字符。
下一个字节是开头为 10 的延续字节，这是正确的。
但第二个延续字节不以 10 开头，所以是不符合规则的。
```



``` java
public static boolean validUtf8(int[] data) {
    if (data.length == 0) {
        return false;
    }
    int cnt = 0;
    for (int d : data) {
        if (cnt == 0) {
            if ((d >>> 5) == 0b110) {
                cnt = 1;
            } else if ((d >>> 4) == 0b1110) {
                cnt = 2;
            } else if ((d >>> 3) == 0b11110) {
                cnt = 3;
            } else if ((d >>> 7) != 0) {
                return false;
            }
        } else {
            if ((d >> 6) != 0b10) {
                return false;
            }
            cnt--;
        }
    }
    return cnt == 0;
}
```



#### [8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)

请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例:

``` java
输入: "42"
输出: 42
  
输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
	我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−231) 。
```



``` java
public static int myAtoi(String str) {
    if (str.length() == 0 || (str = str.trim()).length() == 0) {
        return 0;
    }

    int flag = 1;
    long res = 0;
    int i = 0;
    if (str.charAt(0) == '+') {
        i++;
    } else if (str.charAt(0) == '-') {
        flag = -1;
        i++;
    }

    for (; i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0'; i++) {
        res = res * 10 + str.charAt(i) - '0';
        if (flag * res <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (flag * res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
    }
    return (int) (flag * res);
}
```



#### [46. 全排列](https://leetcode-cn.com/problems/permutations/)

给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

```java
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```



``` java
private List<List<Integer>> res = new ArrayList<>();

public List<List<Integer>> permute(int[] nums) {
    boolean[] visited = new boolean[nums.length];
    permute(nums, new ArrayList<>(), visited);
    return res;
}

private void permute(int[] nums, List<Integer> list, boolean[] visited) {
    if (list.size() == nums.length) {
        res.add(new ArrayList<>(list));
        return;
    }
    for (int i = 0; i < nums.length; i++) {
        if (!visited[i]) {
            list.add(nums[i]);
            visited[i] = true;
            permute(nums, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
```



#### [122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

``` java
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
```



示例 2:

``` java
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
```



示例 3:

``` java
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
```



``` java
public int maxProfit(int[] prices) {
    int res = 0;
    for (int i = 1; i < prices.length; i++) {
        res += Math.max(0, prices[i] - prices[i - 1]);
    }
    return res;
}
```



#### [148. 排序链表](https://leetcode-cn.com/problems/sort-list/)

在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

``` java
输入: 4->2->1->3
输出: 1->2->3->4
```


示例 2:

``` java
输入: -1->5->3->4->0
输出: -1->0->3->4->5
```



``` java
public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    fast = slow.next;
    slow.next = null;
    return mergeSort(sortList(head), sortList(fast));
}

private ListNode mergeSort(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    while (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
            pre.next = l2;
            l2 = l2.next;
        } else {
            pre.next = l1;
            l1 = l1.next;
        }
        pre = pre.next;
    }
    pre.next = l1 != null ? l1 : l2;
    return dummy.next;
}
```



#### [322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)

给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

``` java
输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
```

示例 2:

``` java
输入: coins = [2], amount = 3
输出: -1
```

说明:
你可以认为每种硬币的数量是无限的。



``` java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.sort(coins);
    for (int i = 1; i <= amount; i++) {
        dp[i] = amount + 1;
        for (int coin : coins) {
            if (i >= coin) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
}
```



#### [440. 字典序的第K小数字](https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/)

给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。

注意：1 ≤ k ≤ n ≤ 109。

示例 :

``` java
输入:
n: 13   k: 2

输出:
10

解释:
字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
```

``` java
public int findKthNumber(int n, int k) {
    k--;
    int curr = 1;
    while (k > 0) {
        long steps = 0, first = curr, last = curr + 1;

        while (first <= n) {
            steps += Math.min(last, (long) (n + 1)) - first;
            first *= 10;
            last *= 10;
        }

        if (steps > k) {
            k--;
            curr *= 10;
        } else {
            k -= steps;
            curr++;
        }
    }
    return curr;
}
```

### 

#### [7. 整数反转](https://leetcode-cn.com/problems/reverse-integer/)

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

``` java
输入: 123
输出: 321
```

示例 2:

``` java
输入: -123
输出: -321
```

示例 3:

``` java
输入: 120
输出: 21
```

注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。



``` java
public int reverse(int x) {
    long res = 0;
    while (x != 0) {
        res = res * 10 + x % 10;
        x /= 10;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
    }
    return (int)res;
}
```



#### [19. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

``` java
给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
```

说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？

``` java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    for (int i = 0; i <= n; i++) {
        fast = fast.next;
    }
    while (fast != null) {
        fast = fast.next;
        slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
}
```



#### [55. 跳跃游戏](https://leetcode-cn.com/problems/jump-game/)

给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

判断你是否能够到达最后一个位置。

示例 1:

``` java
输入: [2,3,1,1,4]
输出: true
解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
```

示例 2:

``` java
输入: [3,2,1,0,4]
输出: false
解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
```



``` java
public boolean canJump(int[] nums) {
    int last = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        if (nums[i] + i >= last) {
            last = i;
        }
    }
    return last == 0;
}
```



#### [71. 简化路径](https://leetcode-cn.com/problems/simplify-path/)

以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。

在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径

请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

 

示例 1：

``` java
输入："/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。
```

示例 2：

``` java
输入："/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
```


示例 3：

``` java
输入："/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
```

示例 4：

``` java
输入："/a/./b/../../c/"
输出："/c"
```

示例 5：

``` java
输入："/a/../../b/../c//.//"
输出："/c"
```

示例 6：

``` java
输入："/a//b////c/d//././/.."
输出："/a/b/c"
```



``` java
public String simplifyPath(String path) {
    String[] paths = path.split("/");
    LinkedList<String> deque = new LinkedList<>();
    for (String p : paths) {
        if (".".equals(p) || "".equals(p)) {
            continue;
        }
        if ("..".equals(p)) {
            deque.pollLast();
        } else {
            deque.offerLast("/" + p);
        }
    }
    if (deque.size() == 0) {
        return "/";
    }

    StringBuilder sb = new StringBuilder();
    for (String p : deque) {
        sb.append(p);
    }
    return sb.toString();
}
```



