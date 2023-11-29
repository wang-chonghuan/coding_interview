package org.E_Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
1302 deepest leaves sum
given the root of a binary tree
return the sum of values of its deepest leaves


在你提供的代码块中，我们可以看到你在`for-each`循环中尝试使用`removeFirst()`来修改`levelNodes`队列。这种在`for-each`循环中修改正在迭代的集合的行为是不被允许的。Java在迭代期间不允许对集合进行结构性修改，否则会抛出`ConcurrentModificationException`。

代码块：
```java
for(var node : levelNodes) {
    var curNode = levelNodes.removeFirst();
    // ...
}
```
其中`for(var node : levelNodes)`实际上在内部使用了`Iterator`，你不能在使用迭代器的同时修改其底层的集合。

你可能想要采用如下方式来遍历并同时修改队列：

```java
int levelCnt = levelNodes.size();
int levelSum = 0;
for(int i = 0; i < levelCnt; i++) {
    var curNode = levelNodes.removeFirst();
    // ...
}
```
在这个修正的循环中，首先通过`levelCnt = levelNodes.size()`记录了当前层的节点数量，然后使用一个普通的`for`循环迭代这些节点。在循环体内部，我们可以安全地调用`removeFirst()`来从`levelNodes`中移除元素，因为我们没有使用迭代器进行迭代。

在执行迭代的过程中，你需要谨慎处理集合的修改，确保不会在迭代过程中触发并发修改异常。你可以通过在迭代期间使用其他集合对象来存储需要添加或移除的元素，或者像上面那样，在迭代前记录需要迭代的元素数量，然后在迭代过程中修改集合。

 */
public class BfsP1N1302 {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Deque<TreeNode> levelNodes = new ArrayDeque<>();
        levelNodes.addLast(root);
        while(!levelNodes.isEmpty()) {
            int levelCnt = levelNodes.size();
            boolean isLevelHasSubtree = false;
            int levelSum = 0;
            for(int i = 0; i < levelCnt; i++) {
                var curNode = levelNodes.removeFirst();
                if(curNode == null) {
                    continue;
                }
                levelSum += curNode.val;
                if(curNode.left != null) {
                    isLevelHasSubtree = true;
                    levelNodes.add(curNode.left);
                }
                if(curNode.right != null) {
                    isLevelHasSubtree = true;
                    levelNodes.add(curNode.right);
                }
            }
            if(!isLevelHasSubtree) {
                return levelSum;
            }
        }
        return 0;
    }
}
