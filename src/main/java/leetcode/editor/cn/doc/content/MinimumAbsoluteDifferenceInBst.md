<p>给你一个二叉搜索树的根节点 <code>root</code> ，返回 <strong>树中任意两不同节点值之间的最小差值</strong> 。</p>

<p>差值是一个正数，其数值等于两值之差的绝对值。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst1.jpg" style="width: 292px; height: 301px;" /> 
<pre>
<strong>输入：</strong>root = [4,2,6,1,3]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/05/bst2.jpg" style="width: 282px; height: 301px;" /> 
<pre>
<strong>输入：</strong>root = [1,0,48,null,null,12,49]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点的数目范围是 <code>[2, 10<sup>4</sup>]</code></li> 
 <li><code>0 &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与 783 <a href="https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/">https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/</a> 相同</p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 503, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

中序遍历会有序遍历 BST 的节点，遍历过程中计算最小差值即可。

**标签：[二叉搜索树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121995456690946054)**

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
    int getMinimumDifference(TreeNode* root) {
        traverse(root);
        return res;
    }

    TreeNode* prev = nullptr;
    int res = INT_MAX;

    // 遍历函数
    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);
        // 中序遍历位置
        if (prev != nullptr) {
            res = min(res, root->val - prev->val);
        }
        prev = root;
        traverse(root->right);
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def getMinimumDifference(self, root: TreeNode) -> int:
        self.prev = None
        self.res = float('inf')
        self.traverse(root)
        return self.res
        
    # 遍历函数
    def traverse(self, root: TreeNode) -> None:
        if not root:
            return
        
        self.traverse(root.left)
        # 中序遍历位置
        if self.prev:
            self.res = min(self.res, root.val - self.prev.val)
        self.prev = root
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return res;
    }

    TreeNode prev = null;
    int res = Integer.MAX_VALUE;

    // 遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        if (prev != null) {
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 java 代码对比查看。

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func getMinimumDifference(root *TreeNode) int {
    prev := (*TreeNode)(nil)
    res := math.MaxInt32

    var traverse func(root *TreeNode)
    traverse = func(root *TreeNode) {
        if root == nil {
            return
        }

        traverse(root.Left)
        // 中序遍历位置
        if prev != nil {
            res = min(res, root.Val - prev.Val)
        }

        prev = root
        traverse(root.Right)
    }

    traverse(root)
    return res
}

func min(x, y int) int {
    if x < y {
        return x
    }
    return y
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

/**
 * @param {TreeNode} root
 * @return {number}
 */
var getMinimumDifference = function(root) {
    let prev = null;
    let res = Number.MAX_SAFE_INTEGER;

    // 遍历函数
    function traverse(root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        // 中序遍历位置
        if (prev != null) {
            res = Math.min(res, root.val - prev.val);
        }
        prev = root;
        traverse(root.right);
    }

    traverse(root);
    return res;
}
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_minimum-absolute-difference-in-bst" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_minimum-absolute-difference-in-bst"></div></div>
</details><hr /><br />

**类似题目**：
  - [783. 二叉搜索树节点最小距离 🟢](/problems/minimum-distance-between-bst-nodes)

</details>
</div>

