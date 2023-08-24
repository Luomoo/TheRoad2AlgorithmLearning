<p>给你一个按 <strong>非递减顺序</strong> 排序的整数数组 <code>nums</code>，返回 <strong>每个数字的平方</strong> 组成的新数组，要求也按 <strong>非递减顺序</strong> 排序。</p>

<ul> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-4,-1,0,3,10]
<strong>输出：</strong>[0,1,9,16,100]
<strong>解释：</strong>平方后，数组变为 [16,1,0,9,100]
排序后，数组变为 [0,1,9,16,100]</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [-7,-3,2,3,11]
<strong>输出：</strong>[4,9,9,49,121]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code><span>1 &lt;= nums.length &lt;= </span>10<sup>4</sup></code></li> 
 <li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li> 
 <li><code>nums</code> 已按 <strong>非递减顺序</strong> 排序</li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<ul> 
 <li>请你<span style="color: rgb(36, 41, 46); font-family: -apple-system, BlinkMacSystemFont, &quot;Segoe UI&quot;, Helvetica, Arial, sans-serif, &quot;Apple Color Emoji&quot;, &quot;Segoe UI Emoji&quot;; font-size: 14px; font-style: normal; font-variant-ligatures: normal; font-variant-caps: normal; font-weight: 400; letter-spacing: normal; orphans: 2; text-align: start; text-indent: 0px; text-transform: none; white-space: normal; widows: 2; word-spacing: 0px; -webkit-text-stroke-width: 0px; background-color: rgb(255, 255, 255); text-decoration-style: initial; text-decoration-color: initial; display: inline !important; float: none;">设计时间复杂度为 <code>O(n)</code> 的算法解决本问题</span></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>数组 | 双指针 | 排序</details><br>

<div>👍 867, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

平方的特点是会把负数变成正数，所以一个负数和一个正数平方后的大小要根据绝对值来比较。

可以把元素 0 作为分界线，0 左侧的负数是一个有序数组 `nums1`，0 右侧的正数是另一个有序数组 `nums2`，那么这道题就和 [88. 合并两个有序数组](/problems/merge-sorted-array) 差不多，在进一步就是前文 [链表的双指针技巧汇总](https://labuladong.github.io/article/fname.html?fname=链表技巧) 讲过的 [21. 合并两个有序链表](/problems/merge-two-sorted-lists) 的变体。

所以，我们可以去寻找正负数的分界点，然后向左右扩展，执行合并有序数组的逻辑。不过还有个更好的办法，不用找正负分界点，而是直接将双指针分别初始化在 `nums` 的开头和结尾，相当于合并两个从大到小排序的数组，和 88 题类似。有了思路，直接看代码吧。

**标签：[数组双指针](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

提示：🟢 标记的是我写的解法代码，🤖 标记的是 chatGPT 翻译的多语言解法代码。如有错误，可以 [点这里](https://github.com/labuladong/fucking-algorithm/issues/1113) 反馈和修正。

<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int n = nums.size();
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        // 得到的有序结果是降序的
        int p = n - 1;
        vector<int> res(n);
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (abs(nums[i]) > abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
        }
        return res;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        # 两个指针分别初始化在正负子数组绝对值最大的元素索引
        i, j = 0, n - 1
        # 得到的有序结果是降序的
        p = n - 1
        res = [0] * n
        # 执行双指针合并有序数组的逻辑
        while i <= j:
            if abs(nums[i]) > abs(nums[j]):
                res[p] = nums[i] * nums[i]
                i += 1
            else:
                res[p] = nums[j] * nums[j]
                j -= 1
            p -= 1
        return res
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        // 两个指针分别初始化在正负子数组绝对值最大的元素索引
        int i = 0, j = n - 1;
        // 得到的有序结果是降序的
        int p = n - 1;
        int[] res = new int[n];
        // 执行双指针合并有序数组的逻辑
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[p] = nums[i] * nums[i];
                i++;
            } else {
                res[p] = nums[j] * nums[j];
                j--;
            }
            p--;
        }
        return res;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func sortedSquares(nums []int) []int {
    n := len(nums)
    // 两个指针分别初始化在正负子数组绝对值最大的元素索引
    i, j := 0, n-1
    // 得到的有序结果是降序的
    p := n - 1
    res := make([]int, n)
    // 执行双指针合并有序数组的逻辑
    for i <= j {
        if math.Abs(float64(nums[i])) > math.Abs(float64(nums[j])) {
            res[p] = nums[i] * nums[i]
            i++
        } else {
            res[p] = nums[j] * nums[j]
            j--
        }
        p--
    }
    return res
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    let n = nums.length;
    // 两个指针分别初始化在正负子数组绝对值最大的元素索引
    let i = 0, j = n - 1;
    // 得到的有序结果是降序的
    let p = n - 1;
    let res = new Array(n);
    // 执行双指针合并有序数组的逻辑
    while (i <= j) {
        if (Math.abs(nums[i]) > Math.abs(nums[j])) {
            res[p] = nums[i] * nums[i];
            i++;
        } else {
            res[p] = nums[j] * nums[j];
            j--;
        }
        p--;
    }
    return res;
};
```

</div></div>
</div></div>

<details open><summary><strong>🍭🍭 算法可视化 🍭🍭</strong></summary><div id="data_squares-of-a-sorted-array" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_squares-of-a-sorted-array"></div></div>
</details><hr /><br />

**类似题目**：
  - [360. 有序转化数组 🟠](/problems/sort-transformed-array)

</details>
</div>

