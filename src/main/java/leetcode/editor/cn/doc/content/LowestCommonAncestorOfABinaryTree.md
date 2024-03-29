<p>给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。</p>

<p><a href="https://baike.baidu.com/item/%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88/8918834?fr=aladdin" target="_blank">百度百科</a>中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（<strong>一个节点也可以是它自己的祖先</strong>）。”</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" /> 
<pre>
<strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
<strong>输出：</strong>3
<strong>解释：</strong>节点 <span><code>5 </code></span>和节点 <span><code>1 </code></span>的最近公共祖先是节点 <span><code>3 。</code></span>
</pre>

<p><strong>示例 2：</strong></p> 
<img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarytree.png" style="width: 200px; height: 190px;" /> 
<pre>
<strong>输入：</strong>root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
<strong>输出：</strong>5
<strong>解释：</strong>节点 <span><code>5 </code></span>和节点 <span><code>4 </code></span>的最近公共祖先是节点 <span><code>5 。</code></span>因为根据定义最近公共祖先节点可以为节点本身。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1,2], p = 1, q = 2
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li>树中节点数目在范围 <code>[2, 10<sup>5</sup>]</code> 内。</li> 
 <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li> 
 <li>所有 <code>Node.val</code> <code>互不相同</code> 。</li> 
 <li><code>p != q</code></li> 
 <li><code>p</code> 和 <code>q</code> 均存在于给定的二叉树中。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 二叉树</details><br>

<div>👍 2461, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 和 [递归算法专题课](https://aep.xet.tech/s/3YGcq3) 限时附赠网站会员，全新纸质书[《labuladong 的算法笔记》](https://labuladong.gitee.io/algo/images/book/book_intro_qrcode.jpg) 出版，签名版限时半价！**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=lowest-common-ancestor-of-a-binary-tree" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

经典问题了，先给出递归函数的定义：给该函数输入三个参数 `root`，`p`，`q`，它会返回一个节点：

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，函数返回的即使 `p` 和 `q` 的最近公共祖先节点。

情况 2，那如果 `p` 和 `q` 都不在以 `root` 为根的树中怎么办呢？函数理所当然地返回 `null` 呗。

情况 3，那如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中呢？函数就会返回那个节点。

根据这个定义，分情况讨论：

情况 1，如果 `p` 和 `q` 都在以 `root` 为根的树中，那么 `left` 和 `right` 一定分别是 `p` 和 `q`（从 base case 看出来的）。

情况 2，如果 `p` 和 `q` 都不在以 `root` 为根的树中，直接返回 `null`。

情况 3，如果 `p` 和 `q` 只有一个存在于 `root` 为根的树中，函数返回该节点。

**详细题解：[Git原理之最近公共祖先](https://labuladong.github.io/article/fname.html?fname=公共祖先)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

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
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        // base case
        if (root == nullptr) return nullptr;
        if (root == p || root == q) return root;

        TreeNode* left = lowestCommonAncestor(root->left, p, q);
        TreeNode* right = lowestCommonAncestor(root->right, p, q);
        // 情况 1
        if (left != nullptr && right != nullptr) {
            return root;
        }
        // 情况 2
        if (left == nullptr && right == nullptr) {
            return nullptr;
        }
        // 情况 3
        return left == nullptr ? right : left;
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # base case
        if not root:
            return None
        if root == p or root == q:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        # 情况 1
        if left and right:
            return root
        # 情况 2
        if not left and not right:
            return None
        # 情况 3
        return right if not left else left
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况 1
        if (left != null && right != null) {
            return root;
        }
        // 情况 2
        if (left == null && right == null) {
            return null;
        }
        // 情况 3
        return left == null ? right : left;
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
    // base case
    if root == nil {
        return nil
    }
    if root == p || root == q {
        return root
    }

    left := lowestCommonAncestor(root.Left, p, q)
    right := lowestCommonAncestor(root.Right, p, q)
    // 情况 1
    if left != nil && right != nil {
        return root
    }
    // 情况 2
    if left == nil && right == nil {
        return nil
    }
    // 情况 3
    if left == nil {
        return right
    }
    return left
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var lowestCommonAncestor = function(root, p, q) {
    // base case
    if (root === null) return null;
    if (root === p || root === q) return root;

    var left = lowestCommonAncestor(root.left, p, q);
    var right = lowestCommonAncestor(root.right, p, q);
    // 情况 1
    if (left !== null && right !== null) {
        return root;
    }
    // 情况 2
    if (left === null && right === null) {
        return null;
    }
    // 情况 3
    return left === null ? right : left;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🎃🎃 算法可视化 🎃🎃</strong></summary><div id="data_lowest-common-ancestor-of-a-binary-tree" data="G7B8UZQszhIAnQe2mzRg42gEvziMxHj9U14oaFwLkT/b8k9X/p5aJwkRtqZfnc7OCwkRo1sq9pprmOZCTvGFBFHT2R7f6SUVtBTgMiXfTeg//zO/z1YqoBH1vjdiLmVOMgCMiILEr6p6v2jPGK3OABx6//T1GpjHQEFspZnjTDB7WWJgX8a078Oxyt0fgoAYBOxIblz7fGcH7+pu/iwaE7d38zv7DgOPmbJh0aGW7KhfXH9Wm2Nm+RcstCPada9wolcoYnOmewfL42rmkRGKvwFR9yj3Z4YntPTLdmtMJKzhbpYd+qzHkMNyr0VynkOXdg7h6xGmWFs4++2KQpnTBd2ZnUpbj0pozI7O9+m910fnGPqLtC7E+Ny1rHiyVNPbfg/b8Mkg9H2fzkftoKP2ALgpR+d1+OB5br2H5LPtz5Qw9ZY83+P856eTsRvgyMI75FGa2bzs7al/19raNCMSjC5X3NkyyreO6o1cd4T/1HwGuMtBH+kx3Jzt0xwE9JSN/rasJ54HOR/73/WUeiqaDvJDsGUR23050aQjGUeX9yP7RHLnFHb79smr/879NZAExaGlOkKzELoRAg5svzj7saXnhxzFZub54njNjWw9H43PSL5VxPPWTuv0HuXZAVG2h4QGIoki3WXiV7BissE3RFmjDzQZAKnv4d7h9R70Hb6m6cm/3eI7zzBSYmF/MmqdP1V2Q5E0gFSX/mwnavL7TNQBu8+J367kZHb/xyULKt3mSTyi6iDZ9XE5v2JC3IfjoPx0tYSOizdw8ARPasy87Hyu6azi4ZhbG0fsMcLmyCZk+1o6KtoXSJzAm4vMzyqlGcDyK/ieM301oqzRV0ZIGYD1X79DCKbTiLJmP4kqIQ1cXzSyxD/qKlApzcWv4EBdLW6IskYfRkgD17VSS/yj9WGQ61k8g1xJYPf77G286DEDWH4F58FYrRFljb5CusvEr19AadA3NM1+ErVm4LqxxD/KKlApzcev4IkF4m+IskYfRkgD17VSS/yj9WGQ61k8A0xJIJ+JRlEvq+LTObn0kyPIXsuLKqd2CBWezTd45D/vE1vz8/WdJ+4M3XnhzvBQsCBFF02hghZRsGILzhdDHlMsRbtlXFdvCjv7Gh1fxd9G1UvDYqE39+3/1qNMyI7HKiLHMT20SC6G2P8C12sZgYGsWSNUpvFKKUbwU+cw4p1AGGGe2nHxZDjTN2hvhL0hjVCZxlvbMkI/dR1GvF8gI1Qo1gyEyoAncDJChiTNGiGDPgtOUQA3NHOvvV65c1CMoNW+WKq/nMuHV/Gw5NlRW5cRw/E2Z1XDMdtTsCODXizjY1Ths0rrpEtdklrqwlQXDbLVqKvFyDDq8kaqiLoY1TLgrLrUcF7bbhlgfFSFJom6pvcCozZwQdX4qDAhHnWJt4HgzGsvmtx5LRu0c9hbpYDDyRAM5yx1eqI0rbm6rxcmMqbhT/CplamMHi5+m10YdtNjt4otio+xaahnn2ttacWnc4GDkqYZkCt/uadRQLTcRzZ3WMRpNq1zpoOSoCWmbXGVMMjwqCUmYRNGGcB74Xz1oOShwfTGqvAd57WAZ3JTECPk6JssySIbH3xcStSQB0Flx+w8EifLQUlal9kbSiAb6FW2JvSSPGYqyjqOaVW3Cbn45lAiFLA0sZzQyrGUcEh2VWFJTPOCVLKrCnNx1khnYkJVdLKFMhgMKyvU7Rwyq/f8PfIEDx8SbdSNsjKs6OXqAuw1fn5728rKRkbl4QgjmUEFUHmyJksQsndr3+YpCknNqNFL/G599RKHvMXZ8hk/XZ4ESYkjY9JjvzW/MwtO3cbPgVi3EQTLkLBwp4ak/XIwBG80HDVOQK7NuDYyrtSn2AoDPxjWSELIB9vhb3cSIY1aBWGlsYl0j52xWunQHcu4nlt6vLftDdyrQupbgNkljIVkI9GVH2HEJ2OubXEUEBuzZ6/4rqd+pYiAVEQvcuxOY15gU9ruDuI4ynT2iIfwSi2uDlEyfTRCjJVyw7nLwAw0Snbf48idmETdeLv0Gw6C3MvwUKX7ovTPb2/NT+P42EdIDgYlp0inDlZnKZLlAUhAdGwYOGdRjKJSj+S5brOxCCV2UNavMJKcZYGuuznPC4K+AZIB5ZmKf4i3wqjIrRWDfDTE5BLJJ5OmQKixVJnRrnT9DW4IjopYH5KSj7kNZ9tp9yHw/2yjV1jLzpVF1EY5A0GVyvOuO7eOfyx1sK1elTBGQT0N1L8YVJlKAjUjBlVxkkB9hUEVjyRQg2BQdSABlO0pDrkIz0YoqTNQIGeg3M3g4jUDpWgGCssMlIkZXPRloITLQEGWgfIqg4ulDJQ+GShkMlCWZHCREbjw9cqLyfXm5UMNwSMf0rcnUHWIAQiE6JmTBCcCpjcmWaZ6pnMmXwtAoEaCbhCYEZ/jMuQOdGcosTA7ShKYI8LY7CgpMUeEY7OjZIPZUXJjdpRiMTvKtjE7hlFkB+Uok0Ab4TgcpQeIKMtARNkLRJTTQES52YstV1SmWY5RnrK2Tj65j0VBUhmZd8gblaxWf9flqqqq7W1ZE5TLdFy93Q2V9Vuqvb29qrbSWWXobised8fmnVy9vFTLkGxkqxVxsoBerAekw2tubtmyFEP6yJ1t9YJHxmK2sGAXXQaMR6LWwtF5A+V2bptjLWJIJ96dOD72qw97i/d+b1/vIXbTmEawQcVn56DdMjezYHZeo/26qKeKxbTOmnGo+If+i0S5oydRIBpCYOGe/+NaDn8iUd2wa9Iji/vow50bVdf302ut1GvltX6tvs8/kX+5Ua2pey1v8+TS5a0ufzM="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_lowest-common-ancestor-of-a-binary-tree"></div></div>
</details><hr /><br />

**类似题目**：
  - [1644. 二叉树的最近公共祖先 II 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-ii)
  - [1650. 二叉树的最近公共祖先 III 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iii)
  - [1676. 二叉树的最近公共祖先 IV 🟠](/problems/lowest-common-ancestor-of-a-binary-tree-iv)
  - [235. 二叉搜索树的最近公共祖先 🟠](/problems/lowest-common-ancestor-of-a-binary-search-tree)
  - [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先 🟢](/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof)
  - [剑指 Offer 68 - II. 二叉树的最近公共祖先 🟢](/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof)

</details>
</div>

