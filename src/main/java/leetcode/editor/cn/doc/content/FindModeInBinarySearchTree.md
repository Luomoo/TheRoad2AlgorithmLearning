<p>给你一个含重复值的二叉搜索树（BST）的根节点 <code>root</code> ，找出并返回 BST 中的所有 <a href="https://baike.baidu.com/item/%E4%BC%97%E6%95%B0/44796" target="_blank">众数</a>（即，出现频率最高的元素）。</p>

<p>如果树中有不止一个众数，可以按 <strong>任意顺序</strong> 返回。</p>

<p>假定 BST 满足如下定义：</p>

<ul> 
 <li>结点左子树中所含节点的值 <strong>小于等于</strong> 当前节点的值</li> 
 <li>结点右子树中所含节点的值 <strong>大于等于</strong> 当前节点的值</li> 
 <li>左子树和右子树都是二叉搜索树</li> 
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/11/mode-tree.jpg" style="width: 142px; height: 222px;" /> 
<pre>
<strong>输入：</strong>root = [1,null,2,2]
<strong>输出：</strong>[2]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [0]
<strong>输出：</strong>[0]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点的数目在范围 <code>[1, 10<sup>4</sup>]</code> 内</li> 
 <li><code>-10<sup>5</sup> &lt;= Node.val &lt;= 10<sup>5</sup></code></li> 
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）</p>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉搜索树 | 二叉树</details><br>

<div>👍 693, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

前文 [手把手刷二叉树总结篇](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「遍历」的思维。

BST 的中序遍历有序，在中序遍历的位置做一些判断逻辑和操作有序数组差不多，很容易找出众数。

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
    vector<int> mode;
    TreeNode* prev = nullptr;
    // 当前元素的重复次数
    int curCount = 0;
    // 全局的最长相同序列长度
    int maxCount = 0;

    vector<int> findMode(TreeNode* root) {
        // 执行中序遍历
        traverse(root);

        vector<int> res(mode.size());
        for (int i = 0; i < res.size(); i++) {
            res[i] = mode[i];
        }
        return res;
    }

    void traverse(TreeNode* root) {
        if (root == nullptr) {
            return;
        }
        traverse(root->left);

        // 中序遍历位置
        if (prev == nullptr) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.push_back(root->val);
        } else {
            if (root->val == prev->val) {
                // root.val 重复的情况
                curCount++;
                if (curCount == maxCount) {
                    // root.val 是众数
                    mode.push_back(root->val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode.clear();
                    maxCount = curCount;
                    mode.push_back(root->val);
                }
            }

            if (root->val != prev->val) {
                // root.val 不重复的情况
                curCount = 1;
                if (curCount == maxCount) {
                    mode.push_back(root->val);
                }
            }
        }
        // 别忘了更新 prev
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
    def __init__(self):
        self.mode = []
        self.prev = None
        # 当前元素的重复次数
        self.curCount = 0
        # 全局的最长相同序列长度
        self.maxCount = 0
    
    def findMode(self, root: TreeNode) -> List[int]:
        # 执行中序遍历
        self.traverse(root)

        return self.mode
    
    def traverse(self, root: TreeNode) -> None:
        if not root:
            return
        self.traverse(root.left)

        # 中序遍历位置
        if not self.prev:
            # 初始化
            self.curCount = 1
            self.maxCount = 1
            self.mode.append(root.val)
        else:
            if root.val == self.prev.val:
                # root.val 重复的情况
                self.curCount += 1
                if self.curCount == self.maxCount:
                    # root.val 是众数
                    self.mode.append(root.val)
                elif self.curCount > self.maxCount:
                    # 更新众数
                    self.mode.clear()
                    self.maxCount = self.curCount
                    self.mode.append(root.val)

            if root.val != self.prev.val:
                # root.val 不重复的情况
                self.curCount = 1
                if self.curCount == self.maxCount:
                    self.mode.append(root.val)

        # 别忘了更新 prev
        self.prev = root
        self.traverse(root.right)
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    ArrayList<Integer> mode = new ArrayList<>();
    TreeNode prev = null;
    // 当前元素的重复次数
    int curCount = 0;
    // 全局的最长相同序列长度
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        // 执行中序遍历
        traverse(root);

        int[] res = new int[mode.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = mode.get(i);
        }
        return res;
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        // 中序遍历位置
        if (prev == null) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.add(root.val);
        } else {
            if (root.val == prev.val) {
                // root.val 重复的情况
                curCount++;
                if (curCount == maxCount) {
                    // root.val 是众数
                    mode.add(root.val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode.clear();
                    maxCount = curCount;
                    mode.add(root.val);
                }
            }

            if (root.val != prev.val) {
                // root.val 不重复的情况
                curCount = 1;
                if (curCount == maxCount) {
                    mode.add(root.val);
                }
            }
        }
        // 别忘了更新 prev
        prev = root;

        traverse(root.right);
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码不保证正确性，仅供参考。如有疑惑，可以参照我写的 java 代码对比查看。

func findMode(root *TreeNode) []int {
    var mode []int
    var prev *TreeNode
    var curCount, maxCount int

    traverse := func(node *TreeNode) {
        if node == nil {
            return
        }
        traverse(node.Left)

        // 中序遍历位置
        if prev == nil {
            // 初始化
            curCount = 1
            maxCount = 1
            mode = append(mode, node.Val)
        } else {
            if node.Val == prev.Val {
                // node.Val 重复的情况
                curCount++
                if curCount == maxCount {
                    // node.Val 是众数
                    mode = append(mode, node.Val)
                } else if curCount > maxCount {
                    // 更新众数
                    mode = make([]int, 0)
                    maxCount = curCount
                    mode = append(mode, node.Val)
                }
            }

            if node.Val != prev.Val {
                // node.Val 不重复的情况
                curCount = 1
                if curCount == maxCount {
                    mode = append(mode, node.Val)
                }
            }
        }
        // 别忘了更新 prev
        prev = node

        traverse(node.Right)
    }

    traverse(root)

    return mode
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var findMode = function(root) {
    let mode = [];
    let prev = null;
    // 当前元素的重复次数
    let curCount = 0;
    // 全局的最长相同序列长度
    let maxCount = 0;

    function traverse(root) {
        if (root === null) {
            return;
        }
        traverse(root.left);

        // 中序遍历位置
        if (prev === null) {
            // 初始化
            curCount = 1;
            maxCount = 1;
            mode.push(root.val);
        } else {
            if (root.val === prev.val) {
                // root.val 重复的情况
                curCount++;
                if (curCount === maxCount) {
                    // root.val 是众数
                    mode.push(root.val);
                } else if (curCount > maxCount) {
                    // 更新众数
                    mode = [root.val];
                    maxCount = curCount;
                }
            }

            if (root.val !== prev.val) {
                // root.val 不重复的情况
                curCount = 1;
                if (curCount === maxCount) {
                    mode.push(root.val);
                }
            }
        }
        // 别忘了更新 prev
        prev = root;

        traverse(root.right);
    }

    traverse(root);

    return mode;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_find-mode-in-binary-search-tree" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_find-mode-in-binary-search-tree"></div></div>
</details><hr /><br />

</details>
</div>

