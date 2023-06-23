<p>给定一个非负整数数组&nbsp;<code>nums</code> ，你最初位于数组的 <strong>第一个下标</strong> 。</p>

<p>数组中的每个元素代表你在该位置可以跳跃的最大长度。</p>

<p>判断你是否能够到达最后一个下标。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,3,1,1,4]
<strong>输出：</strong>true
<strong>解释：</strong>可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,1,0,4]
<strong>输出：</strong>false
<strong>解释：</strong>无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li> 
 <li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>贪心 | 数组 | 动态规划</details><br>

<div>👍 2360, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.gitee.io/article/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.github.io/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：[数据结构精品课](https://aep.h5.xeknow.com/s/1XJHEO) 已更新到 V2.1，[手把手刷二叉树系列课程](https://aep.xet.tech/s/3YGcq3) 上线，[第 20 期打卡挑战](https://opedk.xet.tech/s/1cEM6U) 开始报名。**



<p><strong><a href="https://labuladong.gitee.io/article/slug.html?slug=jump-game" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

PS：这道题在[《算法小抄》](https://item.jd.com/12759911.html) 的第 376 页。

这道题表面上不是求最值，但是可以改一改：

**请问通过题目中的跳跃规则，最多能跳多远**？如果能够越过最后一格，返回 true，否则返回 false。

所以解题关键在于求出能够跳到的最远距离。

**详细题解：[如何运用贪心思想玩跳跃游戏](https://labuladong.github.io/article/fname.html?fname=跳跃游戏)**

**标签：[一维动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122007027366395905)，[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)，贪心算法**

## 解法代码

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到了 0，卡住跳不动了
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= n - 1;
    }
}
```

<details open><summary><strong>🥳🥳 算法可视化 🥳🥳</strong></summary><div id="data_jump-game" data="G5IcACyLN4ahySoUF4vOIVQjsBj/9uEWmU6O9EtbYBVioNT3q9tCDz/niGIXDRrEOHg4qL+fk3daHVPMozRJpl9qAUQ9hZPfSt5mTbvrHASmdpFI12dVIn1utDAWgwC+mrK3lFY77/7/r6Vxs5ukQJroxld4YIeSSLjue+/PDf2kBGD//NmdApHbUyErKyQ5Xe0Bl+F2EKwejCr3cG98PQi83df+3kV8osLXP/iHgVeyUq3eIYo01FfT39eKTBV/w92YDcK1/zWKcKWIFc2WV/cYrgrfEhz+VKoq9OqSBheXtl0D6q13DsD4c6I2qVUyFx2tFKw/sQiiXSUfnqpS8lic/TzZsa53z2Hwn7esnuwuHbdk4Piu7gWDUw24bmPZiL1Ll+7IQJLLB3mAL/npmgfflJuD4cq1IT1X4kgo3ouq2d5QlNGFHRfQ1s6bVIa1dhel9blpz2Yu8LluXleGr65Hc0S+YgRD5uqAt9r7Wxb1WpmxnBhqva8IyWukuflGdueOoKWL8cY5wNDWtZVj3ZaJ5qRJy0xdINKt5Zlq7Dg42wy9THSDTFbLOoKmd9npLKW2NQtHq3H9jp2V3WN/qjq605RpuynexWNTtKZFmu8WYOUZIng1iIElOxX4vyWi8kRgciqZzP69Pf0NPf1bcpoITk4k/w00/Vtqmhh9f8qR/yqeWAJlWyi1t0l7g18NFiseWd+khSQw+3vEL3GzNmvgg/2/aZqz6kG795aeZumCmlrWy1FL90K8RXoRTS2JAx3BfEMyiCv+N/nG08LPs9zD8zqdF+/LsmzrkbGGruKZrwTMfL0lrywdPTjfHtOYNmDMfSbG3pbWUxzkXKul00verGomP7xTHzz6cJRDULGbTU+WdytQwsu+h3HTlm27bleAfU/T6g3EsA2ePyTSEBm/yh+ghNleP+oMt74vcljkQ9x5Cp9H/DO11nXu8YJu20lafxw5KDdDSYn0eIBp1qDSFfKIBvOcrDeRHDko0WgH7WurOjvDcII1nHMPSYBMU3Xx4jyn6PCAOzmlrGc4AXFbJptTOTlUF0qFopB7tFFIcHN45wmSex1tpvUBH9r0SSgxIgWGwziSnjWmaGgDyISeNQKHUy+zEkdGJFIefGE3fYQf385idvnb8Nm94x+aOxOkAzcikGPXz085OdwAQ1kuTnquCYJMrAihok0glvs4cgOfEzyYRml8cdsoFUYOYOujq3MC+NxEKTB20l59A35y0eBB812Yli2f4CXlKDhpqPR4mYbgLZLmgjkMZFhREo3jt/nqjJOZhpbQgQarDr54KblcYqsuDe1+EbYsQv+IIjrRwZtW0TU2BIrthyzksNLFTzD20Di2c8cVCJxnGw0pgRA2peb2o8iHxr50QpicQXbymQktNKPvBILPOp1d/u7goVy56JbHEeAbirktB1YB3RCIW55FwE4eoWIwduAhdyDBbL+mjcMCO08ON+ALma0YgfTSVIjLmjEMiEi2gOeJ9vlIhgbRJBtP4RFI7Szu9oJgVK+ykAEvgkClTGYLPK2WBb3i8eWjt1wKFVpzqACW3BhVoGuo06yz5TDkJk0IoOFCKb8TwtMRw0sHO86ip/eWA0cuhHddFRvhLKr8jULWNiIFCCsQBIU1hThjhYAsLPfjjMU7Wff/WpBSnltZLja44qzpbyo8V9xVAE2WV2PrWEvaUNkAXjwLGyDEc/uNtSQ+qVVltM5VTLMELTIM8nU/q68QrEJVpfhcXTXAlzwcF4LTHqqKKk9h+g8MiILgpwPnYFUVM48zU6tP6wiZZx8XP/1RU9iNCjVeqn5r/+r1of100VQ3vn4gu/cf3x+tK0Bat84V3Pz8Z5aNT3+qFqj4K6B/Zpkf1W5byb06HVBwEzIpmtjashusz6fs0GHI/f/P9p5qibG05isV3v7/TYWJr9nvjLombNp/tNVXB57b7SaJbW6IUoV+ec7jCz5DbvK0Aw=="></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_jump-game"></div></div>
</details><hr /><br />

**类似题目**：
  - [45. 跳跃游戏 II 🟠](/problems/jump-game-ii)

</details>
</div>



